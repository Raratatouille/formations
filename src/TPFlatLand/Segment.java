package TPFlatLand;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Segment implements IFlatLandien {

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

    public Segment (String nom, LocalDateTime dateNaissance) {
        setFlatLandien(nom, dateNaissance);
    }

    public void setFlatLandien (String nom, LocalDateTime dateNaissance) {
        setNom(nom);
        setDateNaissance(dateNaissance);
    }

    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");
        return "Je suis un Segment, je m'appelle "+getNom()+", je suis née le "+f.format(getDateNaissance());
    }

    public void sePresenter() {
        System.out.println(toString());
    }
}
