package test.controller;

import test.action.HomeAction;
import test.users.action.UsersCheckidAction;
import test.users.action.UsersDeleteAction;
import test.users.action.UsersInfoAction;
import test.users.action.UsersSigninAction;
import test.users.action.UsersSigninformAction;
import test.users.action.UsersSignoutAction;
import test.users.action.UsersSignupAction;
import test.users.action.UsersSignupformAction;
import test.users.action.UsersUpdateAction;
import test.users.action.UsersUpdateformAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory() {}
	//자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance() {
		if(factory==null){
			factory=new UserActionFactory();
		}
		return factory;
	}
	//인자로 전달되는 command 를 수행할 Action type 객체를 리턴해주는 메소드
	public Action action(String command) {
		//Action 추상클래스 type 을 담을 지역변수 만들기 
		Action action=null;
		if(command.equals("/home")) {
			action=new HomeAction();
		} else if(command.equals("/users/signupform")) {
			action=new UsersSignupformAction();
		} else if(command.equals("/users/checkid")) {
			action=new UsersCheckidAction();
		} else if(command.equals("/users/signup")) {
			action=new UsersSignupAction();
		} else if(command.equals("/users/signinform")) {
			action=new UsersSigninformAction();
		} else if(command.equals("/users/signin")) {
			action=new UsersSigninAction();
		} else if(command.equals("/users/signout")) { 
			action=new UsersSignoutAction();
		} else if(command.equals("/users/private/info")) {
			action=new UsersInfoAction();
		} else if(command.equals("/users/private/updateform")) {
			action=new UsersUpdateformAction();
		} else if(command.equals("/users/private/update")) {
			action=new UsersUpdateAction();
		} else if(command.equals("/users/private/delete")) {
			action=new UsersDeleteAction();
		}
 		return action;
	}
}
