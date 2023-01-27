
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped

public class update {
    private String uid;
    private String addess;
    private String mobile;
    private String email;

    public update() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void updat(){
        try{
         DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();           
             PreparedStatement ps = connection.prepareStatement("UPDATE  USERTEBLE SET EMAIL=?, PHONE=?, ADRESS=? WHERE USER_ID=?");
          
           ps.setString(1, email);
           ps.setString(2, mobile);
           ps.setString(3, addess);
           ps.setString(4, uid);    
           ps.executeUpdate();
      
      }
      catch(SQLException e )
      
      {
      
      System.out.print(e);
      
      }
       
    }
}

