package proxy;

import java.util.concurrent.atomic.AtomicLong;

import aop.AopBrowser;

public class MainTest {
	// proxy는 대리인이라는 뜻으로써, 뭔가를 대신해서 처리하는 것.
	// proxy class를 통해서 대신 무언가를 전달하는 형태로 설계되며,
	// 실제 프록시를 사용하는 클라이언트는 Proxy클래스로부터 결과를 받는다.
	// Cache의 기능으로도 활용이 가능하다.
	// ㄴ (좀 더 빠르게 processing 할 수 있다.
	// 웹 브라우저에서 시각화,, html코드같은거 보여줄때의 상황을 생각해 보자.

	// 한번 메모리에 load된 것을 남겨뒀다가 다시 내려줄 수 있다.
	// Spring에서는 많이 annotation을 활용하는데,, proxy패턴을 활용해서 aop(관점지향형)를 구현할 수 있다.
	// AOP : Aspect Oriented Programming

	public static void main(String[] args) {
//		Browser browser = new Browser("www.naver.com");
//		browser.show();
//		browser.show();
//		browser.show();
		// 새로운 html이 매번 생성된다.
		// cache기능을 사용한단 말은 프록시 객체를 사용

//		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
//		
//		IBrowser browser = new AopBrowser("www.google.com", new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//
//			}
//		}, new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//
//			}
//		});

		// 동시성 문제 때문에
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();

		// 객체 초기화
		IBrowser browser = new AopBrowser("www.naver.com", () -> {

			System.out.println("before");
			start.set(System.currentTimeMillis());
		}, () -> {
			long now = System.currentTimeMillis();
			end.set(now - start.get()); // 총 소요시간 뽑아낼 수 있다.
		}

		);
		browser.show();
		System.out.println("loading time : " + end.get());
		// 첫번째 호출 소요시간 1513
		
		browser.show();
		// 두번째 호출 소요시간 0
		System.out.println("loading time : " + end.get());

		browser.show();
		// 세번째 호출 소요시간 0
		System.out.println("loading time : " + end.get());
		// 캐시 기능을 활용하면 메모리 처리속도에서 굉장한 이득을 볼 수 있다.
		
		
		// AOP란 관점 지향
		// AOP를 실질적으로 활용하는 사례는...
		// 특정한 메서드가 있으면 그 메서드의 실행시간을 확인하던가..
		// 일괄적인 request정보를 확인한다던가, response정보를 확인해서 남긴다고 할 때,,
		// 코드에 개별적으로 작성하는 것이 아니고 
		//일괄적으로 특정 클래스 또는 특정 패키지에 있는
		// 모든 메서드의 전후에 기능을 넣을 수 있는 방법을 제공한다.
		
		// 지켜보고 있다가 특정 클래스가 수행되면 어떤 메서드를 수행해!
	}

}
