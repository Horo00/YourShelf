<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今まで借りた書籍の一覧</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/userHistory.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="history">
<p class="historylist">${user.name}さんの今まで借りた書籍の一覧</p>
<table class="list" border="1">
        <tr>
            <th>表紙画像</th>
            <th>タイトル</th>
            <th>著者</th>
            <th>出版社</th>
            <th>返却期限</th>
        </tr>

        <c:forEach var="book" items="${userBookHis}">
        <tr>
			<td><img src="${book.imgUrl}"></td>
			<td><c:out value="${book.title}"/></td>
			<td><c:out value="${book.authors}"/></td>
			<td><c:out value="${book.publisher}"/></td>
			<td><c:out value="${book.returnScheduleDate}"/></td>
		</tr>
        </c:forEach>
</table>
<a class="backtomain" href="/YourShelf/ControllerServlet?value=loginpage">メニューに戻る</a>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
</html>