package tp.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface MyMinimum {
    int value();
}


/*
class Person {
   @MyMinimum(0)  // pour interdire age négatif 
   Integer age ;
   
   


*/