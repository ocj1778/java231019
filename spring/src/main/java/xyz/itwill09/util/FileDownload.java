package xyz.itwill09.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드 기능을 제공하기 위한 클래스
// => BeanNameViewResovler 객체에 의해 실행되는 클래스
// => Spring Bean Configuration File(servlet-context.xml)에 Spring Bean으로 등록
//BeanNameViewResovler 객체에 의해 실행되는 클래스는 반드시 AbstractView 클래스를 상속받아 작성
// => renderMergedOutputModel() 메소드를 오버라이드 선언하여 응답 처리에 필요한 명령 작성
public class FileDownload extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//요청 처리 메소드에서 제공된 속성값(다운로드 관련 정보)을 객체로 반환받아 저장
		String uploadDirectory=(String)model.get("vDirectory");
		String uploadFilename=(String)model.get("uploadFilename");
		
		//서버 디렉토리에 저장된 업로드 파일에 대한 File 객체 생성
		File file=new File(uploadDirectory, uploadFilename);
		
		//파일로 응답 처리되도록 클라이언트에게 응답할 파일형식(MimeType) 설정
		response.setContentType("application/download; utf-8");
	
		//클라이언트에게 응답할 파일크기 설정
		response.setContentLengthLong(file.length());
		
		//클라이언트에 저장될 파일명 설정
		// => 파일의 이름에 한글이 존재할 경우 부호화 처리하여 응답 처리
		String originalFilename=URLEncoder.encode(uploadFilename.substring(36), "utf-8");
		response.setHeader("Content-Disposition", "attachement;filename=\""
				+originalFilename+"\";");
		
		//파일을 클라이언트에게 전달하기 위한 출력스트림을 반환받아 저장
		OutputStream out=response.getOutputStream();
		
		//서버 디렉토리에 저장된 업로드 파일의 내용을 읽기 위한 입력스트림을 생성하여 저장
		InputStream in=new FileInputStream(file);
		
		//FileCopyUtils.copy(InputStream in, OutputStream out) : 입력스트림으로 원시데이타를
		//읽어 출력스트림으로 전달하는 메소드 - 복사		
		FileCopyUtils.copy(in, out);
		
		in.close();
	}

}









