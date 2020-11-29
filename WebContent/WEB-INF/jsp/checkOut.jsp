<%--[checkOut.jsp] 一般ユーザ画面遷移先の表示: <ログイン> / <新規登録>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourShelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/checkOut.css">
</head>
<body>
<div class="nonusermenu">
<p class="nonuser">YourShelfにログインしていません</p>
<a href="/YourShelf/LoginServlet" class="login">ログイン</a>
<a href="/YourShelf/AddUserServlet" class="adduser">新規ユーザー登録</a>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>