<%@page import="common.LottoCreater"%> 
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>RandomNum</h2>
	<%
	//스크립트렛 내에서 코드 작성이 가능하다. 
	//0~99까지의 난수가 생성된다. 
	Random random = new Random();
	out.println("난수:"+ random.nextInt(100));
	%>    
	
	<h2>Lotto6/45</h2>
	<%
	//클래스도 동일하게 사용할 수 있다. 
	LottoCreater lottoCreater = new LottoCreater();
	int[] lottoNum = lottoCreater.lotto(); 
	for(int lo : lottoNum){
		out.println(lo);
	}
	%>
</body>
</html> 

