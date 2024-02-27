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
				//입력 void 를 스트링으로 바꿔주면 리턴 도우 활성화됨
				//리스폰스를 지우고 모델이라고 넣어준다 도우라는 jsp가 작동할려면 모델이필요하다
				//컨트롤+쉬프트+o 누르면 필요한 것들 임포트시켜준다
				//?year=2021&month=10&day=1
				//작업
				
				Calendar cal = Calendar.getInstance();
				cal.set(year, month -1, day);
				
				int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
				char dow = " 일월화수목금토 ".charAt(dayOfTheWeek);
				
				model.addAttribute("year", year);
				model.addAttribute("month", month);
				model.addAttribute("day", day);
				model.addAttribute("dow", dow);
				//출력
				
				return "dow";

	}

}
