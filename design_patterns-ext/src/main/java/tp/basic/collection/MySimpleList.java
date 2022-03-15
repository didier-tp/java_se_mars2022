package tp.basic.collection;

public interface MySimpleList<T> extends Iterable<T> {
	public void add(T obj);
	public int size();
	public T get(int index);
}
