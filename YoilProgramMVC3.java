package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgramMVC3 {
	@RequestMapping("/YoilProgramMVC3")
	public String main(int year, int month, int day, Model model) throws IOException {
				
				//유효성 검사
				if(!Valid(year, month, day)) {
					return "yoilErrorpage";
				}
		
				char dow = getdow(year, month, day);
				
				
				model.addAttribute("year", year); 
				model.addAttribute("month", month);
				model.addAttribute("day", day);
				model.addAttribute("dow", dow);
				
			
				
				return "dow";

	}

	private boolean Valid(int year, int month, int day) {
		if(year==-1 || month==-1 || day==-1)
			return false;
		
		return (1<=month && month <=12) && (1<=day && day<=31);
	}

	private char getdow(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토 ".charAt(dayOfTheWeek);
		
	}

}
