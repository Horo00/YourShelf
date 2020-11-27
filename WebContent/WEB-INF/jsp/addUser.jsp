<%--[addUser.jsp] ユーザ登録画面--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
</head>
<body>
<p>ユーザー登録</p>
<form action="/YourShelf/AddUserServlet" method="post">
ユーザーID：<input type="text" name="id" required><br>
パスワード：<input type="password" name="password" required><br>
<input type="submit" value="検索"><br>
<input type="submit" value="リセット"><br>
<input type="submit" value="戻る">
</form>
</body>
</html>