package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {

    public void lucreaza(Animal animal){
        if(animal instanceof AnimalZooFeroce) {
            animal.faceBaie();
        }
        System.out.println("Veterinarul are grija de animal" + animal);

    }
}
