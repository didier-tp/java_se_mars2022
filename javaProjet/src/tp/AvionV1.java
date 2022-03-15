package tp;

public class AvionV1 {
	
	//tableau de références sur des Personnes (passager , pilote, hotesse)
	//montées dans l'avion
	private Personne[] tabElements = new Personne[50];
	
	private int nbElements=0; //nombre d'élements montés dans l'avion
	
	
	
	public AvionV1() {
         //avion vide en sortie d'usine
	}


	public void initialiser() {
		addElement(new Personne("jean","Pilote",40));
		addElement(new Personne("sophie","Hotesse",40));
	}
	
	
    public void addElement(Personne p) {
    	if(nbElements<50) {
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
