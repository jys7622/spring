<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Daum News</title>
</head>
<body>

    <div class="container">
        <div class="row">

            <h1>
                Daum News
            </h1>

            <h2>전체 : ${totalCount} 건</h2>
            <table class="pure-table pure-table-bordered">
                <tr>
                    <th>썸네일</th>
                    <th>제목</th>
                    <th>매체</th>
                    <th>등록일</th>
                    <th>편집보기</tn>
                    <th>기사원문<th>
                </tr>
                <c:forEach var="vo" items="${list}">
                <tr>
                    <td>
                        <img src="${vo.thumbnail}" alt="${vo.title_name}" width="70"/>
                    </td>
                    <td><a href="/news/form/${vo.id}">${vo.title_name}</a></td>
                    <td>${vo.newspaper}</td>
                    <td>${vo.reg_date}</td>
                    <td>
                        <a href="/popup/news/view/${vo.id}" target="_blank">앱뷰</a>
                    </td>
                    <td>
                        <a href="${vo.link}" target="_blank">원문보기</a>
                    </td>
                </tr>
                </c:forEach>
            </table>

            <tags:pagination cpage="${param.pageIndex}" pageSize="10" groupSize="${pageVO.groupSize}" totalCount="${totalCount}"/>

            <div style="margin:0 auto; width: 500px; margin-top: 50px;">
                <input type="button" name="btn_newform" value="신규작성">
            </div>


        </div>
    </div>

<link href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/blog/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
$(document).ready(function(){
    $('[name="btn_newform"]').on('click', function(){
        location.href = '/news/form';
    });

});

function goPage(cpage) {
    location.href='/news/news.do?page='+cpage;
}
</script>
</body>
</html>
