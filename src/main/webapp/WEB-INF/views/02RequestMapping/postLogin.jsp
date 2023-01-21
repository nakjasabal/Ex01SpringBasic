<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/Ex01SpringBasic/static/bootstrap5.1.3/css/bootstrap.css" />
<script src="/Ex01SpringBasic/resources/jquery/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">

	<h2>@RequestMapping 어노테이션</h2>
	
	<h3>POST 방식으로 전송된 로그인 파라미터</h3>
	
	<ul>
		<li>아이디 : ${id }</li>
		<li>패스워드 : ${pw }</li>
	</ul>
</div>
</body>
</html>