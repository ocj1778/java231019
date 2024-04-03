package xyz.itwill09.util;

import lombok.Data;

//페이징 처리 관련 값을 저장하기 위한 클래스
@Data
public class Pager {
	//생성자 매개변수로 초기값을 전달받아 필드에 저장
	private int pageNum;//요청 페이지 번호
	private int totalSize;//전체 게시글의 갯수
	private int pageSize;//하나의 페이지에 출력될 게시글의 갯수
	private int blockSize;//하나의 블럭에 출력될 페이지 번호의 갯수
	
	//생성자 매개변수로 초기화 처리된 필드값을 사용해 계산된 결과값을 필드에 저장
	private int totalPage;//전체 페이지의 갯수
	private int startRow;//요청 페이지에 출력될 게시글의 시작 행번호
	private int endRow;//요청 페이지에 출력될 게시글의 종료 행번호
	private int startPage;//현재 블럭에 출력될 시작 페이지 번호
	private int endPage;//현재 블럭에 출력될 종료 페이지 번호
	private int prevPage;//이전 블럭에 출력될 시작 페이지 번호
	private int nextPage;//다음 블럭에 출력될 시작 페이지 번호
	
	public Pager(int pageNum, int totalSize, int pageSize, int blockSize) {
		this.pageNum = pageNum;
		this.totalSize = totalSize;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		calcPaging();
	}
	
	private void calcPaging() {
		totalPage=(int)Math.ceil((double)totalSize/pageSize);
		if(pageNum <= 0 || pageNum > totalPage) {
			pageNum=1;
		}
		
		startRow=(pageNum-1)*pageSize+1;
		endRow=pageNum*pageSize;
		if(endRow > totalSize) {
			endRow=totalSize;
		}
		
		startPage=(pageNum-1)/blockSize*blockSize+1;
		endPage=startPage+blockSize-1;
		if(endPage > totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-blockSize;
		nextPage=startPage+blockSize;
	}
}












