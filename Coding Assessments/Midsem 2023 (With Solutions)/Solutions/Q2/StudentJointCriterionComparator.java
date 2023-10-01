import java.util.Comparator;

public class StudentJointCriterionComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        // Compare based on the joint criterion formula: compare on basis of distance - (6*cgpa)
        int distance1 = Math.abs(s1.getAddress().getPincode() - 110020);
        int distance2 = Math.abs(s2.getAddress().getPincode() - 110020);
        double criterion1 = distance1 - (6 * s1.getCgpa());
        double criterion2 = distance2 - (6 * s2.getCgpa());

        return Double.compare(criterion1, criterion2);
    }
}