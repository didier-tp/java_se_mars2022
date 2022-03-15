package tp;

import java.util.function.Function;

import tp.individu.Personne;

public class IntroProgFonctionnelleV1 {
	
	
	public static void main(String[] args) {
		Personne p1 = new Personne("jean","Bon",40);
		System.out.println("p1="+p1);
		
		Function<Personne,Personne> avecUnAnDePlus ;
		
		avecUnAnDePlus = 
				(Personne p) -> new Personne(p.getPrenom(),
						                     p.getNom(),
						                     p.getAge() + 1);
				
       Personne p1Bis = avecUnAnDePlus.apply(avecUnAnDePlus.apply(p1));	
       //NB: l'objet (de données) p1 n'est pas modifié.
       //la double application de la fonction de transformation avecUnAnDePlus
       //a permis de créer un nouvel objet p1Bis ayant 2 ans de plus que p1.
       
       System.out.println("p1Bis="+p1Bis);//42 ans
	}

}
