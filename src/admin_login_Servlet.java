import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/login")
public class admin_login_Servlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取字段
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //管理员账号验证
        boolean flag = admin_Info_process.checkLogin(username, password);
        if(flag){
            //登录成功后跳转
            response.sendRedirect("loginSuccessed.jsp");
        }else{
            response.sendRedirect("loginFailed.jsp");
        }

    }
}
