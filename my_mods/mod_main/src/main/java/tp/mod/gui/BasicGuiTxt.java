package tp.mod.gui;

public class BasicGuiTxt implements BasicGui {

	@Override
	public void display(String message) {
		System.out.println(message);
	}

	@Override
	public String input(String invite) {
		System.out.print(invite); //ex: invite="votre nom ?"
		java.util.Scanner reader = new java.util.Scanner(System.in);
		String sValeurSaisie = reader.next();
		//reader.close();
		return sValeurSaisie;
	}

}
