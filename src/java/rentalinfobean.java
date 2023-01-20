
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
public class  rentalinfobean{
public List<rentalinfo>list;  
public List<rentalinfo>getlist(){
    list=new ArrayList<>();
 
    try {
      
        Statement st;
        DBconnecter db=new DBconnecter();
        Connection connection = db.conMethod();
        st=connection.createStatement();
        ResultSet rs=st.executeQuery("select * from RENTALINFO");
        while(rs.next()){
        String NAME=rs.getString("NAME");
        String USERID=rs.getString("USERID");
        String PHONE=rs.getString("PHONE");
        String EMAIL=rs.getString("EMAIL");
        String CARID=rs.getString("CARID");
       
       


      list.add(new rentalinfo(NAME,USERID,PHONE,EMAIL,CARID));
 }
        
    } catch (SQLException ex) {
        Logger.getLogger(carlistbean.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}