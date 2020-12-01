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

        <c:forEach var="category" items="${userList}">
        <tr>
			<td><a href="/YourShelf/ViewUserServlet" class="selectuser">${user.name}</a></td>
		</tr>
        </c:forEach>
</table>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>