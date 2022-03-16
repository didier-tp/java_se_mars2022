package tp.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import tp.thread.sam.ResultAggregate;
import tp.thread.sam.SequentialComputing;

public class MyStatsMultiProc extends RecursiveTask<Double> {
	
	private static final long serialVersionUID = 1L;
	private static final int FORK_JOIN_MIN_SIZE=1024*50; // THRESHOLD/SEUIL à éventuellement ajuster selon complexité du calcul
	
	private double[] tab;
	private int start,end;
	private SequentialComputing seqComputing; //reférence de fonction pour calcul ordinaire de somme ou moyenne ou  ...
	private ResultAggregate resAggregate; //reférence de fonction pour recombiner 2 sous sommes ou 2 sous moyennes
	private Double arg; //null ou éventuel argument nécessaire à un  calcul (ex: arg=moyenne pour calcul de variance)

	
	public MyStatsMultiProc(double[] tableau,int deb,int fin , Double arg,SequentialComputing seqComputing , ResultAggregate resAggregate){
		this.tab = tableau;
		this.start = deb;
		this.end = fin;
		this.arg = arg; 
		this.seqComputing = seqComputing; 
		this.resAggregate = resAggregate; 
	}
	   
     static double moyenne_multiProc(double[] tableau){
    	 MyStatsMultiProc myStatsMultiProc= new MyStatsMultiProc(tableau, 0, tableau.length - 1,null,MyStatsAlgo::moyenne_ordinaire_subPart,MyStatsAlgo::composeMoyenneTotale);
    	 ForkJoinPool threadPool = new ForkJoinPool();
    	 return threadPool.invoke(myStatsMultiProc);
	  }
     
     static double ecartType_multiProc(double[] tableau){
    	 ForkJoinPool threadPool = new ForkJoinPool();
    	 double moyenne = moyenne_multiProc(tableau);
    	 
    	 //MyStatsMultiProc myStatsMultiProc= new MyStatsMultiProc(tableau, 0, tableau.length - 1,moyenne,MyStatsAlgo::varianceFoisN_ordinaire_subPart,MyStatsAlgo::composeSommeTotale);
    	 //double varianceFoisN =  threadPool.invoke(myStatsMultiProc);
    	 //return Math.sqrt(varianceFoisN / tableau.length);
    	 
    	 MyStatsMultiProc myStatsMultiProc= new MyStatsMultiProc(tableau, 0, tableau.length - 1,moyenne,MyStatsAlgo::variance_ordinaire_subPart,MyStatsAlgo::composeMoyenneTotale);
    	 double variance =  threadPool.invoke(myStatsMultiProc);
    	 return Math.sqrt(variance);
	  }

	@Override
	protected Double compute() {
		Double res =0.0;
		//System.out.println("MyStatsMultiProc.compute() executé par "+Thread.currentThread().getName() );
		
		//NB: etant donné que la version forkJoin ajoute une complexité au niveau du code 
        // (instance à créer , thread à gérer) , cette version ne sera activée/utilisée
        //que pour traiter des sous tableaux dont la taille minimum est supérieure à FORK_JOIN_MIN_SIZE
      		
		int sizeSubPart = (end - start)+1;
		
	    if(sizeSubPart >= FORK_JOIN_MIN_SIZE) {
	    	   int indiceMilieu = this.start + (sizeSubPart / 2);
	    	   // pas de parametre dans .compute() et donc les tab et indices doivent être renseignés en tant qu'attributs + constructeurs
	    	   MyStatsMultiProc sousCalculGaucheViaForkJoin=new MyStatsMultiProc(tab,start,indiceMilieu-1,arg,seqComputing,resAggregate);
	    	   MyStatsMultiProc sousCalculDroitViaForkJoin=new MyStatsMultiProc(tab,indiceMilieu,end,arg,seqComputing,resAggregate);
	    	  
	    	   sousCalculGaucheViaForkJoin.fork();//déléguer (via potentiel autre thread)
	    	   
	    	   //sous solution A (.compute() ) :
	    	   //Double resCalculSousPartie2 = sousCalculDroitViaForkJoin.compute();//faire soit même (via meme thread)
	    	   
	    	   //sous solution B (.fork/join ) :
	    	   sousCalculDroitViaForkJoin.fork();//déléguer (via potentiel autre thread)
	    	   Double resCalculSousPartie2 = sousCalculDroitViaForkJoin.join(); //attendre
	    	   
	    	   Double resCalculSousPartie1 = sousCalculGaucheViaForkJoin.join(); //attendre 
	    	   
	    	   res = resAggregate.composeTotalRes(resCalculSousPartie1 , (indiceMilieu - start) ,
                                                  resCalculSousPartie2 , (end - indiceMilieu +1) );
	    }else {
	    	res = seqComputing.basicCompute(this.tab,this.start,this.end,this.arg);
	    }
	    return res;

	}
	 
     

}
