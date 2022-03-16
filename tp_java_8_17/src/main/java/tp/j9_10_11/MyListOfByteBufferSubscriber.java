package tp.j9_10_11;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

public class MyListOfByteBufferSubscriber implements Flow.Subscriber<List<ByteBuffer>> {
    private Subscription subscription;
    private StringBuilder stringBuilder = new StringBuilder(1024);
    private static final int NB_OTHER_ITEMS=1;
 
    public String getTextResult() {
    	return stringBuilder.toString();
    }
    
    private void requestSomeItems() {
        subscription.request(NB_OTHER_ITEMS);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        requestSomeItems();
    }

    @Override
    public void onNext(List<ByteBuffer> item) {
    	for(ByteBuffer bytes : item) {
    	   String s = StandardCharsets.UTF_8.decode(bytes).toString();
    	   stringBuilder.append(s);
    	}
  
        System.out.println("MyListOfByteBufferSubscriber>> Received item: " + item.toString());
                           
        requestSomeItems();
    }

    @Override

    public void onError(Throwable error) {
        System.out.println("MyListOfByteBufferSubscriber>> Error occurred: " + error.getMessage());
    }

    @Override

    public void onComplete() {
        System.out.println("MyListOfByteBufferSubscriber>> complete" + " thread:" + Thread.currentThread().getName());
        System.out.println("complete text:"+this.getTextResult());
    }

}
