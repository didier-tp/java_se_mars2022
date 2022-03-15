package tp.basic.collection;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements MySimpleList<T> {
	
	protected MyNode<T> headNode, tailNode;//first and last node/cell
	
	public MySimpleLinkedList(){
		headNode=tailNode=null; //empty linked list without node/cell
	}

	@Override
	public void add(T obj) {
		MyNode<T> node = new MyNode<>(obj, null);
		if(headNode==null) {
			tailNode=headNode=node;
		}else {
			tailNode.next = node;
			tailNode=node;
		}
		
	}

	@Override
	public T get(int index) {
		// not optimized
		int i=0;
		MyNode<T> node=headNode;
		while(i<index && node!=null) {
			node=node.next;
			i++;
		}
		return (node==null)?null:node.data;
	}

	@Override
	public int size() {
		// not optimized
		MyNode<T> node=headNode;
		int size=(node==null)?0:1;
		while(node!=null) {
			node=node.next;
			if(node!=null)
				size++;
		}
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator<T>(this);
	}

}
