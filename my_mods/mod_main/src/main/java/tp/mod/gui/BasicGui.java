package tp.mod.gui;


public interface BasicGui {
	public void display(String message);
	public String input(String invite);
	
	public enum GuiType { TXT_GUI , DLG_GUI };
	public static BasicGui buildBasicGui(GuiType guiType) {
		if(guiType == GuiType.DLG_GUI) return new BasicGuiSwing();
		else return new BasicGuiTxt();
	}
}
