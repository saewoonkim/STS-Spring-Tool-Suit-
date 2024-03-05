package com.dongsung.ch02;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@InitBinder
	public void setDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService"+conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class,  new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator());
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList="+validatorList);
	}
	
	
  @RequestMapping(value="/register/add", method={RequestMethod.GET,RequestMethod.POST})
	public String register() {
		return "registerForm";
	}

//  @RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping(value="/register/save")
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result="+result);
		System.out.println("user="+user);
		
		// ���� ����
		
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user,result);
		
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		//1. ��ȿ�� �˻�
//		
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.","utf-8");
//			return "forward:/register/add?msg="+msg;
//		}
		
		//2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
		
	}

	private boolean isValid(User user) {
	
		return true;
	}

}
