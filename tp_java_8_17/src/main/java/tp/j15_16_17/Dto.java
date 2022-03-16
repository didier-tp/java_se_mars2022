package tp.j15_16_17;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class Dto {
	
	public record Address(Integer number,String street,String zipCode,String town) {
	};
	
	public record Person(Integer id,String firstName,String lastName,Address address) {
		public Person(Integer id,String firstName,String lastName) {
			this(id,firstName,lastName,null);
		}
	};
	
	//... record LineRecord(...) en PHASE3 du Tp de Synthese
	
	//... record RectangleRecord(...) en PHASE3 du Tp de Synthese
	
	//... record CircleRecord(...) en PHASE3 du Tp de Synthese
	
	//... record FigureRecord(...) en PHASE3 du Tp de Synthese

	
	//En PHASE4 du Tp de synthese , redéfinir la méthode .toString() de chaque
	// ...Record de maniére à générer une chaine de caractère au format JSON
	//en s'appuyant sur un TextBloc multiline (encadré par """ et """)
	//et en utilisant .formatted(...,...,...,...);
}
