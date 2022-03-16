package tp.langage.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

public class MySimplePrintSubscriber implements Flow.Subscriber<Object> {

    private Subscription subscription;
    private String subscriberName;
    private int nbTotalReceived = 0;
    private int nbTotalRequest = 0;
    private static final int NB_OTHER_ITEMS=4;
    
    public MySimplePrintSubscriber(){
    	this.subscriberName="mySimplePrintSubscriber";
    }
    
    public MySimplePrintSubscriber(String subscriberName){
    	this.subscriberName=subscriberName;
    }
    
    private void requestSomeItems() {
        subscription.request(NB_OTHER_ITEMS);
        this.nbTotalRequest+=NB_OTHER_ITEMS;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println(this.subscriberName + ">> Received subscription notification" + " thread:" + Thread.currentThread().getName());
        requestSomeItems();
    }

    @Override
    public void onNext(Object item) {
    	 this.nbTotalReceived++;
        System.out.println(this.subscriberName + ">> Received item: " + item.toString() + " thread:" + Thread.currentThread().getName()
        		            + " nbTotalRequest="+this.nbTotalRequest + " nbTotalReceived="+this.nbTotalReceived);
        if(nbTotalReceived==nbTotalRequest) {
        	requestSomeItems();
        }
    }

    @Override

    public void onError(Throwable error) {
        System.out.println(this.subscriberName + ">> Error occurred: " + error.getMessage());
    }

    @Override

    public void onComplete() {
        System.out.println(this.subscriberName + ">> complete" + " thread:" + Thread.currentThread().getName());
    }

}
