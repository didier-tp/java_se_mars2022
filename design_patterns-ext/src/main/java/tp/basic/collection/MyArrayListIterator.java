package tp.basic.collection;

import java.util.Iterator;

public class MyArrayListIterator<T> implements Iterator<T> {
	
	private MySimpleArrayList<T> msaList;
	private int currentPos;
	
	public MyArrayListIterator(MySimpleArrayList<T> msaList){
		this.msaList = msaList;
		this.currentPos=0;//first
	}

	@Override
	public boolean hasNext() {
		return (currentPos < msaList.size);
	}

	@Override
	public T next() {
		return msaList.internalArray[currentPos++];
	}

}
