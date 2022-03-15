package tp.caddy;

import java.util.Map;

public interface AbstractCaddy 
{
   public void addInCaddy(Object elt,int qte);
   public Map<Object,Integer> getCaddyContentList();
}