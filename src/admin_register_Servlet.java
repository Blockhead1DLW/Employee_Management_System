import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet("/register")
public class admin_register_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        if(!confirm_password.equals(password)){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Password Mismatch</title></head><body>");
            out.println("<p>两次输入密码不一致，请重新输入</p>");
            out.println("<a href=\"register.jsp\">返回注册页面</a>");
            out.println("</body></html>");
        }else{
            boolean flag = admin_Info_process.checkregister(username, password);
            if(flag){
                response.sendRedirect("index.jsp");
            }
        }
    }
}

