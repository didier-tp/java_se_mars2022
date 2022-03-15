package tp.volant;

import tp.Bagage;
import tp.Transportable;
import tp.individu.Employe;
import tp.individu.Personne;

public class AvionV2 extends ObjetVolant {
	
	public static final int TAILLE_MAX=50;
	
	//tableau de références sur des choses transportables (passager , pilote, hotesse , bagages)
	//montées dans l'avion
	private Transportable[] tabElements = new Transportable[TAILLE_MAX];
	
	private int nbElements=0; //nombre d'élements montés dans l'avion
	
	
	
	public int getNbElements() {
		return nbElements;
	}


	public AvionV2() {
         //avion vide en sortie d'usine
	}


	public void initialiser() {
	/*	addElement(new Personne("jean","Pilote",40));
		addElement(new Personne("sophie","Hotesse",40));*/
		addElement(new Employe("jean","Pilote",40,4000));
		addElement(new Employe("sophie","Hotesse",40,2000));
		addElement(new Personne("passager","Clandestin",30));
		addElement(new Bagage("sac xy",12,30));
		addElement(new Bagage("valise zz",28,80));
	}
	
	
    public void addElement(Transportable p) {
    	if(nbElements<TAILLE_MAX) {
		    //tabElements[nbElements++]=p;
    		tabElements[nbElements]=p;
    		nbElements++;
    	}
	}
    
    public void afficher() {
    	System.out.println("Avion comportant "+nbElements +" elements");
    	double poidsTotal = 0;
    	for(int i=0; i<nbElements; i++) {
    		//System.out.println("\t" + tabElements[i]);
    		//polymorphisme (déclenché en boucle) sur .toString()
    		//System.out.println("\t" + tabElements[i].toString());
    		
    		//polymorphisme (déclenché en boucle) sur .getDesignation()
    		System.out.println("\t" + tabElements[i].getDesignation());
    		
    		//polymorphisme (déclenché en boucle) sur .getDesignation()
    		poidsTotal += tabElements[i].getPoids();
    		
    		//Appel de getSalaire (sans polymorphisme):
    		Transportable p = tabElements[i];
    		if(p instanceof Employe) {
    			//traitement à déclencher sur un objet dont le type Employé
    			Employe pAsEmp = (Employe) p;
    			int salaire = pAsEmp.getSalaire();
    			//System.out.println("salaire de l'employé = " + salaire);
    		}//fin de if
    	}//fin de for
    	System.out.println("charge utile(interne) de l'avion:" + poidsTotal);
	}


	@Override
	 public int getPlafond() {
		return 12000;
	}

}
