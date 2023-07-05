<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理系统登录</title>
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
<hr><hr>
<h3>欢迎回来</h3>
<hr><hr>
<a href="employee_Add.jsp"><h4>添加员工信息</h4></a>
<hr><hr>
<a href="employee_Find.jsp"><h4>关键字查询员工</h4></a>
<hr><hr>
<a href="view"><h4>显示员工列表</h4></a>
<hr><hr>
<b>修改员工部门</b><br><br>
<form method="post" action="ChangeDepartment">
    <b>员工工号</b><input type="text" name="id"><br><br>
    <b>部门</b><input type="text" name="department"><br><br>
    <input type="submit" value="修改">
</form>
<hr><hr>
<b>上传员工照片</b><br><br>
<form method="post" enctype="multipart/form-data" action="photo">
    <b>员工工号</b><input type="text" name="empid"><br><br>
    <input type="file" name="photo" accept="image/*" required>
    <br><br>
    <input type="submit" value="添加">
</form>
<hr><hr>
<b>上传员工简历</b><br><br>
<form method="post" enctype="multipart/form-data" action="upload">
    <b>员工工号</b><input type="text" id="idd" name="idd"><br><br>
    <input type="file" name="file">
    <br><br>
    <input type="submit" value="上传简历">
</form>
<hr><hr>
</body>
</html>
