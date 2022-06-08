package adapter;

public class MyHouse {

	// 집에서 전기 콘센트를 연결하는 동작
	public static void homeConnect(IElectronic220v electronic220v) {
		electronic220v.connect();
	}

	public static void main(String[] args) {
		// 1. 에어컨
		// 2. 헤어 드라이기
		// 3. 청소기

		// 추상화해주세요!!( --> is 인터페이스 선언해 주세요. (공통적인 동작을 만들어 낸다))
		// 전기콘센트에 연결 --> connect(); // 사용하려면 전기가 필요해서 연결하는 동작을 구현해야 한다.

		// 문제 인식
		// 친구가 일본에서 결혼선물로 청소기, 헤어드라이기를 선물.
		// 110v로 동작하는 녀석들 --> 에어컨은 220v로 동작하는 녀석.

		// 사용해보기
		AirConditioner airConditioner = new AirConditioner();
		// 집의 전기 콘센트에 연결
		homeConnect(airConditioner);

		HairDryer hairDryer = new HairDryer();
//		homeConnect(hairDryer); --> 220v, 110v연결 안된다.

		Cleaner cleaner = new Cleaner();
//		homeConnect(cleaner); --> x

		// 어댑터 구매해서 사용하기
		ElectronicAdapter adapter1 = new ElectronicAdapter(hairDryer);
		// 집에 있는 콘센트에 연결하기.
		homeConnect(adapter1);

		ElectronicAdapter adapter2 = new ElectronicAdapter(cleaner);
		homeConnect(adapter2);
	}
}
