package tp.j15_16_17;

import java.util.List;
import java.util.function.Function;

import tp.data.Figure;
import tp.util.FigureUtil;

public class SyntheseTestApp {
	
	private List<Figure> listeFigures = FigureUtil.initSampleFigureList();

	public static void main(String[] args) {
		// Exercice de synthese (avec code à compléter)
		SyntheseTestApp  syntheseTestApp = new SyntheseTestApp();
		syntheseTestApp.selonTypeFigure();
		syntheseTestApp.autresExperimentationsSelonInspirationDuMoment();
	}

	private void selonTypeFigure() {
		for(Figure fig : listeFigures) {
		//switch/case avec lambda expression
		//PHASE1: afficher LIGNE (en francais) si fig.type vaut Figure.TYPE_LINE 
		//             RECTANGLE si fig.type vaut Figure.TYPE_RECTANGLE
        //             CERCLE (en francais)  si fig.type vaut Figure.TYPE_CIRCLE
		//             TYPE DE FIGURE INCONNU sinon (par défaut)
		/*
		switch(fig.getType()) {
		    //....
		    // à compléter en TP (phase1)
		    //....
		};
		*/
			
		/*
		//PHASE2: via switch/case en tant qu'expression retournant valeur
		//et pour chaque case :
		//      fonctionalité de la PHASE1 ET
		//      via yield , retourner une fonction de transformation adéquate
		Function<Figure,Object> transformationFunction =
				switch(fig.getType()) {
				    //....
				    // à compléter en TP (phase2)
				    //....
				};
				
		Object resTransformation = transformationFunction.apply(fig);
		System.out.println("resTransformation="+resTransformation);
		*/
			
		}
	
	}
	
	private void autresExperimentationsSelonInspirationDuMoment() {
	   //....
	}

}
