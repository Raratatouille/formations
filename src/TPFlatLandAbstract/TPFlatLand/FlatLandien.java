package TPFlatLandAbstract.TPFlatLand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class FlatLandien implements IFlatLandien {

    private String nom;
    private LocalDateTime dateNaissance;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDateTime dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public FlatLandien(String nom, LocalDateTime dateNaissance) {
        setFlatLandien(nom, dateNaissance);
    }

    public void setFlatLandien (String nom, LocalDateTime dateNaissance) {
        setNom(nom);
        setDateNaissance(dateNaissance);
    }

    public String toString(boolean e) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");
        return "Je m'appelle "+getNom()+", je suis un"+(e?"e":"")+" " + this.getClass().getSimpleName() + ", je suis né"+(e?"e":"")+" le "+f.format(getDateNaissance());
    }

    @Override
    public String toString() {
        return this.toString(false);
    }

    public void sePresenter() {
        System.out.println(toString());
    }
}
