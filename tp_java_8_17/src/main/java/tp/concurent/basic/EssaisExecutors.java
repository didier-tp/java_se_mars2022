package tp.concurent.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import tp.concurent.task.MyRunnableCode;

//ExecutorService depuis jdk 1.5
public class EssaisExecutors {

	// Un "ExecutorService" (à fabriquer via Executors.new....Executor()) 
	// démarre automatiquement des Threads (rangés dans des "pools") pour executer des instances de Callabale<T> ou de Runnable
	public static void main(String[] args) {
		
		MyRunnableCode myRunnableCode = new MyRunnableCode("*");
		
		System.out.println("* = préfixe pour taches en exécutions séquentielles");
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(); //exécution séquentielle en background
		singleThreadExecutor.submit(myRunnableCode);
		singleThreadExecutor.submit(myRunnableCode);
		singleThreadExecutor.submit(myRunnableCode);
		singleThreadExecutor.shutdown();//automatiquement différé
		
		MyRunnableCode myRunnableCode2 = new MyRunnableCode("#");
		System.out.println("# = préfixe pour taches en exécutions potentiellement parallèles");
		ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(3); //éxécutions multiples (en //) en background
		multiThreadExecutor.submit(myRunnableCode2);
		multiThreadExecutor.submit(myRunnableCode2);
		multiThreadExecutor.submit(myRunnableCode2);
		multiThreadExecutor.shutdown();//automatiquement différé , .shutdownNow() pour arrêt immédiat
		
		MyRunnableCode myRunnableCode3 = new MyRunnableCode("@");
		
		ScheduledExecutorService scheduleExecutor = Executors.newSingleThreadScheduledExecutor();
		System.out.println("Lancement d'un thread (@) en différé (2000ms)");
		scheduleExecutor.schedule(myRunnableCode3, 2000, TimeUnit.MILLISECONDS);
		scheduleExecutor.shutdown();//automatiquement différé , .shutdownNow() pour arrêt immédiat
	}

}
