<%-- [addBookOK.jsp] 登録完了画面：--%>
<%--〇〇箇所は後日 記述します --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
</head>
<body>
<p>
<c:out value="${〇〇.titleData}"/>を登録しました<br>
登録日：<fmt:formatDate value="${date}" pattern="yyyy/MM/dd HH:mm:ss" /><br>
</p>

<p>書籍検索</p>
<form action="/YourShelf/AddBookServlet" method="post">
ISBN:<input type="number" name="isbn" min="13" required><br>
タイトル<input type="text" name="title" required><br>
<input type="submit" value="検索"><br>
<input type="submit" value="リセット"><br>
<input type="submit" value="戻る">
</form>

</body>
</html>