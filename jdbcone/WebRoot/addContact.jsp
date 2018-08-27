<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加联系人</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <center><h3>添加联系人</h3></center>
    <form action="${pageContext.request.contextPath }/AddContactServlet" method="post">
	    <table align="center" border="1" width="40px">
	    	<tr>
	    		<th>姓名</th>
	    		<td><input type="text" name="name" /><font color="red">${msg }</font></td>
	    	</tr>
	    	<tr>
	    		<th>性别</th>
	    		<td>
	    			<input type="radio" name="gender" value="男"/>男
	    			<input type="radio" name="gender" value="女"/>女
	    		</td>
	    	</tr>
	    	<tr>
	    		<th>年龄</th>
	    		<td><input type="text" name="age"/></td>
	    	</tr>
	    	<tr>
	    		<th>电话</th>
	    		<td><input type="text" name="phone"/></td>
	    	</tr>
	    	<tr>
	    		<th>邮箱</th>
	    		<td><input type="text" name="wmail"/></td>
	    	</tr>
	    	<tr>
	    		<th>QQ</th>
	    		<td><input type="text" name="qq"/></td>
	    	</tr>
	    	<tr>
	    		<td colspan="2" align="center">
	    		<input type="submit" value="保存"/>&nbsp;
	    		<input type="reset" value="重置"/><td>
	    	</tr>
	    </table>	
	    
	    
	    
	    
	    
	    
	    
	    
    </form>
  </body>
</html>
