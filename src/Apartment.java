public class Apartment {

    private String city;
    private int numOfRooms;
    private int areaOfAp;
    private int price;
    private String telephone;
    public Apartment(String city, int numOfRooms, int areaOfAp, int price, String telephone) {
        city = city;
        this.numOfRooms = numOfRooms;
        this.areaOfAp = areaOfAp;
        this.price = price;
        this.telephone = telephone;
    }
    public Apartment() {
       this.city = null;
        this.numOfRooms = 0;
        this.areaOfAp = 0;
        this.price = 0;
        this.telephone = null;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
       city = city;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public int getAreaOfAp() {
        return areaOfAp;
    }

    public void setAreaOfAp(int areaOfAp) {
        this.areaOfAp = areaOfAp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
