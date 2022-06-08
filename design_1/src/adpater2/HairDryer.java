package adpater2;

public class HairDryer implements IElectronic110v {

	@Override
	public void connect() {
		System.out.println("헤어 드라이어 110v on");
	}

}
