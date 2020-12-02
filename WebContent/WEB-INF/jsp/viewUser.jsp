<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourShelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/viewUser.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="user">
<p class="userlist">登録ユーザーの一覧</p>
<table class="list" border="1">
        <tr>
            <th>登録ユーザー</th>
        </tr>

        <c:forEach var="user" items="${userList}"  begin="0" step="1" varStatus="status">
        <tr>
			<td><a href="/YourShelf/UserHistoryForServlet?index=${status.index}" class="selectuser">${user.name}</a></td>
		</tr>
        </c:forEach>
</table>
<a class="backtomain" href="/YourShelf/ControllerServlet?value=loginpage">担当者メニューに戻る</a>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
</html>