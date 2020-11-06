<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

body {
	background-color: #F5F5F5;
}

form {
	font-family: YuGothic;
	text-align: center;
	position: relative;
	top: 160px;
}

button {
	border-radius: 20px;
	color: #FFF;
	background: #000000;
}

#b {
	width: 220px;
	height: 25px;
	font-size: 15px;
}

#c {
	width: 220px;
	height: 25px;
	font-size: 15px;
}

#d {
	height: 25px;
	font-size: 15px;
}

#e {
	height: 25px;
	font-size: 15px;
}
</style>
</head>
<body>
	<div>
		<header>

			<a href="/wcta/Top" id="a">Wcta</a>

		</header>
		<form method="POST" action="/wcta/Oneweek">


			user name <br> <input type="text" name="user" id="b" /> <br>
			key <br> <input type="password" name="key" id="c" /> <br>

			<button type="submit">SIGN IN</button>
			<br> <br> number to display&emsp;<input type="number"
				value="5" min="5" max="30" step="5" name="num" id="d" /><br> <br>price
			per number of one listen&emsp;<input type="number" value="0.2"
				min="0.1" max="0.9" step="0.1" name="pri" id="e" />

		</form>
	</div>
</body>
</html>