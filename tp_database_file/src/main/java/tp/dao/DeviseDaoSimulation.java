package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.data.Devise;

public class DeviseDaoSimulation implements DeviseDao {
	
	//table d'association entre des codes de monnaies et des objets Devises
	private Map<String,Devise> mapDevises = new HashMap<>();
	

	public DeviseDaoSimulation() {
		super();
		this.mapDevises.put("EUR",new Devise("EUR","Euro",1.0) );
		this.mapDevises.put("USD",new Devise("USD","Dollar",1.1));
		this.mapDevises.put("GBP",new Devise("GBP","Livre",0.9));
		this.mapDevises.put("JPY",new Devise("JPY","Yen",120.0) );
	}

	@Override
	public Devise creerDevise(Devise d) {
		this.mapDevises.put(d.getCode(),d );
		return d;
	}

	@Override
	public Devise rechercherDevise(String code) {
		return this.mapDevises.get(code);
	}

	@Override
	public List<Devise> rechercherToutesDevises() {
		return new ArrayList<Devise>(this.mapDevises.values());
	}

	@Override
	public void updateDevise(Devise d) {
		this.mapDevises.put(d.getCode(),d );
	}

	@Override
	public void supprimerDevise(String code) {
			this.mapDevises.remove(code);
			//map.remove(clef) 
			//et confusion avec entityManager.remove(object) de Hibernate/Jpa
	}

}
