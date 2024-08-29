<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
<%
String url = "https://www.du.ac.kr/submenu.do?menuUrl=I9D4yBgHJGlG1TUOf%2fpDHQ%3d%3d&";
String className = "table-type01";
Document doc = Jsoup.connect(url).get();
Elements e = doc.select("."+className);
%>
<a href='#'>게시판 이동</a><br>
<c:if test="${no==0||no==null }">
<a href="loginForm">로그인</a></c:if>

<c:if test="${no!=0&&no!=null }">
<a href="logout">로그아웃</a><br>
<a href="myPage">마이페이지</a></c:if><br>
<%=e %>
</body>
</html>