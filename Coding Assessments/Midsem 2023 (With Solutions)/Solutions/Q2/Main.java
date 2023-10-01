import java.util.List;

public class Main {
    public static void main(String[] args) {
        Address a1 = new Address("Anand Niketan", "New Delhi", "Delhi", 110021);
        Address a2 = new Address("Sector 62", "Noida", "Uttar Pradesh", 201309);
        Address a3 = new Address("Sector 23", "Gurugram", "Haryana", 122022);
        Address a4 = new Address("Sector 125", "Noida", "Uttar Pradesh", 201313);
        Address a5 = new Address("Sector 62", "Noida", "Uttar Pradesh", 201309);

        Student s1 = new Student("Rahul", "Kumar", 1, a1, 9.5, 2018, "dayScholar");
        Student s2 = new Student("Rohit", "Kumar", 2, a2, 9.0, 2018, "dayScholar");
        Student s3 = new Student("Raj", "Kumar", 3, a3, 8.5, 2018, "dayScholar");
        Student s4 = new Student("Ravi", "Kumar", 4, a4, 8.0, 2018, "dayScholar");
        Student s5 = new Student("Rakesh", "Kumar", 5, a5, 7.5, 2018, "dayScholar");

        List<Student> students = new java.util.ArrayList<>(List.of(s1, s2, s3, s4, s5));

        // we use the StudentDistanceComparator class to sort the students by their distance from the college, and print the data
        // then we use the StudentCgpaComparator class to sort the students by their cgpa, and print the data
        // finally, we use the StudentJointCriterionComparator class to sort the students by their distance from the college, and then by their cgpa, print the data, and make the first 3 students onCampus

        System.out.println();

        System.out.println("Sorting by distance from college:");
        // sort the students by their distance from the college here
        students.sort(new StudentDistanceComparator());

        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getResidential_status());
        }

        System.out.println();

        System.out.println("Sorting by cgpa:");
        // sort the students by their cgpa here
        students.sort(new StudentCgpaComparator());

        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getResidential_status());
        }

        System.out.println();

        System.out.println("Sorting by joint criterion:");
        // sort the students by their joint criterion here
        students.sort(new StudentJointCriterionComparator());

        // now we make the first 3 students onCampus
        for (int i = 0; i < 3; i++) {
            students.get(i).setResidential_status("onCampus");
        }

        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getResidential_status());
        }
    }
}