package com.dongsung.ch02;

import java.util.Calendar;

public class YoilProgram {

	public static void main(String[] args) {
		
		//입력
		String year = args[0];
		String month = args[1];
		String day = args[2];
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//작업
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm -1, dd);
		
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
		char dow = " 일월화수목금토 ".charAt(dayOfTheWeek);
		
		//출력
		
		System.out.println(year + "년" + month + "월" + day + "일은");
		System.out.println(dow + "요일입니다.");


	}

}
