package tp.concurent.completable;

import java.util.concurrent.CompletableFuture;

import tp.concurent.task.LongTask;

public class EssaiAsyncJava8V2 {
	
	public static Double extractInitValue(){
		LongTask.simulateLongTask("long computing - p1" ,  2000); 
        /*throw new RuntimeException("exceptionXY");*/ return 2.0; 
	}
	
	public static Double auCarre(Double x){
		 LongTask.simulateLongTask("long computing - p2" ,  2000); return x*x;
	}
	
	public static String convertAsString(Double x){
		LongTask.simulateLongTask("long computing - p3" ,  2000); return String.valueOf(x);
	}
	
	public static void displayString(String s){
		 System.out.println(s) ;
	}

	public static void main(String[] args) {
		System.out.println("debut main / interpreted by " + Thread.currentThread().getName());
		
		CompletableFuture.supplyAsync(EssaiAsyncJava8V2::extractInitValue )
	                     .exceptionally(ex -> { System.out.println("problem: " + ex.getMessage()); return 0.0; } )
		                 .thenApply(EssaiAsyncJava8V2::auCarre )
				         .thenApply(EssaiAsyncJava8V2::convertAsString)
	                     .thenAccept(EssaiAsyncJava8V2::displayString );
		
		System.out.println("suite main / interpreted by " + Thread.currentThread().getName());
		
		LongTask.simulateLongTask("pause pour eviter arrêt complet du programme avant la fin des taches de fond" ,  8000);
		System.out.println("fin main / interpreted by " + Thread.currentThread().getName());
	}
}
