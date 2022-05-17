<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type ="text/css">
th, td{
	border: 1px solid #444;
}	

#loginBtnTd{
	text-align: right;
}

</style>
</head>
<body>
<h2 style= "text-align: center;">로그인</h2>
<!--테이블 안의 데이터를 넘기겠다 form  -->
<!--get방식은 넘긴 데이터의 값이 url에 표시된다. 따라서 post방식으로 사용  -->
<form action="login.jsp" method="post">
<table>
	<tr>
		<th>아이디</th>
		<!--맨 앞자리는 영어문자로 시작해야함, 그뒤로 3글자~19자(앞의 영어문자1자리 포함 4~20자리까지 
		쓸 수 있음으로 설정 -->
		<!--required는 필수입력 , pattern은 정규표현식 검색(영숫자, 영문자 구분 -->
		<td><input name = "id" placeholder="아이디 입력" required="required"
		pattern="\a\w{3,19}" maxlength="20"> 
		</td> 
	</tr>
	<tr>
		<th>비밀번호</th>
		<!--비밀번호는 어떤 문자든 사용가능  -->
		<td><input name = "pw" placeholder="비밀번호 입력" required="required"
		pattern=".{4,20}" maxlength="20" type="password"> 
		</td> 
	</tr>
	<tr>
		<td colspan="2" id ="loginBtnTd">
			<button>로그인</button>
		</td> 
	</tr>
	
	
</table>
</form>
</body>
</html>