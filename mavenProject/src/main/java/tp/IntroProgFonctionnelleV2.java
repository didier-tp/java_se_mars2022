package tp;

import java.util.function.Function;

import tp.individu.Personne;

public class IntroProgFonctionnelleV2 {
	
	/*
	public static Personne appliquerTransformation(Personne p, 
			Function<Personne,Personne> transformationDePersonne) {
		return transformationDePersonne.apply(p);
	}*/
	
	public static<T> T appliquerTransformation(T e, 
			Function<T,T> transformation) {
		return transformation.apply(e);
	}
	
	
	public static void main(String[] args) {
		Personne p1 = new Personne("jean","Bon",40);
		System.out.println("p1="+p1);
		
		Personne p1Bis = appliquerTransformation(p1,
		     (Personne p) -> new Personne(p.getPrenom(),
						                  p.getNom(),
						                  p.getAge() + 2)
		     );
       //NB: l'objet (de données) p1 n'est pas modifié.
       //l'application de la fonction de transformation 
       //a permis de créer un nouvel objet p1Bis ayant 2 ans de plus que p1.
       
       System.out.println("p1Bis="+p1Bis);//42 ans
	}

}
