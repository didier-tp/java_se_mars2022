package tp.data;

import tp.annotations.CsvIgnore;

public class Product {
	private Long id;
	private String label;
	private Double price;
	
	@CsvIgnore
	private String features;
	
	
	public Product() {
		super();
	}


	public Product(Long id, String label, Double price, String features) {
		super();
		this.id = id;
		this.label = label;
		this.price = price;
		this.features = features;
	}
	
	//pour pouvoir ecrire ailleurs  .filter( Product::auMoins100Euros)
	public boolean auMoins100Euros(){
		return this.getPrice() >= 100;
	}
	
	//pour pouvoir ecrire ailleurs   .filter( Product::prodAuMoins100Euros)
	public static boolean prodAuMoins100Euros(Product p){
		return p.getPrice() >= 100;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", label=" + label + ", price=" + price /*+ ", features=" + features*/ + "]";
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	
	
}
