package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dice {
	@RequestMapping("/Dice")
	public void main(HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/diceimg1.jpg'>");
		out.println("<img src='resources/img/diceimg2.jpg'>");
		out.println("<img src='resources/img/diceimg3.jpg'>");
		out.println("<img src='resources/img/diceimg4.jpg'>");
		out.println("<img src='resources/img/diceimg5.jpg'>");
		out.println("<img src='resources/img/diceimg6.jpg'>");
		out.println("</body>");
		out.println("</html>");
	}
}
