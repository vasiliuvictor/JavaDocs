package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public abstract class Animal {


    public abstract void mananca(int i);

    public abstract void seJoaca();

    public abstract  void  faceBaie();

    public Animal(){

        System.out.println("Animal nou");
    }

    public void doarme(){
        System.out.println("Animalul doarme");
    }

    }

