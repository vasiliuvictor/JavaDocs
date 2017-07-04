package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class Circles extends Circle{

    public double getAreaPub(){
        Circle c = new Circle();
        double value;
        value= c.area();
        System.out.println("The area is :" + value);
        return value;
    }

    public void getAreaDef(){
        Circle c1 = new Circle();
        c1.fillColour();
        c1.fillColour(5);
        c1.fillColour(3.6f);
    }

}
