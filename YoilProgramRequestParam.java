package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgramRequestParam {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilErrorpage";
	}
	
	//http://localhost:8090/ch02/YoilProgramRequestParam?year=2021&month=10&day=1	
	@RequestMapping("/YoilProgramRequestParam")
	//1.RequestParam 추가
	public String main(@ModelAttribute MyDate date, Model model) throws IOException {

		
////public String main(MyDate date, Model model) throws IOException {	
	
//	public String main(@RequestParam(required=true) int year, @RequestParam(required=true) int month,
//			@RequestParam(required=true) int day, Model model) throws IOException {
				
				//유효성 검사
//				if(!Valid(year, month, day)) 
				if(!isValid(date))		{
					return "yoilErrorpage";
				}
				
				
				char dow = getDow(date);
				
				
////				model.addAttribute("MyDate", date);
////				model.addAttribute("Dow", dow);
	
		
//				char dow = getdow(year, month, day);
//				
//				
//				model.addAttribute("year", year);
//				model.addAttribute("month", month);
//				model.addAttribute("day", day);
//				model.addAttribute("dow", dow);
//				
			
				
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

////	private char getDow(MyDate date) {
////		return getDow(date.getYear(), date.getMonth(), date.getDay());
////		
////	}


////	private boolean Valid(int year, int month, int day) {
////		if(year==-1 || month==-1 || day==-1)
////			return true;
////		//트루로 바꿔줌
////		
////		return (1<=month && month <=12) && (1<=day && day<=31);
////	}

	private char getDow(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토 ".charAt(dayOfTheWeek);
		
	}

}
