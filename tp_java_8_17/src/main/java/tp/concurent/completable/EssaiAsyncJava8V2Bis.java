package tp.concurent.completable;

import java.util.concurrent.CompletableFuture;

import tp.concurent.task.LongTask;

public class EssaiAsyncJava8V2Bis {
	
	public static void simuLong(String number,long nbMs) {
		LongTask.simulateLongTask("long computing - p"+number ,  nbMs); 
	}
	
	private double initialXValue;
	private String result;
	
	public void noStaticMethodWithLambda() {
        System.out.println("debut / interpreted by " + Thread.currentThread().getName());
        this.initialXValue=2;
		//code ameliorable avec synchronized(this){ this... } 
		CompletableFuture.supplyAsync(()->{ simuLong("p1",2000); return this.initialXValue; } )
		                 .thenApply(  (x)->{ simuLong("p2",2000); return x*x; } )
				         .thenApply(  (x)->{ simuLong("p3",2000); return String.valueOf(x); })
	                     .thenAccept( (s)->{System.out.println(s); this.result=s;});
		
		System.out.println("suite  / interpreted by " + Thread.currentThread().getName());
		
		LongTask.simulateLongTask("pause pour eviter arrêt complet du programme avant la fin des taches de fond" ,  8000);
		System.out.println("fin  / interpreted by " + Thread.currentThread().getName());
		System.out.println("result="+this.result);
	}
	
	public static void main(String[] args) {
		EssaiAsyncJava8V2Bis thisApp = new EssaiAsyncJava8V2Bis();
		thisApp.noStaticMethodWithLambda();
	}
}
