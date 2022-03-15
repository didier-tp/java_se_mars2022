package tp;

public class Cercle /* extends Object */ {
	
	//attributs (données internes , variables d'instances)
	private int xc;//centre du cercle (xc,yc)
	private int yc;
	private int rayon; //valeur par défaut 0
	private String couleur; //valeur par défaut null
	
	public double perimetre() {
		double p = 0.0;//pas de valeur par défaut 
		               //pour variable locale (interne dans méthode)
		p = 2 * Math.PI * this.rayon;
		return p;
	}
	
	
	public Cercle() {
		this.couleur = "black";
		//this.setCouleur("black");
	}
	
	

	@Override
	public String toString() {
		return "Cercle [xc=" + xc + ", yc=" + yc + ", rayon=" + rayon + ", couleur=" + couleur + "]";
	}


	public Cercle(int xc, int yc, int rayon, String couleur) {
		this.xc = xc;
		this.yc = yc;
		this.rayon = rayon;
		this.couleur = couleur;
	}
   
	public int getXc() {
		return xc;
	}
	public void setXc(int xc) {
		this.xc = xc;
	}
	public int getYc() {
		return yc;
	}
	public void setYc(int yc) {
		this.yc = yc;
	}
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
	

}
