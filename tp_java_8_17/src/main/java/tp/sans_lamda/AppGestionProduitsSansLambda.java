package tp.sans_lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import tp.data.Product;
import tp.sam.IsMapped;
import tp.util.ProductUtil;

public class AppGestionProduitsSansLambda {
	
	public static void main(String[] args) {
		List<Product> listProd = ProductUtil.initSampleProductList();
		System.out.println("listProd="+listProd);
		
		List<Product> subListCheapProducts = ProductUtil.extractSubListByPredicate(listProd,
				new Predicate<Product>(){
					@Override
					public boolean test(Product p) {
						return p.getPrice() <= 100;
					}
				});
		System.out.println("subListCheapProducts="+subListCheapProducts);
		
		
		List<Product> subListComputerProducts = ProductUtil.extractSubListByPredicate(listProd,
				new Predicate<Product>(){
					@Override
					public boolean test(Product p) {
						return p.getLabel().contains("computer");
					}
				});
		System.out.println("subListComputerProducts="+subListComputerProducts);
		
		Collections.sort(listProd, new java.util.Comparator<Product>(){
			@Override
			public int compare(Product p1, Product p2) {
				return Double.compare(p1.getPrice(), p2.getPrice());
				}
			});
		System.out.println("listProd par prix croissant="+listProd);
		
		Collections.sort(listProd, new java.util.Comparator<Product>(){
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getLabel().compareTo(p2.getLabel());
				}
			});
		System.out.println("listProd trié par label="+listProd);
		
		List<String> categories = Arrays.asList( "Computer" , "Printer" );
		Map<String,List<Product>> mapProducts = ProductUtil.buildMapFromAssociatedValues(categories , listProd,
				new IsMapped<Product>(){
					@Override
					public boolean isAssociatedWith( String keyValue, Product p ) {
							return p.getLabel().toLowerCase().startsWith(keyValue.toLowerCase());
					}
				});
		System.out.println("mapProducts (by categories)="+mapProducts);
	}

}
