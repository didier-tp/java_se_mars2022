
package tp.caddy;

import java.util.HashMap;
import java.util.Map;

public class BasicCaddy  implements AbstractCaddy
{
	private Map<Object,Integer>	 eltQtyMap = new HashMap<Object,Integer>();

	public BasicCaddy() {
		super();
	}
	
   public void addInCaddy(Object elt,int qte) {
    	  eltQtyMap.put(elt, qte);   
   }
   
   public Map<Object,Integer> getCaddyContentList() {
	   return eltQtyMap;
   }
     



    
}