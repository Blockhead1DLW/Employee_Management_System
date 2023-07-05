import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
@WebServlet("/Details")
public class employee_Details_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empid = request.getParameter("empid");
        try{
            employee_info_process employee = new employee_info_process();
            employee = employee.getEmployee(empid);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("employee_Details.jsp").forward(request, response);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
