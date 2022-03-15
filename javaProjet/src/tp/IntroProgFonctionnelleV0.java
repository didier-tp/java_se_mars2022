package tp;

public class IntroProgFonctionnelleV0 {
	
	public static Personne avecUnAnDePlusStatic(Personne p) {
		return new Personne(p.getPrenom(),
				            p.getNom(),
					        p.getAge() + 1);
	}
	
	public static void main(String[] args) {
		
	   Personne p1 = new Personne("jean","Bon",40);
	   System.out.println("p1="+p1);
		
       Personne p1Bis = avecUnAnDePlusStatic(avecUnAnDePlusStatic(p1));	
       //NB: l'objet (de données) p1 n'est pas modifié.
       //la double application de la fonction de transformation avecUnAnDePlusStatic
       //a permis de créer un nouvel objet p1Bis ayant 2 ans de plus que p1.
       
       System.out.println("p1Bis="+p1Bis);//42 ans
	}

}
