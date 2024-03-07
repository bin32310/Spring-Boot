<%@page import="com.example.demo.domain.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.error_text{
	color: RED;
}

</style>
<body>
	<h1>write.jsp</h1>
	
	<form:form action="/notice/write" method="post" modelAttribute="noticeVO" enctype="">
		제목 <form:input path="noTitle" placeholder="제목"/> 
		<form:errors path="noTitle" class="error_text"/> <br><br>
		내용 <form:textarea path="noContent" />
		<form:errors path="noContent" class="error_text"/> <br>
		<br>
		<hr>
		<input type="submit" value="등록하기">
		<input type="button" value="돌아가기" onclick="location.href='/notice/main'">
	</form:form>

</body>
</html>