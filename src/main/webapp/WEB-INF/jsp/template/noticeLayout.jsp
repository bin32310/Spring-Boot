<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


	<!-- header 부분 -->
	<header>
		<tiles:insertAttribute name="header"/>
	</header>

	
	<!-- contents 부분 -->
	<tiles:insertAttribute name="contents"/>
	
	
	<!-- footer 부분 -->
	<footer>
		<tiles:insertAttribute name="footer"/>
	</footer> 
