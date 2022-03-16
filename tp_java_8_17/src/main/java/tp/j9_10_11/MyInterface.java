package tp.j9_10_11;

public interface MyInterface {
	public int f1(int a); //normal method
	default int f2() { return private_submethod(); } //default method in interface since java 8
	default int f3() { return private_submethod(); } 
	private int private_submethod() { return 9; } // private method in interface since java 9
}
