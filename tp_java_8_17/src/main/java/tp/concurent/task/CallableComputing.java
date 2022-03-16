package tp.concurent.task;

import java.util.concurrent.Callable;

public class CallableComputing implements Callable<String>{
	private double x;

	@Override
	public String call() throws Exception {
		LongTask.simulateLongTask("long computing task (in background) ...", 5000);
		return String.valueOf(Math.sqrt(x));
	}
	
	public CallableComputing() {super();this.x = 0;	}
	public CallableComputing(double x) {super();this.x = x;	}

	public double getX() {	return x;	}
	public void setX(double x) {this.x = x;	}
}
