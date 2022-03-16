package tp.thread;

public class MyBasicAlgo {

	public static final int DECOMP_MIN_SIZE = 1024 * 50;

	static Double maxi_ordinaire_subPart(double[] tableau, int deb, int fin) {
		Double maxi = Double.MIN_VALUE;
		for (int i = deb; i <= fin; i++) {
			if (tableau[i] > maxi)
				maxi = tableau[i];
		}
		return maxi;
	}

	static double maxi_ordinaire(double[] tableau) {
		return maxi_ordinaire_subPart(tableau, 0, tableau.length - 1);
	}

	static double compute_maxi_subPart(double[] tableau, int deb, int fin) {
		double resSp;
		int sizeSubPart = (fin - deb) + 1;
		if (sizeSubPart >= DECOMP_MIN_SIZE) {
			int indiceMilieu = deb + (sizeSubPart / 2);
			double maxiSousPartie1 = compute_maxi_subPart(tableau, deb, indiceMilieu - 1);
			double maxiSousPartie2 = compute_maxi_subPart(tableau, indiceMilieu, fin);
			resSp = (maxiSousPartie1>maxiSousPartie2)?maxiSousPartie1:maxiSousPartie2;

		} else
			resSp = maxi_ordinaire_subPart(tableau, deb, fin);
		return resSp;
	}
	
	static double maxi_decomp(double[] tableau) {
		return compute_maxi_subPart(tableau, 0, tableau.length - 1);
	}

}
