<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工列表</title>
    <link rel="stylesheet" href="./css/set.css" />
</head>
<body>
<a href="loginSuccessed.jsp">返回管理员页面</a>
<div class="container">
    <table border="5px">
        <caption><font size="5"><b>员工列表</b></font></caption>
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>所属部门</th>
            <th>详细信息</th>
            <th>删除该员工</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td><a href="/Details?empid=${employee.id}">查看该员工具体信息</a></td>
                <td><a href="/employee_del?empid=${employee.id}">删除该员工</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>