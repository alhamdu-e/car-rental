import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
 
public class rental {
    private String name;
    private String phone;
    private String email;
    private String carid;

    String userid;
FacesContext facesContext = FacesContext.getCurrentInstance();
ExternalContext externalContext = facesContext.getExternalContext();
Map<String,Object> sessionMap = externalContext.getSessionMap();
    public rental() {
        userid=(String) sessionMap.get("user");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     public void carrent() throws SQLException {
        
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
        }
    



