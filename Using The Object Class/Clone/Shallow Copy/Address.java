class Address {
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
    public String toString() {
        return "Address{ " + "houseNo= " + houseNo + '}';
    }
}