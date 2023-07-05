import java.sql.*;
public class connsql {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/employee_information?useUnicode=true&useSSL=false&characterEncoding=utf-8&serverTimezone=UTC";
    private static String user = "root";
    private static String pwd = "project0";


    //加载驱动
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //连接对象
    public static Connection getConnection(){
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭流
    public static void close(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
            if(st != null){
                st.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pst, Connection conn) {
        close(null, pst, conn);
    }

}
