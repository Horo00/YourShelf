<%--[searchApiResult.jsp] googleAPIでの検索結果 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍検索結果</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/searchApiResult.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="apiresult">
<p class="apilist">検索結果</p>
<c:choose>

<c:when test="${empty addBookList}"> --%>
	<p class="nonlist">該当書籍はありません</p>
</c:when>
<c:otherwise>
		<table class="list" border="1">
		<tr>
		<th>表紙画像</th>
		<th>タイトル</th>
		<th>著者</th>
		<th>出版社</th>
		<th>登録ボタン</th>
		</tr>



		<c:forEach var="bookList" items="${addBookList}" begin="0" step="1" varStatus="status">
		<form action="/YourShelf/AddBookServlet?value=add" method="post">
        <tr>
			<td><img src="${bookList.imgUrl}"></td>
			<td><c:out value="${bookList.title}"/></td>
			<td><c:out value="${bookList.authors}"/></td>
			<td><c:out value="${bookList.publisher}"/></td>
			<td><input type="submit" name="add" value="登録" class="add-submit"></td>
			<td><input type="hidden" name="index" value="${status.index}"></td>
		</tr>
		</form>
        </c:forEach>



		</table>
</c:otherwise>
</c:choose>



<a class="backtosearch" href="/YourShelf/AddBookServlet">新規書籍検索に戻る</a>
<a class="backtomain" href="/YourShelf/ControllerServlet?value=loginpage">担当者メニューに戻る</a>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</div>
</body>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</html>