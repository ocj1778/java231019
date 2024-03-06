package xyz.itwill.dto;

//MYCOMMENT 테이블과 MYUSER 테이블에 저장된 행을 1:1 관계로 결합하여 검색 결과값을 저장하기 
//위한 클래스 - 검색행의 컬럼명과 다른 이름으로 필드명 작성 : 수동 매핑 처리
public class MyComment3 {
	//MYCOMMENT 테이블의 컬럼값을 저장하기 위한 필드
	private int no;
	private String id;
	private String content;
	private String date;
	
	//MYUSER 테이블의 컬럼값을 저장하기 위한 필드
	private String name;
	
	public MyComment3() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
