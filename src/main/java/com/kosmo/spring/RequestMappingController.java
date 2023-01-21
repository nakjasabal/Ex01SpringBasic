package com.kosmo.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.MemberDTO;
import common.StudentDTO;
   
@Controller
public class RequestMappingController {
	
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
	@RequestMapping(value="/requestMapping/getSearch.do", params={"!category"}, method=RequestMethod.GET)
	public String getSearch1(HttpServletRequest req, Model model) {
		/*
		요청 처리를 위한 메서드를 정의할때 해당 메서드에서 사용하고자 하는 
		내장객체가 있다면 매개변수 형태로 선언하면 즉시 사용할 수 있다. 
		즉, 컨트롤러에 정의되는 메서드는 매개변수의 갯수가 큰 의미를 가지지 않는다.
		*/		 
		System.out.println("GET 방식으로 폼값전송");
		
		//request 내장객체를 통해 폼값 받기
		String sColumn = req.getParameter("searchColumn");
		String sWord = req.getParameter("searchWord");
						
		//Model객체에 데이터 저장하기
		model.addAttribute("sColumn", sColumn);
		model.addAttribute("sWord", sWord);
		
		//View경로 반환하기
		return "02RequestMapping/getSearch";		
	}
	@RequestMapping(value="/requestMapping/getSearch.do", params={"!category"}, method=RequestMethod.POST)
	public ModelAndView getSearch2(@RequestParam("searchColumn") String sColumn,
							@RequestParam("searchWord") String sWord) {
		System.out.println("POST 방식으로 폼값전송");
		 
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("sColumn", sColumn);
		mv.addObject("sWord", sWord);
		mv.setViewName("02RequestMapping/getSearch");
		
		return mv;	 
	}

	@RequestMapping(value="/requestMapping/getSearch.do", params={"category=it"}, 
			method=RequestMethod.GET, produces="text/html; charset=utf-8")
	@ResponseBody
	public String getSearch3(HttpServletRequest req) {
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>@RequestMapping 어노테이션</h2>");
		sb.append("getSearch3() 호출됨");
		sb.append("검색어="+req.getParameter("searchWord"));
		sb.append("<br>파라미터="+req.getParameter("category"));
		
		return sb.toString();
	}
	/*
	이 경우 전송방식이 Get이고 category가 it일때만 매핑되므로 
	it가 아닌 다른 카테고리를 선택했을때는 매핑이 되지 않아 400(잘못된요청)에러가 발생한다. 
	따라서 it를 선택한 후 Post전송을 하더라도 에러가 발생될것이다. 
	 */
	
     
	/*
	@ModelAttribute
		: 뷰로 전달되는 커맨드객체의 이름을 변경하고 싶을때 사용한다. 
		StudentDTO를 si로 변경하여 뷰로 전달한다. 
	 */
	@RequestMapping("/requestMapping/modelAttribute.do")
	public String studentInfo(
		@ModelAttribute("dto") MemberDTO memberDTO) {
		
		return "02RequestMapping/modelAttribute";
	}

}







