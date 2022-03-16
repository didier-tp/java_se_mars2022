package tp.concurent.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import tp.concurent.task.CallableComputing;
import tp.concurent.task.LongTask;

public class EssaisFuture {


	public static void main(String[] args) {
		//NB: Callable<T>/call() ressemble un peu à l'interface Running/run()
		//mais permet de récupérer (ultérieurement) un résultat via Future<T> .
		Callable<String> c = new CallableComputing(9); //pour calculer racine carre de 9 
		                                      // via tache de fond simulant traitement long ou lent durant 5s (5000ms)
		String result=null;
		ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> futureRes = executor.submit(c);
        while(result==null){
	        LongTask.simulateLongTask("other works ...",2000);
	        //on re-teste ici toutes les 2s si c'est fini ou pas
	        if(futureRes.isDone()){
	        	try {
					result = futureRes.get();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
	        }
        }
        System.out.println("result=" + result);
        System.out.println("---------------------");
        Future<String> futureRes2 = executor.submit(c);
        LongTask.simulateLongTask("other works ...",2000);
        if(futureRes2.isDone()){
        	try {
				result = futureRes2.get();
				System.out.println("result2=" + result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
        }
        else {
              futureRes2.cancel(true);
              if(futureRes2.isCancelled()){
            	  System.out.println("background computing was cancelled");
              }
        	}
        System.out.println("---------------------");
        Future<String> futureRes3 = executor.submit(c);
        LongTask.simulateLongTask("other works ...",2000);
        try {
			result = futureRes3.get(1500,TimeUnit.MILLISECONDS);
			System.out.println("result3=" + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.err.println("tâche 3 toujours pas terminée au bout de 1500ms");
			System.out.println("after 1500ms,futureRes3.isDone()="+futureRes3.isDone());
			System.out.println("after 1500ms,futureRes3.isCancelled()="+futureRes3.isCancelled());
			//e.printStackTrace();
		}
        executor.shutdown();//automatiquement différé , .shutdownNow() pour arrêt immédiat
	}

}
