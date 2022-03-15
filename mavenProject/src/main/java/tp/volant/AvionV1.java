package tp.volant;

import tp.individu.Employe;
import tp.individu.Personne;

public class AvionV1 extends ObjetVolant {
	
	public static final int TAILLE_MAX=50;
	
	//tableau de r�f�rences sur des Personnes (passager , pilote, hotesse)
	//mont�es dans l'avion
	private Personne[] tabElements = new Personne[TAILLE_MAX];
	
	private int nbElements=0; //nombre d'�lements mont�s dans l'avion
	
	
	
	public int getNbElements() {
		return nbElements;
	}


	public AvionV1() {
         //avion vide en sortie d'usine
	}


	public void initialiser() {
	/*	addElement(new Personne("jean","Pilote",40));
		addElement(new Personne("sophie","Hotesse",40));*/
		addElement(new Employe("jean","Pilote",40,4000));
		addElement(new Employe("sophie","Hotesse",40,2000));
		addElement(new Personne("passager","Clandestin",30));
	}
	
	
    public void addElement(Personne p) {
    	if(nbElements<TAILLE_MAX) {
		    //tabElements[nbElements++]=p;
    		tabElements[nbElements]=p;
    		nbElements++;
    	}
	}
    
    public void afficher() {
    	System.out.println("Avion comportant "+nbElements +" elements");
    	for(int i=0; i<nbElements; i++) {
    		//System.out.println("\t" + tabElements[i]);
    		//polymorphisme (d�clench� en boucle) sur .toString()
    		System.out.println("\t" + tabElements[i].toString());
    		
    		//Appel de getSalaire (sans polymorphisme):
    		Personne p = tabElements[i];
    		if(p instanceof Employe) {
    			//traitement � d�clencher sur un objet dont le type Employ�
    			Employe pAsEmp = (Employe) p;
    			int salaire = pAsEmp.getSalaire();
    			System.out.println("salaire de l'employ� = " + salaire);
    		}
    	}
	}


	@Override
	public int getPlafond() {
		return 12000;
	}

}
