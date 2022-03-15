package tp.dessin.app.variante.command;

import java.awt.Color;

import tp.dessin.app.v2.OngletDessinV2;
import tp.dessin.fig.Figure;

public class ResizeFigCommand extends AbstractFigCommand {
	
	private Figure fig;
	private double coeff;

	
	public ResizeFigCommand(OngletDessinV2 ongletDessinV2,Figure fig,double coeff) {
		super(ongletDessinV2);
		this.fig= fig;
		this.coeff=coeff;
	}

	@Override
	public void execute() {
		fig.resize(coeff);
		ongletDessinV2.rafraichirDessin();
	}

	@Override
	public void undo() {
		fig.resize(1/coeff);
		ongletDessinV2.rafraichirDessin();
	}

}
