import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class login  {
  private String usern;
    private String pass;
  
  
    public String getUsern() {
        return usern;
    }

    public void setUsern(String usern) {
        this.usern = usern;
    }
   
     public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String passs() throws SQLException, ClassNotFoundException {
        boolean num = checker(usern, pass);
        if (num) {
             DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();
            PreparedStatement ps = connection.prepareStatement("select USERTYPE from LOGIN where USERNAME=?");
            ps.setString(1, usern);       
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userType =rs.getString(1);
            if ("admin".equals(userType)) {
                return "admin";
            } else {
                return "user";
            }
        } else {
                   
            return "index";
        }
    }


 public static boolean checker(String name, String password) {
        boolean status = false;
        try {
           DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();
            PreparedStatement ps = connection.prepareStatement("select * from LOGIN where USERNAME=? and PASSWORD=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            System.out.println(e);
         
        }
        return status;
    }
}