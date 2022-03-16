package tp.concurent.basic;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import tp.concurent.task.LongTask;

public class EssaiSemaphore {

	public static void main(String[] args) {
	
		Semaphore semaphore = new Semaphore(0);
		
		Thread t = new Thread(()-> { LongTask.simulateLongTask("background thread work ..." , 3000); semaphore.release();});
		t.start();
		
		System.out.println("... faire autre chose ...");
		
		//attendre la disponibilité du sémaphore:
		try {
			//semaphore.acquire();
			if(semaphore.tryAcquire(5, TimeUnit.MINUTES)){
				System.out.println("semaphore acquis");
			}else{
				System.out.println("after 5mn (semaphore toujours pas disponible)");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
