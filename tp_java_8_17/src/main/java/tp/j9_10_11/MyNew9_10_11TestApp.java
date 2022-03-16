package tp.j9_10_11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import tp.data.Product;
import tp.util.ProductUtil;

public class MyNew9_10_11TestApp {
	
	public static void test_steam_improvement_since_java9() {
		IntStream.iterate(1, i -> i < 5, i -> i + 1)
		         .forEach(System.out::println);
	}
	
	public static void test_collection_factory_method_of_since_java9(){
		List<String> ls2 = List.of("acb" , "def" , "ghi");//List.of(...) since java 9
		//ls2.add("jkl"); //java.lang.UnsupportedOperationException on java.util.ImmutableCollections
		ls2.stream().forEach(System.out::println);
		
		//IMMUTABLE COLLECTIONS --> .of(...) = BOF if immutable is not wished !!!
		
		Set<Integer> integers = Set.of(1,2,3,4); //List.of(...) since java 9
		//integers.add(5);//java.lang.UnsupportedOperationException / IMMUTABLE !
		integers.stream()
		         .map(i->i+1)
		         .forEach(System.out::println);
	}
	
	public static void test_private_interface_method_since_java9() {
		MyInterface obj = new MyItfImpl();
		System.out.println("obj.f2()="+obj.f2());
		System.out.println("obj.f3()="+obj.f3()); //same private sub method (for defaullt)
	}
	
	public static List<String> test_var_since_java10(){
		List<String> ls1 = new ArrayList<String>(); //since java 5
		List<String> ls2 = new ArrayList<>(); //since java 7 (diamond)
		var ls3 = new ArrayList<String>(); //type inference since java 10 with new keyword "var"
		
		ls3.add("abc"); ls3.add("def");
		ls3.stream().forEach(System.out::println);
		
		//NB "var" (since java 10) is not a reserved word.
		//an old variable may be nammed "var" :
		int var=12; //possible (but NOT ADVISED) .
		System.out.println("var="+var);
		return ls3;
	}
	
	public static void test_new_http2_client_since_java9_standard_since_java11() {
		
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest req =
		   HttpRequest.newBuilder(URI.create("http://www.google.com"))
		              .header("User-Agent","Java")
		              .GET()
		              .build();
      /*
        //En mode synchrone :
		try {
			HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
			System.out.println("reponse status:" + resp.statusCode()); //200 for ok
			System.out.println("reponse uri:" + resp.uri().toString()); //http://www.google.com
			System.out.println("reponse type:" + resp.headers().map().get("Content-Type"));//[text/html; charset=ISO-8859-1]
			System.out.println("reponse text:" + resp.body());//texte html  habituellement affiche par navigateur
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		*/
	
		//En mode asynchrone , sendAsync retournant un CompletableFuture : 
		client.sendAsync(req, BodyHandlers.ofString())
		      .thenAccept(resp -> {
		    		System.out.println("recuperation reponse asynchrone / interpreted by " + Thread.currentThread().getName());
		    	    System.out.println("reponse status:" + resp.statusCode()); 
					System.out.println("reponse uri:" + resp.uri().toString()); 
					System.out.println("reponse type:" + resp.headers().map().get("Content-Type"));
					System.out.println("reponse text size:" + resp.body().length());
					//System.out.println("reponse text :" + resp.body());
		      		});
        System.out.println("suite synchrone interpreted by " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);//pause ici pour eviter arret complet du programme 
			                    // avant la fin des taches de fond asynchrones
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("fin synchrone / interpreted by " + Thread.currentThread().getName());
		
	}
	
   public static void test_new_httpClient_withSubscriber() {
		
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest req =
		   HttpRequest.newBuilder(URI.create("http://www.google.com"))
		              .header("User-Agent","Java")
		              .GET()
		              .build();
		
		MySimplePrintSubscriber subscriber1 = new MySimplePrintSubscriber();
		MyListOfByteBufferSubscriber subscriber2 = new MyListOfByteBufferSubscriber();

		// BodyHandlers.fromLineSubscriber(s) for registering a subscriber that will receive response text line by line
		// the return CompletableFuture contains no body but status and other infos
		//client.sendAsync(req, BodyHandlers.fromLineSubscriber(subscriber1))
		client.sendAsync(req, BodyHandlers.fromSubscriber(subscriber2))
	      .thenApply(HttpResponse::statusCode) //extract statusCode from httpResponse
	      .thenAccept((status) -> {
	          if (status != 200) {
	              System.err.printf("ERROR: %d status received%n", status);
	          }
	      });
		
		
        System.out.println("suite synchrone interpreted by " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);//pause ici pour eviter arr�t complet du programme 
			                    // avant la fin des taches de fond asynchrones
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("fin synchrone / interpreted by " + Thread.currentThread().getName());
		
	}

	public static void main(String[] args) {
		//test_collection_factory_method_of_since_java9();
		//test_steam_improvement_since_java9();
		//test_private_interface_method_since_java9();
		var ls = test_var_since_java10();
		System.out.println("ls="+ls);
		//test_new_http2_client_since_java9_standard_since_java11();
		//test_new_httpClient_withSubscriber();
        testUnmodifiableCollection_since_java11();
	}

	private static void testUnmodifiableCollection_since_java11() {
		List<Product> listProd = ProductUtil.initSampleProductList();
		System.out.println("listProd="+listProd);
		List<Product> immutableListProd = Collections.unmodifiableList(listProd);
	
		//add , ... interdit sur immutableListProd !!!!
		//immutableListProd.add(new Product(6L,"produit 6",96.83,"azerty"));
	
		
		List<Product> listeProduitsTriesFiltresEtTransformes =
				immutableListProd.stream()
        		 .filter((p)->p.getPrice()>=100)
                 .sorted((p1,p2)->Double.compare(p1.getPrice(), p2.getPrice()))
                 //.map((p)-> new Product(p.getId(), p.getLabel().toUpperCase(), p.getPrice() , p.getFeatures()))
                 .map((p) -> { p.setLabel(p.getLabel().toUpperCase()); return p; })
                 .collect(Collectors.toList());

        
        //afficher la nouvelle liste construite.
        System.out.println("liste triée filtrée et transformée:\n" + listeProduitsTriesFiltresEtTransformes);
        
        //Attention: on peut tout de même modifier les objets reférencés par la liste !!!!
        System.out.println("immutableListProd modifiée ou pas:"+immutableListProd);
     
		
	}

}
