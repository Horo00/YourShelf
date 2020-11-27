<%-- [addBookOK.jsp] 登録完了画面：--%>
<%--〇〇箇所は後日 記述します --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了画面</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/addBook.css">
</head>
<body>
<div class="addbook">
<h3 class="message">機動戦士ガンダム 逆襲のシャア―ベルトーチカ・チルドレンを登録しました</h1>
<h3 class="date">登録日：2020/12/20</h2>
<p class="booksearch">新規書籍の検索</p>
<form action="/YourShelf/AddBookServlet" method="post">
<input type="text" name="isbn" placeholder="ISBN" class="search-isbn"><br>
<input type="text" name="title" placeholder="検索キーワード" class="search-keyword"><br>
<input type="submit" value="検索" class="search-submit">
<input type="submit" value="リセット" class="reset-submit"><br>
</form>
<a class="backtoadmin" href="○○〇">担当者メニューに戻る</a>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>