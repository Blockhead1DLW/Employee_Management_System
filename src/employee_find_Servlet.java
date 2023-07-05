import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find")
public class employee_find_Servlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String find = request.getParameter("find");
        String key = request.getParameter("key");
        System.out.println(find);
        System.out.println(key);
        Connection connection = connsql.getConnection();
        try {
            String sql = "SELECT * FROM employee WHERE " + find + " = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            List<employee_info_process> employees = new ArrayList<>();
            while(rs.next()) {
                employee_info_process employee =  new employee_info_process();
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                employee.setBirthday(rs.getString("birthday"));
                employee.setHometown(rs.getString("hometown"));
                employee.setEducation(rs.getString("education"));
                employee.setSchool(rs.getString("school"));
                employee.setMajor(rs.getString("major"));
                employee.setDepartment(rs.getString("department"));
                employees.add(employee);
            }
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("employee_Find.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
