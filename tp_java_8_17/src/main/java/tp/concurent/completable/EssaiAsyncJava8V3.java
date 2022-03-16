package tp.concurent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import tp.concurent.task.LongTask;

public class EssaiAsyncJava8V3 {
	
	//NB: CompletableFuture<U> est une classe qui implémente à la fois les interfaces Future<U> et CompletionStage<U> 
	
	// test thenCompose() , thenCombine()
	
	public static Double extractInitValue(){
		LongTask.simulateLongTask("long computing - initValue" ,  2000); 
        /*throw new RuntimeException("exceptionXY");*/ return 2.0; 
	}
	
	public static CompletionStage<Double> cfInitVal(){
		return CompletableFuture.supplyAsync(EssaiAsyncJava8V3::extractInitValue );
	}
	
	public static Double auCarre(Double x){
		 LongTask.simulateLongTask("long computing - auCarre" ,  2000); return x*x;
	}
	
	public static String convertAsString(Double x){
		LongTask.simulateLongTask("long computing - asString" ,  2000); return String.valueOf(x);
	}
	
	public static Double plus(Double x,Double y){
		LongTask.simulateLongTask("long computing - plus" ,  2000); return x+y;
	}
	
	public static CompletionStage<String> cfAsString(Double x){
		CompletableFuture<Double> cfDouble = new CompletableFuture<Double>();
		cfDouble.complete(x);
		System.out.println("*** tout le debut de cfAsString sans attente ****");
		return cfDouble.thenApplyAsync(EssaiAsyncJava8V3::convertAsString);
	}
	
	public static void displayString(String s){
		 System.out.println(s) ;
	}

	public static void main(String[] args) {
		
		 //NB: presque tout le contenu de ce main() existe en version ...Async(...) en déléguant à (encore un autre) Thread .
		
		 System.out.println("debut main de EssaiAsyncJava8V3");
		 //thenCompose register another future to apply/compose to thisFuture (without waiting) to produce a new future 
		 cfInitVal().thenCompose(EssaiAsyncJava8V3::cfAsString)
		            .thenAccept(EssaiAsyncJava8V3::displayString );
		
		 CompletableFuture<Double> cfD1 = new CompletableFuture<Double>();
		 cfD1.complete(3.0); //COMPLETE BY MAIN() --> NEED .thenApplyAsync() to be continued by other thread
	
		 CompletableFuture<Double> cfD2 = new CompletableFuture<Double>();
		 cfD2.complete(2.0); //COMPLETE BY MAIN() --> NEED .thenApplyAsync() to be continued by other thread
		 System.out.println("suite du main de EssaiAsyncJava8V3");
		 CompletableFuture<Double> cfD3 = cfD1.thenApplyAsync(EssaiAsyncJava8V3::auCarre);//3*3=9
		 CompletableFuture<Double> cfD4 = cfD2.thenApplyAsync(EssaiAsyncJava8V3::auCarre);//2*2=4
	
		 //thenCombine apply a biFunction from 2 futures (this & other) to produce a new future
		 CompletableFuture<Double> cfD5 = cfD3.thenCombine(cfD4, EssaiAsyncJava8V3::plus);//9+4=13
		 cfD5.thenAccept((x)->System.out.println(x));
	
		 //variantes proches de thenCombine : 
		 //   thenAcceptBoth(otherFuture, biConsumer ) --> action avec valeurs lorsque les 2 futures sont terminés
		 //   runAfterBoth(otherFuture, runnable ) --> action sans valeur lorsque les 2 futures sont terminés
		 CompletableFuture<Double> cfD6 = cfD1.thenApplyAsync(EssaiAsyncJava8V3::auCarre);//3*3=9
		 CompletableFuture<Double> cfD7 = cfD2.thenApplyAsync(EssaiAsyncJava8V3::auCarre);//2*2=4
		 cfD6.thenAcceptBoth(cfD7, (x,y) -> System.out.println(x*y));//9*4 = 36
		//variantes proches de thenAcceptBoth/runAfterBoth : 
		 //   thenAcceptEither(otherFuture, consumer ) --> action avec valeur lorsque le premier des 2 futures est terminé
		 //   runAfterEither(otherFuture, runnable ) --> action sans valeur lorsque le premier des 2 futures est terminé
		 
         //variante proche de thenAcceptEither --> thenApplyEither(otherFuture , function) --> génère un nouveau future (avec valeur)
		 // pour poursuivre un enchainement avec thenApply() ou autre.
		 
		 //il existe finalement des variantes avec nombres d'arguments variables:
		 // allOf(...) pour attendre la fin de n(3 ou plus) futures
		 // anyOf(...) pour attendre la fin du plus rapide parmi n 

		LongTask.simulateLongTask("pause pour eviter arrêt complet du programme avant la fin des taches de fond" ,  8000);
		System.out.println("fin main de EssaiAsyncJava8V3 / interpreted by " + Thread.currentThread().getName());
	}

}
