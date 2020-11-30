<%-- [addBookOK.jsp] 登録完了画面：--%>
<%--〇〇箇所は後日 記述します --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍登録完了</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/addBook.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="addbook">
<p class="message">機動戦士ガンダム 逆襲のシャア―ベルトーチカ・チルドレンを登録しました</p>
<p class="date">登録日：2020/12/20</p>
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