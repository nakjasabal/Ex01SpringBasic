package com.kosmo.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import env.BoardVO;
import env.EnvApplicationConfig;
import env.ConnectionVO;

@Controller
public class EnvironmentController {
 
	@RequestMapping("/environment/main1.do")
	public String main1(Model model) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();

		String adminIdStr = "";
		String adminPwStr = "";
		try {
			String envPath = "classpath:EnvAdmin.properties";
			propertySources.addLast(new ResourcePropertySource(envPath));
			adminIdStr = env.getProperty("admin.id");
			adminPwStr = env.getProperty("admin.pw");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("adminID", adminIdStr);
		model.addAttribute("adminPW", adminPwStr);

		return "05Environment/main1";
	}
	
	/*
	 * 외부파일참조 2
	 * 
	 * Environment 객체를 사용하지 않고 XML파일에 프로퍼티 파일을
	 * 명시한 후 직접 생성하여 빈을 설정하는 방법
	 */
	@RequestMapping("/environment/main2.do")
	public String main2(Model model){
		
		AbstractApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:AbsAppContext.xml");
		
		ConnectionVO connectionVO = 
				ctx.getBean("connectionVO", ConnectionVO.class);
		
		String userId = connectionVO.getuserId();
		String userPw = connectionVO.getuserPw();
		
		model.addAttribute("userId", userId);
		model.addAttribute("userPw", userPw);
		
		return "05Environment/main2";
	}
	
	
	 

	/*
	 * 외부파일참조3
	 *  : 어노테이션을 이용한 외부파일 참조.
	 *  XML설정파일 대신 EnvApplicationConfig 클래스파일을
	 *  이용하여 외부파일참조 및 빈 생성을 한다. 
	 */
	@RequestMapping("/environment/main3.do")
	public String main3(Model model){
		
		AnnotationConfigApplicationContext ctx = new
			AnnotationConfigApplicationContext(EnvApplicationConfig.class);
		
		BoardVO boardVO = ctx.getBean("boardVOFunc", BoardVO.class);
		
		model.addAttribute("pageSize", boardVO.getPageSize());
		model.addAttribute("blockSize", boardVO.getBlockSize());
		
		return "05Environment/main3";
	}
}

