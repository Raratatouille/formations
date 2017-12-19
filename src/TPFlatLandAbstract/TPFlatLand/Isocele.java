package TPFlatLandAbstract.TPFlatLand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Isocele extends FlatHomme {

    private int angleSommet;

    public int getAngleSommet() {
        return angleSommet;
    }

    public void setAngleSommet(int angleSommet) {
        this.angleSommet = angleSommet;
    }

    public Isocele (String nom, LocalDateTime dateNaissance, int angleSommet) {
        super(nom, dateNaissance);
        setAngleSommet(angleSommet);
    }

    public String toString() {
        return super.toString() + " et j'ai un angle de " + getAngleSommet();
    }

    public void sePresenter() {
        System.out.println(toString());
    }

}
