<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="./css/set.css" />
</head>
<body>
<a href="loginSuccessed.jsp">返回管理员页面</a>
<div class="container">
    <table border="5px">
        <caption><font size="5"><b>员工详细信息</b></font></caption>
        <tr>
            <th>员工照片</th>
            <td>
                <c:choose>
                <c:when test="${not empty employee.photo}">
                    <img src="data:image/jpeg;base64,${employee.photo}" width="100" height="100" alt="员工照片">
                </c:when>
                <c:otherwise>
                    <img src="resource/employee.jpg" alt="未找到员工照片" width="100" height="100">
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th>工号</th>
            <td>${employee.id}</td>
        </tr>
        <tr>
            <th>名字</th>
            <td>${employee.name}</td>
        </tr>
        <tr><th>性别</th>
            <td>${employee.gender}</td>
        </tr>
        <tr><th>出生日期</th>
            <td>${employee.birthday}</td>
        </tr>
        <tr><th>籍贯</th>
            <td>${employee.hometown}</td>
        </tr>
        <tr><th>学历</th>
            <td>${employee.education}</td>
        </tr>
        <tr><th>毕业院校</th>
            <td>${employee.school}</td>
        </tr>
        <tr>
            <th>专业</th>
            <td>${employee.major}</td>
        </tr>
        <tr>
            <th>所属部门</th>
            <td>${employee.department}</td>
        </tr>
        <tr>
            <td colspan="2"><a href="/download?empid=${employee.id}">下载简历</a></td>
        </tr>
    </table>
</div>
</body>
</html>