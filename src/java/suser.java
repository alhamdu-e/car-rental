
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="s")
@SessionScoped
public class suser {
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public suser() {
    }
     public List<signup> getSingleList() {
        return singleList;
    }

    public void setSingleList(List<signup> singleList) {
        this.singleList = singleList;
    }

    public List <signup> singleList;
    public List <signup> getsinglelist(){
    singleList = new ArrayList<>();
    try{
        
           DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();
          
             PreparedStatement ps = connection.prepareStatement("select * from USERTEBLE WHERE USER_ID=?");
               ps.setString(1, userid);
             ResultSet rs = ps.executeQuery();
          
                 while (rs.next()) {
                signup add = new signup();
              add.setUserid(rs.getString("USER_ID"));
              add.setName(rs.getString("NAME"));
              add.setPhone(rs.getString("PHONE"));
              add.setEmail(rs.getString("EMAIL"));
              add.setGeneder(rs.getString("GENEDER"));
              add.setAdress(rs.getString("ADRESS"));
              add.setCcard(rs.getString("CCARD"));
              add.setPass(rs.getString("PASS"));

                singleList.add(add);
            } 
             
    }catch( SQLException e)
    {
    
    
    }
    
    return singleList;
    }
    
}


