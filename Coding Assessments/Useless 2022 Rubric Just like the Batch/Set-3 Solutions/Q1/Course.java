public class Course {
    private Professor professor;
    private Student[] students = new Student[2];

    public Course(String student1_name, int student1_rollno, String student2_name, int student2_rollno, Professor professor) {
        this.professor = professor;
        this.students[0] = new Student(student1_name, student1_rollno);
        this.students[1] = new Student(student2_name, student2_rollno);
    }

    public Professor getProfessor() {
        return professor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void dispProf() {
        System.out.println(professor);
    }

    public void dispStudents() {
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
