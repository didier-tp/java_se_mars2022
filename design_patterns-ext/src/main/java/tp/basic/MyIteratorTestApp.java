package tp.basic;

import java.util.Iterator;

import tp.basic.collection.MySimpleArrayList;
import tp.basic.collection.MySimpleLinkedList;
import tp.basic.collection.MySimpleList;

public class MyIteratorTestApp {

	public static void main(String[] args) {
		basicTest();

	}
	
	public static void displayContentListWithoutIterator(MySimpleList<?> liste) {
		System.out.print("\nwithout iterator :");
		for(int i=0;i<liste.size();i++) {
			System.out.print(liste.get(i) + " ");
		}
	}
	
	public static void displayContentListWithIterator(MySimpleList<?> liste) {
		System.out.print("\nwith iterator :");
		Iterator<?> it = liste.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		//-----------
		System.out.print("\nfor each Iterable :");
		for(Object obj : liste) {
			System.out.print(obj + " ");
		}
	}
	
	public static void basicTest() {
		MySimpleList<String> liste1 = new MySimpleArrayList<>();
		liste1.add("lundi");liste1.add("mardi");liste1.add("mercredi");
		liste1.add("jeudi");liste1.add("vendredi");liste1.add("samedi");
		liste1.add("dimanche");
		displayContentListWithoutIterator(liste1);
		displayContentListWithIterator(liste1);
		
		MySimpleList<Integer> liste2 = new MySimpleLinkedList<>();
		liste2.add(0);liste2.add(1);liste2.add(4);liste2.add(9);
		liste2.add(16);liste2.add(25);liste2.add(36);liste2.add(49);
		liste2.add(64);liste2.add(81);liste2.add(100);
		displayContentListWithoutIterator(liste2);
		displayContentListWithIterator(liste2);
		
		//pour aller plus loin (la semaine des 4 jeudis ou pour réinventer la roue):
		//https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html
		//https://docs.oracle.com/javase/8/docs/api/java/util/stream/StreamSupport.html
		//pour mettre en oeuvre des iterateurs sophistiqués permettant d'utiliser l'api stream de java 8+
		//et les lambdas .
	}

}
