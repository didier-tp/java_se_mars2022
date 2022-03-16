 * switch/cases with lambda expressions.   
    
    int numLetters = switch (day) {
       case MONDAY, FRIDAY, SUNDAY -> 6;
       case TUESDAY -> 7;
       case THURSDAY, SATURDAY -> 8;
       case WEDNESDAY -> 9;
       default -> throw new IllegalStateException("Huh? " + day);
    };
    
* internal JVM improvements 
* ...    