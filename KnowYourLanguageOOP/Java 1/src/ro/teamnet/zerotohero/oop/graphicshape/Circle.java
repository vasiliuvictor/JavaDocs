
package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class Circle extends Shape{
    private int xPos;
    private int yPos;
    private double radius;
    private double area;

    public Circle(){
        this.xPos=10;
        this.yPos=20;
        this.radius=12;
    }



    public Circle(int xPos){
        this.xPos=15;

    }

    public Circle(int xPos,int yPos){
        this.xPos=12;
        this.yPos=14;
    }

    public Circle(int xPos,int yPos,int radius){
        this.xPos=12;
        this.yPos=14;
        this.radius=11;
    }

    public void fillColour(){

        System.out.println("the color is " + color);
    }

    public int fillColour(int color){
        super.color = color;
        System.out.println("the circle colour is now : " + color);
        return color;
    }

    public float fillColour(float saturation){
        super.saturation=saturation;
        System.out.println("the saturation is " + saturation);
        return saturation;
    }



    @Override
    public double area(){
        double value;
        value = radius * radius * Math.PI;
        return value;
    }



    public String toString() {
        return "center = (" + xPos + ")("+yPos +") and radius is " + radius  ;
    }



}
