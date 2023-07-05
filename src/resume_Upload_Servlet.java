import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//添加员工
@WebServlet("/upload")
@MultipartConfig
public class resume_Upload_Servlet extends HttpServlet {
    // 获取上传的文件
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 获取上传的文件信息
        String id = request.getParameter("idd");
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        // 将文件内容保存到数据库中
        Connection conn = connsql.getConnection();
        try {
            String sql = "INSERT INTO resumes(id,filename, content) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, filePart.getSubmittedFileName());
            statement.setBlob(3, fileContent);
            statement.executeUpdate();
            response.sendRedirect("loginSuccessed.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(500); // 上传文件失败
        }
    }
}

