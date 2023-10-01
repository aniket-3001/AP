public class Student extends Person {
    private double cgpa;
    private int start_year;
    private String residential_status; // onCampus or dayScholar

    public Student(String firstName, String lastName, int id, Address address, double cgpa, int start_year, String residential_address) {
        this.cgpa = cgpa;
        this.start_year = start_year;
        this.residential_status = residential_address;
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
        setAddress(address);
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getStart_year() {
        return start_year;
    }

    public String getResidential_status() {
        return residential_status;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setStartYear(int start_year) {
        this.start_year = start_year;
    }

    public void setResidential_status(String residential_status) {
        this.residential_status = residential_status;
    }

    public void goToWork() {
        if (getResidential_status().equals("dayScholar")) {
            System.out.println("vehicle");
        }
        else if (getResidential_status().equals("onCampus")) {
            System.out.println("walk");
        }
    }
}
