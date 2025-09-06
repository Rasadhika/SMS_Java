import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    dao.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int uage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String ucourse = sc.nextLine();
                    dao.updateStudent(uid, uname, uage, ucourse);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

