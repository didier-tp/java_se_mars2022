package tp.langage.flow;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

public class AuCarreProcessor extends SubmissionPublisher<Object> implements Subscriber<Object> {
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
    	double val = Double.parseDouble(item.toString());
        submit(String.valueOf(val*val));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable error) {
        error.printStackTrace();
        closeExceptionally(error);
    }

    @Override
    public void onComplete() {
        System.out.println("AuCarreProcessor completed");
        close();
    }
}
