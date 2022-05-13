<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<!-- CDN방식 부트스트랩 적용 -->
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

  <style type="text/css">
	  .dataRow:hover {
		  background: #eee;
		  cursor: pointer;
	  }
  </style>
  <script>
	  $(function(){
		  $(".dataRow").click(function(){
			  //this = 현재 이벤트가 발생한 곳에서.find 찾아라(".no") 클래스명이 no인것을
		
			  var no = $(this).find(".no").text();
			  location = "view.do?no=" + no + "&inc=1";
			  })
	  })

  </script>
</head>
<body>
<div class ="container">
<h2>게시판 리스트</h2>
<table class="table">
 <tr>
  	<th>번호</th>
  	<th>제목</th>
  	<th>작성자</th>
  	<th>작성일</th>
  	<th>조회수</th>
 </tr>
 <c:forEach items="${list }" var="vo">
 	<tr class ="dataRow">
 		<td class="no">${vo.no }</td>
 		<td>${vo.title }</td>
 		<td>${vo.writer }</td>
 		<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"/></td>
 		<td>${vo.hit }</td>
 	</tr>
 </c:forEach>
 <tr>
	 <td colsapn="5">
		 <a href="write.do" class="btn btn-default">쓰기</a>
	 </td>
 </tr>
</table>
</div>
</body>
</html>