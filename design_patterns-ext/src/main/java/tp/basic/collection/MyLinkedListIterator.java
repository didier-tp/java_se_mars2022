package tp.basic.collection;

import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T> {
	
	private MySimpleLinkedList<T> mslList;
	private MyNode<T> currentNode;
	
	public MyLinkedListIterator(MySimpleLinkedList<T> mslList){
		this.mslList = mslList;
		this.currentNode=mslList.headNode;//first
	}

	@Override
	public boolean hasNext() {
		return (currentNode != null);
	}

	@Override
	public T next() {
		T res=currentNode.data;
		currentNode=currentNode.next;
		return res;
	}

}
