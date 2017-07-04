package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class Square extends Shape {
    private int side;
    public Square(int side){
        this.side = side;
    }

    @Override
    public double area() {
        double value;
        value = side*side;
        return value;
    }
    public String toString() {
        return "Square area = (" + side * side + ")";
    }
}
