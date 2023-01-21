<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringFramework Home</title>
<link rel="stylesheet" href="./resources/bootstrap5.1.3/css/bootstrap.css" />
<script src="./resources/bootstrap5.1.3/js/bootstrap.bundle.js"></script>
<script src="./static/jquery/jquery-3.6.0.js"></script>
<script>
$(function(){
	//alert("jQuery실행 잘됨??");
});
</script>
</head>
<body>
<div class="container">
	<h2>Spring Framework Home</h2>


	<!--  
	Spring MVC에서는 이미지와 같은 정적리소스를 사용하기 위해 별도의 resources폴더를
	제공한다. 해당 폴더의 매핑은 servlet-context.xml에서 변경하거나 추가할수있다. 
	-->
	<h3>정적리소스 사용을 위한 resources 디렉토리</h3>
	<!--  
	views폴더 하위에 있는 이미지는 출력되지 않는다. views폴더는 View파일, 즉 jsp만 
	추가할 수 있다. 
	-->
	<img src="./img_avatar1.png" alt="엑박뜸" />
	<!--  
	폴더의 원본명은 resources이나 개발자가 별도로 별칭을 부여할 수 있으므로 
	아래 2개의 이미지는 정상적으로 출력된다. 
	-->
	<img src="./resources/images/2.png" alt="징징이" />
	<img src="./static/images/3.png" alt="뚱뚱이" />

	<hr />

	<!-- 1.컨트롤러 제작을 위해 제일 먼저 요청명을 결정한다. 
	컨트롤러는 servlet-context.xml에 context:component-scan
	으로 지정된 패키지에 만드는걸 기본으로 한다. 
	 -->
	<h3>첫번째 컨트롤러 만들기</h3>
	<li>
		<a href="./home/helloSpring" target="_blank">첫번째 컨트롤러</a>
	</li>
	
	<hr />
	
	<!-- 컨트롤러 : FormController.java -->	
	<h3>form값 처리하기</h3>
	<!-- 요청명뒤에 쿼리스트링으로 파라미터를 전달한다.  -->
	<li>
		<a href="./form/servletRequest?id=korea&pw=1234"
			target="_blank">
			HttpServletRequest로 폼값받기	
		</a>
	</li>
	<li>
		<a href="./form/requestParam.do?id=korea&pw=1234&name=홍길동&email=hong@gildong.com" target="_blank">
			@requestParam 어노테이션으로 폼값받기
		</a>
	</li>
	<li>
		<a href="./form/commandObject.do?id=korea&pw=1234&name=홍길동&email=hong@gildong.com" target="_blank">
			커맨드(Command)객체로 한번에 폼값받기
		</a>
	</li>
	<li>
		<a href="./form/modelAttribute.do?id=korea&pw=1234&name=홍길동&email=hong@gildong.com" target="_blank">
			@ModelAttribute 사용하기
		</a>
	</li>
	<li>
		<a href="./form/gildong99/코리아" target="_blank">
			pathVariable 어노테이션으로 폼값받기
		</a>
	</li>
	
	<hr />	
	
	<!-- 컨트롤러 : RequestMappingController.java -->
	<h3>@RequestMapping 어노테이션 활용</h3>
	<li>
		<a href="./requestMapping/index.do" target="_blank">
			requestMapping시작페이지 바로가기
		</a>
	</li>

	<hr />	
		
	<!-- 컨트롤러 : ValidateController.java -->
	<h3>폼 데이터 검증하기 - Validator</h3>
	<li>
		<a href="validate/memberRegist.do" target="_blank">
			회원가입 바로가기
		</a>
	</li>
		
	<hr />

	<!-- 컨트롤러 : DIController.java -->
	<h3>DI(Dependency Injection) : 의존성주입</h3>
	<li>
		<a href="di/mydi1.do" target="_blank">
			XML설정파일을 통한 빈 생성1(생성자와 setter)
		</a>
	</li>
	<li>
		<a href="di/mydi2.do" target="_blank">
			XML설정파일을 통한 빈 생성2(다양한 멤버변수)
		</a>
	</li>
	<li>
		<a href="di/mydi3.do" target="_blank">
			어노테이션을 통한 빈 생성
		</a>
	</li>
	
	<hr />
	
	<!-- 컨트롤러 : EnvironmentController -->
	<h3>Environment 객체를 이용한 외부파일 참조하기</h3>
	<li>
		<a href="environment/main1.do" target="_blank">
			외부파일 참조하기1(Environment객체 사용)
		</a>
	</li>
	<li>
		<a href="environment/main2.do" target="_blank">
			외부파일 참조하기2(XML 설정파일 사용)
		</a>
	</li>
	<li>
		<a href="environment/main3.do" target="_blank">
			외부파일 참조하기3(어노테이션 사용)
		</a>
	</li>
	
	<hr />
	
	<h3>파일업로드</h3>
	<li>
		<a href="./fileUpload/uploadPath.do" target="_blank">
			upload폴더의 물리적 경로 확인하기
		</a>
	</li>
	<li>
		<a href="./fileUpload/uploadForm.do" target="_blank">
			파일업로드 폼
		</a>
	</li>
	<li>
		<a href="./fileUpload/uploadList.do" target="_blank">
			파일목록보기
		</a>
	</li>
	
	<hr />
	
	<h3>@Controller, @Service, @Repository 어노테이션</h3>
	<h4>Auto scan으로 자동으로 생성되는 빈</h4>
	<li>
		<a href="./service/myService.do" target="_blank">
			myService 바로가기
		</a>
	</li>	
	<li>
		<!-- resources 폴더에는 html파일을 생성한 후 직접 실행할 수 있다. -->
		<a href="./resources/lottoForm.html" target="_blank">
			Lotto 바로가기
		</a>
	</li>
	
	<hr />

	<h3>HTML / JSP 파일 사용하기</h3>
	<!--  
	HTML파일은 webapp하위에서는 사용할 수 없다. 
	resources 폴더 하위에서만 사용할 수 있다. 
	-->
	<li>
		<!-- webapp하위에 생성된 HTML파일을 실행하면 404에러가 발생한다.  -->
		<a href="./notFound.html" target="_blank">html 파일 사용X</a>
		&nbsp;&nbsp;&nbsp;
		<!-- HTML파일은 정적리소스이므로 resources 하위에서만 사용할 수 있다. -->
		<a href="./resources/found.html" target="_blank">html 파일 사용O</a>
		&nbsp;&nbsp;&nbsp;
		<a href="./static/found.html" target="_blank">별칭 사용할 수 있음</a>
	</li>
	<li>
		<!-- webapp하위에서 JSP 파일은 사용할 수 있다. JSP이므로 스크립트렛이나
		클래스 임포트 등의 모든 기능이 구현가능하다. -->
		<a href="./randomNum.jsp" target="_blank">jsp 파일 사용하기</a>
	</li>
	<li>
		<a href="./htmlJspUsed/includeUse.do" target="_blank">
			요청명 방식에서 파일 인클루드 하기</a>
	</li>
	
	<hr />	
		
	<h2>AOP(Aspect Oriented Programming)</h2>
	<li>
		<a href="./aop/main1.do" target="_blank">바로가기1</a>
	</li>
	<li>
		<a href="./aop/main2.do" target="_blank">바로가기2</a>
	</li>
</div>	
</body>
</html>