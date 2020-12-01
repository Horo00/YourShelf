<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却期限切れ一覧</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/limitOver.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="limitover">
<p class="limitoverlist">返却期限切れ一覧</p>
<table class="list" border="1">
        <tr>
            <th>表紙画像</th>
            <th>タイトル</th>
            <th>著者</th>
            <th>出版社</th>
            <th>返却期限</th>
            <th>ユーザー</th>
        </tr>

        <c:forEach var="category" items="${overBooks}">
        <tr>
			<td><img src="${overBooks.imgUrl}"></td>
			<td><c:out value="${overBooks.name}"/></td>
			<td><c:out value="${overBooks.authors}"/></td>
			<td><c:out value="${overBooks.publisher}"/></td>
			<td><c:out value="${overBooks.returnScheduleDate}"/></td>
			<td><c:out value="${overBooks.userId}"/></td>
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