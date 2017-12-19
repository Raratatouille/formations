package TPFlatLandAbstract.TPFlatLand;

import java.time.LocalDateTime;

public class TPFlatLand {
    public static void main(String[] args) {

        Famille coiffet = new Famille("Coiffet",
                new Isocele("Raphaël", LocalDateTime.of(1973,10,29,0,0),66),
                new Segment("Isabelle", LocalDateTime.of(1975,1,22,0,0)));

        coiffet.addEnfants(new Segment("Joumana", LocalDateTime.of(2006,5,25,0,0)));
        coiffet.addEnfants(new Segment("Emilie", LocalDateTime.of(2008,6,19,0,0)));
        coiffet.addEnfants(new Polygone("Aymeric", LocalDateTime.of(2011,12,13,0,0),5));

        coiffet.sePresenter();

    }
}