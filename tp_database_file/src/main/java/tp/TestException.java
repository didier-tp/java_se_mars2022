package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import util.MyUtil;

public class TestException {
	
	public static void testException1() {
		int a=6;
		int b=Integer.parseInt(MyUtil.inputDlg("b="));
		try {
			int res=a/b;
			System.out.println("res="+res);
		} catch (Exception e) {
			//System.err.println(e.getMessage());
			e.printStackTrace();
			// eventuel System.exit(0); pour arreter le programme
		}
		System.out.println("suite");
	}
	
	public static void testException2() {
	    String nombreSaisiEnTantString = MyUtil.inputDlg("x="); // "12.5" , "3a"
	    double x=0.0;
		try {
			x = Double.parseDouble(nombreSaisiEnTantString);
		} catch (NumberFormatException e) {
			//System.err.println(e.getMessage());
			e.printStackTrace();
		}
	    x=x*10;
	    System.out.println("x="+x);
	}
	
	public static void testException3() {
				try {
					InputStream f = new FileInputStream("f1.txt");
					BufferedReader ff=new BufferedReader(new InputStreamReader(f));
					String ligne1=ff.readLine();
					System.out.println("ligne1 de f1.txt="+ligne1);
					ff.close();
					f.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	public static void main(String[] args) {
		testException1();
		testException2();
		testException3();
        
	}

}
