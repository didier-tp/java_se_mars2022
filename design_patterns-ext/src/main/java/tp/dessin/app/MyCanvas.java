package tp.dessin.app;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import tp.dessin.ext.swing.SwingDrawingVisitor;
import tp.dessin.fig.Figure;

public class MyCanvas extends JPanel{
	

	private static final long serialVersionUID = 1L;
	
	private List<Figure> listeFigures;
	private SwingDrawingVisitor swingDrawingVistor = new SwingDrawingVisitor();

	public List<Figure> getListeFigures() {
		return listeFigures;
	}
	public void setListeFigures(List<Figure> listeFigures) {
		this.listeFigures = listeFigures;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		swingDrawingVistor.setGraphics(g);
		for(Figure f : this.listeFigures){
			//f.dessiner(g);//ancienne version sans visiteur
			f.performVisit(swingDrawingVistor);
		}
	}

}
