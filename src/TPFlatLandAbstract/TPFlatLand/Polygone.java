package TPFlatLandAbstract.TPFlatLand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Polygone extends FlatHomme {

    private int nbCotes;

    public int getNbCotes() {
        return nbCotes;
    }

    public void setNbCotes(int nbCotes) {
        this.nbCotes = nbCotes;
    }

    public Polygone (String nom, LocalDateTime dateNaissance, int nbCotes) {
        super(nom, dateNaissance);
        setNbCotes(nbCotes);
    }

    @Override
    public String toString() {
        return super.toString() + " et j'ai " + getNbCotes() + " cotés";
    }

}
