
package tp.caddy;

import java.util.Map;


public abstract class CaddyDeco  implements AbstractCaddy
{
	private AbstractCaddy sous_caddy;

	public CaddyDeco() {
		super();
	}
	
	public CaddyDeco(AbstractCaddy caddy) {
		super();
		sous_caddy = caddy;
	}
	

   public AbstractCaddy getBasicCaddy() {
		return sous_caddy;
	}

	public void setBasicCaddy(AbstractCaddy sous_caddy) {
		this.sous_caddy = sous_caddy;
	}



public void addInCaddy(Object elt,int qte) {
      sous_caddy.addInCaddy(elt, qte);
   }
   
   public Map<Object,Integer> getCaddyContentList() {
       return sous_caddy.getCaddyContentList();
   }

    
}