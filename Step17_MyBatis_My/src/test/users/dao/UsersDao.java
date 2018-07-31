package test.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.users.dto.UsersDto;

public class UsersDao {
	private static UsersDao dao;
	private static SqlSessionFactory factory;
	private UsersDao() {}
	//UsersDao 객체의 참조값을 리턴해주는 static 메소드
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//회원정보를 추가하는 메소드
	public boolean insert(UsersDto dto ) {
		SqlSession session=null;
		int flag = 0;
		try {
			session=factory.openSession(true);
			flag=session.insert("users.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//회원정보 일치여부를 확인하는 메소드
	public boolean isValid(UsersDto dto) {
		SqlSession session=null;
		String result=null;
		try {
			session=factory.openSession();
			result=session.selectOne("users.isValid", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(result==null) {
			return false;
		} else {
			return true;
		}
	}
	//회원 한 명의 정보를 리턴하는 메소드
	public UsersDto getData(String id) {
		SqlSession session=null;
		UsersDto dto=null;
		try {
			session=factory.openSession();
			dto=session.selectOne("users.getData", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	//회원정보를 삭제하는 메소드
	public boolean delete(String id) {
		SqlSession session=null;
		int flag = 0;
		try {
			session=factory.openSession(true);
			flag=session.delete("users.delete", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//회원정보를 수정하는 메소드
	public boolean update(UsersDto dto) {
		SqlSession session=null;
		int flag = 0;
		try {
			session=factory.openSession(true);
			flag=session.update("users.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//인자로 전달되는 아이디의 사용가능 여부를 리턴해주는 메소드
	public boolean canUseId(String inputId) {
		SqlSession session=null;
		String result=null;
		try {
			session=factory.openSession();
			result=session.selectOne("users.isExist", inputId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(result==null) {
			return true;
		} else {
			return false;
		}
	}
}
