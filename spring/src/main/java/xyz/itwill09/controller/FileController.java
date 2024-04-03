package xyz.itwill09.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.FileBoard;
import xyz.itwill09.service.FileBoardService;

//클라이언트로부터 파일을 전달받아 서버 디렉토리애 업로드 처리하기 위한 방법
//1.commons-fileupload 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2.Spring Bean Configuration File(servlet-context.xml)에 파일 업로드 처리 기능을 제공하는 
//클래스를 Spring Bean으로 등록
//3.MultipartHttpServletRequest 객체를 사용하여 [multipart/form-data] 형태로 전달된 값 또는 
//파일을 제공받아 처리

@Controller
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
	//WebApplicationContext 객체(스프링 컨테이너)를 제공받아 필드에 저장되도록 의존성 주입
	private final WebApplicationContext context;
	private final FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload1", method = RequestMethod.GET)
	public String uploadOne() {
		return "file/form_one";
	}
	
	/*
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
	*/
	
	//요청 처리 메소드에 매개변수를 작성하여 전달값 및 전달파일을 제공받아 사용
	// => 전달값 및 전달파일의 이름과 같은 이름으로 매개변수 작성
	//문제점)전달파일의 이름과 같은 이름의 파일이 서버 디렉토리에 있는 경우 기존 파일을 
	//전달파일로 덮어씌워 저장(OverWrite)
	//해결법)전달파일을 서버 디렉토리에 저장하기 전에 파일의 이름이 중복되지 않도록 변경하여
	//업로드 처리
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(@RequestParam String uploaderName
			, @RequestParam MultipartFile uploaderFile, Model model) throws IOException {
		//전달파일에 대한 검증 작업 관련 명령 작성
		if(uploaderFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");

		//UUID.randomUUID() : 36Byte 크기의 문자열이 저장된 UUID 객체를 반환하는 메소드
		// => UUID 객체 : 식별자 정보를 저장하기 위한 객체
		//UUID.toString() : UUID 객체에 저장된 식별자를  문자열로 반환하는 메소드
		String uploadFilename=UUID.randomUUID().toString()+"_"+uploaderFile.getOriginalFilename();
		
		//업로드 처리될 파일에 대한 정보가 저장된 File 객체 생성 
		File file=new File(uploadDirectory, uploadFilename);
		
		//MultipartFile.transferTo(File file) : MultipartFile 객체에 저장된 전달파일을 File
		//객체의 저장된 정보의 파일로 저장되도록 업로드 처리하는 메소드
		uploaderFile.transferTo(file);
		
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success_one";
	}
	
	@RequestMapping(value = "/upload2", method = RequestMethod.GET)
	public String uploadTwo() {
		return "file/form_two";
	}
	
	//전달파일이 여러개인 경우 매개변수를 List 인터페이스로 작성하여 전달파일에 대한
	//MultipartFile 객체가 요소로 저장된 List 객체를 제공받아 사용 
	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public String uploadTwo(@RequestParam String uploaderName
			, @RequestParam List<MultipartFile> uploaderFileList, Model model) throws IOException {
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");
		
		//업로드 처리된 모든 파일의 이름을 저장하기 위한 List 객체 생성
		List<String> filenameList=new ArrayList<String>();
		
		for(MultipartFile multipartFile : uploaderFileList) {
			if(multipartFile.isEmpty() || !multipartFile.getContentType().equals("image/jpeg")) {
				return "file/upload_fail";
			}

			//전달파일을 서버 디렉토리에 저장되도록 업로드 처리
			String uploadFilename=UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
			File file=new File(uploadDirectory, uploadFilename);
			multipartFile.transferTo(file);
			
			//List 객체에 업로드 처리된 파일명을 요소값으로 추가하여 저장
			filenameList.add(uploadFilename);
		}
			
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("filenameList", filenameList);
		
		return "file/upload_success_two";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String fileBoardWrite() {
		return "file/board_write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String fileBoardWrite(@ModelAttribute FileBoard fileBoard
			, @RequestParam MultipartFile multipartFile) throws IOException {
		if(multipartFile.isEmpty()) {
			return "file/board_write";
		}

		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		// => 다운로드 프로그램에서만 파일에 접근 가능하도록 /WEB-INF 폴더에 업로드 폴더 작성
		String uploadDirectory=context.getServletContext().getRealPath("/WEB-INF/upload");

		//업로드 처리될 파일명을 생성하여 FileBoard 객체의 필드값 변경
		fileBoard.setFilename(UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename());

		//전달파일을 서버 디렉토리에 저장되도록 업로드 처리
		multipartFile.transferTo(new File(uploadDirectory, fileBoard.getFilename()));
		
		//전달값과 업로드 처리된 파일명을 FILE_BOARD 테이블의 행으로 삽입 처리
		fileBoardService.addFileBoard(fileBoard);
		
		return "redirect:/file/list";
	}

	@RequestMapping("/list")
	public String fileBoardList(@RequestParam(defaultValue = "1") int pageNum, Model model) {
		Map<String, Object> map=fileBoardService.getFileBoardList(pageNum);
		
		model.addAttribute("pager", map.get("pager"));
		model.addAttribute("fileBoardList", map.get("fileBoardList"));
		
		return "file/board_list";
	}
}











