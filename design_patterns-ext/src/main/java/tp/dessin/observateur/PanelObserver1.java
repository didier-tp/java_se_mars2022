package tp.dessin.observateur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;  //version prédéfinie "java" 

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelObserver1 extends JPanel implements Observer{
//public class PanelObserver1 extends JPanel implements IObserver{ //VERSION1 "maison"
	
	private SubjectWithCommonData subjectWithCommonData;

	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboCouleur = new JComboBox<String>();
	
	public PanelObserver1(){
		
		   comboCouleur.addItem("black");
		   comboCouleur.addItem("red");
		   comboCouleur.addItem("green");
		   comboCouleur.addItem("blue");
		   
		   this.add(comboCouleur);
		   
		   comboCouleur.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					comboCouleur_itemStateChanged(e);			
				}
			   });
		
	}
	
	public void comboCouleur_itemStateChanged(ItemEvent e){
		if(e.getStateChange()==ItemEvent.SELECTED){
		  String couleurChoisie = (String)e.getItem();
		  subjectWithCommonData.setCommonData(couleurChoisie);
		}
	}

	//@Override
	//public void update() { // version "simple" "maison"
	public void update(Observable o, Object arg) {
		//arg est une éventelle indication et o peut être "casté" en "subjectWithCommonData"
		String couleur = subjectWithCommonData.getCommonData();
		comboCouleur.setSelectedItem(couleur);	
	}

	public SubjectWithCommonData getSubjectWithCommonData() {
		return subjectWithCommonData;
	}

	public void setSubjectWithCommonData(SubjectWithCommonData subjectWithCommonData) {
		this.subjectWithCommonData = subjectWithCommonData;
		subjectWithCommonData.addObserver(this); //POINT CLEF (enregistrement d'un observateur à ultérieurement avertir)
	}

	

}
