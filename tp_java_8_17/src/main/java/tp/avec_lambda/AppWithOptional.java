package tp.avec_lambda;

import java.util.Optional;

import tp.data.Address;
import tp.data.Person;
import tp.util.PersonUtil;

//NB: depuis java 8 , le type de retour Optional<T> plutot que T eventuellement null
//ne fait qu'expliciter clairement (via le type , sans autre commentaire ou documentation supplementaire)
//l'aspect optionel d'une reference vers un autre objet (multiplicite 0..1 en UML)

//au sein de ce Tp , la classe tp.data.Person comportera exceptionnellement
//public Optional<Address> getOptionalAddress() 
//cohabitant avec public Address getAddress()
//pour effectuer des comparaisons de styles de code

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
    	/*
    	 A FAIRE EN TP : 
    	 1) Ajouter (par suppression de commentaire) les methodes "getOptional....()" 
    	    au sein de la classe tp.data.Person :
    	 
    	 
    	 2) programmer au sein de cette methode displayWithOptional() un equivalent des fonctionnalites de
    	    la methode displayWithoutOptional() en utilisant au maximum les constructions syntaxiques suivantes:
    	    if(.....isPresent()){
    	    ....
    	    .....orElse(....)... ou .....get()....
    	    ....
    	    }
    	    et/ou try { ......get()... } catch(java.util.NoSuchElementException ex) { .... }
    	    
    	  Rappels: .get()  quelquefois retourne une execption si pas de test if(....isPresent()) { ...}
    	            et si valeur interne null/empty
    	           .orElse(___valeurSiNullEmpty_____) ne souleve pas d'exception . 
    	    
    	 */
		System.out.println("----------------");
	}
    
    public static void displayWithOptionalAndLambda(Person p) {
    	System.out.println(p);
    	/*
   	 	A FAIRE EN TP : 
   	    programmer au sein de cette methode displayWithOptionalAndLambda() un equivalent un peu adapte des fonctionnalites de
   	    la methode displayWithoutOptional() en utilisant au maximum les constructions syntaxiques suivantes:
   	    
   	    String strResXy = p.getOptional....()
   	                       .map(......)
   	                       .orElse(.....);              
        et/ou 
        
        String strResXy = p.getOptional....()
                           .flatMap(.....) 
   	                       .map(......)
   	                       .orElse(.....);
   	                       
        Rappels:   	                       
           	   * map() effectue une transformation sur la valeur interne de l'optional si non nulle.
		         la valeur transform�e par la lambda interne a .map() est automatiquement
		         re-encapsulee dans un Optional<...> pour pouvoir enchainer l'instruction d'apr�s
		         souvent .orElse() quelquefois .get() avec try/catch ou autre
		         
		       * le resultat de la transformation (sous forme de lambda interne)
		         peut quelquefois etre deja de type Optional<Address>
		         .map(...) a la place de .flatMap(...) retournerait ici un objet de type Optional<Optional<T>> 
		          d'o� l'utilisation quelquefois necessaire de flatMap(...) qui ne re-encapsule
		          pas inutilement dans un Optional<...> une chose deja Optional<...>
   	    
   	    NB: essayer de n'utiliser aucun if(...){ ... } ni aucun try/catch
   	    */
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
		//si l'optionnel original est null/empty :
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
