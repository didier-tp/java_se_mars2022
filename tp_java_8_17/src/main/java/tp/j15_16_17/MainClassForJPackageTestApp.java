package tp.j15_16_17;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MainClassForJPackageTestApp extends JFrame {

	public static void main(String[] args) {
		//JOptionPane.showMessageDialog(null, "welcome to my hello world tiny java app");
        /*
		System.out.println("welcome to my hello world tiny java app"); // with --win-console option of jpackage
        java.util.Scanner scanner =   new java.util.Scanner(System.in);
        System.out.println("Ecrire votre phrase:");
    	String phrase = scanner.nextLine();
    	System.out.println("phrase="+phrase);
    	System.out.println("PAUSE");
    	phrase = scanner.nextLine(); //pour finir
    	*/
		var fp = new MainClassForJPackageTestApp();	
	}

	public MainClassForJPackageTestApp()  {
		this.setTitle("my java app");
		this.setBounds(50,50,600,400);
		this.setVisible(true);
		//pour que le programme s'arrete bien
		//lorque l'on ferme la fenetre principale:
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
}
