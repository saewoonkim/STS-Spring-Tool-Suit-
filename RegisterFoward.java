package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterFoward {
//  @RequestMapping(value="/register/save", method={RequestMethod.GET,RequestMethod.POST})
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//	}

//  @RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping(value="/register/save2")
	public String save(User user, Model m) throws Exception {
		
		//1. 유효성 검사
		
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
			return "redirect:/register/add?msg="+msg;
		}
		
		//2. DB에 신규회원 정보를 저장
		return "registerInfo";
		
	}

	private boolean isValid(User user) {
	
		return false;
	}

}
