import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student1 name: ");
        String student1_name = sc.nextLine();

        System.out.print("Enter student1 rollno: ");
        int student1_rollno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student2 name: ");
        String student2_name = sc.nextLine();

        System.out.print("Enter student2 rollno: ");
        int student2_rollno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter professor name: ");
        String professor_name = sc.nextLine();

        System.out.print("Enter professor experience: ");
        int professor_exp = sc.nextInt();
        sc.nextLine();

        Professor professor = new Professor(professor_name, professor_exp);

        Course course = new Course(student1_name, student1_rollno, student2_name, student2_rollno, professor);

        course.dispProf();
        course.dispStudents();

        sc.close();
    }
}
