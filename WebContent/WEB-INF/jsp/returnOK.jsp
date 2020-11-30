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
<link rel="stylesheet" type="text/css" href="/YourShelf/css/return.css">
<link rel="icon" type="image/png" sizes="32x32" href="img/favicon-32x32.png">
</head>
<body>
<div class="return">
<h3 class="message">機動戦士ガンダム 閃光のハサウェイ〈上〉を返却しました。</h3>
<p class="returnlist">返却書籍の選択</p>
<table class="list" border="1">
        <tr>
            <th>表紙画像</th>
            <th>タイトル</th>
            <th>著者</th>
            <th>出版社</th>
            <th>返却ボタン</th>
        </tr>
        <%-- 以下foreach文 --%>
        <tr>
            <td></td>
            <td>機動戦士ガンダム 逆襲のシャア―ベルトーチカ・チルドレン</td>
            <td>富野由悠季</td>
            <td>角川文庫―スニーカー文庫</td>
            <td><input type="submit" name="return" value="返却" class="return-submit"></td>
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