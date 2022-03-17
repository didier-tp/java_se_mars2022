package tp.data;

public class Produit {
	private Integer id;
	private String label;
	private Double prixHt;
	
	
	private Double tauxTva;
	//+get,set , constructeur , toString()
	
	public Produit() {
		super();
	}
	
	public Produit(Integer id, String label, Double prixHt, Double tauxTva) {
		super();
		this.id = id;
		this.label = label;
		this.prixHt = prixHt;
		this.tauxTva = tauxTva;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", label=" + label + ", prixHt=" + prixHt + ", tauxTva=" + tauxTva + "]";
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrixHt() {
		return prixHt;
	}
	public void setPrixHt(Double prixHt) {
		this.prixHt = prixHt;
	}
	public Double getTauxTva() {
		return tauxTva;
	}
	public void setTauxTva(Double tauxTva) {
		this.tauxTva = tauxTva;
	}
	
	
}
