package tp.dessin.app;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import tp.dessin.observateur.PanelObserver1;
import tp.dessin.observateur.PanelObserver2;
import tp.dessin.observateur.SubjectWithCommonData;

public class OngletObservateurs extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private PanelObserver1 panneauObservateurGauche = new PanelObserver1();
	private PanelObserver2 panneauObservateurDroit = new PanelObserver2();
	private SubjectWithCommonData subjectWithCommonData = new SubjectWithCommonData();
	
	public OngletObservateurs(){
		
	   // LES 2 (ou n) OBSERVATEURS sont reliés au même SUJET observé:
	   panneauObservateurGauche.setSubjectWithCommonData(subjectWithCommonData); //avec addObserver() appelé en "callback immédiate"
	   panneauObservateurDroit.setSubjectWithCommonData(subjectWithCommonData); //avec addObserver() appelé en "callback immédiate"
		
	   this.setLayout(new BorderLayout());
	   this.add(BorderLayout.WEST,panneauObservateurGauche);	
	   panneauObservateurGauche.setBackground(Color.magenta);
	   this.add(BorderLayout.EAST,panneauObservateurDroit);	
	   panneauObservateurDroit.setBackground(Color.orange);
	}
	
	
}
