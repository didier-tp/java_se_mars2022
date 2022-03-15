package tp.dessin.ext.svg;

import java.text.MessageFormat;

import tp.dessin.fig.AbstractFigVisitor;
import tp.dessin.fig.Cercle;
import tp.dessin.fig.Ligne;
import tp.dessin.fig.Rectangle;

public class SvgGenerateVisitor implements AbstractFigVisitor {
	
	StringBuffer svgContent = new StringBuffer();
	
	
	public StringBuffer getSvgContent() {
		return svgContent;
	}

	public void setSvgContent(StringBuffer svgContent) {
		this.svgContent = svgContent;
	}

	@Override
	public void doActionForCercle(Cercle c) {
		String format="<circle cx=''{0}'' cy=''{1}'' r=''{2}'' style=''stroke:{3};stroke-width:1;fill-opacity:0'' />";		
		svgContent.append(MessageFormat.format(format, c.getXc(),c.getYc(),c.getRayon(),c.getCouleur()));
	}

	@Override
	public void doActionForRectangle(Rectangle r) {
		String format="<rect x=''{0}'' y=''{1}'' width=''{2}'' height=''{3}'' style=''stroke:{4};stroke-width:1;fill-opacity:0'' />";		
		svgContent.append(MessageFormat.format(format, r.getX1(),r.getY1(),r.getL(),r.getH(),r.getCouleur()));
	}

	@Override
	public void doActionForLigne(Ligne l) {
		 String format=
				  "<line x1=''{0}'' y1=''{1}'' x2=''{2}'' y2=''{3}''  style=''stroke:{4}'' />";		
		 svgContent.append( MessageFormat.format(format,
						 l.getX1(),l.getY1(),l.getX2(),l.getY2(),l.getCouleur()));
	}

}
