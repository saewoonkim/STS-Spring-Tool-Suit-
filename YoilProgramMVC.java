package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgramMVC {
	@RequestMapping("/YoilProgramMVC")
	public void main(int year, int month, int day, HttpServletResponse response) throws IOException {
				//입력
				
				
				//작업
				
				Calendar cal = Calendar.getInstance();
				cal.set(year, month -1, day);
				
				int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
				char dow = " 일월화수목금토 ".charAt(dayOfTheWeek);
				
				//출력
				
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println(year + "년" + month + "월" + day +"일은");
				out.println(dow + "요일입니다.");
				out.println("</body>");
				out.println("</html>");
				out.close();

	}

}
