import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
@WebServlet("/photo")
@MultipartConfig
public class photoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String empid = request.getParameter("empid");
        Part photoPart = request.getPart("photo");
        InputStream photoInputStream = photoPart.getInputStream();
        Connection conn = connsql.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE employee SET photo = ? WHERE id = ?");
            statement.setBinaryStream(1, photoInputStream);
            statement.setString(2, empid);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add photo.");
        }
    }
}
