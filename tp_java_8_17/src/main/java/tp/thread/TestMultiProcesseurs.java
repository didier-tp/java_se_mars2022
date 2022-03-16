package tp.thread;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class TestMultiProcesseurs {
	
	public enum TypeCalcul  { MOYENNE , ECARTYPE};

	public static void main(String[] args) {
		System.out.println("nb processors:" + Runtime.getRuntime().availableProcessors());
		
		
		double[] t1 = produce_init_tab();
	    display_tab(t1);
	
		System.out.println("## moyenne ordinaire (sans decomposition) ");
		test_calcul_ordinaire(t1,TypeCalcul.MOYENNE);
		System.out.println("$$ moyenne avec decomposition");
		test_calcul_decompose(t1,TypeCalcul.MOYENNE);
		System.out.println("** moyenne avec decomposition optimise pour machine multi-processeurs (fork/join)");
		test_calcul_decompose_multiProc(t1,TypeCalcul.MOYENNE);
		
		test_calcul_moyenne_et_ecartType_via_parrallel_stream(t1);

		System.out.println("==================================");
		
		
		System.out.println("## ecart type ordinaire (sans decomposition) ");
		test_calcul_ordinaire(t1,TypeCalcul.ECARTYPE);
		System.out.println("$$ ecart type avec decomposition");
		test_calcul_decompose(t1,TypeCalcul.ECARTYPE);
		System.out.println("** ecart type avec decomposition optimise pour machine multi-processeurs (fork/join)");
		test_calcul_decompose_multiProc(t1,TypeCalcul.ECARTYPE);

	}
	
	static double[] produce_init_tab(){
		 //double[] t = { 5,15,11,9,13,7,12,8,16,4 };
		 //double[] t = { 26,7,5,2,1,9,3,4,34,12,8,16,6,78,10,89,33,23,90,123,72,3,48 };
		
		 //final int taille=10;
		 final int taille=1024*1024*128;
		 final double coeff = 1000;
		 double[] t = new double[taille];
		 for(int i=0;i<taille;i++){
			 t[i]=Math.random()*coeff;
		 }
		
		 return t;
		
	}
	
	
	
	static void display_tab(double[] tab){
		if(tab.length <= 30) {
		   for(double x : tab)
			  System.out.print(x + " ");
		   System.out.print("\n");
		}
		else{
			System.out.println("tableau de taille = " + tab.length);
		}
	}
	
	
	static void test_calcul_ordinaire(double[] tab,TypeCalcul typeCalcul){
		  String calculName = typeCalcul.toString();
		  long td = System.nanoTime();
		  double res  = 0;
		  switch(typeCalcul) {
		     case MOYENNE : res = MyStatsAlgo.moyenne_ordinaire(tab); break;
		     case ECARTYPE : res = MyStatsAlgo.ecartType_ordinaire(tab); break;
		  }
		  long tf = System.nanoTime();
		  System.out.println("##"+calculName+"="+res);
		  System.out.println("## " + (tf-td)/ 1000000 + " ms");
	  }
	
	static void test_calcul_decompose(double[] tab,TypeCalcul typeCalcul){
		  String calculName = typeCalcul.toString();
		  long td = System.nanoTime();
		  double res  = 0;
		  switch(typeCalcul) {
		     case MOYENNE : res = MyStatsAlgo.moyenne_decomp(tab); break;
		     case ECARTYPE : res = MyStatsAlgo.ecartType_ordinaire(tab); break;
		  }
		  long tf = System.nanoTime();
		  System.out.println("$$"+calculName+"="+res);
		  System.out.println("$$ " + (tf-td)/ 1000000 + " ms");
	  }
	
	
	static void test_calcul_decompose_multiProc(double[] tab,TypeCalcul typeCalcul){
		  String calculName = typeCalcul.toString();
		  long td = System.nanoTime();
		  double res  = 0;
		  switch(typeCalcul) {
		     case MOYENNE : res = MyStatsMultiProc.moyenne_multiProc(tab); break;
		     case ECARTYPE : res = MyStatsMultiProc.ecartType_multiProc(tab); break;
		  }
		  long tf = System.nanoTime();
		  System.out.println("**"+calculName+"="+res);
		  System.out.println("** " + (tf-td) / 1000000 + " ms");
	  }
	
	static void test_calcul_moyenne_et_ecartType_via_parrallel_stream(double[] tab){
		  long td = System.nanoTime();
		  DoubleStream tabStream = Arrays.stream(tab).parallel();
		  double average = tabStream.average().orElse(0.0);
		  long tf = System.nanoTime();
		  double variance = Arrays.stream(tab).parallel()
                  .map(p -> (p - average) * (p - average))
                  .sum() / tab.length;
          double ecartType=Math.sqrt(variance);
          long tf2 = System.nanoTime();
		  System.out.println(">>> moyenne avec calcul via parallel stream :"+ average + " en " + (tf-td) / 1000000 + " ms");
		  System.out.println(">>> ecartType avec calcul via parallel stream :"+ ecartType + " en " + (tf2-td) / 1000000 + " ms");
	  }

}
