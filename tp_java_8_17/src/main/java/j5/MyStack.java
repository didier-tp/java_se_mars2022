package j5;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
	
	private List<T> listeInterne = new ArrayList<>();
	
	public void push(T elt) {
		listeInterne.add(elt);
	}
	
	public T pop() {
		if(listeInterne.isEmpty()) return null;
		return listeInterne.remove(listeInterne.size()-1);
	}

	public MyStack() {
        
	}

}
