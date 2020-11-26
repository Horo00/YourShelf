<%--[addBook.jsp] 新規書籍の検索（GoogleAPI）画面--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規書籍の検索</title>
</head>
<body>
<p>書籍検索</p>
<form action="/YourShelf/AddBookServlet" method="post">
ISBN：<input type="number" name="isbn" min="13" required><br>
タイトル：<input type="text" name="title" required><br>
<input type="submit" value="検索"><br>
<input type="submit" value="リセット"><br>
</form>
<a href="/YourShelf/loginOK.jsp">ログイン画面へ戻る</a>
</body>
</html>