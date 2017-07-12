package ro.teamnet.zerotohero.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // get the class for a String object, and print it
        String a = new String();
        System.out.println(a.getClass());
        System.out.println(a.getClass().getCanonicalName());
        System.out.println(a.getClass().getSimpleName());
		

        // get the class of an Enum, and print it

        Class enumClass = MyEnum.unu.getClass();
        System.out.println(enumClass);


        // get the class of a collection, and print it

        Class collClass = (new HashMap()).getClass();
        System.out.println(collClass);
        

        // get the class of a primitive type, and print it

        int i = 11;
        System.out.println(Integer.valueOf(i).getClass().getTypeName());
        

        // get and print the class for a field of primitive type

        Class primitiveClass = Integer.TYPE;
        System.out.println(primitiveClass);
        try {
            Field f = MyEnum.class.getDeclaredField("unu");
            System.out.println(f.getType());
        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }
        

        // get and print the class for a primitive type, using the wrapper class

        Class wrapperclass = Boolean.TYPE;
        System.out.println(wrapperclass);
        

        // get the class for a specified class name
        try {
            Class c1 = Class.forName("ro.teamnet.zerotohero.reflection.MyEnum");

            System.out.println(c1);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        

        // get the superclass of a class, and print it

        Class superclass = MyEnum.class.getSuperclass();
        System.out.println(superclass);

        // get the superclass of the superclass above, and print it

        Class superSuperClass =superclass.getSuperclass();
        System.out.println(superSuperClass);
        

        //TODO get and print the declared classes within some other class

        System.out.println("Classes within other class");

        Class[] declClasses = MyEnum.class.getDeclaredClasses();
        Class[] var12 = declClasses;

        int var13 = declClasses.length;

        for(int var14 = 0; var14 < var13; ++var14) {
            Class cl = var12[var14];
            System.out.println(cl);
        }



        //TODO print the number of constructors of a class


        int n = MyClass.class.getDeclaredConstructors().length;
        System.out.println(n);




        //TODO get and invoke a public constructor of a class

        MyClass myClass = (MyClass)MyClass.class.getDeclaredConstructor().newInstance();
        System.out.println(myClass);



        

        //TODO get and print the class of one private field
        try {
            Field fieldType = MyClass.class.getDeclaredField("a");
            System.out.println(fieldType.getType());
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
        
		
		//TODO set and print the value of one private field for an object

        Field[] fieldsType = MyClass.class.getFields();
        Field[] var16 = fieldsType;
        int var17 = fieldsType.length;

        for(int var18 = 0; var18 < var17; ++var18) {
            Field f1 = var16[var18];
            System.out.println(f1.getType());
        }



        //TODO get and print only the public fields class
        System.out.println("Public fields");
        try {
            Field fieldA = MyClass.class.getDeclaredField("b");
            System.out.println(fieldA.getType());
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
        

        //TODO get and invoke one public method of a class
        Method method = MyClass.class.getDeclaredMethod("methodA", new Class[0]);
        method.invoke(new MyClass(), new Object[0]);
        

        //TODO get and invoke one inherited method of a class
        Method methodSuperClass = MyClass.class.getMethod("methodS", new Class[0]);
        methodSuperClass.invoke(new MyClass(), new Object[0]);
       
		
		//TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())


        for (int g=0;g<10;g++){
            MyClass.afisare2();
            System.out.println(System.currentTimeMillis());

        }

		//TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
        for(int k=0; k<99;k++){
            Method method2 = MyClass.class.getDeclaredMethod("methodA", new Class[0]);
            method2.invoke(new MyClass(), new Object[0]);
            System.out.println(System.currentTimeMillis());

        }
		//what do you observe?
		
    }
}
