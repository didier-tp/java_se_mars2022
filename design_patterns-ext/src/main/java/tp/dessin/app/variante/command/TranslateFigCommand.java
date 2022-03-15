package tp.dessin.app.variante.command;

import java.awt.Color;

import tp.dessin.app.v2.OngletDessinV2;
import tp.dessin.fig.Figure;

public class TranslateFigCommand extends AbstractFigCommand {
	
	private Figure fig;
	private Translation translation;

	
	public TranslateFigCommand(OngletDessinV2 ongletDessinV2,Figure fig,Translation translation) {
		super(ongletDessinV2);
		this.fig= fig;
		this.translation=translation;
	}

	@Override
	public void execute() {
		fig.translate(translation.dx, translation.dy);
		ongletDessinV2.rafraichirDessin();
	}

	@Override
	public void undo() {
		fig.translate(-translation.dx, -translation.dy);
		ongletDessinV2.rafraichirDessin();
	}

}
