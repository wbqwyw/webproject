<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员信息卡片</title>
</head>
<body>
<form action="/updateManager" method="post">
    <label>用户编码</label><input type="text" value="${manager.usercode}" name="usercode" readonly><br>
    <label>用户名称</label><input type="text" value="${manager.username}" name="username"><br>
    <input type="submit" name="保存" value="保存" src="${pageContext.request.contextPath}/updateManager">
</form>

</body>
</html>
