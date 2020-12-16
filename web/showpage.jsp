<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询全部用户页面</title>
</head>
<body>
<table border="solid 1px" bordercolor="#f00" cellspacing="0">
    <tr bgcolor="#0f0">
        <th>用户编码</th>
        <th>用户名称</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach var="manager" items="${all}">
        <tr>
            <td>${manager.usercode}</td>
            <td>${manager.getUsername()}</td>
            <td><a href="${pageContext.request.contextPath}+deleteManager?usercode=${manager.usercode}">删除</a></td>
            <td><a href="${pageContext.request.contextPath}+updateManager?usercode=${manager.usercode}">修改</a></td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}qall?pageIndex=1">首页</a>
<c:choose>
    <c:when test="${pageIndex > 1}"><a
            href="${pageContext.request.contextPath}qall?pageIndex=${pageIndex-1}">上一页</a></c:when>
    <c:otherwise><a>上一页</a></c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${pageIndex < totlePage}"><a
            href="${pageContext.request.contextPath}qall?pageIndex=${pageIndex+1}">下一页</a></c:when>
    <c:otherwise><a>下一页</a></c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}qall?pageIndex=${totlePage}">尾页</a>
</body>
</html>
