package test.friends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.friends.dto.FriendsDto;
import test.util.DBConnect;

public class FriendsDao {
	private static FriendsDao dao;
	private FriendsDao() {}
	public static FriendsDao getInstance() {
		if(dao==null) {
			dao=new FriendsDao();
		}
		return dao;
	}
	//친구 목록을 불러오는 메소드
	public List<FriendsDto>getList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<FriendsDto> list=new ArrayList<>();
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT num, name, phone FROM friends ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				FriendsDto dto=new FriendsDto(num, name, phone);
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
	//친구정보를 저장하는 메소드
	public boolean insert(FriendsDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		//영향을 받은 row 의 개수를 저장할 지역 변수
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="INSERT INTO friends (num, name, phone) VALUES(FRIENDS_SEQ.NEXTVAL, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
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
	//친구 한 명의 정보를 읽어오는 메소드
	public FriendsDto getData(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		FriendsDto dto=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name, phone FROM friends WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new FriendsDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {}
		}
		return dto;
	}
	//친구 한 명의 정보를 수정하는 메소드
	public boolean update(FriendsDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE friends SET name=?, phone=? WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setInt(3, dto.getNum());
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
		}else {
			return false;
		}
	}
	//친구정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="DELETE FROM friends WHERE num=?";
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
}
