import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet("/view")
public class employee_view_Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employee_info_process employee = new employee_info_process();
        try{
            List<employee_info_process> employees = employee.getAllEmployees();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("employee_view.jsp").forward(request, response);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
