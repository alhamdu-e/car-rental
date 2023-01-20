
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.RequestScoped;  
  
@ManagedBean
@RequestScoped  
public class carlistbean {
public List<carlist>list;  
public List<carlist>getlist(){
    list=new ArrayList<>();
 
    try {
      
        Statement st;
        DBconnecter db=new DBconnecter();
        Connection connection = db.conMethod();
        st=connection.createStatement();
        ResultSet rs=st.executeQuery("select * from CARLIST");
        while(rs.next()){
        String CAR_ID=rs.getString("CAR_ID");
        String CAR_MODEL=rs.getString("CAR_MODEL");
        String CAR_BRAND=rs.getString("CAR_BRAND");
        String CAR_PRICE=rs.getString("CAR_PRICE");
      list.add(new carlist(CAR_ID,CAR_MODEL,CAR_BRAND,CAR_PRICE));
 }
        
    } catch (SQLException ex) {
        Logger.getLogger(carlistbean.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}
