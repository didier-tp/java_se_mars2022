package tp.test;

import java.lang.reflect.Field;

import tp.annotations.MyMinimum;
import tp.data.Person;

public class TestAnnotationApp {
	
	public static boolean estUnePersonneValid(Person p) {
		boolean res = true;
		Class<? extends Person> c = p.getClass();
		for(Field f : c.getDeclaredFields()) {
			//System.out.print(f.getName() + " de type " + f.getType().getSimpleName());
			f.setAccessible(true); //pour avoir le droit de récupérer la valeur d'une chose "private"
			Object valueOfField = null;
			try {
				valueOfField = f.get(p);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			//System.out.println(" et de valeur=" + valueOfField );
			
			MyMinimum annotMini = f.getAnnotation(MyMinimum.class);
			if(annotMini!=null) {
				int miniValide = annotMini.value();
				//System.out.println("\t minimum valide = " + miniValide);
				if( ((Integer) valueOfField ) < miniValide ) {
					res = false;
				}
			}

 		}
		return res;
     }

	public static void main(String[] args) {
		
		Person p1 = new Person(1L, "jean" , "Bon");
		p1.setAge(33); p1.setTaille(150);
		
		if(estUnePersonneValid(p1))
			System.out.println("p1 est valide");
		else
			System.out.println("p1 est invalide");
		
		Person p2 = new Person(2L, "alex" , "Therieur");
		p2.setAge(-5); p2.setTaille(180);
		
		if(estUnePersonneValid(p2))
			System.out.println("p2 est valide");
	    else
	    	System.out.println("p2 est invalide");

	}

}
