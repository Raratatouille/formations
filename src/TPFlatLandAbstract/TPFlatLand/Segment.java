package TPFlatLandAbstract.TPFlatLand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Segment extends FlatLandien {


    public Segment (String nom, LocalDateTime dateNaissance) {
        super(nom, dateNaissance);
    }

    public String toString() {
        return toString(true);
    }

}
