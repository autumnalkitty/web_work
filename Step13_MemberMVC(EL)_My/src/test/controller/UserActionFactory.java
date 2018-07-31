package test.controller;

import test.action.HomeAction;
import test.member.action.MemberDeleteAction;
import test.member.action.MemberInsertAction;
import test.member.action.MemberInsertformAction;
import test.member.action.MemberListAction;
import test.member.action.MemberUpdateAction;
import test.member.action.MemberUpdateformAction;

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
		} else if(command.equals("/member/list")) {
			action=new MemberListAction();
		} else if(command.equals("/member/insertform")) {
			action=new MemberInsertformAction();
		} else if(command.equals("/member/insert")) {
			action=new MemberInsertAction();
		} else if(command.equals("/member/delete")) {
			action=new MemberDeleteAction();
		} else if(command.equals("/member/updateform")) {
			action=new MemberUpdateformAction();
		} else if(command.equals("/member/update")) {
			action=new MemberUpdateAction();
		}
 		return action;
	}
}
