package TestDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class TPDateTime {
    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2016,1,1,0,0);
        LocalDate d1 = LocalDate.of(2016,1,1);

        DateTimeFormatter fq1 = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");
        System.out.println("******* Question 1 *******");
        System.out.println(fq1.format(dt1));

        DateTimeFormatter fq2 = DateTimeFormatter.ofPattern("'Le premier jour de l''année est le 'EEEE dd/MM/yyyy");
        System.out.println("******* Question 2 *******");
        System.out.println(fq2.format(dt1));

        System.out.println("******* Question 3 *******");
        TemporalAdjuster nextDimanche = TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY);
        LocalDateTime d2 = dt1.with(nextDimanche);
        DateTimeFormatter fq3a = DateTimeFormatter.ofPattern("EEEE dd");
        DateTimeFormatter fq3b = DateTimeFormatter.ofPattern("EEEE D");
        while (d2.getMonth().equals(Month.JANUARY)){
            System.out.println(fq3a.format(d2));
//            System.out.println(fq3b.format(d2));
            d2 = d2.plus(Period.ofDays(7));
        }

        System.out.println("******* Question 4 *******");
        TemporalAdjuster lastDayYear = TemporalAdjusters.lastDayOfYear();
        TemporalAdjuster lastDimanche = TemporalAdjusters.previous(DayOfWeek.SUNDAY);
        System.out.println(fq1.format(d2.with(lastDayYear).with(lastDimanche)));

        System.out.println("******* Question 5 *******");
        LocalDate dimanche1 = d1.with(nextDimanche);
        LocalDate dimancheDer = d1.with(lastDayYear).with(lastDimanche);
        System.out.println("Nombre de jour entre le 1er et dernier dimanche de 2016 = " + ChronoUnit.DAYS.between(dimanche1,dimancheDer));

        System.out.println("******* Question 6 *******");
        ZonedDateTime dz3 = ZonedDateTime.of(LocalDateTime.of(2016,07,14,19,25), ZoneId.of("Europe/Paris"));
        ZonedDateTime dz4 = dz3.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter fq6 = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy HH:mm:ss z");
        System.out.println(fq6.format(dz3));
        System.out.println(fq6.format(dz4));

        System.out.println("******* Question 7 *******");
        //Trouve le 1er lundi
        TemporalAdjuster nextJeudi = TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY);
        LocalDateTime dtq7 = dt1.with(nextJeudi);
        LocalDateTime firstDtq7OfMonth = dt1.with(nextJeudi);
        int nbJeudi = 0;
        while (dtq7.getYear() < 2018) {
            //System.out.println(fq1.format(dtq7));
            if (dtq7.getMonth().equals(firstDtq7OfMonth.getMonth())) {
                nbJeudi ++;
                dtq7 = dtq7.plus(Period.ofDays(7));
            }
            else {
                if (nbJeudi == 5){
                    System.out.println("Le mois de "+ firstDtq7OfMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.FRENCH) + " de l'année " + firstDtq7OfMonth.getYear() + " a 5 jeudis");
                }
                nbJeudi = 1;
                firstDtq7OfMonth = dtq7;
                dtq7 = dtq7.plus(Period.ofDays(7));
            }
        }

        System.out.println("******* Question 8 *******");
        System.out.println("Boucle sur les vendredis");
        //Il vaut mieux fair une boucle sur les mois, on verifie moins
        TemporalAdjuster nextVendredi = TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY);
        LocalDateTime dtq8 = dt1.with(nextVendredi);
        while (dtq8.getYear() < 2018) {
            //System.out.println(fq1.format(dtq7));
            if (dtq8.getDayOfMonth() == 13) {
                System.out.println(fq1.format(dtq8));
            }
            dtq8 = dtq8.plus(Period.ofDays(7));
        }

        //boucle sur les mois, on verifie moins
        System.out.println("Boucle sur les mois");
        for (int y = 2016 ; y <= 2017 ; y++) {
            for (int m = 1 ; m <= 12 ; m++) {
                if (LocalDate.of(y,m,13).getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    System.out.println(fq1.format(LocalDate.of(y,m,13)));
                }
            }
        }

        System.out.println("******* Question 9 et 10 *******");
        for (int y = 2015 ; y <= 2016 ; y++) {
            for (int m = 1 ; m <= 12 ; m++) {
                LocalDate date = LocalDate.of(y,m,1);
                System.out.println("Le jour de paye du mois de " + date.getMonth().getDisplayName(TextStyle.FULL, Locale.FRENCH) + " " + y + " est le " +fq1.format(date.with(new NextJourPaye())));
            }
        }

    }
}