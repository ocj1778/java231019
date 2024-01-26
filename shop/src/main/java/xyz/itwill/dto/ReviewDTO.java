package xyz.itwill.dto;

/*
create table review(review_num number primary key, review_member number constraint review_member_fk 
    references member(member_num), review_subject varchar2(500), review_content varchar2(4000) 
    , review_image varchar2(100), review_register date, review_update date, review_readcount number
    , review_ref number, review_restep number, review_relevel number, review_ip varchar2(20), review_status number(1));
	    
create sequence review_seq; 
*/

/*
이름              널?       유형             
--------------- -------- -------------- 
REVIEW_NUM      NOT NULL NUMBER         - 글번호 : 시퀸스의 다음값         
REVIEW_MEMBER            NUMBER         - 작성자 : 로그인 사용자의 회원번호
REVIEW_SUBJECT           VARCHAR2(500)  - 제목 : 사용자 입력값  
REVIEW_CONTENT           VARCHAR2(4000) - 내용 : 사용자 입력값 
REVIEW_IMAGE             VARCHAR2(100)  - 이미지 파일의 경로 : 사용자 입력값
REVIEW_REGISTER          DATE           - 작성날짜 : 시스템의 현재 날짜와 시간
REVIEW_UPDATE            DATE           - 변경날짜 : 시스템의 현재 날짜와 시간
REVIEW_READCOUNT         NUMBER         - 조회수 : 0 >> 게시글 조회 누적수
REVIEW_REF               NUMBER         - 답글의 그룹번호  
REVIEW_RESTEP            NUMBER         - 답글의 글순서
REVIEW_RELEVEL           NUMBER         - 답글의 글깊이
REVIEW_IP                VARCHAR2(20)   - 클라이언트 IP 주소 
REVIEW_STATUS            NUMBER(1)      - 글상태 : 0(삭제글), 1(일반글), 2(비밀글)
*/

//REVIEW 테이블의 컬럼값과 MEMBER 테이블의 컬럼값을 저장하기 위한 DTO 클래스
public class ReviewDTO {
	private int reviewNum;
	private int reviewMember;
	private String reviewName;//MEMBER 테이블의 회원이름(NAME 컬럼)을 저장하기 위한 필드 - 작성자이름
	private String reviewSubject;
	private String reviewContent;
	private String reviewImage;
	private String reviewRegister;
	private String reviewUpdate;
	private int reviewReadcount;
	private int reviewRef;
	private int reviewRestep;
	private int reviewRelevel;
	private String reviewIp;
	private int reviewStatus;
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public int getReviewMember() {
		return reviewMember;
	}

	public void setReviewMember(int reviewMember) {
		this.reviewMember = reviewMember;
	}

	public String getReviewName() {
		return reviewName;
	}

	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}

	public String getReviewSubject() {
		return reviewSubject;
	}

	public void setReviewSubject(String reviewSubject) {
		this.reviewSubject = reviewSubject;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}

	public String getReviewRegister() {
		return reviewRegister;
	}

	public void setReviewRegister(String reviewRegister) {
		this.reviewRegister = reviewRegister;
	}

	public String getReviewUpdate() {
		return reviewUpdate;
	}

	public void setReviewUpdate(String reviewUpdate) {
		this.reviewUpdate = reviewUpdate;
	}

	public int getReviewReadcount() {
		return reviewReadcount;
	}

	public void setReviewReadcount(int reviewReadcount) {
		this.reviewReadcount = reviewReadcount;
	}

	public int getReviewRef() {
		return reviewRef;
	}

	public void setReviewRef(int reviewRef) {
		this.reviewRef = reviewRef;
	}

	public int getReviewRestep() {
		return reviewRestep;
	}

	public void setReviewRestep(int reviewRestep) {
		this.reviewRestep = reviewRestep;
	}

	public int getReviewRelevel() {
		return reviewRelevel;
	}

	public void setReviewRelevel(int reviewRelevel) {
		this.reviewRelevel = reviewRelevel;
	}

	public String getReviewIp() {
		return reviewIp;
	}

	public void setReviewIp(String reviewIp) {
		this.reviewIp = reviewIp;
	}

	public int getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
}
