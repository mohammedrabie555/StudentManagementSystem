package studentmanagementsystem;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Student extends Person{
    private double cGPA;
    private double totalGrades;
    static int studentSerialNumber = 0;
    String universityID = "2024" + (studentSerialNumber + 1);
    ArrayList <Course> course = new ArrayList<>();
    
    public Student(String firstName, String lastName, int age, String address) {
        super(firstName, lastName, age, address);
        studentSerialNumber++;
    }

//    public String getUniversityID() {
//        universityID = studentSerialNumber;
//        return "2024"+universityID;
//    }

//    public void setUniversityID() {
//        universityID = studentSerialNumber;
//    }

    public double getTotalGrades() {
        if(course.isEmpty()){
            return 0;
        }
        else{
            this.totalGrades = 0;
            for (int i = 0; i < course.size(); i++){
                this.totalGrades += course.get(i).getStudentCourseGrade();
            }
            return this.totalGrades;
        }
    }

    public double calculateGPA(){
        if(course.isEmpty()){
            return 0;
        }
        else{
            cGPA = 0;
            double gpa;
            for (int i = 0; i < course.size(); i++) {
                if(course.get(i).getStudentCourseGrade() >= 94)
                    gpa = 4.0;
                else if(course.get(i).getStudentCourseGrade() >= 90)
                    gpa = 3.7;
                else if(course.get(i).getStudentCourseGrade() >= 87)
                    gpa = 3.3;
                else if(course.get(i).getStudentCourseGrade() >= 83)
                    gpa = 3.0;
                else if(course.get(i).getStudentCourseGrade() >= 80)
                    gpa = 2.7;
                else if(course.get(i).getStudentCourseGrade() >= 77)
                    gpa = 2.3;
                else if(course.get(i).getStudentCourseGrade() >= 73)
                    gpa = 2.0;
                else if(course.get(i).getStudentCourseGrade() >= 70)
                    gpa = 1.7;
                else if(course.get(i).getStudentCourseGrade() >= 67)
                    gpa = 1.3;
                else if(course.get(i).getStudentCourseGrade() >= 63)
                    gpa = 1.0;
                else if(course.get(i).getStudentCourseGrade() >= 60)
                    gpa = 0.7;
                else{
                    gpa = 0.0;
                }
                cGPA+=gpa;
            }
            return cGPA/course.size();
        }
    }
//    public void setCGPA(double cGPA) {
//        this.cGPA = cGPA;
//    }
    
    public String getUniversityID(){
        return universityID;
    }

    @Override
    public void displayStudentInfo() {
        super.displayStudentInfo();
        System.out.printf("%s%s%n%s%.2f%n%s%.2f%n%s%n",
        "University ID  : ", getUniversityID(),
        "Total Grades   : ", getTotalGrades(),
        "Cumulative GPA : ", calculateGPA(),
        "----------------------------------------"
        );
    }
}
