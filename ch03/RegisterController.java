package com.dongsung.ch03;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	UserDao userDao;
	
	final int FAIL = 0;
	
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
		
		//DB에 신규회원 정보 저장.
		if(result.hasErrors()) {
			int rowCnt = userDao.insertUser(user);
			
			if(rowCnt!=FAIL) {
				return "registerInfo";
				
			}
		}
		return "registerForm";
	}
		

	private boolean isValid(User user) {
	
		return true;
	}

}
