<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">

</head>
<body>
	<div class="container">
		<h1 class="text-center mb-5">MY SPBBS</h1>
		<div calss="row justify-content-center">
			<table  class="bbsList table-hover">
				<thead>
				<colgroup>
					<col width="10%">
					<col>
					<col width="20%">
					<col width="20%">
					<col width="10%">
				</colgroup>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td class="text-center">${dto.num }</td>
							<td class="title">
								<c:forEach begin="1" end="${dto.s_indent }">
									&nbsp;&nbsp; -
								</c:forEach>
								<a href="detail?num=${dto.num }">${dto.title }</a>
							</td>
							<td class="text-center">${dto.uname }</td>
							<td class="text-center">${dto.wdate }</td>
							<td class="text-center">${dto.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="offset-md-3 col-md-6">
				<ul class="pagination justify-content-center">
				
				<c:if test="${pages.prev }">
					<li class="page-item">
						<a href="list${pages.makeQuery(pages.startPage - 1)}" class="page-link">이전</a>
					</li>
				</c:if>
				<c:forEach begin="${pages.startPage }" end="${pages.endPage }" var="idx">
					<c:choose>
						<c:when test="${idx eq param.page}"	>
							<li class="page-item active">
						</c:when>
						<c:when test="${param.page eq null && idx eq 1 }">
							<li class="page-item active">
						</c:when>
						<c:otherwise>
							<li class="page-item">
						</c:otherwise>
					</c:choose>
						<a href="list${pages.makeQuery(idx)}"  class="page-link">${idx }</a>
					</li>
				</c:forEach>
				<c:if test="${pages.next && pages.endPage > 0}">
					<li class="page-item">
						<a href="list${pages.makeQuery(pages.endPage + 1)}" class="page-link">다음</a>
					</li>
				</c:if>
				</ul>
			</div>
			<div class="col-md-3">
				<div class="button-group">
					<a href="write" class="btn btn-primary">글쓰기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>