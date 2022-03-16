package tp.concurent.completable;

import java.util.concurrent.CompletableFuture;

import tp.concurent.task.LongTask;

public class EssaiAsyncJava8 {

	public static void main(String[] args) {
		
		//CompletableFuture<T> since jdk 1.8 , quelques similitudes avec callback et "Promise" de javascript
		System.out.println("debut main / interpreted by " + Thread.currentThread().getName());
	
		//initialisation asynchrone:
		//CompletableFuture<Void> cf = CompletableFuture.runAsync(aRunnableObject); //with no return result !!! 
		CompletableFuture<Double> completableFuture1 = 
				/*CompletableFuture.supplyAsync( new Supplier<Double>(){
					     public Double get(){ LongTask.simulateLongTask("long computing - p1" ,  2000); return 2.0; } 
				   });*/
				CompletableFuture.supplyAsync(()-> { LongTask.simulateLongTask("long computing - p1" ,  2000); 
				                                     /*throw new RuntimeException("exceptionXY");*/ return 2.0; } );
	
		//En cas d'exception en asynchrone/tâche de fond:
		CompletableFuture<Double> safecompletableFuture1 = 
						completableFuture1.exceptionally(ex -> { System.out.println("problem: " + ex.getMessage()); return 0.0; } );
		/*CompletableFuture<Double> safecompletableFuture1 = 
				completableFuture1.handle((resOk,ex) -> { 
					  if(resOk!=null) return resOk; 
					  else { System.out.println("problem: " + ex.getMessage()); return 0.0;} } );*/

		
		
		System.out.println("suite main A / interpreted by " + Thread.currentThread().getName());
		
		// continuations asynchrones (avec Function<T1,T2>):
		CompletableFuture<Double> completableFuture2 = 
				safecompletableFuture1.thenApply((x) -> { LongTask.simulateLongTask("long computing - p2" ,  2000); return x*x; } );
		        //safecompletableFuture1.thenApplyAsync( ... ); quelquefois exécuté par encore un autre thread
		CompletableFuture<String> completableFuture3 = 
				completableFuture2.thenApply((x) -> { LongTask.simulateLongTask("long computing - p3" ,  2000); return String.valueOf(x); } );
		
		
		System.out.println("suite main B / interpreted by " + Thread.currentThread().getName());
		//fin/terminaison asynchrone:
		completableFuture3.thenAccept((x) -> System.out.println(x) );
		//computableFuture.thenRun(()->System.out.println("ok"));//with no input !!!
		
		
		LongTask.simulateLongTask("pause pour eviter arrêt complet du programme avant la fin des taches de fond" ,  8000);
		System.out.println("fin main / interpreted by " + Thread.currentThread().getName());
		

	}

}
