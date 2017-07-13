package ro.teamnet.zth.api.em;


import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei.Vasiliu on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {
    @Override
    public <T> T findById(Class<T> entityClass, Long id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Connection conn2 = DBManager.getConnection();
        T instance = null;
        String tableN = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<Field> fieldList = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);

        Condition condition = new Condition();
        for (ColumnInfo c:columns)
        {
            if(c.isId()){
                condition.setColumnName(c.getDbColumnName());
                condition.setValue(id);
            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableN);
        queryBuilder.addCondition(condition);
        queryBuilder.setQueryType(QueryType.SELECT);
        queryBuilder.addQueryColumns(columns);



        Statement stm = conn2.createStatement();
        ResultSet resultSet =stm.executeQuery(queryBuilder.createQuery());

        if(resultSet.next()){
            instance = entityClass.newInstance();

            for (ColumnInfo c : columns){
                Field f =instance.getClass().getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                f.set(instance,EntityUtils.castFromSqlType(resultSet.getObject(c.getDbColumnName()),c.getColumnType()));


            }

        }
        return instance;


    }

    @Override
    public long getNextIdVal(String tableName, String columnIdName) throws SQLException, ClassNotFoundException {
        Connection conn3 = DBManager.getConnection();
        String SQL = "SELECT MAX("+columnIdName+") +1 FROM " + tableName;
        try(Statement obj = conn3.createStatement()) {



            ResultSet resultSet = obj.executeQuery(SQL);

            if(resultSet.next()){
                return resultSet.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return -1;
    }

    @Override
    public <T> Object insert(T entity) {
        try {
            long id=0;
            Connection connection = DBManager.getConnection();
            String tableName = EntityUtils.getTableName(entity.getClass());
            List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

            Statement stm = connection.createStatement();



            for(ColumnInfo c: columns){
                if(c.isId()){
                    id=getNextIdVal(tableName,c.getDbColumnName());
                    c.setValue(id);
                }
                else
                {
                    Field f2 = entity.getClass().getDeclaredField(c.getColumnName());
                    f2.setAccessible(true);

                    c.setValue(f2.get(entity));
                }
            }
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setTableName(tableName);
            queryBuilder.setQueryType(QueryType.INSERT);

            queryBuilder.addQueryColumns(columns);
            queryBuilder.createQuery();
            ResultSet resultSet;
            resultSet=stm.executeQuery(queryBuilder.createQuery());

            return findById(entity.getClass(),id);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        try
        {
            Connection con = DBManager.getConnection();
            String tableName = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> columnList = EntityUtils.getColumns(entityClass);
            QueryBuilder qb = new QueryBuilder();
            qb.setTableName(tableName);
            qb.addQueryColumns(columnList);
            qb.setQueryType(QueryType.SELECT);
            String sql = qb.createQuery();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<T> list = new ArrayList<T>();
            while(rs.next())
            {
                T instance = entityClass.newInstance();
                for(ColumnInfo column : columnList)
                {
                    Field field = instance.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    field.set(instance,EntityUtils.castFromSqlType(rs.getObject(column.getDbColumnName()),field.getType()));
                }
                list.add(instance);

            }
            return list;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
