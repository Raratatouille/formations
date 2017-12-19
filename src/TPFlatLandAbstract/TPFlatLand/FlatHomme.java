package TPFlatLandAbstract.TPFlatLand;

import java.time.LocalDateTime;

public abstract class FlatHomme extends FlatLandien {

    public FlatHomme(String nom, LocalDateTime dateNaissance) {
        super(nom, dateNaissance);
    }

    @Override
    public String toString() {
        return super.toString(false);
    }

}
