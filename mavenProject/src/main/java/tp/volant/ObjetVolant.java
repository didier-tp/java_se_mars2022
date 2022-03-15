package tp.volant;

public abstract class ObjetVolant {
    private String couleur = "blanc";

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	abstract public int getPlafond(); //cette operation devra être codée dans les sous-classes
    
}
