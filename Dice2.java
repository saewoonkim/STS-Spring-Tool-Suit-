package com.dongsung.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dice2 {
	@RequestMapping("/Dice2")
	public static void main(HttpServletResponse response)throws IOException {
		
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/diceimg"+idx1+".jpg'>");
		out.println("<img src='resources/img/diceimg"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
