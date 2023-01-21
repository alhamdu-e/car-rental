import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
 
public class rental {
    private String name;
    private String userid;
    private String phone;
    private String email;
    private String carid;

    public rental() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }
     public void carrent() {
        try {
            DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();
        PreparedStatement stmt=connection.prepareStatement("Insert into RENTALINFO(NAME,USERID,PHONE,EMAIL,CARID) values (?,?,?,?,?)");     
        stmt.setString(1,name);  
        stmt.setString(2,userid);  
        stmt.setString(3,phone);  
        stmt.setString(4,email);  
        stmt.setString(5,carid);  
        stmt.executeUpdate(); 
         String query = "DELETE FROM CARLIST WHERE CAR_ID='" + carid+ "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e) {
        }
    }


}
