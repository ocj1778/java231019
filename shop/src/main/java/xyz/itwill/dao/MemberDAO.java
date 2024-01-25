package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xyz.itwill.dto.MemberDTO;

public class MemberDAO extends JdbcDAO {
	private static MemberDAO _dao;
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MemberDAO();
	}
	
	public static MemberDAO getDAO() {
		return _dao;
	}
	
	//회원정보를 전달받아 MEMBER 테이블의 행으로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into member values(member_seq.nextval,?,?,?,?,?,?,?,?,sysdate,null,null,1)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getMobile());
			pstmt.setString(6, member.getZipcode());
			pstmt.setString(7, member.getAddress1());
			pstmt.setString(8, member.getAddress2());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	
	//회원정보를 전달받아 MEMBER 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update member set passwd=?,name=?,email=?,mobile=?,zipcode=?"
					+ ",address1=?,address2=?,update_date=sysdate where member_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getMobile());
			pstmt.setString(5, member.getZipcode());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setInt(8, member.getMemberNum());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//회원번호를 전달받아 MEMBER 테이블에 저장된 행의 마지막 로그인 날짜를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateLastLogin(int memberNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update member set last_login=sysdate where member_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, memberNum);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateLastLogin() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	
	//회원번호를 전달받아 MEMBER 테이블에 저장된 단일행을 검색하여 회원정보를 반환하는 메소드
	public MemberDTO selectMemberByNum(int memberNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO member=null;
		try {
			con=getConnection();
			
			String sql="select member_num,id,passwd,name,email,mobile,zipcode,address1,address2"
					+",join_date,update_date,last_login,member_status from member where member_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, memberNum);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new MemberDTO();
				member.setMemberNum(rs.getInt("member_num"));
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setJoinDate(rs.getString("join_date"));
				member.setUpdateDate(rs.getString("update_date"));
				member.setLastLogin(rs.getString("last_login"));
				member.setMemberStatus(rs.getInt("member_status"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberByNum() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return member;
	}
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 단일행을 검색하여 회원정보를 반환하는 메소드
	public MemberDTO selectMemberById(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO member=null;
		try {
			con=getConnection();
			
			String sql="select member_num,id,passwd,name,email,mobile,zipcode,address1,address2"
					+",join_date,update_date,last_login,member_status from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new MemberDTO();
				member.setMemberNum(rs.getInt("member_num"));
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setJoinDate(rs.getString("join_date"));
				member.setUpdateDate(rs.getString("update_date"));
				member.setLastLogin(rs.getString("last_login"));
				member.setMemberStatus(rs.getInt("member_status"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberById() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return member;
	}
	
	/*
	//이름과 이메일을 전달받아 MEMBER 테이블에 저장된 단일행의 아이디를 검색하여 문자열로 반환하는 메소드
	public String selectMemberId(String name, String email) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String id=null;
		try {
			con=getConnection();
			
			String sql="select id from member where name=? and email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				id=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberById() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return id;
	}
	*/

	//회원정보(이름과 이메일)을 전달받아 MEMBER 테이블에 저장된 단일행의 아이디를 검색하여 
	//문자열로 반환하는 메소드
	public String selectMemberId(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String id=null;
		try {
			con=getConnection();
			
			String sql="select id from member where name=? and email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				id=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectMemberById() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return id;
	}
}
