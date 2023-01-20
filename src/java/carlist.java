
public class carlist {
    private final String carid;
    private final String carmodel;
     private final String carbrand;
    private final String carprice;

    public carlist(String carid,String carmodel, String carbrand,  String carprice) {
        this.carid = carid;
        this.carmodel = carmodel;
        this.carbrand = carbrand;
        this.carprice = carprice;
    }

    public String getCarid() {
        return carid;
    }
      public String getCarmodel() {
        return carmodel;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public String getCarprice() {
        return carprice;
    }



}
