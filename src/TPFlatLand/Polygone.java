package TPFlatLand;

import TPFlatLand.IFlatHomme;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Polygone implements IFlatHomme {

    private String nom;
    private LocalDateTime dateNaissance;
    private int nbCotes;

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

    public int getNbCotes() {
        return nbCotes;
    }

    public void setNbCotes(int nbCotes) {
        this.nbCotes = nbCotes;
    }

    public Polygone (String nom, LocalDateTime dateNaissance) {
        setFlatLandien(nom, dateNaissance);
    }

    public void setFlatLandien (String nom, LocalDateTime dateNaissance) {
        setNom(nom);
        setDateNaissance(dateNaissance);
    }

    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");
        return "Je suis un Polygone, je m'appelle " + getNom() + ", je suis née le " + f.format(getDateNaissance()) + " et j'ai " + getNbCotes() + " cotés";
    }

    public void sePresenter() {
        System.out.println(toString());
    }
}
