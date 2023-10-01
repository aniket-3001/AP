public class Address {
    private String area;
    private String city;
    private String state;
    private int pincode;

    public Address(String area, String city, String state, int pincode) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
