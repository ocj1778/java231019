package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewDAO extends JdbcDAO {
	private static ReviewDAO _dao;
	
	private ReviewDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ReviewDAO();		
	}
	
	public static ReviewDAO getDAO() {
		return _dao;
	}
	
	//검색정보(검색대상과 검색단어)를 전달받아 REVIEW 테이블에 저장된 게시글 중 검색대상의 
	//컬럼에 검색단어가 포함된 게시글의 갯수를 검색하여 반환하는 메소드
	// => 검색 기능을 사용하지 않을 경우 REVIEW 테이블에 저장된 모든 게시글의 갯수를 검색하반환
	public int selectTotalReview(String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int totalCount=0;
		try {
			con=getConnection();
			
			//매개변수에 저장된 값을 비교하여 접속된 DBMS 서버에 다른 SQL 명령을 전달하여 실행
			// => 동적 SQL(Dynamic SQL)
			if(keyword.equals("")) {//검색 기능을 사용하지 않은 경우
				String sql="select count(*) from review";
				pstmt=con.prepareStatement(sql);
			} else {//검색 기능을 사용한 경우
				String sql="select count(*) from review join member on review_member=member_num"
						+ " where "+search+" like '%'||?||'%' and review_status<>0";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectReviewSearchCount() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return totalCount;
	}
}
















