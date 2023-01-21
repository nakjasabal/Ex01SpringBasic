<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">	
	<h2>@RequestMapping의 속성들</h2>
	<script>
	$(function(){
		let f = document.searchFrm;
		$('input[type=button]').click(function(){			
			if(!f.searchWord.value){
				alert('검색어를 입력하세요');
				f.searchWord.focus();
				return;
			}
			else{
				if($(this).attr('id')=='btnGet'){
					console.log("난 GET");
					$('#searchFrm').attr('method','get').submit();
				}
				else if($(this).attr('id')=='btnPost'){
					console.log("난 POST");				
					$('#searchFrm').attr('method','post').submit();
				}
			}
		});
	});
	</script>
	<form action="../requestMapping/getSearch.do" name="searchFrm" id="searchFrm" >	
		<select name="searchColumn">
			<option value="title">제목</option>
			<option value="name">작성자</option>
			<option value="content">내용</option>
		</select>		
		<input type="text" name="searchWord" />
		
		<input type="checkbox" name="category" value="it" />IT		
		<input type="checkbox" name="category" value="pol" />정치
		<input type="checkbox" name="category" value="eco" />경제		
		<input type="checkbox" name="category" value="ent" />연예
		<br />		
		<input type="button" value="get검색" id="btnGet" />
		<input type="button" value="post검색" id="btnPost" />
	</form>
</div>
</body>
</html>



















