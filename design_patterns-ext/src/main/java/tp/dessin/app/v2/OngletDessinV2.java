package tp.dessin.app.v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import tp.dessin.app.MyCanvas;
import tp.dessin.app.variante.command.AddFigCommand;
import tp.dessin.app.variante.command.ChangeColorFigCommand;
import tp.dessin.app.variante.command.FigCommand;
import tp.dessin.app.variante.command.RemoveFigCommand;
import tp.dessin.app.variante.command.ResizeFigCommand;
import tp.dessin.app.variante.command.TranslateFigCommand;
import tp.dessin.app.variante.command.Translation;
import tp.dessin.ext.swing.SwingDrawingVisitor;
import tp.dessin.fig.Cercle;
import tp.dessin.fig.Figure;
import tp.dessin.fig.Ligne;
import tp.dessin.fig.Rectangle;

public class OngletDessinV2 extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Figure nouvelleFigure=null; //mousePressed , mouseReleased
	private Figure figureCourante=null; 
	//reference la nouvelle figure a construire
	private List<Figure> listeFigures =
		  new ArrayList<Figure>();
	
	private Deque<FigCommand> commandStack = new LinkedList<>();
	private Deque<FigCommand> redoCommandStack = new LinkedList<>();
	
	private Figure.TypeFigure typefigCourante 
	                  = Figure.TypeFigure.LIGNE;
	
	private String couleurCourante = "black";
	
	private Map<Figure.TypeFigure,Figure> prototypesFigures;
	
	private JPanel panneauHaut = new JPanel();
	private MyCanvas panneauMilieu = new MyCanvas();
	private JPanel panneauBas = new JPanel();
	private JRadioButton rbLigne =   new JRadioButton("ligne");
	private JRadioButton rbRectangle = new JRadioButton("rectangle");
	private JRadioButton rbCercle = new JRadioButton("cercle");
	private JComboBox<String> comboCouleur = new JComboBox<>();
	private JButton btnEffacer = new JButton("effacer");
	private JLabel labelSelection = new JLabel("selection:");
	private JComboBox<Figure> comboSelection = new JComboBox<>();
	private JButton btnTranslation = new JButton("translation");
	private JButton btnChangerTaille = new JButton("changerTaille");
	private JLabel labelDeltaX = new JLabel("dx:");
	private JTextField txtDeltaX = new JTextField("20");
	private JLabel labelDeltaY = new JLabel("dy:");
	private JTextField txtDeltaY = new JTextField("10");
	private JLabel labelCoeff= new JLabel("coeff:");
	private JTextField txtCoeff = new JTextField("1.3");
	
	public OngletDessinV2(){
		
		
		prototypesFigures= new HashMap<>();
		prototypesFigures.put(Figure.TypeFigure.LIGNE,new Ligne(50,50,80,70));
		prototypesFigures.put(Figure.TypeFigure.RECTANGLE,new Rectangle(50,90,30,30));
		prototypesFigures.put(Figure.TypeFigure.CERCLE,new Cercle(65,160,15));
		
	   this.setLayout(new BorderLayout());
	   this.add(BorderLayout.NORTH,panneauHaut);	   
	   panneauMilieu.setListeFigures(this.listeFigures);
	   this.add(BorderLayout.CENTER,panneauMilieu);
	   this.add(BorderLayout.SOUTH,panneauBas);	
	   
	   ButtonGroup bg = new ButtonGroup();//exclusivite
	   panneauHaut.add(rbLigne); bg.add(rbLigne);
	   panneauHaut.add(rbRectangle); bg.add(rbRectangle);
	   panneauHaut.add(rbCercle); bg.add(rbCercle);
	   rbLigne.setSelected(true);
	   
	  
	   panneauHaut.add(btnEffacer);
	   //panneauHaut.setBackground(Color.GRAY);
	   
	   btnEffacer.addActionListener((e) -> {btnEffacer_actionPerformed(e);  });
	   	 
	   btnTranslation.addActionListener((e) -> { btnTranslation_actionPerformed(e);	} );
		   
	   btnChangerTaille.addActionListener((e) -> {	btnChangerTaille_actionPerformed(e);});
	   
	   ActionListener al = new 
	    /* classe anonyme imbriquee qui implemente */
	               ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boutonRadios_actionPerformed(e);
			}		  		  
		   };
	   rbLigne.addActionListener(al);
	   rbRectangle.addActionListener(al);
	   rbCercle.addActionListener(al);
	   
	  
	   panneauHaut.add(labelSelection);
	   panneauHaut.add(comboSelection);
	  
	   panneauBas.add(comboCouleur);
	   comboCouleur.addItem("black");
	   comboCouleur.addItem("red");
	   comboCouleur.addItem("green");
	   comboCouleur.addItem("blue");
	   comboCouleur.addItem("orange");
	   comboCouleur.addItem("yellow");
	   
	   panneauBas.add(labelDeltaX);	 panneauBas.add(txtDeltaX);
	   panneauBas.add(labelDeltaY);	 panneauBas.add(txtDeltaY);
	   panneauBas.add(btnTranslation);	
	   panneauBas.add(labelCoeff);	 panneauBas.add(txtCoeff);
	   panneauBas.add(btnChangerTaille);
	   
	   comboCouleur.addItemListener((e) -> {comboCouleur_itemStateChanged(e); });
	   comboSelection.addItemListener((e) -> {comboSelection_itemStateChanged(e);});
	   
	   panneauMilieu.addMouseListener(new 
				 /* classe imbriquee anonyme qui
				  * implements/extends*/ MouseAdapter(){			
					public void mousePressed(MouseEvent e) {
						panneauBas_mousePressed(e);
					}
					public void mouseReleased(MouseEvent e) {
						panneauBas_mouseReleased(e);
					}		   
			   }//fin de classe imbriquee
			   );
	   
	}//fin de constructeur	
	
	
	void panneauBas_mousePressed(MouseEvent e){
		//System.out.println("x1="+e.getX()+ ",y1=" + e.getY());
		Figure prototypeFig = this.prototypesFigures.get(this.typefigCourante);
		nouvelleFigure = prototypeFig.cloneFig();
		nouvelleFigure.setCouleur(this.couleurCourante);
		nouvelleFigure.setOrigin(e.getX(), e.getY());
		this.figureCourante=nouvelleFigure;			
	}
	
	void panneauBas_mouseReleased(MouseEvent e){
		//System.out.println("x2="+e.getX() + ",y2=" + e.getY());
		switch(this.typefigCourante){
		case LIGNE:
			Ligne l = (Ligne) this.nouvelleFigure;
			l.setX2(e.getX());l.setY2(e.getY()); break;
		case RECTANGLE:
			Rectangle r = (Rectangle) this.nouvelleFigure;
			r.setL(Math.abs(e.getX()-r.getX1()));
			r.setH(Math.abs(e.getY()-r.getY1())); 
			if(e.getX() < r.getX1()) r.setX1(r.getX1()-r.getL());
			if(e.getY() < r.getY1()) r.setY1(r.getY1()-r.getH());
			break;
		case CERCLE:
			Cercle c = (Cercle) this.nouvelleFigure;
			int dx=e.getX()-c.getXc();
			int dy=e.getY()- c.getYc();
			c.setRayon((int)Math.sqrt(dx*dx+dy*dy));
		}
		AddFigCommand addFigCommand = new AddFigCommand(this,this.nouvelleFigure);
		addFigCommand.execute();
		commandStack.push(addFigCommand);
	}
	
	protected void comboSelection_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED){
			  this.figureCourante = (Figure)e.getItem();
			  Figure.setSelectedFig( this.figureCourante);
			  this.rafraichirDessin();
		}
	}

	protected void btnChangerTaille_actionPerformed(ActionEvent e) {
		if(this.figureCourante==null)
			return;
		double coeff=1;
		coeff=Double.parseDouble(txtCoeff.getText());
		ResizeFigCommand resizeFigCommand = new ResizeFigCommand(this,figureCourante,coeff);
		resizeFigCommand.execute();
		commandStack.push(resizeFigCommand);
	}

	protected void btnTranslation_actionPerformed(ActionEvent e) {
		if(this.figureCourante==null)
			return;
		Translation translation = new Translation();
		translation.dx=Integer.parseInt(txtDeltaX.getText());
		translation.dy=Integer.parseInt(txtDeltaY.getText());
		TranslateFigCommand translateFigCommand = new TranslateFigCommand(this,figureCourante,translation);
		translateFigCommand.execute();
		commandStack.push(translateFigCommand);
	}

	
	public void ajouterNouvelleFigure(Figure fig) {
		this.listeFigures.add(fig);
		comboSelection.addItem(fig);
		comboSelection.setSelectedItem(fig);
		this.figureCourante = fig;
		fig.performVisit( new SwingDrawingVisitor(this.panneauMilieu.getGraphics()));
	}
	
	public void retirerFigure(Figure fig) {
		this.listeFigures.remove(fig);
		comboSelection.removeItem(fig);
		rafraichirDessin();
		if(listeFigures.size()>=1) {
		    this.figureCourante = listeFigures.get(listeFigures.size()-1);
		}else {
			this.figureCourante = null;
		}
	}
	
	public void rafraichirDessin() {
		this.panneauMilieu.repaint();
	}
	
	
	protected void btnEffacer_actionPerformed(ActionEvent e) {
		RemoveFigCommand removeFigCommand = new RemoveFigCommand(this,this.figureCourante);
		removeFigCommand.execute();
		commandStack.push(removeFigCommand);
	}
	
	
	public void boutonRadios_actionPerformed(ActionEvent e){
	   if(e.getSource()==rbLigne)
		   this.typefigCourante=
			    Figure.TypeFigure.LIGNE;
	   else if(e.getSource()==rbRectangle)
		   this.typefigCourante=
			    Figure.TypeFigure.RECTANGLE;
	   else if(e.getSource()==rbCercle)
		   this.typefigCourante=
			    Figure.TypeFigure.CERCLE;
	}
	
	
	public void comboCouleur_itemStateChanged(ItemEvent e){
		if(e.getStateChange()==ItemEvent.SELECTED){
		  String couleurChoisie = (String)e.getItem();
		  //System.out.println("couleur choisie="+couleurChoisie);
		  couleurCourante=couleurChoisie;
		  if(this.figureCourante!=null) {
			  ChangeColorFigCommand changeColorFigCommand = new ChangeColorFigCommand(this,this.figureCourante,this.couleurCourante);
			  changeColorFigCommand.execute();
			  commandStack.push(changeColorFigCommand);
		  }
		}
	}
	
	
	public void undo(){
		try {
			FigCommand figCommand= commandStack.pop();
			System.out.println("undo " + figCommand);
			redoCommandStack.push(figCommand);
			figCommand.undo();
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
			System.out.println("cannot undo : empty commandStack");
		}
	}
	
    public void redo(){
    	try {
			FigCommand figCommand= redoCommandStack.pop();
			System.out.println("redo " + figCommand);
			commandStack.push(figCommand);
			figCommand.execute();
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
			System.out.println("cannot redo : empty redoCommandStack");
		}
	}
	
	
	
	
}
