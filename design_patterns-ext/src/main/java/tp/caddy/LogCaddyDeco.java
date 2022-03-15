
package tp.caddy;

import org.slf4j.LoggerFactory;

public class LogCaddyDeco extends CaddyDeco 
{
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(LogCaddyDeco.class);
	
	public LogCaddyDeco() {
		super();
	}
	
   public LogCaddyDeco(AbstractCaddy caddy) {
		super(caddy);
	}

public void addInCaddy(Object elt,int qte) {
	   //System.out.println("Added in caddy: "+ elt + ",qte="+qte);
	   logger.info("Added in caddy: "+ elt + ",qte="+qte);
       super.addInCaddy(elt, qte);
   
   }
    
}