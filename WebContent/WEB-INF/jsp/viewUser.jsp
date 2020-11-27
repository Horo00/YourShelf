<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ page import="〇〇〇,java.util.List"%> --%>
<%-- getAttribure文 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourShelf</title>
<link rel="stylesheet" type="text/css" href="/YourShelf/css/viewUser.css">
</head>
<body>
<div class="user">
<p class="userlist">登録ユーザーの一覧</p>
<table class="list" border="1">
        <tr>
            <th>登録ユーザー</th>
        </tr>
        <%-- 以下foreach文 --%>
        <tr>
            <td><a href="/〇〇〇/◇◇◇" class="selectuser">シャア・アズナブル</a></td>
        </tr>
</table>
</div>
<div class="underlay-photo"></div>
<div class="underlay-black"></div>
</body>
<footer>
<p class="footerCopy">Copyright YourShelf All Rights Reservsed.</p>
</footer>
</html>