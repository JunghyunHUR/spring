<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form" method="post">
		<input type="search" name="search" placeholder="검색어를 입력하세요.">
	</form>
	<div id="contents" 
		style="margin-top:40px; 
				width:800px; 
				border:1px soilid #ddd; 
				padding: 30px">
				
		구할 인생을 천자만홍이 얼마나 인생에 그들을 뼈 든 쓸쓸한 봄바람이다. 
		반짝이는 튼튼하며, 구하기 그들의 이것이다. 
		풀이 피는 웅대한 무엇을 영원히 풍부하게 작고 곳으로 있으랴? 
		그들은 방황하였으며, 사랑의 것이다. 
		구하기 그러므로 구할 듣기만 앞이 것이다. 
		이상의 싹이 뜨거운지라, 긴지라 얼마나 봄바람이다. 
		노래하며 얼음 따뜻한 수 뛰노는 찬미를 그들은 가슴이 석가는 것이다.
	</div>
	
	<script src="//code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(function(){
			let search = "${search}";
			if(search){
				$("#contents:contains('"+search+"')").each(function(){
					let regex = new RegExp(search, "gi");
					$(this).html($(this).text()
							.replace(regex, "<span style='color:red;font-weight:bold;'>"+search+"</span>"))
				});
			}
		})
	</script>
</body>
</html>