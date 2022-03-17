package util;

public class MyUtil {
	
	public static void display(String message) {
		System.out.println(message);
	}
	
	public static void displayDlg(String message) {
		javax.swing.JOptionPane.showMessageDialog(null, message);
	}
	
	public static String input(String invite) {
		 System.out.print(invite); //ex: invite="votre nom ?"
		java.util.Scanner reader = new java.util.Scanner(System.in);
		String sValeurSaisie = reader.next();
		//reader.close();
		return sValeurSaisie;
	}
	
	public static String inputDlg(String invite) {
		String sValeurSaisie =
				javax.swing.JOptionPane.showInputDialog(null, invite);
		return sValeurSaisie;
	}

}
