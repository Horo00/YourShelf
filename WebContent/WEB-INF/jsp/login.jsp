<%--ログイン画面を出力するView [login.jsp] /WEB-INF/jsp/--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourShelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/login.css">
</head>
<body>
	<form class="login-form" action="/〇〇〇/◇◇◇" method="post">
		<p>
			<span class="fa-stack fa-lg">
			<p class="logintoyouself">YourShelfへログイン</p>
			</span>
		</p>
		<input type="text" class="login-username" name="userName"
			autofocus="true" required="true" placeholder="ユーザー名"><br>
		<input type="password" class="login-password" name="passWord"
			required="true" placeholder="パスワード"><br> <input
			type="submit" name="Login" value="ログイン" class="login-submit">
	</form>
	<div class="underlay-photo"></div>
	<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>