package tp.j15_16_17;

//déclarée non-sealed , la classe Chien peut pas avoir des sous classes
public non-sealed class Chien implements AnimalDomestique{
	@Override
	public void sayHello() {
		System.out.print("chien  wouf wouf - ");
	}
	
	public void aLaNiche() {
		System.out.println(" dodo niche ");
	}
}
