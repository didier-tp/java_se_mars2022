package tp.individu;

import tp.Transportable;

public class Personne implements Transportable {
     private String prenom;
     private String nom ;
     private Integer age;
     
     private double poids=65; //poids moyen par d�faut ici (� affiner en appelant setpoids())
     
     private static int ageMajorite=18;
     
     
     @Override
 	public String getDesignation() {
 		return this.toString();
    	// return this.prenom + " " + this.nom;
 	}

 	@Override
 	public double getPoids() {
 		return this.poids;
 	}
 	
 
     public void setPoids(double poids) {
		this.poids = poids;
	}

	public String mineurOuMajeur() {
    	/* 
    	 if(age>=ageMajorite) return "majeur";
    	 else return "mineur";
    	 */
    	 return (age>=ageMajorite)?"majeur":"mineur";
     }
     
	public static int getAgeMajorite() {
		return ageMajorite;
	}

	public static void setAgeMajorite(int ageMajorite) {
		Personne.ageMajorite = ageMajorite;
	}
	
	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", age=" + age + "] "
				+ this.mineurOuMajeur();
	}

	public Personne(String prenom, String nom, Integer age) {
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}
	
	public Personne() {
		this("?","?",0);
	}
	
	public void incrementerAge() {
		//this.age = this.age + 1;
		this.age++;
	}

	public void setAge(Integer age) {
		if(age>=0)
		    this.age = age;
		else System.out.println("age n�gatif invalide pas pris en compte");
	}
	
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getAge() {
		return age;
	}

	

	
}
