import java.util.Comparator;

public class StudentCgpaComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        // Compare based on CGPA
        return Double.compare(s1.getCgpa(), s2.getCgpa());
    }
}