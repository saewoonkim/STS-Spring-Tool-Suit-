package com.dongsung.ch02;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	  @RequestMapping(value="/register/add", method={RequestMethod.GET,RequestMethod.POST})
		public String register() {
			return "registerForm";
		}
	
	
	/*
	 * // @RequestMapping(value="/register/save",
	 * method={RequestMethod.GET,RequestMethod.POST})
	 * 
	 * @GetMapping("/register/add") //get방식 포스트 방식 다허용 public String register() {
	 * return "registerForm"; }
	 */
	
	/* 포스트 방식으로 바꾸면 주소창에 쿼리문으로 넣어도 바뀌거나 들어가지못한다*/
//  @RequestMapping(value="/register/save", method=RequestMethod.POST)
	/*
	 * @PostMapping(value="/register/save") public String save() { return
	 * "registerInfo"; }
	 */
		@PostMapping(value="/register/save")
		public String save(User user, Model m) throws Exception {
			
			//1. 유효성 검사
			
			if(!isValid(user)) {
				//URL 엔코더를 쓸려면 위에 쓰로우 엑셉션을 무조건 해줘야된다.인코딩한걸 디코더로 풀어줘야지만 작동된다.
				String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.","utf-8");
				//return "redirect:/register/add?msg="+msg; 다시 유저한테 돌아간다
				return "forward:/register/add?msg="+msg; // 한번만 실행
			}		
			
			//2. DB에 신규회원 정보를 저장
			return "registerInfo";
		}
		
		private boolean isValid(User user) {
			
			return false;
			//폴스를 해놓으면 이스베일드로 가고 트루로 바꾸면 2번재인 레지스터 인포로 이동된다.
		}
}
