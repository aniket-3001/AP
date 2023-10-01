import java.util.Comparator;

public class StudentDistanceComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        // Compare based on the distance from college pincode
        int distance1 = Math.abs(s1.getAddress().getPincode() - 110020);
        int distance2 = Math.abs(s2.getAddress().getPincode() - 110020);
        return Integer.compare(distance1, distance2);
    }
}