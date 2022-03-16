package tp.sam;

@FunctionalInterface
public interface IsMapped<T> {
    boolean isAssociatedWith(String keyValue , T obj );
    
    default boolean isCaseSensitive() {  	return false;     } //m�thode par d�faut (rare , quasi bidouille)
    
    static void printIfTrue(boolean bExpr , String message){
    	if(bExpr) 
    		  System.out.println(message);
    	}
    
    static void printEither(boolean bExpr , String messageIfTrue , String messageIfFalse){
    	 System.out.println(bExpr?messageIfTrue:messageIfFalse);
    	}
}
