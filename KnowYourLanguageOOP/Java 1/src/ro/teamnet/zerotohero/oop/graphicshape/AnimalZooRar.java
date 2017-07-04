package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Andrei.Vasiliu on 7/4/2017.
 */
public  class AnimalZooRar extends Animal {
    private String nume;
    private String numeleTariiDeOrigine;

    public AnimalZooRar(String nume,String numeleTariiDeOrigine){
        super();
        this.nume=nume;
        this.numeleTariiDeOrigine=numeleTariiDeOrigine;
    }
    public AnimalZooRar(String nume)
    {
        super();
        this.nume=nume;
    }
    public AnimalZooRar(){
        super();
    }
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
        System.out.println("AnimalulZooRar se joaca");

    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooRar faca baie");

    }

    public void setNume(String nume){
        this.nume = nume;
    }

    public String getNume(){
        return this.nume;
    }

    public void setNumeleTariiDeOrigine(String numeleTariiDeOrigine){
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }

    public String getNumeleTariiDeOrigine(){
        return this.numeleTariiDeOrigine;
    }

}
