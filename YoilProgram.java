package com.dongsung.ch02;

import java.util.Calendar;

public class YoilProgram {

	public static void main(String[] args) {
		
		//�Է�
		String year = args[0];
		String month = args[1];
		String day = args[2];
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//�۾�
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm -1, dd);
		
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
		char dow = " �Ͽ�ȭ������� ".charAt(dayOfTheWeek);
		
		//���
		
		System.out.println(year + "��" + month + "��" + day + "����");
		System.out.println(dow + "�����Դϴ�.");


	}

}
