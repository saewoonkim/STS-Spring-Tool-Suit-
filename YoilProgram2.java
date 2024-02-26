package com.dongsung.ch02;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgram2 {
	@RequestMapping("/YoilProgram2")
	public void main(HttpServletRequest request) {
		
		//입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//작업
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
		char dow = " 일월화수목금토 ".charAt(dayOfTheWeek);
		
		//출력
		
		System.out.println(year + "년" + month + "월" + day + "일은");
		System.out.println(dow + "요일입니다.");

		
	}
}
