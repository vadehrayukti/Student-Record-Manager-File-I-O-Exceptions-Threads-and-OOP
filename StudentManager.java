import java.util.*;

public class StudentManager {
    private final Map<Integer, Student> students = new HashMap<>();

    public boolean addStudent(Student s) {
        if (s == null) return false;
        Integer roll = s.getRollNo();
        if (students.containsKey(roll)) return false; // duplicate prevention
        students.put(roll, s);
        return true;
    }

   
    public boolean addFromInput(String rollStr, String name, String email, String course, String marksStr) {
        // Validate empty fields
        if (rollStr == null || rollStr.trim().isEmpty())
            throw new IllegalArgumentException("Roll No cannot be empty.");
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        if (email == null || email.trim().isEmpty() || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email.");
        if (course == null || course.trim().isEmpty())
            throw new IllegalArgumentException("Course cannot be empty.");
        if (marksStr == null || marksStr.trim().isEmpty())
            throw new IllegalArgumentException("Marks cannot be empty.");

        // Use wrapper classes for conversion (may throw NumberFormatException)
        Integer roll = Integer.valueOf(rollStr.trim());  // autoboxing/wrapper usage
        Double marks = Double.valueOf(marksStr.trim());

        // Validate marks range
        if (marks < 0.0 || marks > 100.0)
            throw new IllegalArgumentException("Marks must be between 0 and 100.");

        Student s = new Student(roll, name.trim(), email.trim(), course.trim(), marks);

        return addStudentWithLoading(s);
    }

    private boolean addStudentWithLoading(Student s) {
        // start loader thread
        Thread loaderThread = new Thread(new Loader("Loading", 5, 200));
        loaderThread.start();

        boolean added = addStudent(s);

        // Wait for loader to finish before proceeding
        try {
            loaderThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return added;
    }

   
    public Student findStudent(Integer roll) throws StudentNotFoundException {
        Student s = students.get(roll);
        if (s == null) throw new StudentNotFoundException("Student with roll " + roll + " not found.");
        return s;
    }


    public boolean deleteStudent(Integer roll) {
        return students.remove(roll) != null;
    }


    public int saveAllWithLoading() {
        Thread loaderThread = new Thread(new Loader("Saving", 6, 150));
        loaderThread.start();
        try {
            loaderThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return students.size();
    }

    public Collection<Student> getAllStudents() {
        return Collections.unmodifiableCollection(students.values());
    }
}
