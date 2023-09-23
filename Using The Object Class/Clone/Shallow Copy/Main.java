public class Main {
    public static void main(String[] args) {
        Address addr1 = new Address(311);
        Employee emp1 = new Employee(29, "Singh", addr1);
        Employee emp2 = emp1.clone();

        System.out.println("Before modification:");
        System.out.println(emp1);
        System.out.println(emp2);

        emp2.getAddress().setHouseNo(21);
        System.out.println();

        System.out.println("After modification");
        System.out.println(emp1);
        System.out.println(emp2);
    }
}
