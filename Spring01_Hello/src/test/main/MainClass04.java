package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		//Spring Bean 컨테이너에서 Car type 객체 얻어오기
		Car c1=context.getBean(Car.class);
		c1.drive();
	}
}
