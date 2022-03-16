package tp.thread;

/*
 A FAIRE EN TP : compléter le code de cette classe
 */

public class MyBasicMultiProc /* extends .... */ {
	
	
	
	public MyBasicMultiProc(double[] tableau,int deb,int fin ){
		// .....

	}
	   
     static double maxi_multiProc(double[] tableau){
    	 MyBasicMultiProc myStatsMultiProc= new MyBasicMultiProc(tableau, 0, tableau.length - 1);
    	 //....
    	 return 0.0; 
	  }
     
   /*
	//@Override
	protected Double c....() {
		Double res =0.0;
		//.....
		
	    if(sizeSubPart >= FORK_JOIN_MIN_SIZE) {
	    	   //...
	    	   //...
	    	   res = (maxiSousPartie1>maxiSousPartie2)?maxiSousPartie1:maxiSousPartie2;
	    }else {
	    	res = MyBasicAlgo.maxi_ordinaire_subPart(this.tab,this.start,this.end);
	    }
	    return res;

	}
	 */
     

}
