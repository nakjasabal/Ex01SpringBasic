package com.kosmo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlJspUsedController {

	//요청명에 대한 매핑 
	@RequestMapping("/htmlJspUsed/includeUse.do")
	public String includeUse(Model model) {
		
		return "08HtmlJspUsed/includeUse";
	}
}



