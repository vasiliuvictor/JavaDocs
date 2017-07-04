package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {

    public void lucreaza(Animal animal){
        System.out.println("Ingrijitorul intra in cusca animalului" + animal);


    }

    public void lucreaza(Animal animal,Object mancare){
        lucreaza(animal);
    }



}
