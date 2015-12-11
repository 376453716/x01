<%--
  Created by IntelliJ IDEA.
  User: xionghao
  Date: 29/10/2015
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
spring mvc test.
<%=request.getContextPath()%>

<form action="/base/test">
    <input type="text" name="name"/>
    <input type="submit">
</form>

<form action="/base/test2">
    <input type="text" name="name"/>
    <input type="submit">
</form>
</body>
</html>
