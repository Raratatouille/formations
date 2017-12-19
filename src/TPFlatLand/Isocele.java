package TPFlatLand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Isocele implements IFlatHomme {

    private String nom;
    private LocalDateTime dateNaissance;
    private int angleSommet;

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
    public int getAngleSommet() {
        return angleSommet;
    }

    public void setAngleSommet(int angleSommet) {
        this.angleSommet = angleSommet;
    }

    public void setFlatLandien (String nom, LocalDateTime dateNaissance) {
        setNom(nom);
        setDateNaissance(dateNaissance);
    }

    public Isocele (String nom, LocalDateTime dateNaissance) {
        setFlatLandien(nom, dateNaissance);
    }

    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");
        return "Je suis un Isocele, je m'appelle " + getNom() + ", je suis née le " + f.format(getDateNaissance()) + " et j'ai un angle de " + getAngleSommet();
    }

    public void sePresenter() {
        System.out.println(toString());
    }

}
