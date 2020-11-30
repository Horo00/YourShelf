<%-- [viewBook.jsp] 登録書籍(所蔵書籍)の一覧表示画面 with「借りる」ボタン / 「書籍検索」機能  --%>
<%--〇〇箇所は後日 記述します --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
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
<p class="viewbooklist">登録書籍一覧</p>
<%-- <c:choose> --%>

<%-- <c:when test="${empty ◇◇}"> --%>
<%-- <p>該当書籍はありません</p> --%>
<%-- </c:when> --%>
<%-- <c:otherwise> --%>
		<table class="list" border="1">
		<tr>
		<th>表紙画像</th>
		<th>タイトル</th>
		<th>著者</th>
		<th>出版社</th>
		<th>借りるボタン</th>
		</tr>

		<%-- 以下foreach文 --%>
			<tr>
			<td><img src="http://books.google.com/books/content?id=EKR4QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"></td>
			<td>機動戦士ガンダム 逆襲のシャア―ベルトーチカ・チルドレン</td>
			<td>富野由悠季</td>
			<td>角川文庫―スニーカー文庫</td>
			<td><input type="submit" name="checkout" value="借りる" class="checkout-submit"></td>
			</tr>

		<%-- <c:forEach var="category" items="${list}"> --%>
		<%-- <tr> --%>
			<%-- <td><img src="http://books.google.com/books/content?id=EKR4QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"></td> --%>
			<%-- <td><c:out value="${○○〇.name}"/></td> --%>
			<%-- <td><c:out value="${○○〇.writer}"/></td> --%>
			<%-- <td><c:out value="${○○〇.company}"/></td> --%>
			<%-- <td><input type="submit" name="checkout" value="借りる" class="checkout-submit"></td> --%>
		<%-- </tr> --%>
		<%-- </c:forEach> --%>

		</table>
		<form action="/YourShelf/AddBookServlet" method="post" class="searchshelf-form-form">
        <input type="text" name="keyword" placeholder="キーワード入力" required class="searchshelf-keyword">
        <input type="submit" value="検索" class="searchshelf-submit">
        </form>
        <a class="backtomain" href="○○〇">メニューに戻る</a>
</div>

        <div class="underlay-photo"></div>
        <div class="underlay-black"></div>
<%-- </c:otherwise> --%>
<%-- </c:choose> --%>



</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>