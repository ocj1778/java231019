package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.UserinfoDTO;

public class UserinfoModelOneDAO extends JdbcDAO {
	private static UserinfoModelOneDAO _dao;
	
	private UserinfoModelOneDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new UserinfoModelOneDAO();
	}
	
	public static UserinfoModelOneDAO getDAO() {
		return _dao;
	}
	
	//회원정보를 전달받아 USERINFO 테이블의 행으로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertUserinfo(UserinfoDTO userinfo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into userinfo values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getUserid());			
			pstmt.setString(2, userinfo.getPassword());			
			pstmt.setString(3, userinfo.getName());			
			pstmt.setString(4, userinfo.getEmail());			
			pstmt.setInt(5, userinfo.getStatus());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertUserinfo() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateUserinfo(UserinfoDTO userinfo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update userinfo set password=?,name=?,email=?,status=? where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getPassword());			
			pstmt.setString(2, userinfo.getName());			
			pstmt.setString(3, userinfo.getEmail());			
			pstmt.setInt(4, userinfo.getStatus());
			pstmt.setString(5, userinfo.getUserid());			
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateUserinfo() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteUserinfo(String userid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);			
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteUserinfo() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//아이디를 전달받아 USERINFO 테이블에 저장된 행을 검색하여 학생정보를 반환하는 메소드
	public UserinfoDTO selectUserinfo(String userid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserinfoDTO userinfo=null;
		try {
			con=getConnection();
			
			String sql="select userid,password,name,email,status from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectUserinfo() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return userinfo;
	}
	
	//USERINFO 테이블에 저장된 모든 행을 검색하여 학생목록을 반환하는 메소드
	public  List<UserinfoDTO> selectUserinfoList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<UserinfoDTO> userinfoList=new ArrayList<UserinfoDTO>();
		try {
			con=getConnection();
			
			String sql="select userid,password,name,email,status from userinfo order by userid";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				UserinfoDTO userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setStatus(rs.getInt("status"));
				
				userinfoList.add(userinfo);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectUserinfoList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return userinfoList;
	}
}
