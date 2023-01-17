import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class deletecar {
    private String carid;

    public deletecar() {
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }
    
     public void cardelete() {
        try {
            DBconnecter db=new DBconnecter();
            Connection connection = db.conMethod();
            String query = "DELETE FROM CARLIST WHERE CAR_ID='" + carid+ "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } 
        catch (SQLException ex) {
        }    
    }
}
