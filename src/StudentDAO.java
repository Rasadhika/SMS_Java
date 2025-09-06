
import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        String query = "INSERT INTO students (id, name, age, course) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getCourse());
            stmt.executeUpdate();
            System.out.println(" Student added successfully!");
        } catch (SQLException e) {
            System.out.println(" Error adding student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return list;
    }

    public void updateStudent(int id, String name, int age, String course) {
        String query = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student not found!");
        } catch (SQLException e) {
            System.out.println(" Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted successfully!");
            else System.out.println("Student not found!");
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}


