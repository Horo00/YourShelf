<%--ログイン成功画面を出力するView [loginOK.jsp] /WEB-INF/jsp/--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourShelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/loginOK.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="mainmenu">
<p class="welcomeuser">○○さんログイン中</p>
<a href="/〇〇〇/◇◇◇" class="userhistory">貸出履歴</a>
<a href="/〇〇〇/◇◇◇" class="viewbook">登録書籍一覧</a>
<a href="/〇〇〇/◇◇◇" class="return">書籍返却</a>
<a href="/〇〇〇/◇◇◇" class="logout">ログアウト</a>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>