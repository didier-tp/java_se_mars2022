package tp.dessin.app.v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import tp.dessin.app.OngletObservateurs;

public class FenetrePrincipale extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private OngletDessin ongletDessin= new OngletDessin();
	private OngletObservateurs ongletObservateur = new OngletObservateurs();
	
	//constructeur par defaut
	public FenetrePrincipale(){
		this.setTitle("application de dessin");
		this.setBounds(50,50,600,400);
		this.setVisible(true);
		//pour que le programme s'arr�te bien
		//lorque l'on ferme la fenetre principale:
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    JMenuBar menuBar = new JMenuBar();
		JMenu menuFichier = new JMenu("Fichier");
		JMenuItem menuSave = new JMenuItem("Save as ...");
		JMenuItem menuOpen = new JMenuItem("Open ...");
		JMenuItem menuExportSvg = new JMenuItem("Export SVG");
	    
	    menuBar.add(menuFichier);
	    menuFichier.add(menuSave);
	    menuFichier.add(menuOpen);
	    menuFichier.add(menuExportSvg);
	    this.setJMenuBar(menuBar);
	    
	    menuSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuSave_actionPerformed(e);
			}	    	
	    });
	    
	    menuExportSvg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuExportSvg_actionPerformed(e);
			}	    	
	    });
	    
	    menuOpen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuOpen_actionPerformed(e);
			}	    	
	    });
	    
	    JTabbedPane serieOnglet = new JTabbedPane();
	    this.getContentPane().add(serieOnglet);
	    
	   
	    serieOnglet.addTab("dessin",ongletDessin);
	    serieOnglet.addTab("observateurs",ongletObservateur);
	    
	}
	
	public static void main(String[] args) {
		FenetrePrincipale fp = new FenetrePrincipale();		
	}
	
	public void menuSave_actionPerformed(ActionEvent e) {
		//System.out.println("save file ...");
		ongletDessin.sauver();
	}
	
	public void menuOpen_actionPerformed(ActionEvent e) {
		//System.out.println("open file ...");
		ongletDessin.charger();
	}
	
	public void menuExportSvg_actionPerformed(ActionEvent e) {
		//System.out.println("export svg ...");
		ongletDessin.exporterSvg();
	}

}
