package tp.j15_16_17;

/*
 NB: le nouveau mot clef record permet de demander au compilateur de construire automatiquement
     une sorte de pseudo POJO IMMUTABLE (sans Setter possible !) 
     et avec des accesseurs de type .xxx() 
     ne respectant même pas les conventions .getXxx() !!!
     Dans les détails : classe "final" héritant de java.lang.Record et avec des champs privés "final"
     et avec .equals()/.hashCode()/.toString() et des acesseurs de type .xxx() et allArgsConstructor . 
     
     -------------
     record ne peut pas etre vu comme un remplacement de lombok 
     car IMMUTABLE/final/read-only et car .xxx() plutôt que .getXxx()
     -------------
     record doit plutôt être vu comme une sorte de petit DTO/VO très léger
 */

/*
//Minimalist v1 (with no default constructor):
public record CustomerRecord(Integer id,String firstName,String lastName) {
}
*/

/*
// V2 (with explicit default constructor)
public record CustomerRecord(Integer id,String firstName,String lastName) {
	public CustomerRecord() { this(0,null,null);} //possible mais pas très utile si final/immutable !!!
}
*/

/*public void setFirstName(String firstName) { this.firstName = firstName; }
est interdit/impossible car this.firstName est final/immutable !!! 
*/

/*
//V3 (V2 + some redefinitions & methods adding)
public record CustomerRecord(Integer id,String firstName,String lastName) {
	public CustomerRecord() { this(0,null,null);} //possible mais pas très utile si final/immutable !!!
	public String fullName() { return firstName + " " + lastName;}
	public String lastName() { return lastName.toUpperCase(); }
}
*/

//V4 (V3 + new record constructor checking syntax)
public record CustomerRecord(Integer id,String firstName,String lastName) {
	//not useful default constructor:
	public CustomerRecord() { this(0,"unknown","unknown");} //possible mais pas très utile si final/immutable !!!
	
	//new method:
	public String fullName() { return firstName + " " + lastName;}
	
	//old pojo style getter as a new complementary method :
	public String getFirstName() { return firstName; }
	
	//accessor redefinition :
	public String lastName() { return lastName.toUpperCase(); }
	
	//specific record new syntax for allArgsContructor 
	//partial redefinition with value(s) checking:
	public  CustomerRecord {
		    if (lastName ==null || lastName.isBlank()) {
			       throw new IllegalArgumentException("lastName is required");
			     }
		 }
}