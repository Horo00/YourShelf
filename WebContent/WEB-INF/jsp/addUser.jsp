
<%--[addUser.jsp] ユーザ登録画面--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/addUser.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<form action="/YourShelf/AddUser" method="post" class="adduser-form">
<p class="adduser">登録情報の入力</p>
<input class="add-username" type="text" name="name" placeholder="ユーザー名" required>
<input class="name-check" type="submit" value="ユーザー名の使用状況確認"><br>
<input class="add-pass" type="password" name="password" required placeholder="パスワード">
<input class="add-pass-check" type="password" name="password-check" required placeholder="確認用パスワード"><br>
<input class="add-submit" type="submit" value="登録">
</form>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>