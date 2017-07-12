package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei.Vasiliu on 7/12/2017.
 */
public class EntityUtils {
    private EntityUtils() throws UnsupportedOperationException{

    }
    public static String getTableName(Class entity){
        if(entity.getAnnotation(Table.class)!=null){
             return ((Table)entity.getAnnotation(Table.class)).name();
        }
        else
            return entity.getName();

    }

    public static List<ColumnInfo> getColumns(Class entity){

        List<ColumnInfo> cols = new ArrayList<ColumnInfo>();

        Field[] fields = entity.getClass().getDeclaredFields();

        for(Field field : fields)
            if(entity.getAnnotation(Column.class)!=null){
                ColumnInfo col1 = new ColumnInfo();

                col1.setDbColumnName(field.getAnnotation(Id.class).name());
                col1.setColumnType(field.getType());
                col1.setColumnName(field.getName());
                cols.add(col1);

            }
        return cols;
    }

    public static Object castFromSqlType(Object value,Class wantedType){
        if(value instanceof BigDecimal && wantedType.getName().equals("java.lang.integer"))
            return ((BigDecimal) value).intValue();
        else
        if(value instanceof BigDecimal && wantedType.getName().equals("java.lang.long"))
            return ((BigDecimal) value).longValue();
        else
        if(value instanceof BigDecimal && wantedType.getName().equals("java.lang.float"))
            return ((BigDecimal) value).floatValue();
        else
        if(value instanceof BigDecimal && wantedType.getName().equals("java.lang.double"))
            return ((BigDecimal) value).doubleValue();
        else
            if(!(value instanceof BigDecimal))
                return value;
        return value;
    }
    public static List<Field> getFieldsByAnnotations(Class clazz,Class annotations){

        Field[] fields= clazz.getDeclaredFields();
        List<Field> list = new ArrayList<Field>();
        for(Field f:fields){
            if(f.isAnnotationPresent(annotations)){
                list.add(f);
            }
        }
        return list;

    }
}
