package tp.j14;

public class TestNewSwitchApp {

	public static void main(String[] args) {
		test_switch_with_lambda();

	}

	private static void test_switch_with_lambda() {
		/*
		int dayOfWeek = 4;
		System.out.print("dayOfWeek="+dayOfWeek + " -> ");
		switch(dayOfWeek) {
		   case 1 -> System.out.println("monday");
		   case 2 -> System.out.println("tuesday");
		   case 3 -> System.out.println("wednesday");
		   case 4 -> { System.out.print("jeudi "); System.out.println("thursday"); }
		   case 5 -> System.out.println("friday");
		   case 6 -> System.out.println("saturday");
		   case 0 , 7 -> System.out.println("sunday");
		   default -> System.out.println("unknown");
		}
		*/
		//******************************
		
		String dayName="vendredi";
		System.out.print("dayName="+dayName + " -> ");
		
	
		int dayNumber = 
				switch(dayName) {
				   case "lundi" , "monday" -> 1;
				   case "mardi" , "tuesday" -> 2;
				   case "mercredi" , "wednesday" -> 3;
				   case "jeudi" , "thursday" -> 4;
				   case "vendredi" , "friday" -> 5;
				   case "samedi" , "saturday" -> 6;
				   case "dimanche" , "sunday" -> 7;
				   default -> 0;
				};
		System.out.println("dayNumber="+dayNumber);
    	
		//******************************
		int value = (int) (Math.random() * 14);

        String result = switch( value ) {
            case 0, 2, 4, 6, 8 -> {
                double racine = Math.sqrt( value );
                yield "chiffre pair dont la racine carree vaut " + racine;
            }
            case 1, 3, 5, 7, 9 -> {
                double carre = value * value;
                yield "chiffre impair dont le carree vaut " + carre;
            }
            default -> "ce n'est plus un chiffre, mais un nombre";
        };

        System.out.println("value=" + value + "->" +  result );
      
	}

}
