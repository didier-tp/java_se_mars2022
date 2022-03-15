package tp.dessin.fig;

public interface AbstractFigVisitor {
	public void doActionForCercle(Cercle c);
	public void doActionForRectangle(Rectangle r);
	public void doActionForLigne(Ligne l);
}
