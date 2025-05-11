import java.sql.*;
import java.util.Scanner;

public class StudentDatabaseApp {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database successfully!");
            
            Scanner scanner = new Scanner(System.in);
            int choice;
            
            do {
                System.out.println("\nStudent Database Operations");
                System.out.println("1. Display All Students");
                System.out.println("2. Add New Student");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1:
                        displayStudents(connection);
                        break;
                    case 2:
                        addStudent(connection, scanner);
                        break;
                    case 3:
                        updateStudent(connection, scanner);
                        break;
                    case 4:
                        deleteStudent(connection, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 5);
            
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
    
    // A. Select all students
    private static void displayStudents(Connection connection) throws SQLException {
        String query = "SELECT * FROM student";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            System.out.println("\nStudent Records:");
            System.out.println("ID\tName\tAge\tGrade\tEmail");
            System.out.println("----------------------------------");
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                String email = resultSet.getString("email");
                
                System.out.printf("%d\t%s\t%d\t%s\t%s\n", id, name, age, grade, email);
            }
        }
    }
    
    // B. Insert a new student
    private static void addStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("\nEnter Student Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Grade: ");
        String grade = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        String query = "INSERT INTO student (name, age, grade, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, grade);
            preparedStatement.setString(4, email);
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added successfully!");
            } else {
                System.out.println("Failed to add student.");
            }
        }
    }
    
    // C. Update a student
    private static void updateStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("\nEnter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Check if student exists
        if (!studentExists(connection, id)) {
            System.out.println("Student with ID " + id + " does not exist.");
            return;
        }
        
        System.out.println("Enter new details (leave blank to keep current value):");
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Age: ");
        String ageInput = scanner.nextLine();
        Integer age = ageInput.isEmpty() ? null : Integer.parseInt(ageInput);
        
        System.out.print("Grade: ");
        String grade = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        // Build the update query dynamically based on provided fields
        StringBuilder queryBuilder = new StringBuilder("UPDATE student SET ");
        boolean needsComma = false;
        
        if (!name.isEmpty()) {
            queryBuilder.append("name = ?");
            needsComma = true;
        }
        
        if (age != null) {
            if (needsComma) queryBuilder.append(", ");
            queryBuilder.append("age = ?");
            needsComma = true;
        }
        
        if (!grade.isEmpty()) {
            if (needsComma) queryBuilder.append(", ");
            queryBuilder.append("grade = ?");
            needsComma = true;
        }
        
        if (!email.isEmpty()) {
            if (needsComma) queryBuilder.append(", ");
            queryBuilder.append("email = ?");
        }
        
        queryBuilder.append(" WHERE id = ?");
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString())) {
            int paramIndex = 1;
            
            if (!name.isEmpty()) {
                preparedStatement.setString(paramIndex++, name);
            }
            
            if (age != null) {
                preparedStatement.setInt(paramIndex++, age);
            }
            
            if (!grade.isEmpty()) {
                preparedStatement.setString(paramIndex++, grade);
            }
            
            if (!email.isEmpty()) {
                preparedStatement.setString(paramIndex++, email);
            }
            
            preparedStatement.setInt(paramIndex, id);
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Failed to update student.");
            }
        }
    }
    
    // D. Delete a student
    private static void deleteStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("\nEnter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        String query = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with ID " + id);
            }
        }
    }
    
    // Helper method to check if student exists
    private static boolean studentExists(Connection connection, int id) throws SQLException {
        String query = "SELECT id FROM student WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}