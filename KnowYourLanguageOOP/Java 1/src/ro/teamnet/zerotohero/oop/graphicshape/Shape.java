package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public abstract class Shape extends AbstractShape implements ShapeBehaviour{

    private double value;
    protected int color=1;
    protected float saturation;

    public double area(){
        return 1;
    }

    public void setColor(int color){
        this.color =color;
    }
    public void setSaturation(float saturation){
        this.saturation=saturation;
    }
}
