package com.example.jsp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/index")
	public String index() {

//        prefix: /WEB-INF/views/
//        suffix: .jsp
//        /WEB-INF/views/index.jsp

		return "index";
		// http://localhost:9090/board/for -->주소창에 입력하면
		// WEB-INF/views/index.jsp --> 보여준다.

	}

	@GetMapping("/example1")
	public String example1() {
		return "example1";
		// http://localhost:9090/board/example1 -->주소창에 입력하면
		// WEB-INF/views/example1.jsp --> 보여준다.
	}

	@GetMapping("/example2")
	public String example2() {
		return "example2";
		// http://localhost:9090/board/example2 -->주소창에 입력하면
		// WEB-INF/views/example2.jsp --> 보여준다.
	}

	@GetMapping("/if")
	public String if2() {
		return "if";
		// http://localhost:9090/board/if -->주소창에 입력하면
		// WEB-INF/views/if.jsp --> 보여준다.

	}

	@GetMapping("/while")
	public String while2() {
		return "while";
		// http://localhost:9090/board/while -->주소창에 입력하면
		// WEB-INF/views/while.jsp --> 보여준다.
	}

	@GetMapping("/for")
	public String for2() {
		return "for";
		// http://localhost:9090/board/for -->주소창에 입력하면
		// WEB-INF/views/for.jsp --> 보여준다.
	}

	@GetMapping("/round")
	public String round() {
		return "round";
		// http://localhost:9090/board/round -->주소창에 입력하면
		// WEB-INF/views/round.jsp --> 보여준다.
	}
}