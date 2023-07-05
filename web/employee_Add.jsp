<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工信息管理系统</title>
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
<div class="container"><table>
    <caption><font size="5"><b>添加员工</b></font></caption>
    <form action="employee_Add" method="post">
        <tr>
            <th><label for="id">工号</label></th>
            <td><input type="text" id="id" name="id"></td>
        </tr>
        <tr>
            <th><label for="name">姓名</label></th>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <th><label for="gender">性别</label></th>
            <td><input type="text" id="gender" name="gender"></td>
        </tr>
        <tr>
            <th><label for="birthday">出生日期（格式xxxx-xx-xx）</label></th>
            <td><input type="text" id="birthday" name="birthday"></td>
        </tr>
        <tr>
            <th><label for="hometown">籍贯</label></th>
            <td><input type="text" id="hometown" name="hometown"></td>
        </tr>
        <tr>
            <th><label for="education">教育背景</label></th>
            <td><input type="text" id="education" name="education"></td>
        </tr>
        <tr>
            <th><label for="school">毕业院校</label></th>
            <td> <input type="text" id="school" name="school"></td>
        </tr>
        <tr>
            <th><label for="major">专业</label></th>
            <td><input type="text" id="major" name="major"></td>
        </tr>
        <tr>
            <th><label for="department">所属部门</label></th>
            <td><input type="text" id="department" name="department"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
            <td><a href="loginSuccessed.jsp">返回管理员页面</a></td>
        </tr>

    </form>
</table>

</div>
</body>
</html>