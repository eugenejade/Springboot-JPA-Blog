package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//data가 아니라 file을 return
@Controller
public class TempControllerTest {
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temp at home");
		//파일리턴 기본경로: src/main/resources/static
		// 리턴병 : /home.html
		// src/main/resources/static/home.html
		return "/home.html";
	}
	@GetMapping("/temp/img")
	public String tempImg() {
		System.out.println("temp at img");
		return "/c11.JPG";
	}
	@GetMapping("/temp/jsp")
	public String tempJsp() {
//	      prefix: /WEB-INF/views/
//	      suffix: .jsp
		System.out.println("temp at jsp");
		return "test";
	}
}
