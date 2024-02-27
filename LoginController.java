package com.dongsung.ch02;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception {
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		//1. id�� pwd Ȯ��
		if(!loginCheck(id,pwd)) {
		//2. ��ġ���� ������, loginForm���� �̵�.
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�","utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		
		//   id�� pwd�� ��ġ�ϸ�
		//   2-1 ��Ű�� ����
		
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
		//   2-2 ���信 ����
			response.addCookie(cookie);
		//   2-3 Ȩ���� �̵�
		}else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);//��ȿ���� �� 0���� ���� (�����϶�¸���)
			response.addCookie(cookie);
		}
		
		return "redirect:/";
		
		}
	

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
