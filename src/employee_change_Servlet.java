import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ChangeDepartment")
public class employee_change_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empid = request.getParameter("id");
        String department = request.getParameter("department");
        Connection conn = connsql.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE employee SET department=? WHERE id = ?");
            statement.setString(1, department);
            statement.setString(2, empid);
            statement.executeUpdate();
            response.sendRedirect("loginSuccessed.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

