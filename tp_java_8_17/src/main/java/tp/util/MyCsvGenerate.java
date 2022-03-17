package tp.util;

import java.lang.reflect.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tp.annotations.CsvIgnore;
import tp.annotations.MyMinimum;
import tp.data.Person;
import tp.data.Product;

public class MyCsvGenerate {
	
	public static String generateLineOfCsv(Object obj,boolean forFirstLine) {
		StringBuilder sb = new StringBuilder();
		Class c = obj.getClass();
		for(Field f : c.getDeclaredFields()) {
			f.setAccessible(true); //pour avoir le droit de récupérer la valeur d'une chose "private"
			Object valueOfField = null;
			try {
				valueOfField = f.get(obj);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			CsvIgnore annotCsvIgnore = f.getAnnotation(CsvIgnore.class);
			MyMinimum annotMyMinimum = f.getAnnotation(MyMinimum.class);
			if(annotMyMinimum!=null) {
				System.out.println("le minimum valide pour " + f.getName() + " est " + annotMyMinimum.value());
			}
			if(annotCsvIgnore==null) {
				if(forFirstLine)
					sb.append(";" + f.getName());
				else
			      sb.append(";" + valueOfField);
			}
		}
		sb.deleteCharAt(0);
		return sb.toString();
	}

	public static void main(String[] args) {
		Person p1 = new Person(1L, "jean" , "Bon");
		p1.setEmail("jb@gmail.com"); p1.setAge(40); p1.setTaille(180);
		System.out.println(generateLineOfCsv(p1,true));
		System.out.println(generateLineOfCsv(p1,false));
		System.out.println("-----");
		try {
			ObjectMapper jacksonObjectMapper = new ObjectMapper();
			String p1JsonString = jacksonObjectMapper.writeValueAsString(p1);
			System.out.println("p1JsonString="+p1JsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("-----");
		
		Product prod1 = new Product(1L, "prod 1" , 123.0 , "Bon produit");
		System.out.println(generateLineOfCsv(prod1,true));
		System.out.println(generateLineOfCsv(prod1,false));
		
		decrireClasseJava("tp.data.Product");
		decrireClasseJava("tp.data.Person");
	}
	
	public static void decrireClasseJava(String  nomClasseJava) {
		 System.out.println("description de " + nomClasseJava +":") ;
		try {
			Class c = Class.forName(nomClasseJava);
			//ou bien Class c = intanceObjetJava.getClass();
			for(Field f : c.getDeclaredFields()) {
				f.setAccessible(true); //pour avoir le droit de récupérer la valeur d'une chose "private"
			    System.out.println("\t attribut " + f.getName() + " de type=" + f.getType().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
