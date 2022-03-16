package tp.thread;

import tp.thread.sam.ResultAggregate;
import tp.thread.sam.SequentialComputing;

public class MyStatsAlgo {
	
	//calcul de somme , moyenne ou variance sur grands tableaux
	
	public static final Double composeMoyenneTotale(double moyenne_tab1, int taille_tab1,double moyenne_tab2, int taille_tab2) {
		return (moyenne_tab1*taille_tab1 + moyenne_tab2*taille_tab2) / (taille_tab1 + taille_tab2);
	}
	
	public static final Double composeSommeTotale(double somme_tab1, int taille_tab1,double somme_tab2, int taille_tab2) {
		return (somme_tab1+somme_tab2);
	}
	
	
	public static final int DECOMP_MIN_SIZE=1024*50;

	 //versions ordinaires (sans decomposition en 2 sous parties):
	/*
	static Double somme_ordinaire_subPart(double[] tableau,int deb,int fin,Double notUsedArg){
		 Double somme = 0.0;
	     for(int i=deb; i<=fin ;i++) {
	    	 somme += tableau[i];
	     }
	     return somme;
	 }*/
	
	 static Double moyenne_ordinaire_subPart(double[] tableau,int deb,int fin,Double notUsedArg){
		 //Double somme = somme_ordinaire_subPart(tableau,deb,fin,notUsedArg); //calcul OK mais beaucoup moins rapide
		 Double somme = 0.0;
	     for(int i=deb; i<=fin ;i++) {
	    	 somme += tableau[i];
	     }
	     int sizeSubPart = (fin - deb)+1;
	     return somme / sizeSubPart;
	 }
	 
	 static Double variance_ordinaire_subPart(double[] tableau,int deb,int fin,Double moyenne){
		 Double varianceFoisN = 0.0;
	     for(int i=deb; i<=fin ;i++) {
	    	 varianceFoisN += (tableau[i] - moyenne) * (tableau[i] - moyenne);
	     }
	     int sizeSubPart = (fin - deb)+1;
	     return varianceFoisN/sizeSubPart;
	 }
	 
	 static Double varianceFoisN_ordinaire_subPart(double[] tableau,int deb,int fin,Double moyenne){
		 Double varianceFoisN = 0.0;
	     for(int i=deb; i<=fin ;i++) {
	    	 varianceFoisN += (tableau[i] - moyenne) * (tableau[i] - moyenne);
	     }
	     return varianceFoisN;
	 }
	 
	 
	
	 //versions avec decomposition en 2 sous parties:
     static double moyenne_decomp_subPart(double[] tableau,int deb,int fin){
    	 return compute_decomp_subPart(tableau,deb,fin,null,MyStatsAlgo::moyenne_ordinaire_subPart,MyStatsAlgo::composeMoyenneTotale);
     }
     
     static double varianceFoisN_decomp_subPart(double[] tableau,int deb,int fin,double moyenne){
    	 return compute_decomp_subPart(tableau,deb,fin,moyenne,MyStatsAlgo::varianceFoisN_ordinaire_subPart,MyStatsAlgo::composeSommeTotale);
     }
     
     static double variance_decomp_subPart(double[] tableau,int deb,int fin,double moyenne){
    	 return compute_decomp_subPart(tableau,deb,fin,moyenne,MyStatsAlgo::variance_ordinaire_subPart,MyStatsAlgo::composeMoyenneTotale);
     }
    	 
    static double compute_decomp_subPart(double[] tableau,int deb,int fin,Double arg,
    		           SequentialComputing seqComptuting , ResultAggregate resAggregate){
       double resSp;
       int sizeSubPart = (fin - deb)+1;
       if(sizeSubPart >= DECOMP_MIN_SIZE){
		   int indiceMilieu = deb + (sizeSubPart / 2);
		   double resCalculSousPartie1 = compute_decomp_subPart(tableau,deb,indiceMilieu-1,arg,seqComptuting,resAggregate); 
		   double resCalculSousPartie2 = compute_decomp_subPart(tableau,indiceMilieu,fin,arg,seqComptuting,resAggregate); 
		   resSp = resAggregate.composeTotalRes(resCalculSousPartie1 , (indiceMilieu - deb) ,
				                                resCalculSousPartie2 , (fin - indiceMilieu +1) );
				      
           }
       else 
    	   resSp = seqComptuting.basicCompute(tableau,deb,fin,arg);
       return resSp;
       }
	  
    //fonctions de niveau principal (appels simples , niveau global):
    
     /*
     static double somme_ordinaire(double[] tableau){
    	 return somme_ordinaire_subPart(tableau, 0, tableau.length - 1 , null );
	  }*/
     
     static double moyenne_ordinaire(double[] tableau){
    	 return moyenne_ordinaire_subPart(tableau, 0, tableau.length - 1 , null );
	  }
     
     static double variance_ordinaire(double[] tableau){
    	 double moyenne = moyenne_ordinaire_subPart(tableau, 0, tableau.length - 1 , null );
    	 return variance_ordinaire_subPart(tableau, 0, tableau.length - 1 , moyenne );
	  }
     
     static double ecartType_ordinaire(double[] tableau){
    	 double moyenne = moyenne_ordinaire_subPart(tableau, 0, tableau.length - 1 , null );
    	 double variance =  variance_ordinaire_subPart(tableau, 0, tableau.length - 1 , moyenne );
	     return Math.sqrt(variance);
	  }
	 
     
     static double moyenne_decomp(double[] tableau){
    	 return moyenne_decomp_subPart(tableau, 0, tableau.length - 1 );
	  }
     
     static double ecartType_decomp(double[] tableau){
    	 double moyenne = moyenne_decomp_subPart(tableau, 0, tableau.length - 1 );
    	 //double varianceFoisN =  varianceFoisN_decomp_subPart(tableau, 0, tableau.length - 1 , moyenne);
	     //return Math.sqrt(varianceFoisN / tableau.length);
	     double variance =  variance_decomp_subPart(tableau, 0, tableau.length - 1 , moyenne);
	     return Math.sqrt(variance);
	  }
     

}
