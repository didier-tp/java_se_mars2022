package tp;

public class Bagage implements Transportable {
	
	private String label;
	private double poids; //en kg
	private double volume ; //en litre

	@Override
	public String getDesignation() {
		return this.label;
	}

	@Override
	public double getPoids() {
		return this.poids;
	}
	
	
	public Bagage() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Bagage [label=" + label + ", poids=" + poids + ", volume=" + volume + "]";
	}

	public Bagage(String label, double poids, double volume) {
		super();
		this.label = label;
		this.poids = poids;
		this.volume = volume;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	

}
