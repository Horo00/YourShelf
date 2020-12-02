<%--ログイン画面を出力するView [login.jsp] /WEB-INF/jsp/--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/login.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
	<form class="login-form" action="/YourShelf/ControllerServlet" method="post">


			<p class="logintoyouself">YourShelfへログイン</p>
			<p> ${message} </p>


		<input type="text" class="login-username" name="name"
			autofocus required placeholder="ユーザー名"><br>
		<input type="password" class="login-password" name="password"
			required placeholder="パスワード"><br> <input
			type="submit" name="Login" value="ログイン" class="login-submit">
			<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
	</form>

	<div class="underlay-photo"></div>
	<div class="underlay-black"></div>
</body>
</html>