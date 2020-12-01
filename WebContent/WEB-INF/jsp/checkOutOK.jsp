<%-- [viewBook.jsp] 登録書籍(所蔵書籍)の一覧表示画面 with「借りる」ボタン / 「書籍検索」機能  --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出完了</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/viewBook.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="viewbook">
<p class="message">${book.name}を借りました。</p>
<p class="sub-messsage">返却期限：${overBooks.returnScheduleDate}</p>
<p class="viewbooklist">登録書籍一覧</p>
<c:choose>
<c:when test="${empty book}">
<p class="nonlist">該当書籍はありません</p>
</c:when>
<c:otherwise>
		<table class="list" border="1">
		<tr>
		<th>表紙画像</th>
		<th>タイトル</th>
		<th>著者</th>
		<th>出版社</th>
		<th>借りるボタン</th>
		</tr>

		<c:forEach var="category" items="${book}" begin="0" step="1" varStatus="status">
		<tr>
			<td><img src="${book.imgUrl}"></td>
			<td><c:out value="${book.name}"/></td>
			<td><c:out value="${book.authors}"/></td>
			<td><c:out value="${book.publisher}"/></td>
			<td><input type="submit" name="checkout" value="借りる" class="checkout-submit"></td>
			<td><input type="hidden" name="index" value="${status.index}"></td>
		</tr>
		</c:forEach>
		</table>
		<form action="/YourShelf/AddBookServlet" method="post" class="searchshelf-form-form">
        <input type="text" name="keyword" placeholder="キーワード入力" required class="searchshelf-keyword">
        <input type="submit" value="検索" class="searchshelf-submit">
        </form>
        <a class="backtomain" href="/WEB-INF/jsp/loginOK.jsp">メニューに戻る</a>
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