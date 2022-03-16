package tp.test;

import tp.data.Address;

public class TestLombokApp {

	public static void main(String[] args) {
		Address adr = new Address("12","rue X" , "75000" , "Paris");
		System.out.println("num rue=" + adr.getNumber());
        /*
         NB: pour que l'ide (ex: eclipse) reconnaisse bien les .get/set
         générés automatiquement par lombok , il faut au moins une fois :
         - repérer lombok...jar dans $HOME/.m2/repository/org/projetlombok/lombok/...
         - double click dessus sous windows
         - sélectionner ou préciser le chemin menant à l'IDE utilisé 
           (ex : ...../eclipse)
         - cliquer sur "install ..." ce qui a pour effet de modifier eclipse.ini ou équivalent
         - redémarrer l'IDE (eclipse ou autre) 
         - relancer un build si nécessaire
         */
	}

}
