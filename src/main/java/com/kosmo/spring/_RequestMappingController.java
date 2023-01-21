package com.kosmo.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common._StudentDTO;
   
 
public class _RequestMappingController {
	
	//get 혹은 post 방식의 전송을 위한 인덱스 페이지 매핑
	@RequestMapping(value="/requestMapping/index.do")
	public String rmIndex() {		
		return "02RequestMapping/index";
	}
	/**
@RequestMapping(value="/test", params={"p1=spring"})
public String myMethod() {
    p1이 spring이면 호출된다. 
}

@RequestMapping(value="/test", params={"p1!=spring"})
public String myMethod() {
    p1이 spring이 아니면 호출된다. 
}

@RequestMapping(value="/test", params={"p1"})
public String myMethod() {
    파라미터에 p1이 있으면 호출된다. 
}

@RequestMapping(value="/test", params={"!p1"})
public String myMethod() {
    파라미터에 p1이 없으면 호출된다. 
}

	 */
	/*
	단순히 요청명만 매핑하는 경우에는 value, method를 생략할 수 있으나 
	전송방식까지 명시해야하는 경우에는 속성을 제거하면 에러가 발생한다.  
	*/
	@RequestMapping(value="/requestMapping/getSearch.do", method=RequestMethod.GET)
	public String getSearch(HttpServletRequest req,	Model model) {
		/*
		요청 처리를 위한 메서드를 정의할때 해당 메서드에서 사용하고자 하는 
		내장객체가 있다면 매개변수 형태로 선언하면 즉시 사용할 수 있다. 
		즉, 컨트롤러에 정의되는 메서드는 매개변수의 갯수가 큰 의미를 가지지 않는다.
		*/		 
		System.out.println("RequestMethod.GET방식으로 폼값전송");
		
		//request 내장객체를 통해 폼값 받기
		String sColumn = req.getParameter("searchColumn");
		String sWord = req.getParameter("searchWord");
						
		//Model객체에 데이터 저장하기
		model.addAttribute("sColumn", sColumn);
		model.addAttribute("sWord", sWord);
		
		//View경로 반환하기
		return "02RequestMapping/getSearch";		
	}

	
	
	
	
	
	
	//전송방식이 POST인 경우 요청명 매핑
	//파라미터를 어노테이션을 통해 받은 후 변수에 저장
	@RequestMapping(method=RequestMethod.POST, value="/requestMapping/postLogin.do")
	public ModelAndView postLogin(
			@RequestParam("user_id") String id,
			@RequestParam("user_pw") String pw) 
	{		
		/*
		ModelAndView
			: View로 전송할 데이터의 저장과 View의 경로를 반환하는 2가지
			기능을 동시에 처리할 수 있는 클래스
			-View설정 : 참조변수.setViewName("뷰의경로 및 파일명");
			-Model객체에 저장 : 참조변수.addObject("속성명", "속성값");
			최종적으로 뷰를 호출할때는 ModelAndView 참조변수를 반환한다. 
		*/
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("02RequestMapping/postLogin");
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		
		return mv;		
	}
	
     
	/*
	@ModelAttribute
		: 뷰로 전달되는 커맨드객체의 이름을 변경하고 싶을때 사용한다. 
		StudentDTO를 si로 변경하여 뷰로 전달한다. 
	 */
	@RequestMapping("/requestMapping/modelAttribute.do")
	public String studentInfo(
		@ModelAttribute("si") _StudentDTO studentDTO) {
		
		return "02RequestMapping/modelAttribute";
	}

}







