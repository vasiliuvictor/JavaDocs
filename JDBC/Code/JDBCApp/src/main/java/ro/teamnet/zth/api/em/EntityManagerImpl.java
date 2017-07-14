package ro.teamnet.zth.api.em;


import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Employee;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public <T> T update(T entity) {
        Long id=0L;
        String dbColumnName="";
        try {
            Connection conn=DBManager.getConnection();
            String nameTable=EntityUtils.getTableName(entity.getClass());
            List<ColumnInfo> listaCol=new ArrayList<ColumnInfo>();
            listaCol=EntityUtils.getColumns(entity.getClass());
            for(ColumnInfo col:listaCol)
            {
                Field field=entity.getClass().getDeclaredField(col.getColumnName());
                field.setAccessible(true);
                col.setValue(field.get(entity));
                if(col.isId())
                {
                    id= (Long) col.getValue();
                    dbColumnName=col.getDbColumnName();
                }
            }
            Condition obj=new Condition();
            obj.setValue(id);
            obj.setColumnName(dbColumnName);

            QueryBuilder qb=new QueryBuilder();
            qb.setTableName(nameTable);
            qb.setQueryType(QueryType.UPDATE);
            qb.addQueryColumns(listaCol);
            qb.addCondition(obj);
            Statement stm=DBManager.getConnection().createStatement();

            ResultSet resultSet=stm.executeQuery(qb.createQuery());
            if(resultSet.next())
                return entity;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void delete(Object entity) {
        String dbColumnName="";

        try {long id = 0;
            Connection connection = DBManager.getConnection();
            String tableName = EntityUtils.getTableName(entity.getClass());
            List<ColumnInfo> columnList = EntityUtils.getColumns(entity.getClass());



            for (ColumnInfo c1: columnList)
            {
                if(c1.isId()){
                    dbColumnName=c1.getDbColumnName();
                    id=getNextIdVal(tableName,c1.getDbColumnName());

                    c1.setValue(id);
                }
                else
                {
                    Field f = entity.getClass().getDeclaredField(c1.getColumnName());
                    f.setAccessible(true);
                    c1.setValue(f.get(entity));
                }
            }
            Condition con = new Condition();
            con.setValue(id-1);
            con.setColumnName(dbColumnName);

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setTableName(tableName);
            queryBuilder.setQueryType(QueryType.DELETE);
            queryBuilder.addQueryColumns(columnList);
            queryBuilder.addCondition(con);
            Statement stm = connection.createStatement();
            stm.executeUpdate(queryBuilder.createQuery());







        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        String dbColumnName="";
        long id = 0;
        try {
            Connection connection = DBManager.getConnection();
            String tableName = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> columnList = EntityUtils.getColumns(entityClass);
            List<T> list = new ArrayList<>();
            for(ColumnInfo c : columnList)
            {
                if(c.isId()){
                    dbColumnName=c.getDbColumnName();
                    id=getNextIdVal(tableName,dbColumnName);
                    c.setValue(id);
                }
                else
                {
                    Field f = entityClass.getDeclaredField(c.getColumnName());
                    f.setAccessible(true);
                    c.setValue(f.get(entityClass.newInstance()));
                }

            }
            Set<Map.Entry<String,Object>> entries = params.entrySet();

            QueryBuilder queryBuilder = new QueryBuilder();
            for(Map.Entry<String,Object> entry:entries)
            {
                Condition c = new Condition();
                c.setColumnName(entry.getKey());
                c.setValue(entry.getValue());
                queryBuilder.addCondition(c);

            }

            queryBuilder.setTableName(tableName);
            queryBuilder.setQueryType(QueryType.SELECT);
            queryBuilder.addQueryColumns(columnList);

            Statement stm = connection.createStatement();
            ResultSet resultSet =stm.executeQuery(queryBuilder.createQuery());
            while (resultSet.next()){
                T instance = entityClass.newInstance();
                for (ColumnInfo c : columnList){
                    Field f =instance.getClass().getDeclaredField(c.getColumnName());
                    f.setAccessible(true);
                    f.set(instance,EntityUtils.castFromSqlType(resultSet.getObject(c.getDbColumnName()),f.getType()));


                }
                list.add(instance);
            }
            return list;

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


        return null;


    }

    public List<Employee> findEmployees(String param){

        try {
            Connection connection = DBManager.getConnection();
            String SQL = "SELECT * from DEPARTMENTS\n" +
            "inner join EMPLOYEES on DEPARTMENTS.DEPARTMENT_ID=EMPLOYEES.DEPARTMENT_ID\n" +
            "and DEPARTMENTS.DEPARTMENT_NAME like '%" + param +"%'";
            Statement stm = connection.createStatement();
            ResultSet resultSet =stm.executeQuery(SQL);
            List<Employee> list = new ArrayList<Employee>();

            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("EMPLOYEE_ID"));
                list.add(employee);

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }



}
