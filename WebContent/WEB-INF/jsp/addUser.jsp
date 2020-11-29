<%--[addUser.jsp] ユーザ登録画面--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/addUser.css">
</head>
<body>
<form action="/YourShelf/AddUserServlet" method="post" class="adduser-form">
<p class="adduser">登録情報の入力</p>
<input class="add-username" type="text" name="name" placeholder="ユーザー名" required><br>
<input class="add-pass" type="password" name="password" required placeholder="パスワード"><br>
<input class="add-submit" type="submit" value="登録">
</form>

<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>