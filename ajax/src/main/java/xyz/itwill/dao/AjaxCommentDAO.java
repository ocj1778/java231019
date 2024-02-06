package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.AjaxCommentDTO;

public class AjaxCommentDAO extends JdbcDAO {
	private static AjaxCommentDAO _dao;
	
	private AjaxCommentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new AjaxCommentDAO();
	}
	
	public static AjaxCommentDAO getDAO() {
		return _dao;
	}
	
	//댓글정보를 전달받아 AJAX_COMMENT 테이블에 행으로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertAjaxComment(AjaxCommentDTO ajaxComment) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into ajax_comment values(ajax_comment_seq.nextval,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxComment.getWriter());
			pstmt.setString(2, ajaxComment.getContent());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertAjaxComment() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//댓글정보를 전달받아 AJAX_COMMENT 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateAjaxComment(AjaxCommentDTO ajaxComment) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update ajax_comment set writer=?,content=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxComment.getWriter());
			pstmt.setString(2, ajaxComment.getContent());
			pstmt.setInt(3, ajaxComment.getNum());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateAjaxComment() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//댓글번호를 전달받아 AJAX_COMMENT 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteAjaxComment(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from ajax_comment where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteAjaxComment() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//댓글번호를 전달받아 AJAX_COMMENT 테이블에 저장된 행을 검색하여 댓글정보를 반환하는 메소드
	public AjaxCommentDTO selectAjaxComment(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		AjaxCommentDTO ajaxComment=null;
		try {
			con=getConnection();
			
			String sql="select num,writer,content,regdate from ajax_comment where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();

			if(rs.next()) {
				ajaxComment=new AjaxCommentDTO();
				ajaxComment.setNum(rs.getInt("num"));
				ajaxComment.setWriter(rs.getString("writer"));
				ajaxComment.setContent(rs.getString("content"));
				ajaxComment.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAjaxComment() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return ajaxComment;
	}
	
	//AJAX_COMMENT 테이블에 저장된 행을 검색하여 댓글목록을 반환하는 메소드
	public List<AjaxCommentDTO> selectAjaxCommentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AjaxCommentDTO> ajaxCommentList=new ArrayList<AjaxCommentDTO>();
		try {
			con=getConnection();
			
			String sql="select num,writer,content,regdate from ajax_comment order by num desc";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();

			while(rs.next()) {
				AjaxCommentDTO ajaxComment=new AjaxCommentDTO();
				ajaxComment.setNum(rs.getInt("num"));
				ajaxComment.setWriter(rs.getString("writer"));
				ajaxComment.setContent(rs.getString("content"));
				ajaxComment.setRegdate(rs.getString("regdate"));
				ajaxCommentList.add(ajaxComment);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAjaxCommentList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return ajaxCommentList;
	}
}
