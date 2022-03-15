package tp.dessin.app.v2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

public class FenetrePrincipaleV2 extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private OngletDessinV2 ongletDessinV2= new OngletDessinV2();
	
	
	//constructeur par defaut
	public FenetrePrincipaleV2(){
		this.setTitle("application de dessin (V2)");
		this.setBounds(50,50,800,400);
		this.setVisible(true);
		//pour que le programme s'arr�te bien
		//lorque l'on ferme la fenetre principale:
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    JMenuBar menuBar = new JMenuBar();
		JMenu menuEdition = new JMenu("Edition");
		JMenuItem menuUndo = new JMenuItem("Undo (Ctrl-Z)");
		menuUndo.setAccelerator(
		         KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		JMenuItem menuRedo = new JMenuItem("Redo (Ctrl-Y)");
		menuRedo.setAccelerator(
		         KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
	
	    
	    menuBar.add(menuEdition);
	    menuEdition.add(menuUndo);
	    menuEdition.add(menuRedo);
	 
	    this.setJMenuBar(menuBar);
	    
	    menuUndo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuUndo_actionPerformed(e);
			}	    	
	    });
	    
	   
	    menuRedo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuRedo_actionPerformed(e);
			}	    	
	    });
	    
	    JTabbedPane serieOnglet = new JTabbedPane();
	    this.getContentPane().add(serieOnglet);
	    
	    serieOnglet.addTab("dessin-v2",ongletDessinV2);
	    
	}
	
	public static void main(String[] args) {
		FenetrePrincipaleV2 fp = new FenetrePrincipaleV2();		
	}
	
	public void menuUndo_actionPerformed(ActionEvent e) {
		//System.out.println("undo ...");
		ongletDessinV2.undo();
	}
	
	public void menuRedo_actionPerformed(ActionEvent e) {
		//System.out.println("redo ...");
		ongletDessinV2.redo();
	}
	
	
}
