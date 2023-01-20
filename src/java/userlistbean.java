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
public class userlistbean {
public List<userlist>list;  
public List<userlist>getlist(){
    list=new ArrayList<>();
 
    try {
      
        Statement st;
        DBconnecter db=new DBconnecter();
        Connection connection = db.conMethod();
        st=connection.createStatement();
        ResultSet rs=st.executeQuery("select * from USERTEBLE");
        while(rs.next()){
        String NAME=rs.getString("NAME");
        String EMAIL=rs.getString("EMAIL");
        String PHONE=rs.getString("PHONE");
        String GENDER=rs.getString("GENEDER");
        String ADRESS=rs.getString("ADRESS");
        String CCARD=rs.getString("CCARD");
        String PASS=rs.getString("PASS");
       String USERID=rs.getString("USER_ID");
       
        



      list.add(new userlist(NAME,EMAIL,PHONE,GENDER,ADRESS,CCARD,PASS,USERID));
 }
        
    } catch (SQLException ex) {
        Logger.getLogger(carlistbean.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
}