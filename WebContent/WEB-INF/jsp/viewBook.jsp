<%-- [viewBook.jsp] 登録書籍(所蔵書籍)の一覧表示画面 with「借りる」ボタン / 「書籍検索」機能  --%>
<%--〇〇箇所は後日 記述します --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍一覧 / 所蔵検索</title>
</head>
<body>
<p>書籍一覧</p>
<c:choose>

<c:when test="${empty ◇◇}">
	<p>該当書籍はありません</p>
</c:when>
<c:otherwise>
		<table border="1">
		<tr><th>表紙画像</th><th>タイトル</th><th>著者</th><th>出版社</th><th><input type=submit value="借りる"></th></tr>

		<c:forEach var="〇〇" items="${◇◇}">
			<tr>
			<td class="DBの書籍一覧table□□□"><c:out value="${■■.画像data}"/></td>
			<td><c:out value="${〇〇〇.タイトルdata}"/></td>
			<td><c:out value="${〇〇〇.著者data}"/></td>
			<td><c:out value="${〇〇〇.出版社data}"/></td>
			</tr>
		</c:forEach>
		</table>
</c:otherwise>
</c:choose>

<input type="submit" value="検索">
<input type="text" name="keyword" placeholder="キーワード入力" required>

</body>
</html>