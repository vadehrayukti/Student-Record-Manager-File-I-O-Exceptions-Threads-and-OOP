
public class Student {
    private Integer rollNo;      // wrapper type
    private String name;
    private String email;
    private String course;
    private Double marks;        // wrapper type
    private String grade;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    public Integer getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public Double getMarks() { return marks; }
    public String getGrade() { return grade; }

    public void setMarks(Double marks) {
        this.marks = marks;
        this.grade = calculateGrade();
    }

    private String calculateGrade() {
        double m = (marks == null) ? 0.0 : marks.doubleValue();
        if (m >= 90) return "A";
        if (m >= 75) return "B";
        if (m >= 60) return "C";
        return "D";
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    @Override
    public String toString() {
        return "Student{" + "rollNo=" + rollNo + ", name='" + name + '\'' +
                ", email='" + email + '\'' + ", course='" + course + '\'' +
                ", marks=" + marks + ", grade='" + grade + '\'' + '}';
    }
}
