package decoratorpattern;

// 데코레이터 패턴은 기본 뼈대(클래스)를 유지하되, 이후 필요한 기능을 꾸밀 때 사용한다.
// new Buffered.... new InputStreamReader(new InputStream());
public class MainTest {

	public static void main(String[] args) {
		
		ICar audi = new Audi(1_000);
		audi.showPrice();
		
		ICar a3 = new A3(audi, "A3", 3_000); // audi를 넣어서 새로운 객체 생성 --> decorator패턴
		a3.showPrice();
		
	}

}
