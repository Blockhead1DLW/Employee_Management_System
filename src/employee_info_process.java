import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class employee_info_process {
    String name;
    String id;
    String gender;
    String birthday;
    String hometown;
    String education;
    String school;
    String major;
    String photo;
    String department;

    public employee_info_process(String id, String name,String gender,String birthday,String hometown,String education,String school,String major,String department){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.hometown = hometown;
        this.education = education;
        this.school = school;
        this.major = major;
        this.department = department;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public employee_info_process() {
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEducation() {
        return education;
    }

    public String getSchool() {
        return school;
    }
    public String getHometown() {
        return hometown;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSchool(String graduated_school) {
        this.school = graduated_school;
    }



    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }



    //获取单个员工信息表
    public employee_info_process getEmployee(String id) throws SQLException {
        employee_info_process employee =  new employee_info_process();
        Connection conn = connsql.getConnection();
        try {
            String sql = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                employee.setBirthday(rs.getString("birthday"));
                employee.setHometown(rs.getString("hometown"));
                employee.setEducation(rs.getString("education"));
                employee.setSchool(rs.getString("school"));
                employee.setMajor(rs.getString("major"));
                employee.setDepartment(rs.getString("department"));
                if(rs.getBytes("photo") != null){
                    byte[] photoData = rs.getBytes("photo");
                    String photoBase64 = Base64.getEncoder().encodeToString(photoData);
                    employee.setPhoto(photoBase64);
                }
            } else {
                System.out.println("没有找到该员工");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    //获取所有员工列表
    public List<employee_info_process> getAllEmployees() throws SQLException {
        List<employee_info_process> employees = new ArrayList<>();
        Connection conn = connsql.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
        while (rs.next()) {
            employee_info_process employee =  new employee_info_process();
            employee.setId(rs.getString("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            employees.add(employee);
        }
        return employees;

    }
    //添加员工
    public static boolean add_employee(employee_info_process employee){
        boolean flag = false;
        PreparedStatement st = null;
        int rs = 0;
        String sql ="insert into employee(id,name,gender,birthday,hometown,education,school,major,department)values(?,?,?,?,?,?,?,?,?)";
        Connection conn = connsql.getConnection();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, employee.getId());
            st.setString(2, employee.getName());
            st.setString(3, employee.getGender());
            st.setString(4, employee.getBirthday());
            st.setString(5, employee.getHometown());
            st.setString(6, employee.getEducation());
            st.setString(7, employee.getSchool());
            st.setString(8, employee.getMajor());
            st.setString(9, employee.getDepartment());
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
    //删除员工
    public static void del_employee(String id){
        PreparedStatement st = null;
        int rs = 0;
        String sql ="DELETE FROM employees WHERE id = ?";
        Connection conn = connsql.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            int res = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
