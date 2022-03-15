package tp.dessin.observateur;

import java.util.Observable; //version prédéfinie / standard "java" de AbstractSubject

// public class SubjectWithCommonData extends AbstractSubject { // VERSION1 "MAISON"
public class SubjectWithCommonData extends Observable {
	
	private String commonData;

	public String getCommonData() {
		return commonData;
	}

	public void setCommonData(String commonData) {
		this.commonData = commonData;
		this.setChanged();//en version java.util.Observable seulement (pas en version "maison"/AbstractSubject)
		this.notifyObservers();
		//avertir tous les observateurs qu'un changement a été effectué
		// et INDIRECTEMENT DECLENCHER DES mises à jour
	}
	
	

}
