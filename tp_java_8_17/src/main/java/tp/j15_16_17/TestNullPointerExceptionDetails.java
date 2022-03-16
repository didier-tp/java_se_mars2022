package tp.j15_16_17;

public class TestNullPointerExceptionDetails {

	public static void main(String[] args) {
		try {
			int a[] = null;
			a[4]=3;
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 java.lang.NullPointerException: Cannot store to int array because "a" is null
	            at tp.j15_16_17.TestNullPointerExceptionDetails.main(TestNullPointerExceptionDetails.java:8)
			 */
		}
		

	}

}
