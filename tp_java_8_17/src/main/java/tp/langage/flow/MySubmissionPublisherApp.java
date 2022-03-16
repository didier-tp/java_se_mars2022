package tp.langage.flow;

import java.util.concurrent.SubmissionPublisher;

public class MySubmissionPublisherApp {
	
	public static void pause(long nbMs) {
		try {
			System.out.println("** debut de pause de " + nbMs + " ms , thread:" + Thread.currentThread().getName());
			Thread.sleep(nbMs);
			System.out.println("** fin de pause de " + nbMs + " ms , thread:" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	   sansProcesseur();
	  // avecProcesseur();
	}
	public static void sansProcesseur() {
        SubmissionPublisher<Object> publisher = new SubmissionPublisher<>();
        publisher.subscribe(new MySimplePrintSubscriber("s1"));
        System.out.println("Submitting first items...");
        for (int i = 0; i < 10; i++) {
            publisher.submit(i); //.onNext() may be called on subscriber(s) if request(...)
            if(i==5) {
            	pause(1000);
            	publisher.subscribe(new MySimplePrintSubscriber("s2"));
            	System.out.println("Submitting others items...");
            }
        }
        pause(1000);
        publisher.close(); //.onComplete() will be called on subscriber(s)
	}
	
	public static void avecProcesseur() {
        //publisher <--> processor <--> subscriber
        AuCarreProcessor processor = new AuCarreProcessor();
        processor.subscribe(new MySimplePrintSubscriber("s1"));
        SubmissionPublisher<Object> publisher = new SubmissionPublisher<>();
        publisher.subscribe(processor);
        System.out.println("Submitting items...");
        for (int i = 0; i < 10; i++) {
            publisher.submit(i); //.onNext() may be called on subscriber(s) if request(...)
        }
        pause(1000);
        publisher.close(); //.onComplete() will be called on subscriber(s)
	}

}
