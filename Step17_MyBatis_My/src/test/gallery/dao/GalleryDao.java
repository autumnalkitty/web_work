package test.gallery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.gallery.dto.GalleryDto;
import test.mybatis.SqlMapConfig;

public class GalleryDao {
	private static GalleryDao dao;
	private static SqlSessionFactory factory;
	private GalleryDao() {}
	public static GalleryDao getInstance() {
		if(dao==null) {
			dao=new GalleryDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//이미지 정보를 삭제하는 메소드
	public boolean delete(int num) {
		SqlSession session=null;
		int flag = 0;
		try {
			session=factory.openSession(true);
			flag = session.delete("gallery.delete", num);
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
	//이미지 하나의 정보를 리턴해주는 메소드
	public GalleryDto getData(int num) {
		SqlSession session=null;
		//select 된 결과를 담을 지역변수 생성
		GalleryDto dto=null;
		try {
			session=factory.openSession();
			dto=session.selectOne("gallery.getData", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	//이미지 정보를 추가하는 메소드
	public boolean insert(GalleryDto dto) {
		SqlSession session=null;
		int flag = 0;
		try {
			session=factory.openSession(true);
			flag = session.insert("gallery.insert", dto);
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
	//이미지 정보 목록을 리턴하는 메소드
	public List<GalleryDto> getList(GalleryDto dto){
		SqlSession session=null;
		//select 된 결과를 담을 지역변수 생성
		List<GalleryDto> list=null;
		try {
			session=factory.openSession();
			list=session.selectList("gallery.getList", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
