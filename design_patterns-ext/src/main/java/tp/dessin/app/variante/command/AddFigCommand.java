package tp.dessin.app.variante.command;

import tp.dessin.app.v2.OngletDessinV2;
import tp.dessin.fig.Figure;

public class AddFigCommand extends AbstractFigCommand {
	
	private Figure fig;
	
	public AddFigCommand(OngletDessinV2 ongletDessinV2,Figure fig) {
		super(ongletDessinV2);
		this.fig= fig;
	}

	@Override
	public void execute() {
		ongletDessinV2.ajouterNouvelleFigure(fig);
	}

	@Override
	public void undo() {
		ongletDessinV2.retirerFigure(fig);
	}

}
