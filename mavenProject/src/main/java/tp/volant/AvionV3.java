package tp.volant;

import java.util.ArrayList;
import java.util.List;

import tp.Bagage;
import tp.Transportable;
import tp.individu.Employe;
import tp.individu.Personne;

/**
* @author didier defrance
*
* AvionV2 comportant un tableau de références sur des choses Transportable
*/
public class AvionV3 extends ObjetVolant {
	public static final int TAILLE_MAX=50;
	
	//liste/collection de références sur des choses transportables (passager , pilote, hotesse , bagages)
	//montées dans l'avion
	private  List<Transportable>   colElements = new ArrayList<>();
	//private  Set<Transportable>   colElements = new HashSet<>();
	
	public int getNbElements() {
		return colElements.size();
	}
	
    public void addElement(Transportable p) {
    	if(getNbElements()<TAILLE_MAX) {
		    this.colElements.add(p);
    	}
	}
    
    public void afficher() {
    	System.out.println("AvionV3 comportant "+colElements.size() +" elements");
    	double poidsTotal = 0;
    	for(Transportable t : colElements) {
    		//polymorphisme (déclenché en boucle) sur .getDesignation()
    		System.out.println("\t" + t.getDesignation());
    		//polymorphisme (déclenché en boucle) sur .getDesignation()
    		poidsTotal += t.getPoids();
    	}//fin de for
    	System.out.println("charge utile(interne) de l'avion:" + poidsTotal);
	}

    
    public AvionV3() {
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

	@Override
	 public int getPlafond() {
		return 12000;
	}

}
