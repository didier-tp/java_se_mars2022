package tp.thread.exemples;

import java.util.Arrays;

public class TestSortMultiProcesseurs {

	public static void main(String[] args) {
		System.out.println("nb processors:" + Runtime.getRuntime().availableProcessors());
		double[] t1 = produce_init_tab();
		double[] copyOfT1 = t1.clone();
		display_tab(t1); // display_tab(copyOfT1);
		System.out.println("## tri ordinaire (quick-sort) en java maison");
		test_tri(t1);
		System.out.println("$$ tri standard prédéfini java/c (quick-sort) ");
		test_tri_standard(t1);
		System.out.println("** tri (quick-sort) optimisé pour machine multi-processeurs en java maison ");
		test_tri_multiProc(copyOfT1);
	}

	static double[] produce_init_tab() {
		// double[] t = { 5,2,1,9,3,4,12,8,16,6 };
		// double[] t = { 26,7,5,2,1,9,3,4,34,12,8,16,6,78,10,89,33,23,90,123,72,3,48 };
		// final int taille=10;
		final int taille = 1024 * 1024 * 8;
		double[] t = new double[taille];
		for (int i = 0; i < taille; i++) {
			t[i] = Math.random() * taille;
		}
		return t;
	}

	static void display_tab(double[] tab) {
		if (tab.length <= 30) {
			for (double x : tab)
				System.out.print(x + " ");
			System.out.print("\n");
		} else {
			System.out.println("tableau de taille = " + tab.length);
		}
	}

	static void test_tri(double[] tab) {
		long td = System.nanoTime();
		MyQuickSortAlgo.quick_sort(tab);
		long tf = System.nanoTime();
		display_tab(tab);
		System.out.println("## " + (tf - td) / 1000000 + " ms");
	}
	
	static void test_tri_standard(double[] tab) {
		long td = System.nanoTime();
		Arrays.sort(tab);
		long tf = System.nanoTime();
		display_tab(tab);
		System.out.println("$$ " + (tf - td) / 1000000 + " ms");
	}

	static void test_tri_multiProc(double[] tab) {
		long td = System.nanoTime();
		MyQuickSortMultiProc.quick_sort_multiProc(tab);
		long tf = System.nanoTime();
		display_tab(tab);
		System.out.println("** " + (tf - td) / 1000000 + " ms");
	}

}
