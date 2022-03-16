package j5;

public class Assiette {
	
	private String couleur;
	private Integer numero;
	
	
	
	@Override
	public String toString() {
		return "Assiette [couleur=" + couleur + ", numero=" + numero + "]";
	}

	public Assiette() {
		super();
	}

	public Assiette(String couleur, Integer numero) {
		super();
		this.couleur = couleur;
		this.numero = numero;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
