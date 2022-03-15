package tp.dessin.app.variante.command;

import tp.dessin.app.v2.OngletDessinV2;

public abstract class AbstractFigCommand implements FigCommand {
	
	protected OngletDessinV2 ongletDessinV2;

	public AbstractFigCommand(OngletDessinV2 ongletDessinV2) {
		this.ongletDessinV2 = ongletDessinV2;
	}

	public AbstractFigCommand() {

	}
	

}
