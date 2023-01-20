
public class rentalinfo {
   private final String name;
    private final String userid;
    private final String phone;
    private final String email;
    private final String carid;

    public rentalinfo(String name, String userid, String phone, String email, String carid) {
        this.name = name;
        this.userid = userid;
        this.phone = phone;
        this.email = email;
        this.carid = carid;
    }

    public String getName() {
        return name;
    }

    public String getUserid() {
        return userid;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCarid() {
        return carid;
    }
    

}
