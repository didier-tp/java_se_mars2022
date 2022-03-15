
package tp.caddy;

import java.util.Map;

import org.slf4j.LoggerFactory;

public class StatCaddyDeco extends CaddyDeco 
{
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(StatCaddyDeco.class);

	public StatCaddyDeco() {
		super();
	}
	
	
   public StatCaddyDeco(AbstractCaddy caddy) {
		super(caddy);
	}


public Map<Object,Integer> getCaddyContentList() {
	   Map<Object,Integer> resMap = super.getCaddyContentList();
	   int nbElts = (resMap!=null)?resMap.size():0;
	   //System.out.println("Nb elements of caddy: "+ nbElts);
	   logger.info("Nb entry of caddy: "+ nbElts);
      return resMap;
      
   }
    
}