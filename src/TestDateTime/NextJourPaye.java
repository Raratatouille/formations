package TestDateTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextJourPaye implements TemporalAdjuster {

    @Override
    public Temporal adjustInto (Temporal tmp) {
        int d = tmp.get(ChronoField.DAY_OF_MONTH);
        int m = tmp.get(ChronoField.MONTH_OF_YEAR);
        int y = tmp.get(ChronoField.YEAR);

        LocalDate dateParam = LocalDate.of(y, m, d);

        // Si la date est > 25, on calcule la date de paye du prochain mois
        if (tmp.get(ChronoField.DAY_OF_MONTH) > 25 ) {
            dateParam = LocalDate.of(y,m,1).plus(Period.ofMonths(1));
            // Recalcul le mois et l'année
            d = 1;
            m = dateParam.get(ChronoField.MONTH_OF_YEAR);
            y = dateParam.get(ChronoField.YEAR);
        }

        LocalDate retour = LocalDate.of(y,m,25);
        switch (retour.getDayOfWeek()) {
            case SUNDAY:
                retour = retour.minusDays(2);
                break;
            case SATURDAY:
                retour = retour.minusDays(1);
                break;
            default:
                break;
        }
        return retour;
    }
}
