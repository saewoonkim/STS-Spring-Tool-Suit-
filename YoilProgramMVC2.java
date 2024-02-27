package com.dongsung.ch02;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgramMVC2 {
	@RequestMapping("/YoilProgramMVC2")
	public String main(int year, int month, int day, Model model) throws IOException {
				//�Է� void �� ��Ʈ������ �ٲ��ָ� ���� ���� Ȱ��ȭ��
				//���������� ����� ���̶�� �־��ش� ������ jsp�� �۵��ҷ��� �����ʿ��ϴ�
				//��Ʈ��+����Ʈ+o ������ �ʿ��� �͵� ����Ʈ�����ش�
				//?year=2021&month=10&day=1
				//�۾�
				
				Calendar cal = Calendar.getInstance();
				cal.set(year, month -1, day);
				
				int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
				char dow = " �Ͽ�ȭ������� ".charAt(dayOfTheWeek);
				
				model.addAttribute("year", year);
				model.addAttribute("month", month);
				model.addAttribute("day", day);
				model.addAttribute("dow", dow);
				//���
				
				return "dow";

	}

}
