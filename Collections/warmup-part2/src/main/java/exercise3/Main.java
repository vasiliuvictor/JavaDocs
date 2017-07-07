package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrei.Vasiliu on 7/7/2017.
 */
public class Main {
    public static void main(String args[]){
        Map<Student ,BigDecimal> map1 = new HashMap<Student, BigDecimal>();
        Map<Student,BigDecimal> map2 = new HashMap<Student, BigDecimal>();
        Map<Student,BigDecimal> map3 = new HashMap<Student, BigDecimal>();
        Map<Student,BigDecimal> map4 = new HashMap<Student, BigDecimal>();


        Student1 stud1 = new Student1("Victor","Andrei");
        Student2 stud2 = new Student2("Haraga","Ginel");
        Student3 stud3 = new Student3("Guiu","Iuli");
        Student4 stud4 = new Student4("Radu","Nebunu");
        Student1 stud5 = new Student1("Radu","Nebunu");

        map1.put(stud1,BigDecimal.valueOf(30));
        map2.put(stud2,BigDecimal.valueOf(32));
        map3.put(stud3,BigDecimal.valueOf(34));
        map4.put(stud4,BigDecimal.valueOf(35));

        Set<Student> list1 =map1.keySet();
        for (Student stud : list1)
        {
            System.out.print(stud.toString() + map1.get(stud) +",");
        }
        Set<Student> list2 =map2.keySet();
        for (Student stud : list2)
        {
            System.out.print(stud.toString() + map2.get(stud) +",");
        }
        Set<Student> list3 =map3.keySet();
        for (Student stud : list3)
        {
            System.out.print(stud.toString() + map3.get(stud) +",");
        }
        Set<Student> list4 =map4.keySet();
        for (Student stud : list4)
        {
            System.out.print(stud.toString() + map4.get(stud) +",");
        }

        System.out.println(stud1.equals(stud5));





    }
}
