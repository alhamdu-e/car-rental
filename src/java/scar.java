
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped


public class scar {
    private int carid ;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public List<carreg> getSingleList() {
        return singleList;
    }

    public void setSingleList(List<carreg> singleList) {
        this.singleList = singleList;
    }

    
     public List <carreg> singleList;
    public List <carreg> getsinglelist(){
    singleList = new ArrayList<>();
    try{
        
           DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();
          
             PreparedStatement ps = connection.prepareStatement("select * from CARLIST where CAR_ID=?");
               ps.setInt(1, carid);
             ResultSet rs = ps.executeQuery();
          
                 while (rs.next()) {
            carreg add = new carreg();
                add.setCid(rs.getString("CAR_ID"));
              add.setCmodel(rs.getString("CAR_MODEL"));
                add.setCbrand(rs.getString("CAR_BRAND"));
                 add.setCprice(rs.getString("CAR_PRICE"));
                 
          
          
                singleList.add(add);
            } 
             
    }catch( SQLException e)
    {
    
    
    }
    
    return singleList;
    }
    
}
