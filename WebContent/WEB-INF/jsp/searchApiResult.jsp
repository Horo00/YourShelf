<%--[searchApiResult.jsp] googleAPIでの検索結果 --%>
<%--〇〇箇所は後日 記述します --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
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
<%-- <c:choose> --%>

<%-- <c:when test="${empty ◇◇}"> --%>
	<%-- <p class="nonlist">該当書籍はありません</p> --%>
<%-- </c:when> --%>
<%-- <c:otherwise> --%>
		<table class="list" border="1">
		<tr>
		<th>表紙画像</th>
		<th>タイトル</th>
		<th>著者</th>
		<th>出版社</th>
		<th>登録ボタン</th>
		</tr>

		<%-- 以下foreach文 --%>

			<tr>
			<td><img src="http://books.google.com/books/content?id=EKR4QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"></td>
			<td>機動戦士ガンダム 逆襲のシャア―ベルトーチカ・チルドレン</td>
			<td>富野由悠季</td>
			<td>角川文庫―スニーカー文庫</td>
			<td><input type="submit" name="add" value="登録" class="add-submit"></td>
			</tr>

		<%-- <c:forEach var="category" items="${list}"> --%>
        <%-- <tr> --%>
			<%-- <td><img src="http://books.google.com/books/content?id=EKR4QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"></td> --%>
			<%-- <td><c:out value="${○○〇.name}"/></td> --%>
			<%-- <td><c:out value="${○○〇.writer}"/></td> --%>
			<%-- <td><c:out value="${○○〇.company}"/></td> --%>
			<%-- <td><input type="submit" name="add" value="登録" class="add-submit"></td> --%>
		<%-- </tr> --%>
        <%-- </c:forEach> --%>

		</table>
<%-- </c:otherwise> --%>
<%-- </c:choose> --%>

<form action="/YourShelf/AddBookServlet" method="post">
</form>
<a class="backtosearch" href="○○〇">新規書籍検索に戻る</a>
<a class="backtoadmin" href="○○〇">担当者メニューに戻る</a>
</div>
</body>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>