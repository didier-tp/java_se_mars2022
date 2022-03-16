package tp.concurent.task;

public class LongTask {
	
  public static void printThread(){
	  System.out.println(Thread.currentThread().getName() );
  }

  public static void simulateLongTask(String msg,long nbMs){
		try {
			System.out.println(">>(begin)" + msg + " / by " + Thread.currentThread().getName());
			Thread.sleep(nbMs);
			System.out.println("<<(end)" + msg + " / by " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("** interrupted **");
		}
	}
}
