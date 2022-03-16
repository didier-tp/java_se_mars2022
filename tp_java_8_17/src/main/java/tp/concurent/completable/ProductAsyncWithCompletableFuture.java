package tp.concurent.completable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import tp.concurent.task.LongTask;
import tp.data.Product;
import tp.util.MyFileConsumer;
import tp.util.ProductUtil;

public class ProductAsyncWithCompletableFuture {
	
	
	public static String fetchFavoriteCategory(){
		String category = null;
		MyFileConsumer myFileConsumer = new MyFileConsumer();
		int nbTry=0;
		while(category==null && nbTry < 20) {
		   nbTry++;
		   LongTask.simulateLongTask("waiting 2000ms before (re-)trying fetch category file in files/input" ,  2000);
		   category = myFileConsumer.extractNewFileContentIfExists().orElse(null);
		}
		if(category==null) {
			category="other"; //default value
		}
		System.out.println("category="+category);
        return category; 
	}
	

	
	public static List<Product> fetchProductListByCategory(String category){
		LongTask.simulateLongTask("fetch products , ... async waiting in background ..." ,  1000); 
        /*throw new RuntimeException("exceptionXY");*/ return ProductUtil.initSampleProductListByCategory(category); 
	}
	
	
	

	public static void main(String[] args) {
		System.out.println("debut main / interpreted by " + Thread.currentThread().getName());
		
		/* A faire en TP:
		
        enregistrer l'enchainement des traitements asynchrones suivants 
        - recupération de la categorie favorite choisie (par copie d'un fichier ....txt du
          répertoire files/to_copy dans le répertoire files/input (voir code source de tp.util.MyFileConsumer)
        - récupération d'une liste de produit en fonction de la categorie choisie
        - affichage de la liste des produits
        
        via du code de ce genre : 
        CompletableFuture.supplyAsync(__lambda_ou_refFonction_qui_va_bien_pour_recuperer_FavoriteCategory__)
		.thenApply(__lambda_qui_va_bien_pour_recuperer_listProduit_selon_category____ )
        .thenAccept(__lambda_ou_refFonction_qui_va_bien_pour_afficher_listProduit____);
        
        //NB: on s'appuira sur les méthodes en haut de cette classe et sur ProductUtil 
		*/
		
		System.out.println("suite main / interpreted by " + Thread.currentThread().getName());
		
		LongTask.simulateLongTask("pause pour eviter arrêt complet du programme avant la fin des taches de fond" ,  2000 * 22);
		System.out.println("fin main / interpreted by " + Thread.currentThread().getName());
	}
}
