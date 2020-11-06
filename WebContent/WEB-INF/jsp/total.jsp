<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0px;
	padding: 0px
}

header {
	background-color: #FFF;
	height: 50px;
}

body {
	background-color: #F5F5F5;
}

#a {
	float: left;
	color: #000000;
	text-decoration: none;
	font-size: 25px;
	letter-spacing: 5px;
	font-family: Osaka;
	position: relative;
	top: 10px;
}

#b {
	color: #000000;
	text-decoration: none;
	font-family: YuGothic;
	position: relative;
	top: 15px;
	left: 1050px;
	font-size: 15px;
}

p {
	text-align: center;
	position: relative;
	top: 100px;
	font-family: YuGothic;
	text-align: center;
	padding: 10px;
}
</style>
</head>
<body>
	<header>
		<a href="/wcta/Top" id="a">Wcta</a><a href="#"
			onclick="window.history.back(); return false;" id="b">one week</a>
	</header>
	<p>total</p>
	<br>
	<%
		double price = (double) request.getSession().getAttribute("price");
	%>
	<c:forEach var="artist" items="${artists}" varStatus="status">
		<p>${status.count}
			:
			<c:out value="${artist.name}" />
			&nbsp;
			<c:out value="${Math.round(artist.playcount*price)}" />
			円
		</p>
	</c:forEach>
</body>
</html>