package TPFonctional.Dive;

import java.util.function.Predicate;

public class TPFunctionalDive {
    public static void main(String[] args) {
        IDiveConformity dive18 = d -> IDiveConformity.nbValeursSupA(d.getData(),18.)==0;
        IDiveConformity dive18II = d -> d.getMaxDepth() <= 18.;
        IDiveConformity dive40 = d -> IDiveConformity.nbValeursSupA(d.getData(),40.)==0 && IDiveConformity.nbValeursSupA(d.getData(),30.)<20;
        IDiveConformity dive40II = d -> d.getMaxDepth() <= 40. && IDiveConformity.nbValeursSupA(d.getData(),30.)<20;
        IDiveConformity dive40No18 = d -> !dive18.test(d) && dive40.test(d);

        Predicate<Dive> pred18 = d -> d.getMaxDepth() <= 18.;
        Predicate<Dive> pred40 = d -> IDiveConformity.nbValeursSupA(d.getData(),40.)==0 && IDiveConformity.nbValeursSupA(d.getData(),30.)<20;
        Predicate<Dive> pred40no18 = pred40.and(pred18.negate());

        for (int i=0;i<=10;i++) {
            Dive dive = DiveUtils.generateOneDive();
            System.out.println("********** dive "+i+" ***********");
            System.out.println("duree "+dive.getDuration()+", max "+dive.getMaxDepth());
            System.out.print("[");
            for (double d : dive.getData())
                System.out.print(d+", ");
            System.out.println("]");

            System.out.println(dive18.test(dive)?"dive "+i+" est 18":"dive "+i+" n'est pas 18");
            System.out.println(dive18II.test(dive)?"dive "+i+" est 18 II":"dive "+i+" n'est pas 18 II");
            System.out.println(pred18.test(dive)?"dive "+i+" est 18 predicate":"dive "+i+" n'est pas 18 predicate");
            System.out.println(dive40.test(dive)?"dive "+i+" est 40":"dive "+i+" n'est pas 40");
            System.out.println(dive40II.test(dive)?"dive "+i+" est 40 II":"dive "+i+" n'est pas 40 II");
            System.out.println(pred40.test(dive)?"dive "+i+" est 40 predicate":"dive "+i+" n'est pas 40 predicate");
            System.out.println(dive40No18.test(dive)?"dive "+i+" est 40-no-18":"dive "+i+" n'est pas 40-no-18");
            System.out.println(pred40no18.test(dive)?"dive "+i+" est 40-no-18 preicate":"dive "+i+" n'est pas 40-no-18 predicate");
        }
    }
}
