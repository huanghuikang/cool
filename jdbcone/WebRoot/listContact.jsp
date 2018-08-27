<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询所有联系人</title>
    
	<style type="text/css">
		table td{
			text-align:center;
		}
		table{
			border-collapse:collapse;
		}
	</style>

  </head>
  
  <body>
  	<center><h3>查询所有联系人</h3></center>
  	<table align="center" border="1" width="700px">
  		<tr>
  			<th>编号</th>
  			<th>姓名</th>
  			<th>性别</th>
  			<th>年龄</th>
  			<th>电话</th>
  			<th>邮箱</th>
  			<th>QQ</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${contacts }" var="con" varStatus="varSta">
  		<tr>
  			<td>${varSta.count }</td>
  			<td>${con.name }</td>
  			<td>${con.gender }</td>
  			<td>${con.age }</td>
  			<td>${con.phone }</td>
  			<td>${con.email }</td>
  			<td>${con.qq }</td>
  			<td><a href="${pageContext.request.contextPath }/QueryContactServlet?id=${con.id }">修改</a>&nbsp;
  			<a href="${pageContext.request.contextPath }/DeleteContactServlet?id=${con.id }">删除</a> </td>
  		</tr>
  		</c:forEach>
  		<tr>
  			<td colspan="8" align="center"><a href="${pageContext.request.contextPath }/addContact.jsp">[添加联系人]</a>
  		</tr>
  	</table>
  </body>
</html>








