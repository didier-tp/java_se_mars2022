package tp.basic.collection;

import java.util.Iterator;

public class MySimpleArrayList<T> implements MySimpleList<T>{
	//protected visibility for iterators (in same package) access
	protected int size, capacity;
	
	protected T[] internalArray;
	
	
	public MySimpleArrayList(){
		capacity=4; //initial capacity 
		internalArray = (T[])new Object[capacity];
		size=0;
	}

	@Override
	public void add(T obj) {
		if(size==capacity) {
			int newCapacity=capacity*2;
			T[] newInternalArray = (T[]) new Object[newCapacity];
			for(int i=0;i<size;i++) {
				newInternalArray[i]=internalArray[i];
			}
			internalArray=newInternalArray;
			capacity=newCapacity;
		}
		internalArray[size++]=obj;
	}

	@Override
	public T get(int index) {
		return internalArray[index];
	}
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyArrayListIterator<T>(this);
	}
	
}
