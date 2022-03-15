package tp.test;


import java.util.Map;

import tp.caddy.AbstractCaddy;
import tp.caddy.BasicCaddy;
import tp.caddy.LogCaddyDeco;
import tp.caddy.StatCaddyDeco;

public class CaddyDecoTestApp {

	
	public static void main(String[] args) {
		testCaddyDeco();
	}
	
	public static void testCaddyDeco()
	{
		BasicCaddy basicCaddy = new BasicCaddy();
		AbstractCaddy caddy = null;
		LogCaddyDeco logged_caddy = new LogCaddyDeco(basicCaddy);
		StatCaddyDeco withStat_caddy = new StatCaddyDeco(basicCaddy);
		StatCaddyDeco withStat_logged_caddy = new StatCaddyDeco(logged_caddy);
		
		// EFFECTUER PLUSIEURS TESTS en SWITCHANT de ligne caddy = ...
		
		//caddy = basicCaddy;
		//caddy = logged_caddy;
		//caddy = withStat_caddy;
		caddy = withStat_logged_caddy;
		
		caddy.addInCaddy("stylo", 3);
		caddy.addInCaddy("cahier", 2);
		caddy.addInCaddy("crayon", 4);
		Map<Object,Integer> mapCaddyContent  = caddy.getCaddyContentList();
		for(Object obj : mapCaddyContent.keySet())
			System.out.println(obj.toString()+ 
					           "--"+ mapCaddyContent.get(obj));
		
		
	}

}
