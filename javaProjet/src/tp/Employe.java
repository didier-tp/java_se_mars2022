package tp;

public class Employe extends Personne{
    private int salaire;

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + " heritant de " + super.toString() + "]";
	}

	public Employe() {
		super();
		this.salaire = 0;
	}

	public Employe(String prenom, String nom, Integer age) {
		super(prenom, nom, age);
		this.salaire =0;
	}
	
	public Employe(String prenom, String nom, Integer age, int salaire) {
		super(prenom, nom, age);
		this.salaire =salaire;
	}

	

	
    
	
}
