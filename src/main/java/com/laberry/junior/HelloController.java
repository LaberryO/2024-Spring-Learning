package com.laberry.junior;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/myhello")
	@ResponseBody
	public String hello() {
		return "안녕하세요. 정보고 3학년 정승재입니다. 스프링부트 재미있습니다.";
	}
	
//	@GetMapping("/")
//	public String main() {
//		return "main";
//	}
	
	
}