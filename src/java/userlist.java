
public class userlist {
    private final String name;
    private final String gender;
    private final String mobile;
    private final String adress;
    private final String email;
    private final String ccard;
    private final String userid;
    private final String pass;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public String getCcard() {
        return ccard;
    }
      public String getPass() {
        return pass;
    }

    public String getUserid() {
        return userid;
    }

  

    public userlist(String name,String email,String mobile, String gender,  String adress,  String ccard, String pass,String userid ) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.adress = adress;
        this.ccard = ccard;
        this.pass = pass;
       this.userid = userid;
    }
    

}
