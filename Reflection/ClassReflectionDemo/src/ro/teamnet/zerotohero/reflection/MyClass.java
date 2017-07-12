package ro.teamnet.zerotohero.reflection;

/**
 * Created by Andrei.Vasiliu on 7/12/2017.
 */
public class MyClass extends MyField{
    int i;
    private String a="unu";
    public int b;
    public float c;
    public int d;

    public MyClass(){}

    public MyClass(int i){}

    public void methodA(){
        System.out.println("afisare");
    }

    public static void afisare2(){
        System.out.println("Afisare2");
    }
}
