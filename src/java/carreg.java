import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped


public class carreg {
    private String Cid;
    private String Cmodel;
    private String Cbrand;
    private String Cprice;

    public carreg() {
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getCmodel() {
        return Cmodel;
    }

    public void setCmodel(String Cmodel) {
        this.Cmodel = Cmodel;
    }

    public String getCbrand() {
        return Cbrand;
    }

    public void setCbrand(String Cbrand) {
        this.Cbrand = Cbrand;
    }

    public String getCprice() {
        return Cprice;
    }

    public void setCprice(String Cprice) {
        this.Cprice = Cprice;
    }
      public void carregister() {
        try {
            DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();
        PreparedStatement stmt=connection.prepareStatement("Insert into CARLIST(CAR_ID,CAR_MODEL,CAR_BRAND,CAR_PRICE) values (?,?,?,?)");     
        stmt.setString(1,Cid);  
        stmt.setString(2,Cmodel);  
        stmt.setString(3,Cbrand);  
        stmt.setString(4,Cprice);  
        stmt.executeUpdate();  
        }
        catch (SQLException e) {
        }
    }

    
    
   }
