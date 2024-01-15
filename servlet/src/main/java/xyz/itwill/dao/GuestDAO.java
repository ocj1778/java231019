package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.GuestDTO;

//GUEST 테이블에 행을 삽입,삭제,변경,검색하기 위한 기능을 제공하는 DAO 클래스
public class GuestDAO extends JdbcDAO {
	private static GuestDAO _dao;
	
	private GuestDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new GuestDAO();
	}
	
	public static GuestDAO getDAO() {
		return _dao;
	}
	
	//게시글(방명록)을 전달받아 GUEST 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertGuest(GuestDTO guest) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into guest values(guest_seq.nextval,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getSubject());
			pstmt.setString(3, guest.getContent());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertGuest() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//게시글(방명록)을 전달받아 GUEST 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드
	public int UpdateGuest(GuestDTO guest) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update guest set writer=?,subject=?,content=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getSubject());
			pstmt.setString(3, guest.getContent());
			pstmt.setInt(4, guest.getNum());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]UpdateGuest() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows; 
	}
	
	//게시글(방명록)의 글번호를 전달받아 GUEST 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteGuest(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from guest where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteGuest() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows; 
	}
	
	//게시글(방명록)의 글번호를 전달받아 GUEST 테이블에 저장된 행을 검색하여 게시글(DTO 객체)를 반환하는 메소드
	public GuestDTO selectGuest(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		GuestDTO guest=null;
		try {
			con=getConnection();
			
			String sql="select num,writer,subject,content,regdate from guest where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				guest=new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("wrtier"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectGuest() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return guest;
	}
	
	//GUEST 테이블에 저장된 모든 행을 검색하여 모든 게시글들(List 객체)을 반환하는 메소드
	public List<GuestDTO> selectGuestList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<GuestDTO> guestList=new ArrayList<GuestDTO>();
		try {
			con=getConnection();
			
			String sql="select num,writer,subject,content,regdate from guest order by num desc";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDTO guest=new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("writer"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));
				
				guestList.add(guest);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectGuest() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return guestList;
	}
}