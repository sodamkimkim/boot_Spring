package decoratorpattern;

public class A5 extends AudiDecorator{

	public A5(ICar audi, String modelName, int modelPrice) {
		super(audi, modelName, 4_000);
	}

}
