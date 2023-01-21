<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Ex01SpringBasic/static/bootstrap5.1.3/css/bootstrap.css" />
<script src="/Ex01SpringBasic/resources/jquery/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">
	<h2>Form값 받기</h2>	
	<h3>HttpServletRequest로 폼값 받기</h3>	
	<ul>
		<li>아이디 : ${id }</li>
		<li>패스워드 : ${pw }</li>
		<li>메세지 : ${message }</li>
	</ul>
</div>
</body>
</html>