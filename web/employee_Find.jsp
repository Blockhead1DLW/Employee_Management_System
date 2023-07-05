<%--
  Created by IntelliJ IDEA.
  User: 27770
  Date: 2023/6/30
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询员工信息</title>
    <link rel="stylesheet" href="./css/set.css" />
    <style>
        input:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
            outline: none;
        }
    </style>
</head>
<body>
<a href="loginSuccessed.jsp">返回管理员页面</a><br><br>
    <form method="get" action="find">
        <label for="find">选择关键字查询：</label>
        <select id="find" name="find">
            <option value="id">工号</option>
            <option value="name">姓名</option>
            <option value="school">毕业院校</option>
            <option value="major">专业</option>
        </select>
        <input type="text" id="key" name="key">
        <input type="submit" value="查询">
    </form>
    <table border="5px">
        <caption><font size="5"><b>员工列表</b></font></caption>
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>所属部门</th>
            <th>详细信息</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td><a href="/Details?empid=${employee.id}">查看该员工具体信息</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
