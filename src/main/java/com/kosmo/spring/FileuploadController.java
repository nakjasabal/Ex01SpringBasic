package com.kosmo.spring;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileuploadController {
	
	//파일업로드를 위한 디렉토리의 물리적경로 확인하기
	@RequestMapping("/fileUpload/uploadPath.do")
	//request, response 내장객체를 사용하기 위해 매개변수로 선언
	public void uploadPath(HttpServletRequest req, 
			HttpServletResponse resp) throws IOException {
		
		//request 내장객체를 통해 서버의 물리적경로를 얻어옴
		//파일업로드를 위한 디렉토리는 정적파일 저장을 위한 resources하위에 생성한다.
		String path = req.getSession().getServletContext()
				.getRealPath("/resources/upload");
		
		//View호출없이 컨트롤러에서 직접 출력하기 위해 MIME타입을 지정한다. 
		resp.setContentType("text/html; charset=utf-8");
		//PrintWriter 객체 생성 후 경로를 출력한다.
		PrintWriter pw = resp.getWriter();
		pw.print("/upload 디렉토리의 물리적경로 : "+ path);
	}
	
	//파일 업로드 폼 매핑
	@RequestMapping("/fileUpload/uploadForm.do")
	public String uploadForm() {
		return "06FileUpload/uploadForm";
	}

	/*
	UUID(Universally Unique IDentifier)
	: 범용 고유 식별자. randomUUID() 메서드를 통해 문자열을 생성하면 하이픈이 4개
	포함된 32자의 랜덤하고 유니크한 문자열이 생성된다. JDK에서 기본클래스로 제공된다. 
	 */
	public static String getUuid(){
		//생성된 원본 그대로 출력하기. 하이픈이 포함된 문자열임. 
		String uuid = UUID.randomUUID().toString();		
		System.out.println("생성된UUID-1:"+ uuid);
		//하이픈을 제거한 상태로 출력하기.
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된UUID-2:"+ uuid);
		return uuid;
	}
		
	/*
	파일업로드 처리
		: 파일업로드는 post방식으로 전송되므로 매핑시 method, value
		두가지 속성을 모두 기술한다. 
	*/
	@RequestMapping(method=RequestMethod.POST, value="/fileUpload/uploadAction.do")
	//파일업로드를 위한 객체를 매개변수로 선언하여 해당 메서드에서 사용한다. 
	public String uploadAction(Model model, MultipartHttpServletRequest req) {
		
		//파일이 저장될 디렉토리의 물리적 경로를 얻어온다. 
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		//파일 정보 저장을 위한 객체생성. 
		MultipartFile mfile = null;
		//2개이상의 파일정보를 저장하기 위해 List컬렉션 생성함.
		List<Object> resultList = new ArrayList<Object>();			
		
		try {
			//제목 폼값을 얻어온다. 
			String title = req.getParameter("title");
			
			//업로드폼의 file속성의 input상자가 2개이므로 갯수만큼 반복한다. 
			Iterator itr = req.getFileNames();
			while(itr.hasNext()) {
				//서버로 전송된 파일명을 읽어온다. 
				mfile = req.getFile(itr.next().toString());
				//한글깨짐방지 처리 후 전송된 파일명을 가져온다. 
				String originalName = new String(mfile.getOriginalFilename().getBytes(),"UTF-8");
				//서버로 전송된 파일이 없다면 while문의 처음으로 돌아간다. 
				if("".equals(originalName)) continue;
				//파일명에서 확장자를 따낸다. 
				String ext = originalName.substring(originalName.lastIndexOf('.'));
				//UUID를 통해 생성된 문자열과 확장자를 결합해서 저장할 파일명을 생성한다. 
				String saveFileName = getUuid() + ext;
				//물리적경로에 새롭게 생성된 파일명으로 저장한다. 
				mfile.transferTo(new File(path + File.separator + saveFileName));
				
				//폼값과 파일명을 저장할 Map컬렉션을 생성한다. 
				Map<String, String> fileMap = new HashMap<String, String>();	
				//원본 파일명, 서버에 저장된 새로운 파일명, 제목을 저장한다. 
				fileMap.put("originalName", originalName); 
				fileMap.put("saveFileName", saveFileName); 
				fileMap.put("title", title); 
				//하나의 파일정보를 저장한 Map컬렉션을 List컬렉션에 저장한다.(2개의 파일정보)
				resultList.add(fileMap);
			}
		}		 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//필요한 정보를 Model에 저장한 후 View반환
		model.addAttribute("resultList", resultList);	
		return "06FileUpload/uploadAction";
	}
 
	//파일목록보기	
	@RequestMapping("/fileUpload/uploadList.do")
	public String uploadList(HttpServletRequest req, Model model){
		//디렉토리의 물리적 경로 얻어오기
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		//경로를 기반으로 파일객체 생성
		File file = new File(path);
		//파일의 목록을 배열 형태로 얻어온다. 
		File[] fileArray = file.listFiles();
		//View로 전달할 파일목록 저장을 위해 Map컬렉션 생성.(파일명, 파일크기)
		Map<String, Integer> fileMap = new HashMap<String, Integer>();		
		for(File f : fileArray){
			fileMap.put(f.getName(), (int)Math.ceil(f.length()/1024.0));
		}
		//Model객체에 저장 및 View 반환
		model.addAttribute("fileMap", fileMap);				
		return "06FileUpload/uploadList";
	}
	
	//파일 다운로드 처리
	@RequestMapping("/fileUpload/download.do")
	public ModelAndView download(HttpServletRequest req) throws Exception {
		
		//서버에 저장된 파일명
		String fileName = req.getParameter("fileName");
		//원본 파일명
		String oriFileName = req.getParameter("oriFileName");
		//디렉토리의 물리적 경로
		String saveDirectory = req.getSession().getServletContext()
				.getRealPath("/resources/upload");
		//경로와 파일명으로 파일객체 생성
		File downloadFile = new File(saveDirectory+"/"+fileName);
		//해당 경로에 파일이 존재하는지 확인
		if(!downloadFile.canRead()) {
			throw new Exception("파일을 찾을 수 없습니다");
		}		
		
		//다운로드를 위한 Model과 View 처리
		ModelAndView mv = new ModelAndView();
		//다운로드를 위해 미리 생성한 빈으로 View 설정(servlet-context.xml)
		mv.setViewName("fileDownloadView");
		//저장된 파일명과 원본파일명 설정
		mv.addObject("downloadFile", downloadFile);
		mv.addObject("oriFileName", oriFileName); 
		return mv;		
	}
}
