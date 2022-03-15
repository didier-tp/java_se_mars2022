package tp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class Cercle /* extends Object */ {
	
	//attributs (données internes , variables d'instances)
	private int xc;//centre du cercle (xc,yc)
	private int yc;
	private int rayon; //valeur par défaut 0
	private String couleur = "black"; //valeur par défaut null
	
	public double perimetre() {
		double p = 0.0;//pas de valeur par défaut 
		               //pour variable locale (interne dans méthode)
		p = 2 * Math.PI * this.rayon;
		return p;
	}
	
	
	public Cercle(int xc, int yc, int rayon, String couleur) {
		this.xc = xc;
		this.yc = yc;
		this.rayon = rayon;
		this.couleur = couleur;
	}
   
	

}
