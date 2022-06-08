package aop;

import proxy.Html;
import proxy.IBrowser;

public class AopBrowser implements IBrowser {
	// aop의 대표 특징 -- 전처리, 후처리
	// 어떤 코드가 돌아가기 전에 먼저/후 처리 되는거
	private String url;
	private Html html;
	private Runnable before;
	private Runnable after;

	public AopBrowser(String url, Runnable before, Runnable after) {
		this.url = url;
		this.before = before;
		this.after = after;
	}

	@Override
	public Html show() {
		before.run();
		if (html == null) {
			System.out.println("AopBrowser html loading from : " + url);
			html = new Html(url);
			// 여기 코드 너무 빨리 처리되어서 Thread sleep걸어주겠음
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
        after.run();
        System.out.println("AopBroswer html cache : " + url);
        return null;
	}
}
