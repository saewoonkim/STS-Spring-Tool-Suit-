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
	 * @GetMapping("/register/add") //get��� ����Ʈ ��� ����� public String register() {
	 * return "registerForm"; }
	 */
	
	/* ����Ʈ ������� �ٲٸ� �ּ�â�� ���������� �־ �ٲ�ų� �������Ѵ�*/
//  @RequestMapping(value="/register/save", method=RequestMethod.POST)
	/*
	 * @PostMapping(value="/register/save") public String save() { return
	 * "registerInfo"; }
	 */
		@PostMapping(value="/register/save")
		public String save(User user, Model m) throws Exception {
			
			//1. ��ȿ�� �˻�
			
			if(!isValid(user)) {
				//URL ���ڴ��� ������ ���� ���ο� �������� ������ ����ߵȴ�.���ڵ��Ѱ� ���ڴ��� Ǯ��������� �۵��ȴ�.
				String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.","utf-8");
				//return "redirect:/register/add?msg="+msg; �ٽ� �������� ���ư���
				return "forward:/register/add?msg="+msg; // �ѹ��� ����
			}		
			
			//2. DB�� �ű�ȸ�� ������ ����
			return "registerInfo";
		}
		
		private boolean isValid(User user) {
			
			return false;
			//������ �س����� �̽����ϵ�� ���� Ʈ��� �ٲٸ� 2������ �������� ������ �̵��ȴ�.
		}
}
