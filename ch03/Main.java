//package com.dongsung.ch03;
//
//import java.io.FileReader;
//import java.util.Properties;
//
//class Car{}
//class SprotsCar extends Car{}
//class Truck extends Car{}
//class Engine{}
//
//public class Main {
//	public static void main(String[] args) throws Exception {
//		
//		Car car = (Car)getObject("car");
//		Engine engine = (Engine)getObject("engine");
//		System.out.println("car= " +car);
//		System.out.println("engine="+engine);
//	}
//	
//	private static Object getObject(String key) throws Exception {
//		Properties p = new Properties();
//		p.load(new FileReader("config.txt"));
//		Class clazz = Class.forName(p.getProperty(key));
//		return clazz.newInstance();
//	}
//
//
//	private static Car getCar() throws Exception {
//		Properties p = new Properties();
//		p.load(new FileReader("config.txt"));
//		Class clazz = Class.forName(p.getProperty("car"));
//		return (Car)clazz.newInstance();
//	}
//
//}
