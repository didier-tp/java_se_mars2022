package tp.langage.flow;

import java.util.concurrent.SubmissionPublisher;

import tp.data.Product;
import tp.util.MyFileConsumer;

public class FromFilePublisherApp {
	
	private static MyFileConsumer myFileConsumer = new MyFileConsumer();
	
	public static void pause(long nbMs) {
		try {
			//System.out.println("** debut de pause de " + nbMs + " ms , thread:" + Thread.currentThread().getName());
			Thread.sleep(nbMs);
			//System.out.println("** fin de pause de " + nbMs + " ms , thread:" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//sansProcesseur();
		avecEtSansProcesseur();
	}
	
	public static void submitLoop(SubmissionPublisher<Object> publisher) {
		for (int i = 0; i < 24; i++) {
        	//Submitting file content if exists:
    		myFileConsumer.extractNewFileContentIfExists()
    		              .map((fileContent)->publisher.submit(fileContent));
            pause(5000); //retry every 5000ms (5s)
        }
        //en Tp ici : arret au bout de 24 * 5s = 2mm
        //sur vrai projet , on ferait mieux (Thread en tache de fond , ...)
        publisher.close(); //.onComplete() will be called on subscriber(s)

	}
	public static void sansProcesseur() {
        SubmissionPublisher<Object> publisher = new SubmissionPublisher<>();
        publisher.subscribe(new MySimplePrintSubscriber("s1"));
        publisher.subscribe(new MySimplePrintSubscriber("s2"));
        submitLoop(publisher);
    }
	
	public static void avecEtSansProcesseur() {
		SubmissionPublisher<Object> publisher = new SubmissionPublisher<>(); //source
		
		//intermédiaire convertissant json en objet java:
        JsonProcessor processor = new JsonProcessor(Product.class);
        
        
        /* A COMPLETER EN TP :
         //deux niveaux d'abonnement publisher <-- processor <--- subscriber "s_java"
         ....subscribe(....)
         ....subscribe(....)
      
        
        //abonnement direct (sans processeur): publisher <--- subscriber "s_json"
        ....subscribe(....)
        */
        submitLoop(publisher); //boucle d'attente de fichiers produit...json à
                               //recopier dans le répertoire ./files/input
	}

}
