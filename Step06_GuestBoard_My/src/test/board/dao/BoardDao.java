package test.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.board.dto.BoardDto;
import test.util.DbcpBean;

public class BoardDao {
	private static BoardDao dao;
	private BoardDao() {}
	public static BoardDao getInstance() {
		if(dao==null) {
			dao=new BoardDao();
		}
		return dao;
	}
	//글정보 저장하는 메소드
	public boolean insert(BoardDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DbcpBean().getConn();
			String sql="INSERT INTO board_guest (num, writer, title, content, regdate) "
					+ "VALUES(board_guest_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			flag=pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				//Connection Pool 에 Connection 객체 반납하기
				if(conn!=null) conn.close();
			} catch(Exception e) {}
		}
		if(flag>0) {
			return true;
		} else {
			return false;
		}
	}
	//글목록 리턴하는 메소드
	public List<BoardDto> getList(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardDto> list=new ArrayList<>();
		try {
			conn=new DbcpBean().getConn();
			String sql="SELECT num, writer, title, content, "
					+ "TO_CHAR(regdate, 'YYYY.MM.DD AM HH:MI') AS regdate "
					+ "FROM board_guest ORDER BY num DESC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDto dto=new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {}
		}
		return list;
	}
	//글 하나의 정보를 리턴하는 메소드
	public BoardDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 생성
		BoardDto dto=null;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성
			String sql = "SELECT num, writer, title, content, "
					+ "TO_CHAR(regdate, 'YYYY.MM.DD AM HH:MI') AS regdate "
					+ "FROM board_guest WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 내용 추출
			while(rs.next()) {
				dto=new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
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
	//글을 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DbcpBean().getConn();
			String sql="DELETE FROM board_guest WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			flag=pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {}
		}
		if(flag>0) {
			return true;
		} else {
			return false;
		}
	}
	//글정보 수정하는 메소드
	public boolean update(BoardDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성하기
			String sql = "UPDATE board_guest SET writer=?, title=?, content=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용 결정하기 
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
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
}
