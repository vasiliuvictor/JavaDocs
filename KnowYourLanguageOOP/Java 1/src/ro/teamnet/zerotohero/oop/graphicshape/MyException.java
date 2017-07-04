package ro.teamnet.zerotohero.oop.graphicshape;



/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class MyException extends Exception {

    void m(){
        int data=50/0;
    }
    void n(){
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handled");}
    }
}
