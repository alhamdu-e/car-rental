import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class deletuser {
    private String userid;

    public deletuser() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
     public void userdelete() {
        try {
            DBconnecter db=new DBconnecter();
            Connection connection = db.conMethod();
            String query = "DELETE FROM USERTEBLE WHERE USER_ID='" + userid+ "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } 
        catch (SQLException ex) {
        }    
    }
    
}
