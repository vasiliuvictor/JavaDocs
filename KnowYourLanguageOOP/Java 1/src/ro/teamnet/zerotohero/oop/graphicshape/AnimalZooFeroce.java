package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal{



    public void mananca(Object obj) {
        if(obj instanceof AngajatZoo)
            throw new AnimalManancaOmException();
        else
            System.out.println("AnimalZooRar mananca");

    }

    @Override
    public void mananca(int i) {

    }

    @Override
    public void seJoaca() {

    }

    @Override
    public void faceBaie() {

    }

    @Override
    public void doarme() {
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
}
