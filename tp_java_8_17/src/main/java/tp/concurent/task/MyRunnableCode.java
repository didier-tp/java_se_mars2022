package tp.concurent.task;

public class MyRunnableCode implements Runnable {
	private String prefix;
	
	public MyRunnableCode() {	super();		this.prefix = "";	}
	public MyRunnableCode(String prefix) {		super();		this.prefix = prefix;	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {			
		}
		System.out.println(prefix+Thread.currentThread().getName());
	}
}
