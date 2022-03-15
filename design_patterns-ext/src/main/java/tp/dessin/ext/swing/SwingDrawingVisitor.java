package tp.dessin.ext.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import tp.dessin.fig.AbstractFigVisitor;
import tp.dessin.fig.Cercle;
import tp.dessin.fig.Figure;
import tp.dessin.fig.Ligne;
import tp.dessin.fig.Rectangle;

public class SwingDrawingVisitor implements AbstractFigVisitor {
	
	private Graphics g;
	
	private static Color javaColorFromString(String couleur) {
		switch(couleur) {
		case "blue" : return Color.BLUE;
		case "red" : return Color.RED;
		case "green" : return Color.GREEN;
		case "yellow" : return Color.YELLOW;
		case "orange" : return Color.ORANGE;
		case "black" :
		default: return Color.BLACK;
		}
	}
	
	public SwingDrawingVisitor() {
		super();
	}

	public SwingDrawingVisitor(Graphics g) {
		super();
		this.g = g;
	}

	public void setGraphics(Graphics g) {
		this.g = g;
	}
	
	private void highlighSelectedFig(Figure f) {
		Graphics2D g2 = (Graphics2D) g;
		if(f==Figure.getSelectedFig()) {
			g2.setStroke(new BasicStroke(3));
		}else {
			g2.setStroke(new BasicStroke(1));
		}
	}

	@Override
	public void doActionForCercle(Cercle c) {
		int x1=c.getXc()-c.getRayon();
		int y1=c.getYc()-c.getRayon();
		int width=2*c.getRayon();
		int height=2*c.getRayon();
		g.setColor(javaColorFromString(c.getCouleur()));
		highlighSelectedFig(c);
		g.drawOval(x1, y1, width, height);	
	}

	@Override
	public void doActionForRectangle(Rectangle r) {
		g.setColor(javaColorFromString(r.getCouleur()));
		highlighSelectedFig(r);
		g.drawRect(r.getX1(), r.getY1(), r.getL(), r.getH());	
	}

	@Override
	public void doActionForLigne(Ligne l) {
		g.setColor(javaColorFromString(l.getCouleur()));
		highlighSelectedFig(l);
		g.drawLine(l.getX1(),l.getY1(), l.getX2(), l.getY2());		
	}

}
