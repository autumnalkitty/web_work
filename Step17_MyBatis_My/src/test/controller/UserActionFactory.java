package test.controller;

import test.action.HomeAction;
import test.cafe.action.CafeCommentDeleteAction;
import test.cafe.action.CafeCommentInsertAction;
import test.cafe.action.CafeCommentUpdateAction;
import test.cafe.action.CafeDeleteAction;
import test.cafe.action.CafeDetailAction;
import test.cafe.action.CafeInsertAction;
import test.cafe.action.CafeInsertFormAction;
import test.cafe.action.CafeListAction;
import test.cafe.action.CafeUpdateAction;
import test.cafe.action.CafeUpdateformAction;
import test.file.action.FileDeleteAction;
import test.file.action.FileDownloadAction;
import test.file.action.FileListAction;
import test.file.action.FileUploadAction;
import test.file.action.FileUploadFormAction;
import test.gallery.action.GalleryDeleteAction;
import test.gallery.action.GalleryListAction;
import test.gallery.action.GalleryUploadAction;
import test.gallery.action.GalleryUploadFormAction;
import test.member.action.MemberDeleteAction;
import test.member.action.MemberInsertAction;
import test.member.action.MemberInsertformAction;
import test.member.action.MemberListAction;
import test.member.action.MemberUpdateAction;
import test.member.action.MemberUpdateformAction;
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
		} else if(command.equals("/file/list")) {
			action=new FileListAction();
		} else if(command.equals("/file/download")) {
			action=new FileDownloadAction();
		} else if(command.equals("/file/private/upload_form")) {
			action=new FileUploadFormAction();
		} else if(command.equals("/file/private/upload")) {
			action=new FileUploadAction();
		} else if(command.equals("/file/private/delete")) {
			action=new FileDeleteAction();
		} else if(command.equals("/cafe/list")) {
			action=new CafeListAction();
		} else if(command.equals("/cafe/detail")) {
			action=new CafeDetailAction();
		} else if(command.equals("/cafe/private/insertform")) {
			action=new CafeInsertFormAction();
		} else if(command.equals("/cafe/private/insert")) {
			action=new CafeInsertAction();
		} else if(command.equals("/cafe/private/delete")) {
			action=new CafeDeleteAction();
		} else if(command.equals("/cafe/private/updateform")) {
			action=new CafeUpdateformAction();
		} else if(command.equals("/cafe/private/update")) {
			action=new CafeUpdateAction();
		} else if(command.equals("/cafe/private/comment_insert")) {
			action=new CafeCommentInsertAction();
		} else if(command.equals("/cafe/private/comment_delete")) {
			action=new CafeCommentDeleteAction();
		} else if (command.equals("/cafe/private/comment_update")) {
			action=new CafeCommentUpdateAction();
		} else if (command.equals("/gallery/list")) {
			action=new GalleryListAction();
		} else if (command.equals("/gallery/private/uploadform")) {
			action=new GalleryUploadFormAction();
		} else if (command.equals("/gallery/private/upload")) {
			action=new GalleryUploadAction();
		} else if (command.equals("/gallery/private/delete")) {
			action=new GalleryDeleteAction();
		}
 		return action;
	}
}
