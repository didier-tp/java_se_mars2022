package tp.avec_lambda;

import java.util.List;
import java.util.stream.Collectors;

import tp.data.Product;
import tp.util.ProductUtil;

public class AppGestionProduitsAvecStream {
	public static void main(String[] args) {

		List<Product> listProd = ProductUtil.initSampleProductList();
		System.out.println("listProd="+listProd);
        
        //on va enchainer a partir de listProd.stream()
		//.filter(...) avec une lambda qui filtre les produits prix >=100
        //.sorted ( ... ) avec une lambda pour trier par ordre de prix croissant
        //.map (...)  avec une lambda qui va transformer les produits , label en majuscules
        //.collect(Collectors.toList());
		
		
		//exemple de lambda pour .map(...)
        // (p) -> { code_de_transformation_sur_p; return p_ou_chose_transforme; }
		
		//**** A COMPLETER ET TESTER:
        //List<Product> listeProduitsTriesFiltresEtTransformes =
        //		listProd.stream()
		//         .filter(__lambda_de_filtrage_qui_va_bien___)
        //         .sorted(__lambda_de_comparaison_qui_va_bien___)
        //         .map(__lambda_de_transformation_qui_va_bien___)
        //         .collect(__collecteur_qui_va_bien__);
        
       
        //afficher la nouvelle liste construite.
        //System.out.println("liste triee filtree et transform�e:\n" + listeProduitsTriesFiltresEtTransformes);
        
        
       //Version avec affichage direct en fin d'enchainement:
		//**** A COMPLETER ET TESTER:
        //System.out.println("idem via .forEach():");
        //listProd.stream()
        //         ....
        //         ....
        //         ....
        //         .forEach( __lambda_ou_reference_de_fonction_qui_va_bien___ );
        
        //"moyenne des prix de tous les produits:"
		//**** A COMPLETER ET TESTER:
        //Double sommePrix = listProd.stream()
        //         .map(__lambda_de_extraction_de_prix_qui_va_bien___)
        //         .reduce(0.0 , __lambda_de_addition_qui_va_bien___);
        //System.out.println("moyenne des prix de tous les produits:"+sommePrix/listProd.size());
	}
}
