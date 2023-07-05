import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

@WebServlet("/download")
@MultipartConfig
public class resume_download_Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取员工ID
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("empid");
        Connection connection = connsql.getConnection();
        try {
            String sql = "SELECT content FROM resumes WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("content");
                InputStream inputStream = blob.getBinaryStream();

                // 将简历文件内容作为响应发送到客户端
                response.setContentType("application/msword");
                response.setHeader("Content-Disposition", "attachment; filename=resume.md");
                OutputStream outputStream = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
            } else {
                response.setStatus(403); // 未找到简历文件
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(500); // 下载文件失败
        }
    }
}