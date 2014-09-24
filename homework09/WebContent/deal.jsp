<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
String name = request.getParameter("username");	//获取用户名参数
String password = request.getParameter("password");	//获取用户输入的密码参数
String email = request.getParameter("email");	//获取用户输入的邮箱
String degree = request.getParameter("degree");	//获取用户输入学历
String date = request.getParameter("birthday");	//获取用户输入出生日期
%>
<h1>注册成功！</h1>
<body align="center">
<article>
姓名:<%=name%><br>
密码：<%=password %><br>
邮箱：<%=email %><br>
学历：<%=degree %><br>
出生日期:<%=date %><br>
</article>
</body>

