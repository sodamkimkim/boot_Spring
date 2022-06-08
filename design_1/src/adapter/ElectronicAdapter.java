package adapter;

public class ElectronicAdapter implements IElectronic220v {// 대한민국 표준 220이라서


		// adapter패턴을 설계하는 방법
		// 1. 포함 관계를 만들어 준다. 변환시킬 대상(110)을 포함관계로 만들어줌

	private IElectronic110v electronic110v;

	// 2. 생성자를 통해서 의존주입을 받을 수 있도록 설계한다.
	// ㄴ 내한테서 뉴 때리지 않고 생성자를 토애서 받는거
	// 생성자는 객체를 메모리에 올릴 때 반드시 호출해야 하는 강제성
	public ElectronicAdapter(IElectronic110v electronic110v) {
		this.electronic110v = electronic110v;
	}
	@Override
	public void connect() {
		electronic110v.connect(); // 생성자에 있기 때문에 null포인터 걱정 없다.
		// 런타임 시점에 메모리에 올라가 있는 객체의 동작을 호출한다.

	} 

}
