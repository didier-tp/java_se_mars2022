package tp.dessin.app.variante.command;

import tp.dessin.app.v2.OngletDessinV2;
import tp.dessin.fig.Figure;

public class ChangeColorFigCommand extends AbstractFigCommand {
	
	private Figure fig;
	private String newColor;
	private String oldColor; //memento
	
	public ChangeColorFigCommand(OngletDessinV2 ongletDessinV2,Figure fig,String newColor) {
		super(ongletDessinV2);
		this.fig= fig;
		this.newColor=newColor;
		this.oldColor = fig.getCouleur();
	}

	@Override
	public void execute() {
		fig.setCouleur(this.newColor);
		ongletDessinV2.rafraichirDessin();
	}

	@Override
	public void undo() {
		fig.setCouleur(this.oldColor);//restore old (memento) color
		ongletDessinV2.rafraichirDessin();
	}

}
