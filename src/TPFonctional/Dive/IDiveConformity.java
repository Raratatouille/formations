package TPFonctional.Dive;

@FunctionalInterface
public interface IDiveConformity {
    static int nbValeursEntre(double[] data, double min, double max) {
        if (data == null) return 0;
        int res = 0;
        for (double d : data) {
            if (d >= min && d <= max) {
                res++;
            }
        }
        return res;
    }

    static int nbValeursInfA(double[] data, double max) {
        return nbValeursEntre(data,0, max);
    }

    static int nbValeursSupA(double[] data, double min) {
        return nbValeursEntre(data,min,Integer.MAX_VALUE);
    }

    boolean test (Dive dive);
}
