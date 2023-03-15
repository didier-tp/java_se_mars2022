package tp.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import util.CsvIgnore;

public class Stat {
	private String label;
	private Double somme;
	private Double moyenne;
	
	//@CsvIgnore
	@JsonIgnore
	private Double ecartType;


	
	@Override
	public String toString() {
		return "Stat [label=" + label + ", somme=" + somme + ", moyenne=" + moyenne + ", ecartType=" + ecartType
				+ "]";
	}
	public Stat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stat(String label, Double somme, Double moyenne, Double ecartType) {
		super();
		this.label = label;
		this.somme = somme;
		this.moyenne = moyenne;
		this.ecartType = ecartType;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSomme() {
		return somme;
	}
	public void setSomme(Double somme) {
		this.somme = somme;
	}
	public Double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}
	public Double getEcartType() {
		return ecartType;
	}
	public void setEcartType(Double ecartType) {
		this.ecartType = ecartType;
	}
	
	
	
}
