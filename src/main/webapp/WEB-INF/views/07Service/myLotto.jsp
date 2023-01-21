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
	<h1>로또 결과</h1>
	<hr>
	<ul>
		<li>사용자:${lottoVO.userLottoNum }</li>
		<li>시스템:${lottoVO.randomLottoNum }</li>
	</ul>
	<h2>${lottoVO.result }</h2>	
	<hr>
	<a href="../resources/lottoForm.html">재시도.....</a>
</div>	
</body>
</html>