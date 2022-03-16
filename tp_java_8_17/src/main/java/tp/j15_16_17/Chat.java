package tp.j15_16_17;

//déclarée final , la classe Chat ne peut pas avoir de sous classe
public final class Chat implements AnimalDomestique{

	@Override
	public void sayHello() {
		System.out.print("chat miaou - ");
	}

	public void ronronner() {
		System.out.println(" ronron ");
	}
}
