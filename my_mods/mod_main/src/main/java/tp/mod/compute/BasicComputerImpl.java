package tp.mod.compute;

public class BasicComputerImpl implements BasicComputer {

	@Override
	public double square(double x) {
		return x * x;
	}

	@Override
	public double add(double x, double y) {
		return x + y;
	}

}
