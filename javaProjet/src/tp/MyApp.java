package tp;

public class MyApp {

	public static void main(String[] args) {
		//System.out.println("ok2");
		//test1();
		//testCercle();
		testPersonne();
	}
	
	public static void testPersonne() {
		Personne p1 = new Personne();
		System.out.println("p1="+p1.toString());
		Personne p2 = new Personne("jean","Bon",40);
		p2.incrementerAge();
		System.out.println("age de p2 = " + p2.getAge());
		System.out.println("p2 = " + p2);
		p2.setAge(-5); //pas pris en compte (plus tard encadré par try/catch)
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
		                             //pour convertir l'objet c2 en "string" à concaténer
	    double pC2 = c2.perimetre();
	    System.out.println("perimetre de c2=" + pC2);
	}
	
	public static void test1() {
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
