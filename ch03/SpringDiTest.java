//package com.dongsung.ch03;
//
//import java.util.Arrays;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//
//
//
////@Component 
//class Engine{}   // <bean id="engine" class="com.dongsung.ch03.Engine"/>
//@Component class SuperEngine extends Engine{}
//@Component class TruboEngine extends Engine{}
//@Component class Door{}
//@Component
//class Car{
//@Value("red")String color;
//@Value("100")int oil;
//
////@Autowired	
////@Qualifier("superEngine")
//@Resource(name="superEngine")
//Engine engine;
//@Autowired	Door[] doors;
//	
//	public Car() {}
//	
//	public Car(String color, int oil, Engine engine, Door[] doors) {
//		super();
//		this.color = color;
//		this.oil = oil;
//		this.engine = engine;
//		this.doors = doors;
//	}
//	
//	public void setColor(String color) {
//		this.color = color;
//	}
//	public void setOil(int oil) {
//		this.oil = oil;
//	}
//	public void setEngine(Engine engine) {
//		this.engine = engine;
//	}
//	public void setDoors(Door[] doors) {
//		this.doors = doors;
//	}
//	@Override
//	public String toString() {
//		return "Car [color=" + color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors) + "]";
//	}
//	
//
//}
//
//
//
//public class SpringDiTest {
//	public static void main(String[] args) {
//		
//		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//		
//		Car car = (Car) ac.getBean("car"); //byName
//
//		
//		
////		car.setColor("red");
////		car.setOil(100);
////		car.setEngine(engine);
////		car.setDoors(new Door[] {ac.getBean("door", Door.class), (Door)ac.getBean("door")});
//		
//		
//		System.out.println("car=" + car);
////		System.out.println("engine=" + engine);
////		System.out.println("car2=" + car2);
////		System.out.println("engine=" + engine);
////		System.out.println("door=" + door);
//		
//	}	
//}
