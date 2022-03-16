package tp.avec_lambda;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import tp.data.Product;
import tp.util.ProductUtil;

public class AppExemplesStreams {

	public static void main(String[] args) {
		
		String s = IntStream.iterate(1, i -> i * 2) //generation d'une sequence a priori infinie 1 , 2 , 4, ...
				.limit (10) //limitation a 10 iterations
				.mapToObj(String :: valueOf) //transformation de chaque element  en String
				.collect(Collectors.joining(" ; ")); //collector rassemblant tout en une seule grande chaine 
		                                             //via des concatenations (en boucle) avec le separateur/jointeur specifie
		System.out.println(s);
		//affiche 1 ; 2 ; 4 ; 8 ; 16 ; 32 ; 64 ; 128 ; 256 ; 512

		
		List<Product> listProd = ProductUtil.initSampleProductList();
		Optional<Product> ofp=listProd.stream().filter(p -> p.getPrice() >= 200).findFirst();
		System.out.println("premier produit trouve avec prix >= 200 :" + ofp.orElse(null));
		
		boolean auMoinsUnProduitExistantQuiCommenceParPrinter = 
				listProd.stream().anyMatch(p -> p.getLabel().startsWith("printer"));
		if(auMoinsUnProduitExistantQuiCommenceParPrinter)
			System.out.println("au moins un des produits existants commence par printer");
		
		
		double prixMaxi =listProd.stream().map(p -> p.getPrice()).reduce(Double::max).orElse(0.0);
		//double prixMaxi =listProd.parallelStream().map(p -> p.getPrice()).reduce(Double::max).orElse(0.0);
		//pourrait etre interessant avec collection de tres grande taille et processeur multi-coeurs
		System.out.println("prixMaxi="+prixMaxi);
		
		List<String> liste1 = Arrays.asList("rouge", "vert" , "bleu");
		List<String> liste2 = Arrays.asList("jaune", "orange" , "bleu");
		Set<String> ensembleCouleurs = Stream.concat(liste1.stream(), liste2.stream())
				                              .collect(Collectors.toSet());
		System.out.println("ensembleCouleurs="+ensembleCouleurs);
		List<String> listeCouleurs = Stream.concat(liste1.stream(), liste2.stream())
                							.distinct()
                							.collect(Collectors.toList());
		System.out.println("liste des couleurs (sans doublon)="+listeCouleurs);
		
		List <Point> points = Arrays.asList(new Point(1, 2),new Point(2, 4));
		System.out.println("liste de points =" + points);
		points.stream().forEach(p -> p.translate(10, 5));//forEach() = operation terminale (void)
		                                                 // p.translate() : void/ne retourne rien et modifie p 
		System.out.println("Apres translation(10,5) , liste de points =" + points);
		
	}

}
