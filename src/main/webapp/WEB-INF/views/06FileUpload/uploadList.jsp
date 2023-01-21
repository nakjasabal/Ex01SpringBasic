<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

	<h2>upload폴더의 파일목록 보기</h2>
	<!--  
	Map컬렉션은 Key로 파일명, Value로 파일크기를 저장하였다. 
	-->
	<ul>	
	<c:forEach items="${fileMap }" var="file" varStatus="vs">		
		<li>
			파일명 : ${file.key }
			&nbsp;&nbsp;
			파일크기 : ${file.value }Kb
			&nbsp;&nbsp;
			<!--  
			fileName : 서버에 저장된 파일명
			oriFileName : 원본 파일명
			※다운로드시 원본파일명으로 변경하려면 기존파일명을 DB에 저장해야 하므로
			여기서는 "임시파일명1.jpg"와 같이 변경해서 다운로드한다.
			-->
			<a href="download.do?fileName=${file.key }&oriFileName=임시파일명${vs.count }.jpg">
				[다운로드]
			</a>
			 
		</li>
	</c:forEach>	
	</ul>
</div>
</body>
</html>