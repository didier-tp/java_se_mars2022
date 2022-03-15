package tp.dessin.fig;

import java.awt.Color;
import java.io.Serializable;

public abstract class  Figure implements Serializable , Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private String couleur;
	private static Figure selectedFig = null;
	
	public enum TypeFigure { LIGNE , RECTANGLE, CERCLE , AUTRE };
	
	
	public Figure(){
		couleur="black";//couleur par defaut
	}
	
	@Override
	public Figure clone() throws CloneNotSupportedException {   
		return (Figure)super.clone();
	} 
	
	
	public Figure cloneFig() {
		Figure f =null;
		try {
			f=(Figure) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return f;
	}

	abstract public void translate(int dx,int dy);
	abstract public void resize(double coeff);
	abstract public void setOrigin(int x,int y);
	
	abstract public void performVisit(AbstractFigVisitor figVisitor);

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}



	public static Figure getSelectedFig() {
		return selectedFig;
	}

	public static void setSelectedFig(Figure selectedFig) {
		Figure.selectedFig = selectedFig;
	}
	

}
