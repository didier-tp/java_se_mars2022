package tp;

public abstract class ObjetVolant {
    private String couleur = "blanc";

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	abstract int getPlafond(); //cette operation devra �tre cod�e dans les sous-classes
    
}
