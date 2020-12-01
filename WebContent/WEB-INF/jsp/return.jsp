<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍返却</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/return.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="return">
<p class="returnlist">返却書籍の選択</p>
<table class="list" border="1">
        <tr>
            <th>表紙画像</th>
            <th>タイトル</th>
            <th>著者</th>
            <th>出版社</th>
            <th>返却ボタン</th>
        </tr>



        <c:forEach var="category" items="${book}" begin="0" step="1" varStatus="status">
        <form action="/YourShelf/ReturnServlet?value=return" method="get">
        <tr>
			<td><img src="${book.imgUrl}"></td>
			<td><c:out value="${book.name}"/></td>
			<td><c:out value="${book.authors}"/></td>
			<td><c:out value="${book.publisher}"/></td>
			<td><input type="submit" name="return" value="返却" class="return-submit"></td>
			<td><input type="hidden" name="index" value="${status.index}"></td>
		</tr>
		</form>
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