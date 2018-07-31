package test.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.gallery.dto.GalleryDto;
import test.util.DbcpBean;

public class GalleryDao {
	private static GalleryDao dao;
	private GalleryDao() {}
	public static GalleryDao getInstance() {
		if(dao==null) {
			dao=new GalleryDao();
		}
		return dao;
	}
	//이미지 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성하기
			String sql = "DELETE FROM board_gallery WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용 결정하기
			pstmt.setInt(1, num);
			flag = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//이미지 하나의 정보를 리턴해주는 메소드
	public GalleryDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 생성
		GalleryDto dto=null;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성
			String sql = "SELECT writer, caption, imagePath, regdate FROM board_gallery WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 내용 추출
			if (rs.next()) {
				dto=new GalleryDto();
				dto.setNum(num);
				dto.setWriter(rs.getString("writer"));
				dto.setCaption(rs.getString("caption"));
				dto.setImagePath(rs.getString("imagePath"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	//이미지 정보를 추가하는 메소드
	public boolean insert(GalleryDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성하기
			String sql = "INSERT INTO board_gallery (num, writer, caption, imagePath, regdate) "
					+ "VALUES(board_gallery_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용 결정하기
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getCaption());
			pstmt.setString(3, dto.getImagePath());
			flag = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	//이미지 정보 목록을 리턴하는 메소드
	public List<GalleryDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 생성
		List<GalleryDto> list=new ArrayList<>();
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성
			String sql = "SELECT num, writer, caption, imagePath, regdate "
					+ "FROM board_gallery ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 내용 추출
			while (rs.next()) {
				GalleryDto dto=new GalleryDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setCaption(rs.getString("caption"));
				dto.setImagePath(rs.getString("imagePath"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
}
