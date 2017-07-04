
package ro.teamnet.zerotohero.oop.graphicshape;
import ro.teamnet.zerotohero.oop.graphicshape.canvas.Canvas;


/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class RunApp {
    public static void main(String args[]){



        Circles c1 = new Circles();
            Shape s = new Circle(10);
            ShapeBehaviour sq = new Square(10);



            Object p1 = new Point(10,20);
            Object p2 = new Point(50,100);
            Object p3 = new Point(10,20);
            Planet pll = new Planet(20,"bambi");
            MyException ex1 = new MyException();



        c1.getAreaPub();
        System.out.println(c1.toString());
        c1.getAreaDef();

        Canvas can = new Canvas();
        can.paint();

        System.out.println(s);
        System.out.println(sq);


        System.out.println("p1 equals p2 is "+ p1.equals(p2));
        System.out.println("p1 equals p3 is "+ p1.equals(p3));

        System.out.println(pll.toString());

        ex1.p();
        try {
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
        }
        finally{System.out.println("Text de afisat in consola");}






    }
    }

