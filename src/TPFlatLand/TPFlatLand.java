package TPFlatLand;

import TestDateTime.NextJourPaye;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Locale;

public class TPFlatLand {
    public static void main(String[] args) {

        Famille coiffet = new Famille("Coiffet",
                new Isocele ("Raphaël", LocalDateTime.of(1973,10,29,0,0)),
                new Segment ("Isabelle", LocalDateTime.of(1975,1,22,0,0)));

        coiffet.addEnfants(new Segment("Joumana", LocalDateTime.of(2006,5,25,0,0)));
        coiffet.addEnfants(new Segment("Emilie", LocalDateTime.of(2008,6,19,0,0)));
        coiffet.addEnfants(new Polygone("Aymeric", LocalDateTime.of(2011,12,13,0,0)));

        coiffet.sePresenter();

    }
}