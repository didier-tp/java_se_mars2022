package tp.mod.main;

import tp.mod.compute.BasicComputer;
import tp.mod.gui.BasicGui;
import tp.mod.gui.BasicGui.GuiType;

public class MyApp {

	public static void main(String[] args) {
		
		BasicComputer basicComputer = BasicComputer.buildBasicComputer();
		
		BasicGui basicGui = BasicGui.buildBasicGui(GuiType.TXT_GUI);
		//BasicGui basicGui = BasicGui.buildBasicGui(GuiType.DLG_GUI);
		
		String sX= basicGui.input("x=");
        Double x  = Double.parseDouble(sX);
        
		String sY= basicGui.input("y=");
		Double y  = Double.parseDouble(sY);
		
		Double carreX = basicComputer.square(x);
		Double xPlusY = basicComputer.add(x, y);
		basicGui.display("carreX="+carreX);
		basicGui.display("xPlusY="+xPlusY);
	}

}
