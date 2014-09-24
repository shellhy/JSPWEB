<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*"%>
<%@ page import="homework09.peopleBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>黄勇的作业</title>
</head>
<body>
<div width="100%" align="center">
		<h2>注册人数信息</h2>
	</div>
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="1" bgcolor="#666666">
		<tr>
		    <th bgcolor="#FFFFFF">id</th>
			<th bgcolor="#FFFFFF">userName</th>
			<th bgcolor="#FFFFFF">password</th>
			<th bgcolor="#FFFFFF">email</th>
			<th bgcolor="#FFFFFF">birthday</th>
			<th bgcolor="#FFFFFF">degree</th>
			<th bgcolor="#FFFFFF">PushInfo</th>
		</tr>
		<%
			List<peopleBean> list = (List<peopleBean>)request.getAttribute("list");
			// 判断集合是否有效
			if (list == null || list.size() < 1) {
				out.print("<tr><td bgcolor='#FFFFFF' colspan='7'>没有任何信息！</td></tr>");
			} else {
				for (peopleBean people : list) {
		%>
		<tr align="center">
		    <td bgcolor="#FFFFFF"><%=people.getId()%></td>
			<td bgcolor="#FFFFFF"><%=people.getUserName()%></td>
			<td bgcolor="#FFFFFF"><%=people.getPassword()%></td>
			<td bgcolor="#FFFFFF" ><%=people.getEmail()%></td>
			<td bgcolor="#FFFFFF" ><%=people.getBirthday()%></td>
			<td bgcolor="#FFFFFF"><%=people.getDegree()%></td>			
			<td bgcolor="#FFFFFF"><%=people.getPushInfo()%></td>
		</tr>
		<%
			}
		}
		%>
	</table>
	<div width="98%" align="center" style="padding-top:10px;">
		<%=request.getAttribute("bar")%>
	</div>	
</body>
</html>