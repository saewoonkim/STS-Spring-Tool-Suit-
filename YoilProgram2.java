package com.dongsung.ch02;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgram2 {
	@RequestMapping("/YoilProgram2")
	public void main(HttpServletRequest request) {
		
		//�Է�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//�۾�
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
		char dow = " �Ͽ�ȭ������� ".charAt(dayOfTheWeek);
		
		//���
		
		System.out.println(year + "��" + month + "��" + day + "����");
		System.out.println(dow + "�����Դϴ�.");

		
	}
}
