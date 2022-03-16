package tp.avec_lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import tp.data.Product;
import tp.sam.IsMapped;
import tp.util.ProductUtil;

public class AppGestionProduitsAvecLambda {
	
	public static void testStaticMethodOfInterface() {
		int age=20;
		IsMapped.printIfTrue(age>=18, "adulte");
		IsMapped.printEither(age>=18, "majeur" , "mineur");
	}

	public static void main(String[] args) {
		List<Product> listProd = ProductUtil.initSampleProductList();
		System.out.println("listProd="+listProd);
		
		//List<Product> subListCheapProducts = ProductUtil.extractSubListByPredicate(listProd,___lambda__qui_va_bien____);
		//NB: sur ce premier exemple de lambda , effectuer plusieurs essais avec les differentes
		//variations syntaxiques possibles (avec ou sans () , avec ou sans { } , ...)
		//System.out.println("subListCheapProducts="+subListCheapProducts);
		
		//List<Product> subListCheapProductsV2 = 
		//		ProductUtil.extractSubListByPredicate(listProd,	__reference_fonction_qui_va_bien___);
		//System.out.println("subListCheapProductsV2="+subListCheapProductsV2);
				
		//List<Product> subListComputerProducts = ProductUtil.extractSubListByPredicate(listProd,___lambda__qui_va_bien____);
		//System.out.println("subListComputerProducts="+subListComputerProducts);
		
		//List<Product> subListComputerProductsV2 = 
		//		ProductUtil.extractSubListByPredicate(listProd,__reference_fonction_qui_va_bien___);
		//System.out.println("subListComputerProductsV2="+subListComputerProductsV2);
		
		//Collections.sort(listProd, ___lambda__qui_va_bien____ );
		//System.out.println("listProd par prix croissant="+listProd);
		
		//Collections.sort(listProd, ___lambda__qui_va_bien____ );
		//System.out.println("listProd trie par label="+listProd);
		
		testStaticMethodOfInterface();
		
		//List<String> categories = Arrays.asList( "Computer" , "Printer" );
		//Map<String,List<Product>> mapProducts = ProductUtil.buildMapFromAssociatedValues(categories , listProd,
		//		___lambda__qui_va_bien____ );
		//System.out.println("mapProducts (by categories)="+mapProducts);
	}

}
