public class Main {
    public static void main(String[] args) {
       
        Student student = new Student("John Doe", "12345", "A");

        StudentView studentView = new StudentView();

        StudentController studentController = new StudentController(student, studentView);

        studentController.updateView();

        studentController.setStudentName("Jane Smith");
        studentController.setStudentId("67890");
        studentController.setStudentGrade("B");

        studentController.updateView();
    }
}
