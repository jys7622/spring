<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 폼</title>
<!-- CDN방식 부트스트랩 적용 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/se2/js/HuskyEZCreator.js"
<script type="text/javascript" src="/resources/se2/js/jindo.min.js" charset="utf-8" ></script>
	charset="utf-8"></script>

<script type="text/javascript">
	$(function() {
		$("#cancelBtn").click(function() {
			history.back();
		});
	});
</script>
</head>

<body>
	<div class="container">
		<h2>게시판 글쓰기 폼</h2>
		<form name ="frm" id ="frm" action="write.do" method="post">
			<div class="form-group">
				<label>제목</label>
				<!-- input 태그의 name이 VO객체의 게터 이름과 맞아야 데이터가 자동으로 저장된다 -->
				<input type="text" name="title" id="title" class="form-control">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea name="content" id="content" rows="10" cols="100"></textarea>
			</div>
			<script type="text/javascript">
			$(document).ready(function(){
				var oEditors = [];
				nhn.husky.EZCreator.createInIFrame({
				oAppRef: oEditors,
				elPlaceHolder: "content",
				sSkinURI: "/resources/se2/SmartEditor2Skin.html",
				fCreator: "createSEditor2",
		        fOnBeforeUnload : function() {
		        	
		            }

				});
				$("#saveBtn").click(function(){
			        //id가 smarteditor인 textarea에 에디터에서 대입
			        oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			        // 이부분에 에디터 validation 검증
			        //폼 submit

			        $("#frm").submit();

			    });
			    var pasteHTML = function(filename){
				    var sHTML = '<img src="${pageContext.request.contextPath}/resources/upload/'+filename+'">';
				    oEditors.getById["content"].exec("PASTE_HTML", [sHTML]);
				};
			});
			</script>
			<div class="form-group">
				<label>작성자</label>
				<!-- input 태그의 name이 게터의 이름과 맞아야 데이터가 자동으로 저장된다 -->
				<input type="text" name="writer" id="writer" class="form-control">
			</div>
			<button id ="saveBtn" type="submit">등록</button>
			<button type="reset">새로입력</button>
			<button type="button" id="cancelBtn">취소</button>
		</form>
	</div>
</body>
</html>