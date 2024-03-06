<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>read.jsp</h1>
	
	제목 <input type="text" value="${notice.no_title }" disabled="disabled"> <br>
	내용 <textarea disabled="disabled">
			${notice.no_content }
		</textarea> 
	<br>
	<hr>
	<input type="button" value="수정하기">
	<input type="button" value="삭제하기">
	<input type="button" value="목록가기">
	
</body>
</html>