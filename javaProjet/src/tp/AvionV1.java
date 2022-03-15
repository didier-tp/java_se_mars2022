package tp;

public class AvionV1 {
	
	public static final int TAILLE_MAX=50;
	
	//tableau de références sur des Personnes (passager , pilote, hotesse)
	//montées dans l'avion
	private Personne[] tabElements = new Personne[TAILLE_MAX];
	
	private int nbElements=0; //nombre d'élements montés dans l'avion
	
	
	
	public int getNbElements() {
		return nbElements;
	}


	public AvionV1() {
         //avion vide en sortie d'usine
	}


	public void initialiser() {
		addElement(new Personne("jean","Pilote",40));
		addElement(new Personne("sophie","Hotesse",40));
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
    		System.out.println("\t" + tabElements[i]);
    		//System.out.println("\t" + tabElements[i].toString());
    	}
	}

}
