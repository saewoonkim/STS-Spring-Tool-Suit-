package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
	public class dateProgram {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilErrorpage";
	}
		@RequestMapping("/dateProgram")
		public String main(@ModelAttribute MyDate date, Model model) throws IOException {
			if(!isValid(date))		{
				return "yoilErrorpage";
			}
			
			
			char dow = getDow(date);
			return "dow2";
		
		
		}



		private boolean isValid(MyDate date) {
			
			return isValid(date.getYear(), date.getMonth(), date.getDay());
			
			
		}



		private boolean isValid(int year, int month, int day) {
			if(year==-1 || month==-1 || day==-1)
				return true;
			
			return (1<=month && month <=12) && (1<=day && day<=31);
		}


		private @ModelAttribute("Dow") char getDow(MyDate date) {
			return getDow(date.getYear(), date.getMonth(), date.getDay());
			
		}
		
		
		private char getDow(int year, int month, int day) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month -1, day);
			
			int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
			return " 일월화수목금토 ".charAt(dayOfTheWeek);
			
		}




}
	

	
