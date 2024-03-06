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
<body>
	<h1>write.jsp</h1>
	
	<form:form action="/notice/write" >
		제목 <input type="text" value="" > <br>
		내용 <textarea></textarea> 
		<br>
		<hr>
		<input type="submit" value="등록하기">
		<input type="button" value="돌아가기">
	</form:form>
	
	

	
	<form:form commandName="user" >
    	아이디 : <form:input path="userId" value="" />
	</form:form>
	

</body>
</html>