<%--ログイン成功画面を出力するView [loginOK.jsp] /WEB-INF/jsp/--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Shelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/loginOK.css">
</head>
<body>
<div class="mainmenu">
<p>
<span class="fa-stack fa-lg">
<p class="welcomeuser">○○さんログイン中</p>
</span>
</p>
<a href="/〇〇〇/◇◇◇" class="history">貸出履歴へ</a>
<a href="/〇〇〇/◇◇◇" class="search">書籍検索へ</a>
<a href="/〇〇〇/◇◇◇" class="return">書籍返却</a>
<a href="/〇〇〇/◇◇◇" class="backtotop">Top画面へ戻る</a>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>