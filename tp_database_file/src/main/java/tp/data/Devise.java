package tp.data;

public class Devise {
     private String code; // "EUR" , "USD" , "GBP" , "JPY" , ...
                          //le code sera l'indentifiant (pk) d'une devise
     private String nom; //"Euro" , "Dollar" , "...
     private Double change; //nb ... pour 1 euro (0.9 , 1.1 )
	
     
    @Override
	public String toString() {
		return "Devise [code=" + code + ", nom=" + nom + ", change=" + change + "]";
	}


	public Devise() {
		super();
	}


	public Devise(String code, String nom, Double change) {
		super();
		this.code = code;
		this.nom = nom;
		this.change = change;
	}
    
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
     
}
