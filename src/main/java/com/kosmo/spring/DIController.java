package com.kosmo.spring; 

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import di.AnnotationBean;
import di.Circle;
import di.Person;

@Controller
public class DIController {

	@RequestMapping("/di/mydi1.do")
	public ModelAndView mydi1(Model model) {
		//Model객체에 속성저장과 View경로를 동시에 설정할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		//XML 설정파일의 위치를 설정한다.(클래스패스는 차후 배포했을때 classes하위로 이동된다.)
		String configLocation = "classpath:my_di1.xml";
		//스프링 컨테이너를 생성한다. 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//컨테이너에 생성된 빈을 getBean() 메서드를 통해 주입(Injection)받는다. 
		Circle circle = ctx.getBean("circle", Circle.class);
		//View의 경로 및 Model객체에 속성 저장 및 반환
		mv.setViewName("04DI/mydi1");
		mv.addObject("circle", circle);		
		return mv;
	}

	
	@RequestMapping("/di/mydi2.do")
	public ModelAndView mydi2(Model model) {
		ModelAndView mv = new ModelAndView();		
		
		//XML설정파일을 기반으로 생성한 스프링 컨테이너를 통해 빈을 주입받는다.
		String configLocation = "classpath:my_di2.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation);
		Person person = ctx.getBean("person", Person.class);
		
		//View설정 및 반환
		mv.setViewName("04DI/mydi2");
		mv.addObject("person", person.getInfo());		
		return mv;
	}

	//어노테이션을 통한 빈생성 및 주입
	@RequestMapping("/di/mydi3.do")
	public ModelAndView mydi3(Model model) {
		ModelAndView mv = new ModelAndView();		
		
		//어노테이션을 통해 생성된 빈을 주입받기 위해 스프링 컨테이너를 생성한다. 
		AnnotationConfigApplicationContext aCtx = 
				new AnnotationConfigApplicationContext(
						AnnotationBean.class
				); 
		//메서명을 통해 생성한 참조변수로 각 빈을 주입받는다. 
		Circle circle1 = aCtx.getBean("circleBean", Circle.class);
		Person person1 = aCtx.getBean("personBean", Person.class);
		
		//Model에 저장한 후 View를 설정한다. 
		mv.setViewName("04DI/mydi3");
		mv.addObject("person", person1.getInfo());
		mv.addObject("circle", circle1);		
		return mv;
	}
}
