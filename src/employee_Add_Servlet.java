import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//添加员工
@WebServlet("/employee_Add")
public class employee_Add_Servlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String hometown = request.getParameter("hometown");
        String education = request.getParameter("education");
        String school = request.getParameter("school");
        String major = request.getParameter("major");
        String department = request.getParameter("department");
        employee_info_process employee = new employee_info_process(id,name,gender,birthday,hometown,education,school,major,department);
        boolean res = employee_info_process.add_employee(employee);
        if(res){
            response.sendRedirect("employee_AddSuccessed.jsp");
        }
    }
}
