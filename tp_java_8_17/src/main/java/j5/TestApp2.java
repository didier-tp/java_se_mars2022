package j5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestApp2 {


	public static void main(String[] args) {
		m1();
		//m2();
	}
	public static void m2() {
		List<Integer> listeInt = new ArrayList<>();
		listeInt.add(6); listeInt.add(3); listeInt.add(7); listeInt.add(2);
		System.out.println(listeInt);
		//Collections.sort(listeInt);
		//System.out.println(listeInt);
		
		List<Integer> listeTransformee =
		listeInt.stream().filter( (e) -> (e <= 5))
		                 .map( (e) -> e*10)
		                 .sorted( (e1,e2)-> e1-e2)
		                 .collect(Collectors.toList());
		System.out.println(listeTransformee);
		
		List<Assiette> listeAssiettes = new ArrayList<>();
		listeAssiettes.add(new Assiette("blanche",6)); 
		listeAssiettes.add(new Assiette("rouge",3));
		listeAssiettes.add(new Assiette("bleu",7)); 
		listeAssiettes.add(new Assiette("vert",2)); 
		System.out.println(listeAssiettes);
		Collections.sort(listeAssiettes,
				(a1,a2) -> { if(a1.getNumero() < a2.getNumero()) return -1;
				                             else return 1; });
		System.out.println(listeAssiettes);
		
	}
	
	public static void m1() {
		MyStack<String> pileChaines = new MyStack<>();
		pileChaines.push("ch1");pileChaines.push("ch2");pileChaines.push("ch3");
		System.out.println(pileChaines.pop());
		System.out.println(pileChaines.pop());
		System.out.println(pileChaines.pop());
		
		MyStack<Assiette> pileAssiettes = new MyStack<>();
		for(int i=1;i<=3;i++) {
		    pileAssiettes.push(new Assiette("blanche",i));
		}
		Assiette a = null;
		do {
			a = pileAssiettes.pop();
		    System.out.println(a);
		}while(a!=null);
		
	}

}
