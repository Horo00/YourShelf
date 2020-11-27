<%--footer.jsp [現在日時] --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" java.util.Date, java.text.SimpleDateFormat" %>

<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh時mm分ss秒");
String now = sdf.format(new Date());
%>
<p>現在の日時 ： <%= now %></p>
<p>Copyright Your Shelf All Rights Reservsed.</p>
