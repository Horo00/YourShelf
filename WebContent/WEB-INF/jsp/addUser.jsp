
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
<div class="adduser-form">
<form action="/YourShelf/UserNameCheckServlet" method="post">
<p class="adduser">登録情報の入力</p>
<input class="add-username" type="text" name="name" placeholder="ユーザー名" value="${name}" required>
<input class="name-check" type="submit" value="ユーザー名の使用状況確認">
<p class="addmessage"> ${message} </p>
</form>


<form action="/YourShelf/AddUser" method="post" id="adduser">
<input type="hidden" name="name" value="${name}">
<input class="add-pass" type="password" name="password" required placeholder="パスワード">
<input class="add-pass-check" type="password" name="password-check" required placeholder="確認用パスワード"><br>
<input class="add-submit" type="submit" value="登録">
</form>
</div>

<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>