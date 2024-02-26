package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilProgram3 {
	@RequestMapping("/YoilProgram3")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
				
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println(year + "��" + month + "��" + day +"����");
				out.println(dow + "�����Դϴ�.");
				out.println("</html>");
				out.close();

	}

}
