package tp.j15_16_17;

public class TestPatternMatchingIstanceOfApp {

	public static void main(String[] args) {
		String s = "abc";
		oldStyleWithoutPatternMatchingIstanceOf(s);
		newStyleWithPatternMatchingIstanceOf(s);
	}
	
	public static void oldStyleWithoutPatternMatchingIstanceOf(Object obj) {
		if (obj instanceof String) {
		    String str = (String) obj;
		    int len = str.length();
		    System.out.println("obj is as string of length="+len);
		}
	}
	
    public static void newStyleWithPatternMatchingIstanceOf(Object obj) {
    	if (obj instanceof String str) {
		    int len = str.length();
		    System.out.println("obj is as string of length="+len);
		}
	}


}
