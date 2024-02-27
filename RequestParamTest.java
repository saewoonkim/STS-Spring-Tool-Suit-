package com.dongsung.ch02;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamTest {
	
	//��Ʈ�� + �����̽� ������ ���õ� ������̼ǵ��� ���´� ��) @re ��ġ��ȴ�.
	//��Ʈ�� + ����Ʈ + o ������ �ڵ� import �� �����ش�.
	//����Ʈ���� �ȳ־��ָ� �ʼ��Է��� ���� false 
	
	@RequestMapping("/requestParam")
	//�ʼ� �Է��� false�̱� ������ ���� �߻�
	public String main(HttpServletRequest request) {
		String year = request.getParameter("year");
	//http://localhost:8090/ch02/requestParam         ---> year = null
	//http://localhost:8090/ch02/requestParam?year=   ---> year = ""
	//http://localhost:8090/ch02/requestParam?year    ---> year = ""	
		
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		
		return "yoil";
	}
	
	@RequestMapping("/requestParam2")//������ �̸��� ������ �浹�� �Ͼ�� ������ �̸��� �ٲ���ߵȴ�
	//�ʼ� �Է��� false
	public String main2(String year) {
	//http://localhost:8090/ch02/requestParam2		  ---> year = null
    //http://localhost:8090/ch02/requestParam2?year   ---> year = ""	
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam3")
	//�ʼ� �Է��� true
	//public String main3(@RequestParam(name="year", required=true String year)
	public String main3(@RequestParam String year) {
	//http://localhost:8090/ch02/requestParam3		  ---> 400 Bad Request
	//http://localhost:8090/ch02/requestParam3?year   ---> year = ""			
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam4")
	//�ʼ� �Է��� false
	public String main4(@RequestParam(required=false) String year) {
	//http://localhost:8090/ch02/requestParam4		  ---> year = null 404 ����
	//http://localhost:8090/ch02/requestParam4?year   ---> year = ""		
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam5")
	public String main5(@RequestParam(required=false, defaultValue="1") String year){
	//http://localhost:8090/ch02/requestParam5		  ---> year = 1
	//http://localhost:8090/ch02/requestParam5?year   ---> year = 1
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam6")
	public String main6(int year) {
	//http://localhost:8090/ch02/requestParam6	     ---> 500 ���� null ���� int�� ��ȯ �Ұ�
    //http://localhost/ch2/requestParam6?year		 ---> 400 ���� "" ���ڿ��� int�� ��ȯ �Ұ�
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam7")
	public String main7(@RequestParam int year) {
	//http://localhost:8090/ch02/requestParam7	     ---> 400 ����
    //http://localhost:8090/ch02/requestParam7?year	 ---> 400 ����
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam8")
	public String main8(@RequestParam(required=false) int year) {
	//http://localhost:8090/ch02/requestParam8	     ---> 400 ����
    //http://localhost:8090/ch02/requestParam8?year	 ---> 400 ����
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam9")
	public String main9(@RequestParam(required=true) int year) {
	//http://localhost:8090/ch02/requestParam9	     ---> 400 ����
    //http://localhost:8090/ch02/requestParam9?year	 ---> 400 ����
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam10")
	public String main10(@RequestParam(required=true, defaultValue="1") int year) {
	//http://localhost:8090/ch02/requestParam10	     ---> year=1
    //http://localhost:8090/ch02/requestParam10?year ---> year=1
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam11")
	public String main11(@RequestParam(required=false, defaultValue="1") int year) {
	//http://localhost:8090/ch02/requestParam10	     ---> year=1
    //http://localhost:8090/ch02/requestParam10?year ---> year=1
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
}
