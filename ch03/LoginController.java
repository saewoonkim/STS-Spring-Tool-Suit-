package com.dongsung.ch03;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {

		//1. ���� ����
		session.invalidate();
		//2. Ȩ���� �̵�
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//1. id�� pwd Ȯ��
		if(!loginCheck(id,pwd)) {
		//2. ��ġ���� ������, loginForm���� �̵�.
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�","utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		
		
		//3-1. id�� pwd�� ��ġ�ϸ�,
		
		HttpSession session = request.getSession();
		
		//3-2. ���� ��ü�� id�� ����.
		
		session.setAttribute("id", id);
		
		
		
		//   id�� pwd�� ��ġ�ϸ�
		//   2-1 ��Ű�� ����
		
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
		//   2-2 ���信 ����
			response.addCookie(cookie);
		//   2-3 Ȩ���� �̵�
		}else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:" + toURL;
		
		}
	

	private boolean loginCheck(String id, String pwd) {
		User user = userDao.selectUser(id);
		
		
		if(user==null) return false;
		
		return user.getPwd().equals(pwd);
	}
}
