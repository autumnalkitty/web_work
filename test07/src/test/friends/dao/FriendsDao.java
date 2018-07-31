package test.friends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.friends.dto.FriendsDto;
import test.util.DbcpBean;

public class FriendsDao {
	private static FriendsDao dao;
	private FriendsDao() {}
	public static FriendsDao getInstance() {
		if(dao==null) {
			dao=new FriendsDao();
		}
		return dao;
	}
	public List<FriendsDto> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 생성
		List<FriendsDto> list=new ArrayList<>();
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성
			String sql = "SELECT num, name, phone, regdate FROM friends ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 내용 추출
			while (rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String regdate=rs.getString("regdate");
				FriendsDto dto=new FriendsDto(num, name, phone, regdate);
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
