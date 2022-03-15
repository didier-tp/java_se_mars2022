package tp.basic.collection;

public class MyNode<T> {
	protected T data; 
    protected MyNode<T> next;
    
	public MyNode(T data, MyNode<T> next) {
		this.data = data;
		this.next = next;
	} 
    
	public MyNode(T data) {
		this(data,null);
	}
	
	public MyNode() {
		this(null,null);
	}
    
}
