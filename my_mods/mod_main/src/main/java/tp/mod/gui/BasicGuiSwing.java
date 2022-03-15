package tp.mod.gui;

public class BasicGuiSwing implements BasicGui {

	@Override
	public void display(String message) {
		javax.swing.JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public String input(String invite) {
		String sValeurSaisie =
				javax.swing.JOptionPane.showInputDialog(null, invite);
		return sValeurSaisie;
	}

}
