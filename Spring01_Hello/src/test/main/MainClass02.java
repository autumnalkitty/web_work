package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		/*
		필요한 ㄱ객체를 직접 new 하지 않고 
		Spring bean 컨테이너에서 필요한 객체를 얻어와서
		인터페이스 type 으로 사용하기
		(느슨한 의존관계)
		*/
		Weapon w1=(Weapon)context.getBean("myWeapon");
		w1.attack();
	}
}
