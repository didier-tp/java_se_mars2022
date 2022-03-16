package tp.j15_16_17;

import java.util.ArrayList;

//sealed keyword can be used if option "enabled preview features for java 16"
public class TestSealedApp {

	public static void main(String[] args) {
		testSealed();
	}
	
   public static void operationOnSealed(AnimalDomestique a) {
		if(a instanceof Chien chien) {
			chien.aLaNiche();
			if(chien instanceof ChienFou chienFou) {
				chienFou.tournerEnRond();
			}
		}
		if(a instanceof Chat chat) {
			chat.ronronner();
		}
	}
	
	public static void testSealed() {
		
		var animauxDomestiques = new ArrayList<AnimalDomestique>();
		animauxDomestiques.add(new Chat());
		animauxDomestiques.add(new Chien());
		animauxDomestiques.add(new ChienFou());
		
		animauxDomestiques.stream().forEach(a-> { a.sayHello(); operationOnSealed(a);});
	}
	
    

}
