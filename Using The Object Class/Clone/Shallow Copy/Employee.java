public class Employee implements Cloneable {
    private int id;
    private String name;
    private Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address; // Shallow copy
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() { // Shallow copy
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name; // Shallow copy
    }

    public void setAddress(Address address) { // Shallow copy
        this.address = address;
    }

    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Employee{ " + "id= " + id + ", name= " + name + ", address= " + address + '}';
    }
}
