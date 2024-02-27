package com.dongsung.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingTest {
	
	@RequestMapping("/login/hello.do")   //http://localhost/ch02/login/hello.do
	public void test1() {
		System.out.println("urlpattern=/login/hello.do");
	}//
	
	@RequestMapping("/login/*")			//login/hello,   /login/hi,   /lgoin/wow
	public void test2() {
		System.out.println("urlpattern=/login/*");
	}
	
	@RequestMapping("/login/**/tmp/*.do") //login/tmp/hello.do, /login/aaa/tmp/hello.do
	public void test3() {
		System.out.println("urlpattern=/login/**/tmp/*.do");
	}//*���� 1 ���� ���丮 **�����ͻ������ ������ �������丮 
	
	@RequestMapping("/login/??") // login/hi, //login/my
	public void test() {
		System.out.println("urlpattern=/login/??");
	}//?�ϳ��� �ѱ���
	
	@RequestMapping("*.do") // hello.do, /hi.do /login/hi.do
	public void test5() {
		System.out.println("urlpattern=/*.do");
	}//.do �տ� �ƹ��ų� ���� �ȴٴ°���.
	
	@RequestMapping("/*.???") // hello.aaa, /abc.txt
	public void test6() {
		System.out.println("urlpattern=/*.???");
	}
	
}
