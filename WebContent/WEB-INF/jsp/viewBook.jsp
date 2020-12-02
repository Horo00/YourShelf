<%-- [viewBook.jsp] 登録書籍(所蔵書籍)の一覧表示画面 with「借りる」ボタン / 「書籍検索」機能  --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍一覧 / 所蔵検索</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/viewBook.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="viewbook">
<form action="/YourShelf//ViewBookServlet" method="post" class="searchshelf-form-form">
        <input type="text" name="keyword" placeholder="キーワード入力" required class="searchshelf-keyword">
        <input type="submit" value="検索" class="searchshelf-submit">
</form>
<p class="viewbooklist">登録書籍一覧</p>
<c:choose>

<c:when test="${empty book}">
<p>該当書籍はありません</p>
</c:when>
<c:otherwise>
		<table class="list" border="1">
		<tr>
		<th>表紙画像</th>
		<th>タイトル</th>
		<th>著者</th>
		<th>出版社</th>
		<th>貸出回数</th>
		<th>借りるボタン</th>
		</tr>

		<c:forEach var="books" items="${book}" begin="0" step="1" varStatus="status">
		<form action="/YourShelf/CheckOutServlet" method="post">
		<tr>
			<td><img src="${books.imgUrl}" alt="${books.imgUrl}"></td>
			<td><c:out value="${books.title}"/></td>
			<td><c:out value="${books.authors}"/></td>
			<td><c:out value="${books.publisher}"/></td>
			<td><c:out value="${books.count}"/></td>
			<c:choose>
			<c:when test="${books.isCheckedOut == true}">
			<td><input type="submit" value="貸出中" disabled class="checkoutnow-submit"></td>
			</c:when>
			<c:otherwise>
			<td><input type="submit" name="checkout" value="借りる" class="checkout-submit"></td>
			</c:otherwise>
			</c:choose>
			<td><input type="hidden" name="index" value="${status.index}"></td>
		</tr>
		</form>
		</c:forEach>

		</table>

        <a class="backtomain" href="/YourShelf/ControllerServlet?value=loginpage">メニューに戻る</a>
</div>

        <div class="underlay-photo"></div>
        <div class="underlay-black"></div>
</c:otherwise>
</c:choose>


</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>