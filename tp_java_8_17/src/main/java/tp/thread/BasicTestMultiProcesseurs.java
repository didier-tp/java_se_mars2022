package tp.thread;

public class BasicTestMultiProcesseurs {
	

	public static void main(String[] args) {
		System.out.println("nb processors:" + Runtime.getRuntime().availableProcessors());
		
		
		double[] t1 = produce_init_tab();
	    display_tab(t1);
	
		System.out.println("## maxi ordinaire (sans decomposition) ");
		test_maxi_ordinaire(t1);
		System.out.println("$$ maxi avec decomposition");
		test_maxi_decompose(t1);
		System.out.println("** maxi avec decomposition optimise pour machine multi-processeurs (fork/join)");
		test_maxi_decompose_multiProc(t1);
		

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
	
	
	static void test_maxi_ordinaire(double[] tab){
		  long td = System.nanoTime();
		  double res  = MyBasicAlgo.maxi_ordinaire(tab);
		  long tf = System.nanoTime();
		  System.out.println("##maxi="+res);
		  System.out.println("## " + (tf-td)/ 1000000 + " ms");
	  }
	
	static void test_maxi_decompose(double[] tab){
		  long td = System.nanoTime();
		  double res  = MyBasicAlgo.maxi_decomp(tab);
		  long tf = System.nanoTime();
		  System.out.println("$$maxi="+res);
		  System.out.println("$$ " + (tf-td)/ 1000000 + " ms");
	  }
	
	
	static void test_maxi_decompose_multiProc(double[] tab){
		  long td = System.nanoTime();
		  double res  = MyBasicMultiProc.maxi_multiProc(tab);
		  long tf = System.nanoTime();
		  System.out.println("**maxi="+res);
		  System.out.println("** " + (tf-td) / 1000000 + " ms");
	  }

}
