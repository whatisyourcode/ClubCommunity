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
<a href='#'>게시판 이동</a><br>
<c:if test="${no==0||no==null }">
<a href="loginForm">로그인</a></c:if>

<c:if test="${no!=0&&no!=null }">
<a href="logout">로그아웃</a><br>
<a href="myPage">마이페이지</a></c:if><br>
오늘의 식단
<div>
<c:choose>
<c:when test="${dayIndex == 1 }">화요일</c:when>
<c:when test="${dayIndex == 2 }">수요일</c:when>
<c:when test="${dayIndex == 3 }">목요일</c:when>
<c:when test="${dayIndex == 4 }">금요일</c:when>
<c:otherwise>월요일</c:otherwise>
</c:choose>
<table style="border: 1px solid black;">
		<c:forEach var="food" items="${day}"> 
		<tr>
			<td>
				${food }
			</td>
		</tr>
		</c:forEach>
</table>
<button id="prev" onclick="location.href='main.jsp'">prev</button>
<button id="next" onclick="location.href='main.jsp'">next</button>
</div>
<script src="./main.js"></script>
</body>
</html>