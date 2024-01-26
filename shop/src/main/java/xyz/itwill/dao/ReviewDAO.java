package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.ReviewDTO;

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
				//게시글 작성자의 이름을 검색하기 위해 REVIEW 테이블과 MEMBER 테이블의 행을 결합하여 검색
				String sql="select count(*) from review join member on review_member=member_num"
						+ " where "+search+" like '%'||?||'%' and review_status=1";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectTotalReview() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return totalCount;
	}
	
	//페이징 처리 관련 정보(시작 행번호와 종료 행번호)와 게시글 검색 기능 관련 정보(검색대상과
	//검색단어)를 전달받아 REVIEW 테이블에 저장된 행을 검색하여 게시글 목록을 반환하는 메소드
	public List<ReviewDTO> selectReviewList(int startRow, int endRow, String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ReviewDTO> reviewList=new ArrayList<ReviewDTO>();
		try {
			con=getConnection();
			
			if(keyword.equals("")) {//검색 기능을 사용하지 않은 경우
				String sql="select * from (select rownum rn, temp.* from (select review_num"
					+ ", review_member, name, review_subject, review_content, review_image"
					+ ", review_register, review_update, review_readcount, review_ref, review_restep"
					+ ", review_level, review_ip, review_status from review join member"
					+ " on review_member=member_num order by ref desc, restep) temp)"
					+ " where rn between ? and ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			} else {//검색 기능을 사용한 경우
				String sql="select * from (select rownum rn, temp.* from (select review_num"
					+ ", review_member, name, review_subject, review_content, review_image"
					+ ", review_register, review_update, review_readcount, review_ref, review_restep"
					+ ", review_level, review_ip, review_status from review join member"
					+ " on review_member=member_num where "+search+" like '%'||?||'%'"
					+ " and review_status=1 order by ref desc, restep) temp)"
					+ " where rn between ? and ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewDTO review=new ReviewDTO();
				review.setReviewNum(rs.getInt("review_num"));
				review.setReviewMember(rs.getInt("review_member"));
				review.setReviewName(rs.getString("name"));
				review.setReviewSubject(rs.getString("review_subject"));
				review.setReviewContent(rs.getString("review_content"));
				review.setReviewImage(rs.getString("review_image"));
				review.setReviewRegister(rs.getString("review_register"));
				review.setReviewUpdate(rs.getString("review_update"));
				review.setReviewReadcount(rs.getInt("review_readcount"));
				review.setReviewRef(rs.getInt("review_ref"));
				review.setReviewRestep(rs.getInt("review_restep"));
				review.setReviewRelevel(rs.getInt("review_relevel"));
				review.setReviewIp(rs.getString("review_ip"));
				review.setReviewStatus(rs.getInt("review_status"));
				
				reviewList.add(review);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectReviewList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return reviewList;
	}
}



















