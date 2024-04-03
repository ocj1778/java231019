package xyz.itwill09.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

//클라이언트로부터 파일을 전달받아 서버 디렉토리애 업로드 처리하기 위한 방법
//1.commons-fileupload 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.Spring Bean Configuration File(servlet-context.xml)에 파일 업로드 처리 기능을 제공하는 
//클래스를 Spring Bean으로 등록
//3.MultipartHttpServletRequest 객체를 사용하여 [multipart/form-data] 형태로 전달된 값 또는 
//파일을 제공받아 처리

@Controller
@RequestMapping("/file")
public class FileController {
	@RequestMapping(value = "/upload1", method = RequestMethod.GET)
	public String uploadOne() {
		return "file/form_one";
	}
	
	//요청 처리 메소드에 MultipartHttpServletRequest 인터페이스로 매개변수를 작성하면 Front
	//Controller로부터 MultipartHttpServletRequest 객체를 제공받아 사용 
	// => MultipartHttpServletRequest 객체 : [multipart/form-data] 형태로 전달된 값 또는 파일을
	//저장하여 처리하기 위한 객체
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(MultipartHttpServletRequest request) throws IOException {
		//MultipartHttpServletRequest.getParameter(String name) : 전달값을 String 객체로 반환하는 메소드
		String uploaderName=request.getParameter("uploaderName");
		
		//MultipartHttpServletRequest.getFile(String name) : 전달파일을 MultipartFile 객체로 반환하는 메소드
		// => MultipartFile 객체 : 사용자로부터 입력받아 전달된 파일정보를 저장하기 위한 객체
		MultipartFile uploaderFile=request.getFile("uploaderFile");
	
		//전달파일에 대한 검증 작업 관련 명령 작성
		//MultipartFile.isEmpty() : MultipartFile 객체에 파일정보가 저장되어 있는 경우 [false]를
		//반환하고 파일정보가 저장되어 있지 않은 경우 [true]를 반환하는 메소드
		if(uploaderFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//MultipartFile.getContentType() : MultipartFile 객체에 저장된 전달파일의 파일형태
		//(MimeType)를 반환하는 메소드
		System.out.println("파일 형태 = "+uploaderFile.getContentType());
		//MultipartFile.getBytes() : MultipartFile 객체에 저장된 전달파일의 내용을 byte 배열
		//(원시데이타)로 반환하는 메소드
		System.out.println("파일 크기 = "+uploaderFile.getBytes().length+"Byte");
		
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirectory=request.getServletContext().getRealPath("/resources/images/upload");
		System.out.println("uploadDirectory = "+uploadDirectory);
		
		//MultipartFile.getOriginalFilename() : MultipartFile 객체에 저장된 전달파일의 이름을
		//반환하는 메소드
		String uploadFilename=uploaderFile.getOriginalFilename();
		
		//업로드 처리될 파일에 대한 정보가 저장된 File 객체 생성 
		File file=new File(uploadDirectory, uploadFilename);
		
		//MultipartFile.transferTo(File file) : MultipartFile 객체에 저장된 전달파일을 File
		//객체의 저장된 정보의 파일로 저장되도록 업로드 처리하는 메소드
		uploaderFile.transferTo(file);
		
		request.setAttribute("uploaderName", uploaderName);
		request.setAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success_one";
	}
}











