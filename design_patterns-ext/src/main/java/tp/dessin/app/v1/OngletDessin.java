package tp.dessin.app.v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import tp.dessin.app.MyCanvas;
import tp.dessin.ext.svg.SvgGenerateVisitor;
import tp.dessin.ext.swing.SwingDrawingVisitor;
import tp.dessin.fig.Cercle;
import tp.dessin.fig.Figure;
import tp.dessin.fig.Ligne;
import tp.dessin.fig.Rectangle;

public class OngletDessin extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Figure figureCourante=null; 
	//reference la nouvelle figure � construire
	private List<Figure> listeFigures =
		  new ArrayList<Figure>();
	
	private Figure.TypeFigure typefigCourante 
	                  = Figure.TypeFigure.LIGNE;
	
	private String couleurCourante = "black"; 
	
	private JPanel panneauHaut = new JPanel();
	private MyCanvas panneauBas = new MyCanvas();
	private JRadioButton rbLigne =   new JRadioButton("ligne");
	private JRadioButton rbRectangle = new JRadioButton("rectangle");
	private JRadioButton rbCercle = new JRadioButton("cercle");
	private JComboBox<String> comboCouleur = new JComboBox<String>();
	private JButton btnEffacer = new JButton("effacer");
	
	public OngletDessin(){
	   this.setLayout(new BorderLayout());
	   this.add(BorderLayout.NORTH,panneauHaut);	   
	   panneauBas.setListeFigures(this.listeFigures);
	   this.add(BorderLayout.CENTER,panneauBas);
	   
	   ButtonGroup bg = new ButtonGroup();//exclusivite
	   panneauHaut.add(rbLigne); bg.add(rbLigne);
	   panneauHaut.add(rbRectangle); bg.add(rbRectangle);
	   panneauHaut.add(rbCercle); bg.add(rbCercle);
	   rbLigne.setSelected(true);
	   
	   panneauHaut.add(btnEffacer);
	   //panneauHaut.setBackground(Color.GRAY);
	   
	   btnEffacer.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			listeFigures.clear();
			panneauBas.repaint();
		}
	   });
	   
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
	   
	   panneauHaut.add(comboCouleur);
	   comboCouleur.addItem("black");
	   comboCouleur.addItem("red");
	   comboCouleur.addItem("green");
	   comboCouleur.addItem("blue");
	   comboCouleur.addItem("orange");
	   comboCouleur.addItem("yellow");
	   
	   comboCouleur.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent e) {
			comboCouleur_itemStateChanged(e);			
		}
	   });
	   
	   panneauBas.addMouseListener(new 
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
		switch(this.typefigCourante){
		case LIGNE:
			Ligne l =new Ligne();
			this.figureCourante=l;	break;
		case RECTANGLE:
			Rectangle r =new Rectangle();
			this.figureCourante=r;	break;
		case CERCLE:
			Cercle c =new Cercle();
			this.figureCourante=c;	break;			
		}	
		figureCourante.setOrigin(e.getX(), e.getY());
	}
	
	void panneauBas_mouseReleased(MouseEvent e){
		//System.out.println("x2="+e.getX() + ",y2=" + e.getY());
		switch(this.typefigCourante){
		case LIGNE:
			Ligne l = (Ligne) this.figureCourante;
			l.setX2(e.getX());l.setY2(e.getY()); break;
		case RECTANGLE:
			Rectangle r = (Rectangle) this.figureCourante;
			r.setL(Math.abs(e.getX()-r.getX1()));
			r.setH(Math.abs(e.getY()-r.getY1())); 
			if(e.getX() < r.getX1()) r.setX1(r.getX1()-r.getL());
			if(e.getY() < r.getY1()) r.setY1(r.getY1()-r.getH());
			break;
		case CERCLE:
			Cercle c = (Cercle) this.figureCourante;
			int dx=e.getX()-c.getXc();
			int dy=e.getY()- c.getYc();
			c.setRayon((int)Math.sqrt(dx*dx+dy*dy));
		}
		figureCourante.setCouleur(this.couleurCourante);
		figureCourante.performVisit( new SwingDrawingVisitor(this.panneauBas.getGraphics()));
		this.listeFigures.add(this.figureCourante);
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
		}
	}
	
	public String choosePathName(String pourquoi){
		String pathName= null;//"c:\\temp\\listeFigures.ser"; //par defaut;
		JFileChooser chooser = new JFileChooser();
		int  returnVal;
		if(pourquoi.equals("open"))
		   returnVal = chooser.showOpenDialog(this);
		else returnVal = chooser.showSaveDialog(this);
		
		if(returnVal == JFileChooser.APPROVE_OPTION)
		pathName= 
			chooser.getSelectedFile().getPath();		
		return pathName;
	}
	
	public void sauver(){
		//String pathName= "c:\\temp\\listeFigures.ser"; //par defaut;
		String pathName= this.choosePathName("save");
		try {
			FileOutputStream of = new 
			   FileOutputStream(pathName);
			ObjectOutputStream oos = 
				       new ObjectOutputStream(of);
			oos.writeObject(this.listeFigures);
			oos.close(); of.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
    public void charger(){
    	//String pathName= "c:\\temp\\listeFigures.ser"; //par defaut;
		String pathName= this.choosePathName("open");
    	try {
			FileInputStream fis = 
				new FileInputStream(pathName);
			ObjectInputStream ois = 
				  new ObjectInputStream(fis);
			this.listeFigures = 
				 (List<Figure>)ois.readObject();
			ois.close(); fis.close();			
			panneauBas.setListeFigures(listeFigures);
			panneauBas.repaint();			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void exporterSvg(){
		try {
			//String defaultFileName="c:\\temp\\figures.svg";
			String defaultFileName="figures.svg"; //+refresh eclipse ou ...
			FileOutputStream of = new FileOutputStream(defaultFileName);
			PrintStream ps = new PrintStream(of);
			ps.println("<svg xmlns='http://www.w3.org/2000/svg' width='600' height='400'>");
			
			SvgGenerateVisitor svgGenerateVisitor = new SvgGenerateVisitor();
			for(Figure f : listeFigures){
				//ps.println(f.toSvgString()); //ancienne version sans visiteur
				f.performVisit(svgGenerateVisitor);
			}
			ps.println(svgGenerateVisitor.getSvgContent());
			ps.println("</svg>");
			ps.close(); of.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
