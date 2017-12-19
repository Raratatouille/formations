package TPFonctional.Dive;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TPStreamDive {
    public static void main(String[] args) {

        List<Dive> listeDive = DiveUtils.generateDiveList();

        System.out.println("********** Question 1 **********");
        Stream<Dive> streamDive = listeDive.stream();
        streamDive
                .filter(dive -> dive.getDatetime().getYear()==2008)
                .limit(5)
                .forEach(dive -> System.out.println(dive.toString()));

        System.out.println("********** Question 2 **********");
        streamDive = listeDive.stream();
        System.out.println("il y a " + streamDive.filter(dive -> dive.getDatetime().getYear()==2008).count() + " plongées en 2008");

        System.out.println("********** Question 3 **********");
        streamDive = listeDive.stream();
        streamDive
                .filter(dive -> dive.getDatetime().getYear()>=2008 && dive.getDatetime().getYear()<=2010)
                .map(Dive::getSite)
                .distinct()
                .forEach(System.out::println);

        System.out.println("********** Question 4 **********");
        System.out.println("5 plus longue");
        streamDive = listeDive.stream();
        streamDive
                .filter(dive -> dive.getDatetime().getYear()==2010)
                .sorted( (dv1,dv2) -> dv2.getDuration() - dv1.getDuration())
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Plus de 55 mn");
        streamDive = listeDive.stream();
        streamDive
                .filter(dive -> dive.getDatetime().getYear()==2010)
                .filter(dive -> dive.getDuration()>55)
                .sorted( (dv1,dv2) -> dv2.getDuration() - dv1.getDuration())
                .forEach(System.out::println);

        System.out.println("5 plus profondes de 2010");
        streamDive = listeDive.stream();
        streamDive
                .filter(dive -> dive.getDatetime().getYear()==2010)
                .sorted( (dv1,dv2) -> dv2.getMaxDepth() - dv1.getMaxDepth()<0 ? -1 : dv2.getMaxDepth() - dv1.getMaxDepth()==0 ? 0 : 1)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("5 moins profondes de Idonésie");
        streamDive = listeDive.stream();
        streamDive
                .filter(dive -> dive.getSite().contains("Indonesia"))
                .sorted((dv1,dv2) -> dv1.getMaxDepth() - dv2.getMaxDepth()<0 ? -1 : dv1.getMaxDepth() - dv2.getMaxDepth()==0 ? 0 : 1)
                .limit(5)
                .sorted( (dv1,dv2) -> dv2.getMaxDepth() - dv1.getMaxDepth()<0 ? -1 : dv2.getMaxDepth() - dv1.getMaxDepth()==0 ? 0 : 1)
                .forEach(System.out::println);

        System.out.println("********** Question 5 **********");
        streamDive = listeDive.stream();

        final HashMap<Integer, TreeSet<Dive>> mapDive = new HashMap<>();
        // Definie le comparateur de dive
        Comparator<Dive> cmpDive = (dv1,dv2) -> dv2.getMaxDepth() - dv1.getMaxDepth()<0 ? -1 : dv2.getMaxDepth() - dv1.getMaxDepth()==0 ? 0 : 1;
        streamDive
                .forEach(dive -> {
                    int annee = dive.getDatetime().getYear();
                    if (!mapDive.containsKey(annee))
                        mapDive.put(annee,new TreeSet<>(cmpDive));
                    mapDive.get(annee).add(dive);
                    if (mapDive.get(annee).size() == 4)
                        mapDive.get(annee).remove(mapDive.get(annee).last());
                });
        mapDive.keySet().stream().peek(a -> System.out.println("Les 3 plongées les plus profondes de l'année "+a)).flatMap(k -> mapDive.get(k).stream()).forEach(System.out::println);

        System.out.println("********** Question 6 **********");
        streamDive = listeDive.stream();

        final HashMap<Integer, TreeSet<Dive>> mapDive2 = new HashMap<>();
        streamDive
                .peek(dive -> { if (!mapDive2.containsKey(dive.getDatetime().getYear())) mapDive2.put(dive.getDatetime().getYear(),new TreeSet<>(cmpDive)); })
                .peek(dive -> mapDive2.get(dive.getDatetime().getYear()).add(dive))
                .forEach(dive -> { if (mapDive2.get(dive.getDatetime().getYear()).size() == 4) mapDive2.get(dive.getDatetime().getYear()).remove(mapDive2.get(dive.getDatetime().getYear()).last()); });
        mapDive.keySet().stream().peek(a -> System.out.println("Les 3 plongées les plus profondes de l'année "+a)).flatMap(k -> mapDive2.get(k).stream()).forEach(System.out::println);

        System.out.println("********** Question Qq la praline **********");
        streamDive = listeDive.stream();

        streamDive
                .filter(dive -> dive.getDatetime().getYear()==2008)
                .filter(dive -> dive.getSite().contains("Indonesia"))
                .peek(System.out::println)
                .forEach(d -> Arrays.stream(d.getData()).collect(Collectors.averagingDouble()));
    }
}
