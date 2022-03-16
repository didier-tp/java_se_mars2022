package tp.util;


import java.util.ArrayList;
import java.util.List;

import tp.data.Figure;

public class FigureUtil {
	
public static List<Figure> initSampleFigureList(){
	var figureList = new ArrayList<Figure>();
	figureList.add(new Figure("line",10,10,100,100,"red"));
	figureList.add(new Figure("rectangle",5,5,120,120,"blue"));
	figureList.add(new Figure("circle",40,40,80,80,"green"));
	figureList.add(new Figure("line",10,10,100,10,"black"));
	figureList.add(new Figure("ellipse",10,10,100,30,"orange"));//"ellipse" = unknown type
	//...
	return figureList;
	}

public static Object figureToLine(Figure fig) {
	return "Line from " + fig.toString(); 
	//ce code sera ultérieurement amélioré en PHASE3
	//En PHASE3 , créer et retourner une instance de Dto.LineRecord
	//ayant les propriétés x1,y1,x2,y2 et lineColor
}

public static Object figureToRectangle(Figure fig) {
	return "Rectangle from " + fig.toString();
	//ce code sera ultérieurement amélioré en PHASE3
	//En PHASE3 , créer et retourner une instance de Dto.RectangleRecord
	//ayant les propriétés x1,y1,largeur,hauteur et fillColor
	//largeur=x2-x1 , hauteur=y2-y1
}

public static Object figureToCircle(Figure fig) {
	return "Circle from " + fig.toString();
	//ce code sera ultérieurement amélioré en PHASE3
	//En PHASE3 , créer et retourner une instance de Dto.CircleRecord
	//ayant les propriétés xc,yc,radius et fillColor
	//largeur=x2-x1 , hauteur=y2-y1
	//xc=x1+largeur/2 , yc=y1+hauteur/2
	//radius = (int) Math.sqrt(Math.pow(largeur/2,2)+ Math.pow(hauteur/2,2))
}

public static Object figureToUnknown(Figure fig) {
	return "Unknown from " + fig.toString();
	//ce code sera ultérieurement amélioré en PHASE3
	//En PHASE3 , créer et retourner une instance de Dto.FigureRecord
	//pour un type de figure inconnu , Dto.FigureRecord aura une structure tres proche de Figure
}

//+ autres essais/expérimentations libres (selon inspiration et envies)
	public static void main(String[] args) {
		//main secondaire/alternatif pour expérimentations libres:
	}

}
