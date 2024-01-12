package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//입력페이지에서 form 태그를 사용해 사용자 입력값(파일)을 [multipart/form-data] 형태로 전달하면
//HttpServletRequest 객체로 리퀘스트 메세지의 몸체부의 저장된 파일을 읽기 위한 입력스트림
//(ServletInputStream 객체)를 반환받아 전달값과 파일을 구분하여 처리
// => [multipart/form-data] 형태로 전달되는 문자값 및 파일을 처리하기 위한 클래스를 사용하는 것을 권장

//[multipart/form-data] 형태로 전달되는 문자값 및 파일을 처리하기 위한 클래스가 포함된 라이브러리 
//파일을 다운로드 받아 프로젝트에 빌드 처리
//1.Apache 그룹에서 배포한 commons-fileupload 라이브러리의 클래스 사용 - 선택적 파일 업로드
//2.Oreilly 그룹에서 배포한 cos 라이브러리의 클래스 사용 - 무조건 파일 업로드

//Oreilly 그룹에서 배포한 cos 라이브러리 파일을 다운로드 받아 프로젝트에 빌드 처리하는 방법
//1.http://www.servlets.com 사이트 접속 >> COS File Upload Library 메뉴 클릭 >> cos-22.05.zip 다운로드
//2.cos-22.05.zip 파일 압축 풀기 >> cos-22.05 폴더 이동 >> lib 폴더 이동 >> cos.jar 복사
//3.프로젝트 >> src/main/webapp >> WEB-INF >> lib >> cos.jar 붙여넣기
// => /WEB-INF/lib 폴더에 라이브러리 파일(jar 파일)을 붙여하기 하면 자동으로 프로젝트에 
//라이브러리 파일이 빌드 처리

//입력페이지(fileupload.html)에서 전달된 문자값과 파일의 이름을 HTML 문서로 만들어 클라이언트에게
//전달하여 응답하는 서블릿
// => 사용자로부터 입력받아 전달된 파일은 서버 디렉토리에 저장 - 파일 업로드(File Upload) 
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("fileupload.html");
			return;
		}
		
		/*
		request.setCharacterEncoding("utf-8");

		//[multipart/form-data] 형태로 전달되는 입력값은 HttpServletRequest 객체의 
		//getParameter() 메소드를 호출하여 반환 불가능
		String uploader=request.getParameter("uploader");
		*/
		
		//전달파일이 저장될 서버 디렉토리의 파일 시스템 경로를 반환받아 저장
		// => 이클립스의 작업 디렉토리가 아닌 WAS 프로그램의 사용하는 웹디렉토리의 파일 시스템 경로 반환
		//WAS 프로그램이 실행(Start)될 때 이클립스 작업 디렉토리의 파일을 이용하여 웹디렉토리의
		//자원(Context)으로 변환하여 저장 - 서버 동기화
		// => 작업 디렉토리에 업로드 파일이 없으므로 서버 동기화되면 웹디렉토리의 업로드 파일 소멸
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println("saveDirectory = "+saveDirectory);
		
		//cos 라이브러리의 MultipartRequest 클래스로 객체 생성
		// => MultipartRequest 객체 : [multipart/form-data] 형태로 전달되는 문자값 및 파일을 
		//처리하는 기능을 제공하는 객체
		// => MultipartRequest 객체를 생성하면 모든 전달파일을 자동으로 서버 디렉토리에 저장 - 무조건인 파일 업로드
		// => MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize]
		//[, String encoding][, FileRenamePolicy policy]) 생성자를 이용하여 객체 생성
		// => request : 요청정보가 저장된 HttpServletRequest(ServletRequest) 객체 전달
		// => saveDirectory : 전달파일을 저장할 서버 디렉토리의 파일 시스템 경로 - 업로드 디렉토리
		// => maxPostSize : 전달파일의 용량을 제한하기 위한 크기(Byte) 전달 - 생략시 무제한을 기본값으로 사용
		// => encoding : 전달값을 제공받기 위한 문자형태를 전달 - 생략시 서유럽어를 기본값으로 사용
		// => policy : FileRenamePolicy 객체를 전달 - 생략시 기존 파일 덮어씌우기
		//FileRenamePolicy 객체 : 전달파일의 이름과 같은 이름의 파일이 이미 서버 디렉토리에
		//존재할 경우 전달파일의 이름을 변경하는 기능을 제공하는 객체
		// => FileRenamePolicy 인터페이스를 상속받은 자식클래스를 작성하여 객체 생성
		MultipartRequest mr=new MultipartRequest(request, saveDirectory, 20*1024*1024
				, "utf-8", new DefaultFileRenamePolicy());
		
		//MultipartRequest.getParameter(String name) :  [multipart/form-data] 형태로 전달된
		//문자값을 반환하는 메소드
		String uploader=mr.getParameter("uploader");
		
		//MultipartRequest.getOriginalFileName(String name) : 전달파일의 원본 파일명을 반환하는 메소드
		String fileone=mr.getOriginalFileName("fileone");
		String filetwo=mr.getOriginalFileName("filetwo");
		
		//MultipartRequest.getFilesystemName(String name) : 전달파일이 업로드 처리된 파일명을 반환하는 메소드
		String uploadone=mr.getFilesystemName("fileone");
		String uploadtwo=mr.getFilesystemName("filetwo");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파일 업로드</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+uploader+"</p>");
		out.println("<p>파일-1(원본 파일명) = "+fileone+"</p>");
		out.println("<p>파일-1(업로드 파일명) = "+uploadone+"</p>");
		out.println("<p>파일-2(원본 파일명) = "+filetwo+"</p>");
		out.println("<p>파일-2(업로드 파일명) = "+uploadtwo+"</p>");
		out.println("<hr>");
		out.println("<img src='upload/"+uploadone+"' width='200'>");
		out.println("<img src='upload/"+uploadtwo+"' width='200'>");
		out.println("</body>");
		out.println("</html>");
	}
}
