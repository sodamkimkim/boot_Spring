package adpater2;

public class MyHouse {
	public static void homeConnect(IElectronic220v electronic220v) {
		electronic220v.connect();
	}

	public static void main(String[] args) {

		AirConditioner airConditioner = new AirConditioner();
		Cleaner cleaner = new Cleaner();
		HairDryer hairDryer = new HairDryer();

		homeConnect(airConditioner);
//		homeConnect(cleaner);
//		homeconnect(hairDryer);

		// 110인 드라이어 쓰려면, 드라이어를 어뎁터에 연결하고 어뎁터를 homeConnect해줌
		ElectronicAdapter adapter1 = new ElectronicAdapter(hairDryer);
		homeConnect(adapter1);
		ElectronicAdapter adapter2 = new ElectronicAdapter(cleaner);
		homeConnect(adapter2);
	}
}
