package TPFonctional.Dive;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiveUtils {
	public static String[][] DIVE_SITES = { 
		{ "Sipadan, Sabah Malaysia : Barracuda Reef",
			"Sipadan, Sabah Malaysia : Turtle point",
			"Sipadan, Sabah Malaysia : Shark cave"} ,
		{ "Amed, Bali Indonesia : Japanese Garden",
			"Amed, Bali Indonesia : Tumlaben wreck",
			"Amed, Bali Indonesia : Eel garden" } ,
		{ "Coron, Busuangas Island, Philipinas : Wakamaru wreck",
			"Coron, Busuangas Island, Philipinas : Toriyomo wreck",
			"Malapascua, Cebu , Philipinas : Tresher shark cleaning station"} ,
		{ "Similan Islands, Thailand : Richelieu Rock",
			"Similan Islands, Thailand : Koh Tachai"} ,
		{ "Perhentian Islands , Malaysia : Sea Temple",		
			"Perhentian Islands , Malaysia : Shark Point",		
			"Perhentian Islands , Malaysia : Turtle Garden" }
	};

	//profondeur en metre, duree en minute.
	public static double[] generateProfile(double maxDepth, int duration) {
		int nbP = 2 * duration + 1;
		double secDepth = maxDepth / 2;
		double[] res = new double[2 * duration + 1];
		res[0] = 0.0f;
		res[nbP - 1] = 0.0f;

		for (int i = 1; i < 4; i++) {
			res[i] = (double) (res[i - 1] + maxDepth * 0.5 * Math.random());
			if (res[i] > maxDepth)
				res[i] = maxDepth;
		}

		for (int i = 4; i < nbP - 1; i++) {
			res[i] = res[i - 1] + (double) (4 * Math.random() - 2);
			if (res[i] > maxDepth)
				res[i] = maxDepth;
			if (res[i] < secDepth)
				res[i] = secDepth;

		}

		for (int i = 2; i < 6; i++)
			res[nbP - i] = 3f;
		for (int i = 6; i < 15; i++)
			res[nbP - i] = 5f;
		res[nbP - 15] = (double) ((maxDepth + 5) / 2 + Math.random());
		
		//normalisation de la profondeur a la precision de 10cm
		for (int i = 0; i < res.length; i++) res[i] = (int) (res[i] * 10) / 10.0;
		return res;
	}
	
	public static List<Dive> generateDiveList() {
		List<Dive> diveList = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			LocalDateTime dt0 = LocalDateTime.of(2000 + i, 1, 1, 8, 0);
			for (int j = 0; j < 50; j++) {
				Dive dv = new Dive();
				long dd = (long) (Math.random() * 1000 % 120);
				long dh = (long) (Math.random() * 1000 % 10);
				int s = (int) ((Math.random() * 1000) % DiveUtils.DIVE_SITES[i % 5].length);
				int mdp = 15 + (int) ((Math.random() * 1000) % 35);
				int mdu = 45 + (int) ((Math.random() * 1000) % 15);
				dv.setDatetime(dt0.plusDays(dd).plusHours(dh));
				dv.setSite(DiveUtils.DIVE_SITES[i % 5][s]);
				dv.setData(DiveUtils.generateProfile(mdp, mdu));
				diveList.add(dv);
			}

		}
		return diveList;
	}
	
	public static Dive generateOneDive() {
		LocalDateTime dt0 = LocalDateTime.of(2015, 1, 1, 8, 0);
		Dive dv = new Dive();
		long dd = (long) (Math.random() * 1000 % 120);
		long dh = (long) (Math.random() * 1000 % 10);
		int mdp = 15 + (int) ((Math.random() * 1000) % 35);
		int mdu = 45 + (int) ((Math.random() * 1000) % 15);
		dv.setDatetime(dt0.plusDays(dd).plusHours(dh));
		dv.setSite("ma baignoire");
		dv.setData(DiveUtils.generateProfile(mdp, mdu));
		return dv;
	}
}

//// profondeur exprimee en metres
//public static final int MAXDEPTH = 45 + 1;
//// nombre de points de mesure de la plongee (1 point par periode de 30s)
//public static final int MAXDURATION = 2 * 60 + 1;
//
//public static synchronized byte[][] getDepthBitMap(double[] prf) {
//	byte[][] map = new byte[MAXDEPTH][MAXDURATION];
//	for (int i = 0; i < MAXDEPTH; i++)
//		for (int j = 0; j < MAXDURATION; j++)
//			map[i][j] = 0;
//
//	double maxDepth = 0;
//	int ln = MAXDURATION < prf.length ? MAXDURATION : prf.length;
//	for (int j = 0; j < ln; j++) {
//		double x = prf[j];
//		if (x > maxDepth)
//			maxDepth = x;
//		if (x >= MAXDEPTH)
//			x = MAXDEPTH - 1;
//		for (int i = 0; i < (int) x; i++)
//			map[i][j] = 1;
//	}
//	return map;
//}

//public static double[] decodeJSONProfile(String pS) {
//int deb = 1;
//int fin = 0;
//List<String> lf = new ArrayList<String>();
//while ((fin = pS.indexOf(",", deb)) > 0) {
//	String f = pS.substring(deb + 1, fin - 1);
//	lf.add(f);
//	deb = fin + 1;
//}
//fin = pS.indexOf("]", deb);
//lf.add(pS.substring(deb + 1, fin - 1));
//double[] res = new double[lf.size()];
//for (int i = 0; i < lf.size(); i++)
//	res[i] = Float.parseFloat(lf.get(i));
//return res;
//}
//
//public static String encodeJSONProfile(double[] f) {
//StringBuffer res = new StringBuffer("[");
//String pf2 = "";
//for (int i = 0; i < f.length; i++) {
//	res.append(pf2 + "\"" + f[i] + "\"");
//	pf2 = ",";
//}
//res.append("]");
//return res.toString();
//}

//public static String generateJSONProfile(double maxDepth, int duration) {
//double[] f = generateProfile(maxDepth, duration);
//return encodeJSONProfile(f);
//}




