package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass03 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		//Spring bean 컨테이너로부터 객체의 참조값 2번 얻어내기
		Weapon w1=(Weapon)context.getBean("myWeapon");
		Weapon w2=(Weapon)context.getBean("myWeapon");
		//Spring 이 관리하는 객체는 single ton 객체
		if(w1==w2) {
			//여러번 getBean() 해도 같은 객체의 참조값
			System.out.println("w1 과 w2 는 같아요.");
		} else {
			System.out.println("w1 과 w2 는 달라요.");
		}
	}
}
