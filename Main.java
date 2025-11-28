import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        try {
            // Collect input as strings to demonstrate wrapper conversions later
            System.out.print("Enter Roll No (Integer): ");
            String rollStr = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            String marksStr = sc.nextLine();

            try {
                boolean added = manager.addFromInput(rollStr, name, email, course, marksStr);
                if (!added) {
                    System.out.println("Error: Duplicate roll number. Student not added.");
                } else {
                    // display added student details 
                    Integer roll = Integer.valueOf(rollStr.trim());
            
                    Student s = manager.findStudent(roll); // may throw StudentNotFoundException
                    s.displayDetails();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error: Roll No and Marks must be numeric. " + nfe.getMessage());
            } catch (IllegalArgumentException iae) {
                System.out.println("Validation Error: " + iae.getMessage());
            } catch (StudentNotFoundException snfe) {
                System.out.println("Lookup Error: " + snfe.getMessage());
            }

            int total = manager.saveAllWithLoading();
            System.out.println("Total students saved: " + total);

        } finally {

            sc.close();
            System.out.println("Program execution completed.");
        }
    }
}
