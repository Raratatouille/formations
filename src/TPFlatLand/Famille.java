package TPFlatLand;

import java.util.ArrayList;

public class Famille {

    private String nom;

    private IFlatLandien mere;
    private IFlatHomme pere;
    private ArrayList<IFlatLandien> enfants;

    public Famille (String nom, IFlatHomme pere, Segment mere) {
        setNom(nom);
        setPere(pere);
        setMere(mere);
        this.enfants = new ArrayList<>();
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public IFlatLandien getMere() {
        return mere;
    }

    public void setMere(IFlatLandien mere) {
        this.mere = mere;
    }

    public IFlatHomme getPere() {
        return pere;
    }

    public void setPere(IFlatHomme pere) {
        this.pere = pere;
    }

    public ArrayList<IFlatLandien> getEnfants() {
        return enfants;
    }

    public void addEnfants(IFlatLandien enfant) {
        this.enfants.add(enfant);
    }

    public String toString() {
        String ret = "Père : " + pere.toString()
                +", Mère = " + mere.toString()
                +", Enfants = ";

        for (IFlatLandien e : enfants) {
            ret += e.toString() + ", ";
        }

        return ret;
    }

    public void sePresenter(){
        System.out.println(toString());
    }

}
