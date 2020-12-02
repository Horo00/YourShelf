<%--デフォルトページのView [index.jsp] /WEB-INF/jsp/--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourShelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/index.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="defaultpage">
<p>
<img src="img/yourshelflogo.png">
</p>
<a href="/YourShelf/ControllerServlet?value=loginpage" class="login">ログイン</a>
<a href="/YourShelf/ControllerServlet?value=adduserpage" class="adduser">ユーザー登録</a>
<a href="/YourShelf/ControllerServlet?value=viewbookpage" class="viewbook">登録書籍一覧</a>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
</html>