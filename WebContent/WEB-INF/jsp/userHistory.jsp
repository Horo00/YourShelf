<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ page import="〇〇〇,java.util.List"%> --%>
<%-- getAttribure文 --%>
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
<p class="historylist">今まで借りた書籍の一覧</p>
<table class="list" border="1">
        <tr>
            <th>表紙画像</th>
            <th>タイトル</th>
            <th>著者</th>
            <th>出版社</th>
            <th>返却期限</th>
        </tr>
        <%-- 後で消す --%>
        <tr>
            <td><img src="http://books.google.com/books/content?id=EKR4QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"></td>
            <td>機動戦士ガンダム 逆襲のシャア―ベルトーチカ・チルドレン</td>
            <td>富野由悠季</td>
            <td>角川文庫―スニーカー文庫</td>
            <td>2020/12/20</td>
        </tr>

        <%-- <c:forEach var="category" items="${list}"> --%>
        <%-- <tr> --%>
			<%-- <td><img src="http://books.google.com/books/content?id=EKR4QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"></td> --%>
			<%-- <td><c:out value="${○○〇.name}"/></td> --%>
			<%-- <td><c:out value="${○○〇.writer}"/></td> --%>
			<%-- <td><c:out value="${○○〇.company}"/></td> --%>
			<%-- <td><c:out value="${○○〇.limitdate}"/></td> --%>
		<%-- </tr> --%>
        <%-- </c:forEach> --%>
</table>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>