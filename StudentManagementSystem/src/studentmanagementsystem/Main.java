/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author GAMING STORE
 */
public class Main {
    static StudentManagementSystem sms = new StudentManagementSystem();
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        // TODO code application logic here
        System.out.println("Welcome to the Student Management System in UoPeople: ");
        while(true){
            System.out.println("""
                               1. Add new student
                               2. Add courses to a student
                               3. Display Student info
                               4. Update student info 
                               5. Search for a student
                               6. Number of Students in Database
                               7. Remove student
                               8. Passed or Failed
                               9. Display highest and lowest Total grades
                               10. Display highest and lowest grade for a specific course
                               11.Display highest and lowest cGPA in the college
                               12.Top 10 students 
                               13.Exit \n""");
            String op = s.nextLine();
            switch(op){
                case "1"->{
                    sms.add();
                }
                case "2"->{
                    sms.addNewCourse();
                }
                case "3"->{
                    sms.display();
                }
                case "4"->{
                    sms.update();
                }
                case "5"->{
                    sms.searchStudent();
                }
                case "6"->{
                    sms.numberOfStudents();
                }
                case "7"->{
                    sms.remove();
                }
                case "8"->{
                    sms.passedOrFailed();
                }
                case "9"->{
                    sms.highLowTotalGrades();
                }
                case "10"->{
                    sms.highLowSpecificCourseGrade();
                }
                case "11"->{
                    sms.highLowGPA();
                }
                case "12" ->{
                    sms.topTenStudents();
                }
                case "13" ->{
                    return;
                }
                default ->{
                    System.out.println("Invalid option\n");
                }
            }
        }
    }
}
