package studentmanagementsystem;

public class Course {
    private String courseName;
    private double studentCourseGrade;
    public static final int MinimalSuccessGrade = 51;

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getStudentCourseGrade() {
        return studentCourseGrade;
    }

    public void setStudentCourseGrade(double studentCourseGrade) {
        this.studentCourseGrade = studentCourseGrade;
    }
    
}
