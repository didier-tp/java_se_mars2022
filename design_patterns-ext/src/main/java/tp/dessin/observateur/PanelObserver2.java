package tp.dessin.observateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelObserver2 extends JPanel implements Observer{
//public class PanelObserver2 extends JPanel implements IObserver{ //VERSION1 "maison"

	
	private SubjectWithCommonData subjectWithCommonData;

	private static final long serialVersionUID = 1L;
	
	private JTextField txtCouleur = new JTextField("black");
	private JButton btnCouleur = new JButton("update color");
	
	public PanelObserver2(){
		this.add(txtCouleur);
		this.add(btnCouleur);
		btnCouleur.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				subjectWithCommonData.setCommonData(txtCouleur.getText());
			}
		});
	}

	@Override
	//public void update() { // version "simple" "maison"
	public void update(Observable o, Object arg) {	
		//arg est une éventelle indication et o peut être "casté" en "subjectWithCommonData"
		txtCouleur.setText(subjectWithCommonData.getCommonData());		
	}

	public SubjectWithCommonData getSubjectWithCommonData() {
		return subjectWithCommonData;
	}

	public void setSubjectWithCommonData(SubjectWithCommonData subjectWithCommonData) {
		this.subjectWithCommonData = subjectWithCommonData;
		subjectWithCommonData.addObserver(this); //POINT CLEF (enregistrement d'un observateur à ultérieurement avertir)
	}
	
	

}
