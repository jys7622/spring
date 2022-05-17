<%-- <%@page import = "com.webjjang.member.vo.LoginVO" %>
<%@page import ="com.webjjang.member.service.MemberService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 데이터 수집 - 아이디, 비밀번호
// request에는 사용자의 정보, 처리한 데이터가 담겨있다
String id = request.getParameter("id");
String pw = request.getParameter("pw");
 //LoginVO.java에서 생성한 객체를 만들어서 받아서 쓴다
LoginVO inVO = new LoginVO();
 inVO.setId(id);
 inVO.setPw(pw);
 
 System.out.println("login.jsp - inVO: " + inVO);
 
 // db에서 로그인 정보 가져오기. 
 MemberService service = new MemberService();
 LoginVO vo = service.service(inVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="contianer">
	<h2>로그인 폼</h2>
	<form action="Login.do" method ="post">
	<div class ="form-group">
		<label for="id">아이디</label>
		<input name ="id" id="id" class="form-control">
	</div>
	<div class ="form-group">
		<label for="pw">비밀번호</label>
		<input name ="pw" id="pw" class="form-control" type="password">
	</div>
	<button class ="btn btn-default">로그인</button>
	<button class ="btn btn-default" type="button" onclick ="history.back()">취소</button>
	</form>
</div>

</body>
</html> --%>