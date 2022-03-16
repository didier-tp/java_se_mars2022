package tp.thread.exemples;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//ForkJoin (RecursiveAction) / divide & conquer since jdk 1.7
public class MyQuickSortMultiProc extends RecursiveAction {
	
	private static final long serialVersionUID = 1L;
	private static final int FORK_JOIN_MIN_SIZE=1024*10;
	
	private double[] tab;
	private int start,end;
	
	public MyQuickSortMultiProc(double[] tableau,int deb,int fin){
		this.tab = tableau;
		this.start = deb;
		this.end = fin;
	}
	   
     static void quick_sort_multiProc(double[] tableau){
    	 MyQuickSortMultiProc myQuickSortMultiProc= new MyQuickSortMultiProc(tableau, 0, tableau.length - 1);
    	 ForkJoinPool threadPool = new ForkJoinPool();
    	 threadPool.invoke(myQuickSortMultiProc);
	  }

	@Override
	protected void compute() {
		// pas de parametre et donc les tab et indices doivent être renseignés en tant qu'attributs + constructeurs
		MyQuickSortMultiProc sousTriGaucheViaForkJoin=null;
		MyQuickSortMultiProc sousTriDroitViaForkJoin = null;
		//System.out.println("MyQuickSortMultiProc.compute() executé par "+Thread.currentThread().getName() );
		
		if(start<end){
			 //partitionner le tableau en 2 parties partiellement ré-arrangées .
			 //d'un coté tous les éléments plus petits que le pivot , de l'autre coté tous les éléments plus grands:
          int positionPivot=MyQuickSortAlgo.partition(tab,start,end);
	
          //NB: etant donné que la version forkJoin ajoute une complexité au niveau du code 
          // (instance à créer , thread à gérer) , cette version ne sera activée/utilisée
          //que pour trier des sous tableaux dont la taille minimum est supérieure à
          //FORK_JOIN_MIN_SIZE=1024
          
          if(positionPivot - start > FORK_JOIN_MIN_SIZE){
             sousTriGaucheViaForkJoin= new MyQuickSortMultiProc(tab, start, positionPivot-1);
             sousTriGaucheViaForkJoin.fork(); //déléguer le tri du sous tableau des plus petits éléments que le pivot
          } else MyQuickSortAlgo.tri_rapide(tab,  start, positionPivot-1);
          
          if(end - positionPivot > FORK_JOIN_MIN_SIZE){
             sousTriDroitViaForkJoin= new MyQuickSortMultiProc(tab, positionPivot+1,end);
             sousTriDroitViaForkJoin.fork(); ////déléguer le tri du tableau des plus grands éléments que le pivot
          } else MyQuickSortAlgo.tri_rapide(tab, positionPivot+1, end);
          
          if(sousTriGaucheViaForkJoin!=null) sousTriGaucheViaForkJoin.join(); //attendre 
          if(sousTriDroitViaForkJoin!=null) sousTriDroitViaForkJoin.join(); //attendre
          
          //NB: il existe invokeAll(recursiveAction1 , recursiveAction2) qui declenche en // .fork() et .join()
          }
		
	}
	 
     

}
