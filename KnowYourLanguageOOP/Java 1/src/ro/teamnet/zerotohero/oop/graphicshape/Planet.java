package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public final class Planet extends MyException{
    private final double fMass;
    private final String fName;


    public Planet(double fMass, String fName) {
    this.fMass = fMass;
    this.fName = fName;

    }


    public String toString(){

        return "Planet " + fName +" varsta "+ fMass;

    }
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