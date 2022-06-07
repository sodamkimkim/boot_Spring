package com.example.filter_ex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public List<String> list() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		return list;
	}
}
