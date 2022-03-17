package tp.avec_lambda.solutions;

import java.util.Collections;
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
		
		//listProd = Collections.unmodifiableList(listProd); //depuis java 10,11
		//listProd.add(new Product(99L,"prod99",99.99,"abc")); //interdit si unmodifiable/immutable
		
        List<Product> listeProduitsTriesFiltresEtTransformes =
        		listProd.stream()
        		 .filter((p)->p.getPrice()>=100)
        		 //.filter( Product::auMoins100Euros)
        		 //.filter( Product::prodAuMoins100Euros)
                 .sorted((p1,p2)->Double.compare(p1.getPrice(), p2.getPrice()))
                 .map((p)-> new Product(p.getId(), p.getLabel().toUpperCase(), p.getPrice() , p.getFeatures()))
                 //.map((p) -> { p.setLabel(p.getLabel().toUpperCase()); return p; })//MOINS BIEN
                 .collect(Collectors.toList());
        
        //exemple de lambda pour .map(...)
        // (p)-> new Product(p.getId(), p.getLabel().toUpperCase(), p.getPrice() , p.getFeatures())
        
        //afficher la nouvelle liste construite.
        System.out.println("liste triée filtrée et transformée:\n" + listeProduitsTriesFiltresEtTransformes);
        System.out.println("listeProd modifiée ou pas:"+listProd);
        
       //Version avec affichage direct en fin d'enchainement:
        System.out.println("idem via .forEach():");
        listProd.stream()
                 .filter((p)->p.getPrice()>=100)
                 .sorted((p1,p2)->Double.compare(p1.getPrice(), p2.getPrice()))
                 .map((p)-> new Product(p.getId(), p.getLabel().toUpperCase(), p.getPrice() , p.getFeatures()))
                 .forEach( (p) -> System.out.println(p) );
        
        //"moyenne des prix de tous les produits:"
        Double sommePrix = listProd.stream()
                 .map((p) -> p.getPrice())
                 .reduce(0.0 , (x,y) -> x+y);
        System.out.println("moyenne des prix de tous les produits:"+sommePrix/listProd.size());
        
        Double moyennePrixV2 = listProd.stream()
                .map(p -> p.getPrice())
                .mapToDouble(val -> val).average().orElse(0.0);
                //NB: .mapToDouble() preparer l'opération terminale .average()
                //de type appel de fonction sur un paquet de Double
       System.out.println("moyenne des prix de tous les produits (v2):"+moyennePrixV2);
	}
}
