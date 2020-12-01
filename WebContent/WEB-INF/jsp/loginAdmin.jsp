<%--管理者ログイン成功画面を出力するView [loginAdministrator.jsp] /WEB-INF/jsp/--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourShelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/loginAdmin.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="mainmenu">
<p class="welcomeuser">担当者ログイン中</p>
<a href="/YourShelf/ViewUserServlet" class="viewuser">登録ユーザー確認</a>
<a href="/YourShelf/LimitOverServlet" class="limitover">返却期限切れ確認</a>
<a href="/YourShelf/ControllerServlet?value=viewbookpage" class="viewbook">登録書籍一覧</a>
<a href="/YourShelf/AddBookServlet" class="addbook">書籍登録</a>
<a href="/YourShelf/LogoutServlet" class="logout">ログアウト</a>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>