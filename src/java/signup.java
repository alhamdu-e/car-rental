
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped


public class signup {
    private String name;
    private String phone;
    private String email;
    private String adress;
    private String ccard;
    private String pass;
    private String userid;

     private String geneder;
     List<String> genderList;
    

    
    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }
     public String getGeneder() {
        return geneder;
    }

    public void setGeneder(String geneder) {
        this.geneder = geneder;
    }
    public signup() {
         genderList = new ArrayList<>();
         genderList.add("Male");
        genderList.add("Female");

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCcard() {
        return ccard;
    }

    public void setCcard(String ccard) {
        this.ccard = ccard;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
     

 public void userregister() {
        try {
            signup s=new signup();
            DBconnecter db=new DBconnecter();
             Connection connection = db.conMethod();
        PreparedStatement stmt=connection.prepareStatement("Insert into USERTEBLE(name,email,phone,geneder,adress,ccard,pass,USER_ID) values (?,?,?,?,?,?,?,?)");     
        stmt.setString(1,name);  
        stmt.setString(2,email);  
        stmt.setString(3,phone);  
        stmt.setString(4,geneder);  
        stmt.setString(5,adress); 
         stmt.setString(6,ccard); 
         stmt.setString(7,pass);  
         stmt.setString(8,userid);  


       stmt.executeUpdate();  
        }
        catch (SQLException e) {
        }
    }

   }