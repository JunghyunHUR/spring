<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색어힌트</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>
<script>
   $(function(){
	  
	   $("#hint").autocomplete({
		      source: "AvailableTags",
		      minLength : 1
	   });
   });
</script>
</head>
<body>
   <form name="form" method="post" action="showHint.jsp">
      <label for="hint">검색어 :</label>
      <input id="hint" name="search" placeholder="검색어를 입력하세요..." />
      <br>
      <br>
      <button type="submit" class="ui-widget"> 검 색 </button>
   </form>
</body>
</html>