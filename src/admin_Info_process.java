import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin_Info_process {
    //注册逻辑
    public static boolean checkregister(String username, String password) {
        boolean flag = true;
        PreparedStatement st = null;
        int rs = 0;
        String sql ="insert into admin(username,password)values(?,?)";
        Connection conn = connsql.getConnection();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeUpdate();
            if(rs > 0){
                flag = true;
            }else{
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    //登录逻辑
    public static boolean checkLogin(String username, String password) {
        boolean flag = false;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql ="select * from admin where username = '"+ username +"'";
        Connection conn = connsql.getConnection();
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                if(rs.getString("password").equals(password)) {
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connsql.close(rs, st, conn);
        }
        return flag;
    }
}
