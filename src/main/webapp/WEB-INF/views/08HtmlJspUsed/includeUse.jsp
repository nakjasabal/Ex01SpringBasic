<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 파일 인클루드 하기</h2>
	<!--  
	webapp하위에 생성된 jsp 파일을 인클루드 할때에는 아래와 같이 
	루트경로를 사용하면 된다. 
	-->
	<%@include file="/randomNum.jsp"%>
	
	
	<%@include file="/sub/sub.jsp"%>
	
	
	<h2>JSP 파일 링크걸기</h2>
	<!--  
	링크 생성시에도 컨텍스트 루트 경로를 사용하면 된다. 
	-->
	<a href="<%=request.getContextPath()%>/randomNum.jsp">
		RandomNum.jsp 바로가기
	</a>
</body>
</html> 

