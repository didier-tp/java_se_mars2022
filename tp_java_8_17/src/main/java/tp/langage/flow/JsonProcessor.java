package tp.langage.flow;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessor extends SubmissionPublisher<Object> implements Subscriber<Object> {
    private Subscription subscription;
    
    private static ObjectMapper jacksonObjectMapper = new ObjectMapper();
    
    private Class extractClass;
    
    public JsonProcessor(Class extractClass){
    	super();
    	this.extractClass = extractClass ; //ex: Product.class
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);//indiquer que l'on est pret à traiter la première entrée
    }

    @Override
    public void onNext(Object item) {
    	try {
			Object p = jacksonObjectMapper.readValue(item.toString(), extractClass);
			//System.out.println("p from json string="+p);
			submit(p); //envoyer le resultat de la conversion "json vers java" aux abonnés
			subscription.request(1); //indiquer que l'on est pret à traiter une nouvelle entrée
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void onError(Throwable error) {
        error.printStackTrace();
        closeExceptionally(error);
    }

    @Override
    public void onComplete() {
        System.out.println("JsonProcessor completed");
        close();
    }
}
