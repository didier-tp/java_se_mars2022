package tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp.individu.Employe;
import tp.individu.Personne;
import tp.volant.AvionV3;
import tp.volant.ObjetVolant;

public class MyApp {

	public static void main(String[] args) {
		//System.out.println("ok2");
		//test1();
		//testCercle();
		//testPersonne();
		//testString();
		//testMoyenne();
		testAvionV1();
		testCollection();
		double x= Math.sqrt(81);
		System.out.println("racine de 81="+x);
		
		//java.util.Date d1 = new java.util.Date();
		Date d1 = new Date();
		System.out.println("d1="+d1);
	}
	
	public static void testCollection() {
		System.out.println(">>>> testCollection");
		List<String> l1 = new ArrayList<String>();
		l1.add("abc"); l1.add("xyz"); 
		int nbElt = l1.size();
		System.out.println("nbElt="+nbElt);
		//boucle for au sens forEach
		for(String s : l1) {
			System.out.println("s="+s);
		}
	}
	
	public static void testAvionV1() {
		ObjetVolant obj =null; //obj est une variable référence
		//qui pourra référence n'importe quel cas particuliers d'objet volant
		
		//obj = new ObjetVolant(); impossible car ObjetVolant est une classe abtraite
		
		//Personne.setAgeMajorite(17);
		Personne.setAgeMajorite(18);
		
		//AvionV1 avion = new AvionV1();
		//System.out.println("TAILLE_MAX="+AvionV1.TAILLE_MAX);
		//AvionV2 avion = new AvionV2();
		//System.out.println("TAILLE_MAX="+AvionV2.TAILLE_MAX);
		AvionV3 avion = new AvionV3();
		System.out.println("TAILLE_MAX="+AvionV3.TAILLE_MAX);
		
		avion.initialiser();//avec  un pilote et une hotesse
		avion.addElement(new Personne("jean","Bon",4));
		avion.addElement(new Personne("jean","Aimaire",17));
		avion.addElement(new Personne("axelle","Aire",18));
		
		obj=avion;
		System.out.println("plafond = " + obj.getPlafond());
		
		Employe hotesse2 = new Employe("sylvie","Hotesse",32,2000);
		hotesse2.setSalaire(2200); //augmentation
		avion.addElement(hotesse2);
		System.out.println("hotesse2.toString()=" + hotesse2.toString() );
		
		Personne p=null;
		p=hotesse2;//Employe en tant que cas particulier de Personne
		System.out.println("p.toString()=" + p.toString() );
		
		avion.afficher();
	}
	
	public static void testMoyenne() {
		/*
		double[] tabVal = new double[5];
		tabVal[0]=4.0;
		tabVal[1]=2.0;
		tabVal[2]=1.0;
		tabVal[3]=0.0;
		tabVal[4]=5.0;
		*/
		double[] tabVal = { 4.0 , 2.0 , 1.0 , 0.0 , 5.0 };
		double somme=0.0;
		for(int i=0;i<tabVal.length;i++) {
			somme = somme + tabVal[i];
		}
		double moyenne = somme / tabVal.length;
		System.out.println("moyenne="+moyenne);
	}
	
	public static void testString() {
		String ch="lundi-mardi";
		int posTiret = ch.indexOf("-");//5
		//appeler 2 fois .substring() pour récupérer et afficher les sous parties
		//avant et aprés
		if(posTiret>=0) {
			String chDebut=ch.substring(0,posTiret);
			System.out.println("chDebut="+chDebut);
			String chFin=ch.substring(posTiret+1,ch.length());
			System.out.println("chFin="+chFin);
		}else {
			System.out.println("pas de - trouvé dans ch");
		}
		
		String ch2 = "BONJOUR"; //ch2="BONJOUR" ou "OK"
		//via une boucle for, contruire une chaine de caractére a l'envers
		//...
		StringBuilder buffer= new StringBuilder(ch2.length());
		for(int i=ch2.length()-1 ; i>=0 ; i=i-1) {
			buffer.append(ch2.charAt(i));
		}
		String chInversee = buffer.toString();
		System.out.println("chInversee="+chInversee);
	}
	
	public static void testPersonne() {
		Personne p1 = new Personne();
		System.out.println("p1="+p1.toString());
		Personne p2 = new Personne("jean","Bon",40);
		p2.incrementerAge();
		System.out.println("age de p2 = " + p2.getAge());
		System.out.println("p2 = " + p2);
		try {
			p2.setAge(-5); //pas pris en compte et remonte exception
		} 
		catch(IllegalArgumentException iae) {
			System.err.println(iae.getMessage());
		}
		catch (Exception e) {
			//System.err.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("p2 = " + p2);
		p2.setAge(5); //pris en compte
		System.out.println("p2 = " + p2);
	}
	
	public static void testCercle() {
		Cercle c1 = null;
		c1 = new Cercle();
		System.out.println("rayon de c1 = " + c1.getRayon());
		Cercle c2 = new Cercle(50,60,20,"red");
		System.out.println("rayon de c2 = " + c2.getRayon());
		c2.setRayon(30);
		//System.out.println("c2="+c2.toString());
		System.out.println("c2="+c2);//.toString() est appelé automatiquement sur c2
		                             //pour convertir l'objet c2 en "string" a concaténer
	    double pC2 = c2.perimetre();
	    System.out.println("perimetre de c2=" + pC2);
	}
	
	public static void test1() {
		String chFileName = "ficA.txt";
		int n = chFileName.length(); // 8 caractères
		String chExt = chFileName.substring(n-3,n);
		System.out.println("chExt="+chExt);
		char c5 = chFileName.charAt(5);
		System.out.println("c5="+c5);
		
		
		String ch1 = null;
		if( ch1 !=null &&  ch1.equals("ok") ) 
			System.out.println("ch1 est déja ok");
		else 
			System.out.println("ch1 est pas encore ok");
		ch1 = "ok";
		if( ch1 !=null && ch1.equals("ok") ) 
			System.out.println("ch1 est ok");
		
		//System.out.println("test1");
		String s1 ="123.5";
		double x1 ;
		x1 = Double.parseDouble(s1);
		double y = 2 * x1;
		System.out.println("y="+y);
		
		int age = 40;
		Integer objAge = null;
		objAge = 40;	//new Integer(40); //automatique depuis java 5
		
	}

}
