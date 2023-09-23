class Address implements Cloneable {
    private int houseNo;

    public Address(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Address{ " + "houseNo= " + houseNo + '}';
    }
}