package tp.avec_lambda.solutions;

import java.util.Optional;

import tp.data.Address;
import tp.data.Person;
import tp.util.PersonUtil;

//NB: depuis java 8 , le type de retour Optional<T> plutot que T eventuellement null
//    ne fait qu'expliciter clairement (via le type , sans autre commentaire ou documentation supplementaire)
//    l'aspect optionel d'une reference vers un autre objet (multiplicite 0..1 en UML)

// au sein de ce Tp , la classe tp.data.Person comportera exceptionnellement
// public Optional<Address> getOptionalAddress() 
// cohabitant avec public Address getAddress()
// pour effectuer des comparaisons de styles de code

//dans un veritable projet java >=8 , on aura interet a ne conserver
//que public Optional<Address> getOptionalAddress() (ou eventuellement public Optional<Address> getAddress())
//mais ne surtout pas coder public Address getAddress()
      

public class AppWithOptional {
	
	public static void displayWithoutOptional(Person p) {
		System.out.println(p);
		if(p.getEmail()!=null) {
		    System.out.println("with uppercase email="+ p.getEmail().toUpperCase());
		}
		if(p.getAddress()!=null) {
			System.out.println("with uppercase address="+ p.getAddress().toString().toUpperCase());
		}
		if(p.getBestFriend()!=null) {
			System.out.println("with best fiend full name="+p.getBestFriend().getFullName() );
			if(p.getBestFriend().getAddress()!=null) {
				System.out.println("with uppercase address of best friend="+ p.getBestFriend().getAddress().toString().toUpperCase());
			}
		}
		System.out.println("----------------");
	}
	
    public static void displayWithOptional(Person p) {
    	System.out.println(p);
		System.out.println("with uppercase email="+ p.getOptionalEmail().orElse("inconnue").toUpperCase());//avec .orElse() pas d'exception
		
		if(p.getOptionalAddress().isPresent()) {
			//NB: .get() renvoie une exception si empty(inside null) qui ne peut pas se produire ici
			//car appel englobe par if(....isPresent())
			System.out.println("with uppercase address="+ p.getOptionalAddress().get().toString().toUpperCase());
		}
		//Variante:
		try {
			System.out.println("with uppercase address="+ p.getOptionalAddress().get().toString().toUpperCase());
		}catch(java.util.NoSuchElementException ex) { //NoSuchElementException herite de RuntimeException
			System.out.println("with no or unknown address. normal exception="+ex.getMessage());
		}
		
		
		if(p.getOptionalBestFriend().isPresent()) {
			Person bestFriend = p.getOptionalBestFriend().get();
			System.out.println("with best fiend full name="+bestFriend.getFullName() );
			if(p.getBestFriend().getOptionalAddress().isPresent()) {
				System.out.println("with uppercase address of best friend="+ bestFriend.getOptionalAddress().get().toString().toUpperCase());
			}
		}
		System.out.println("----------------");

	}
    
    public static void displayWithOptionalAndLambda(Person p) {
    	System.out.println(p);
		System.out.println("with uppercase email="+ p.getOptionalEmail().orElse("iconnue").toUpperCase());
		String strAdr = p.getOptionalAddress()
		           .map(a -> a.toString().toUpperCase()) //map() effectue une transformation sur la valeur interne de l'optional si non nulle
		                                                 //la valeur transformee par la lambda interne à .map() est automatiquement
		                                                 //re-encapsulee dans un Optional<...> pour pouvoir enchainer l'instruction d'apres
		                                                 //souvent .orElse() quelquefois .get() avec try/catch ou autre
		           .orElse("INCONNUE");
		//� terminer ....
        System.out.println("with uppercase address = "+strAdr);
        String bestFriendFullName = p.getOptionalBestFriend()
		           .map((Person bf) -> bf.getFullName())  //retourne une String automatiquement encapsulee dans Optional<...> pour enchainer.
		           .orElse("inconnu (non renseigne)");
        System.out.println("with best fiend full name="+bestFriendFullName );
		
        
        String bestFriendAddress = p.getOptionalBestFriend()
		           .flatMap(bf -> bf.getOptionalAddress()) //le resultat de la transformation (lambda interne a flatMap())
		                                                   //est ici deja de type Optional<Address>
		                                                   //.map(...) a la place de .flatMap(...) retournerait ici un objet de type
		                                                   //Optional<Optional<Address>> 
		                                                   //d'ou ici l'utilisation necessaire de flatMap(...) qui ne re-encapsule
		           										   //pas inutilement dans un Optional<...> unne chose deja Optional<...>
		           .map(bfAddr -> bfAddr.toString().toUpperCase())
		           .orElse("INCONNUE");
        System.out.println("with uppercase address of best friend="+ bestFriendAddress);
		System.out.println("----------------");

	}

	public static void withoutOptional() {
		for(Person p : PersonUtil.buildSamplePersonList()) {
			displayWithoutOptional(p);
		}
	}
	
	public static void withOptional() {
		for(Person p : PersonUtil.buildSamplePersonList()) {
			displayWithOptional(p);
		}
	}
	
	public static void withOptionalAndLambda() {
		for(Person p : PersonUtil.buildSamplePersonList()) {
		displayWithOptionalAndLambda(p);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("******** withoutOptional :");
		withoutOptional();
		System.out.println("\n******** withOptional :");
		withOptional();
		System.out.println("\n******** withOptionalAndLambda :");
		withOptionalAndLambda();
		testDiversAvecNouvellesMethodesDeOptionalDepuisJava9();
	}
	
	public static void testDiversAvecNouvellesMethodesDeOptionalDepuisJava9() {
		System.out.println("=====================================");
		Optional<String> opS1 = Optional.of("s1");
		Optional<String> opS2 = /*Optional.ofNullable(null); */ Optional.empty();
		
		//op.or(....) permet de construire et fournir un autre optional (valeur par defaut ou plan B)
		//si l'optionnel original est null/emmpty :
		System.out.println(opS1.or(()->Optional.of("default_string"))); //affiche Optional[s1]
		System.out.println(opS2.or(()->Optional.of("default_string"))); //affiche Optional[default_string]
		
		//op.ifPresentOrElse(nomEmptyConsumer_as_lambda , emptyActionLambda) 
		//permet de déleclencher alternativement une lambda ou une autre en fonction d'un contenu vide ou pas
		//pas d'enchainement apres (opération terminale en "void")
		opS1.ifPresentOrElse( (value) -> System.out.println("opS1="+value),
				               () -> System.out.println("value of opS1 is empty")); //affiche opS1=s1
		opS2.ifPresentOrElse( (value) -> System.out.println("opS2="+value),
	               () -> System.out.println("value of opS2 is empty")); //affiche value of opS2 is empty
	}

}
