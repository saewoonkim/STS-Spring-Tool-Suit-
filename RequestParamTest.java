package com.dongsung.ch02;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamTest {
	
	//컨트롤 + 스페이스 누르면 관련된 어노테이션들이 나온다 예) @re 만치면된다.
	//컨트롤 + 쉬프트 + o 누르면 자동 import 를 도와준다.
	//디폴트값을 안넣어주면 필수입력이 에러 false 
	
	@RequestMapping("/requestParam")
	//필수 입력이 false이기 때문에 에러 발생
	public String main(HttpServletRequest request) {
		String year = request.getParameter("year");
	//http://localhost:8090/ch02/requestParam         ---> year = null
	//http://localhost:8090/ch02/requestParam?year=   ---> year = ""
	//http://localhost:8090/ch02/requestParam?year    ---> year = ""	
		
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		
		return "yoil";
	}
	
	@RequestMapping("/requestParam2")//위에랑 이름이 같으면 충돌이 일어나기 떄문에 이름을 바꿔줘야된다
	//필수 입력이 false
	public String main2(String year) {
	//http://localhost:8090/ch02/requestParam2		  ---> year = null
    //http://localhost:8090/ch02/requestParam2?year   ---> year = ""	
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam3")
	//필수 입력이 true
	//public String main3(@RequestParam(name="year", required=true String year)
	public String main3(@RequestParam String year) {
	//http://localhost:8090/ch02/requestParam3		  ---> 400 Bad Request
	//http://localhost:8090/ch02/requestParam3?year   ---> year = ""			
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam4")
	//필수 입력이 false
	public String main4(@RequestParam(required=false) String year) {
	//http://localhost:8090/ch02/requestParam4		  ---> year = null 404 에러
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
	//http://localhost:8090/ch02/requestParam6	     ---> 500 에러 null 값은 int로 변환 불가
    //http://localhost/ch2/requestParam6?year		 ---> 400 에러 "" 빈문자열은 int로 변환 불가
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam7")
	public String main7(@RequestParam int year) {
	//http://localhost:8090/ch02/requestParam7	     ---> 400 에러
    //http://localhost:8090/ch02/requestParam7?year	 ---> 400 에러
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam8")
	public String main8(@RequestParam(required=false) int year) {
	//http://localhost:8090/ch02/requestParam8	     ---> 400 에러
    //http://localhost:8090/ch02/requestParam8?year	 ---> 400 에러
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestParam9")
	public String main9(@RequestParam(required=true) int year) {
	//http://localhost:8090/ch02/requestParam9	     ---> 400 에러
    //http://localhost:8090/ch02/requestParam9?year	 ---> 400 에러
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
