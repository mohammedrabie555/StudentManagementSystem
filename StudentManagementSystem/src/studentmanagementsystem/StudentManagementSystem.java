package studentmanagementsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystem implements CRUD{
    
    static Scanner s = new Scanner(System.in);
    static ArrayList<Student> student = new ArrayList<>();
    static Person person;
    private int numberOfStudents;
    
    // #1
    @Override
    public void add(){
        String firstName;
        String lastName;
        int age = 0;
        String address;
        boolean f = true;
        
        System.out.print("Enter student first name: ");
        firstName = s.nextLine();
        

        System.out.print("Enter student last name: ");
        lastName = s.nextLine();
        while(true){
            try{
                System.out.print("Enter student age: ");
                age = s.nextInt();
                s.nextLine();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Only numbers are allowed here!");
                s.next();
            }   
        }
        while(!(age > 0 && age < 30)){
            System.out.print("Age greater than 30 or less than or equal zero is not allowed!\n");
            while(true){
                try{
                    System.out.print("Please enter a valid age: ");
                    age = s.nextInt();
                    s.nextLine();
                    break;
                }
                catch(InputMismatchException e){
                    System.out.println("Only numbers are allowed here!");
                    s.next();
                }
            }
        }
        
        System.out.print("Enter student Address: ");
        address = s.nextLine();
        
        person = new Student(firstName,lastName,age,address);
        student.add((Student)person);
        
        System.out.print("\nStudent has been added!\n\n");
    }
    
    
    // #2
    public void addNewCourse(){
        String courseName = "";
        double studentCourseGrade = 0;
        int i;
        numberOfStudents = student.size();
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
                
            for (i = 0; i < numberOfStudents; i++) {
                if(student.get(i).course.isEmpty()){
                        int j;
                        for (j = 0; j < 3; ) {
        //                    System.out.println("Please add course #"+(j+1)+" to a student #"+(i+1)+": ");
        //                    System.out.println("""
        //                                       1. Computer Science
        //                                       2. Information System
        //                                       3. Online Educational Strategies
        //                                           """);
                                //prompt the user to choose the course
        //                        int choice = s.nextInt();
                                switch(j){
                                    case 0 -> {
                                        courseName = "Computer Science";
                                    }
                                    case 1 -> {
                                        courseName = "Information System";
                                    }
                                    case 2 -> {
                                        courseName = "Online Educational Strategies";
                                    }
        //                            default -> {
        //                                System.out.print("Invalid Option, Selecet the course again: ");
        //                                continue;
        //                            }
                                }
                            //setting the course name 
                            student.get(i).course.add(new Course(courseName));
                            System.out.print("Please enter the student #"+(i+1)+" grade for \""+courseName+"\" course: ");
                            while(true){
                                //setting grade for the course
                                while(true){
                                    try{
                                        studentCourseGrade = s.nextDouble();
                                        s.nextLine();
                                        break;
                                    }
                                    catch(InputMismatchException e){
                                        System.out.print("Invalid Grade! Enter again: ");
                                        s.next();
                                    }
                                }
                                while(!(studentCourseGrade > 0 && studentCourseGrade <= 100)){
                                    System.out.print("Invalid grade!, Enter grade again: ");
                                    while(true){
                                        try{
                                            studentCourseGrade = s.nextDouble();
                                            s.nextLine();
                                            break;
                                        }
                                        catch(InputMismatchException e){
                                            System.out.print("Invalid Grade! Enter again: ");
                                            s.next();
                                        }
                                    }
                                }
                                break;
                            }
                            student.get(i).course.get(j).setStudentCourseGrade(studentCourseGrade);
                            //display course info
                            System.out.println("\n"+courseName + " course has been added to student #"+(i+1)+" with grade: "+studentCourseGrade+"%\n");
                            j++;
                        }
                    }
                    else{
                        System.out.println("Student #"+(i+1)+" already registered to the courses"+"\n");
                    }
                }
        }
        for(int m = 0; m < numberOfStudents; m++){
        System.out.println("\nStudent #"+(m+1)+" courses: ");
            for (int j = 0; j < student.get(m).course.size(); j++) {
                System.out.println(student.get(m).course.get(j).getCourseName()+" course with grade: "+student.get(m).course.get(j).getStudentCourseGrade()+"%");
            }
        }
        System.out.println();
    }
    
    
    // #3
    @Override
    public void display() {
        numberOfStudents = student.size();
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{ 
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Student #" +(i+1)+ ": ");
                student.get(i).displayStudentInfo();
            }
        }
    }
    
    
    // #4
    @Override
    public void update() {
        int selectedStudent = 0;
        numberOfStudents = student.size();
        System.out.println("The current number of students in Database is: " + numberOfStudents);
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
            while(true){
            System.out.println("""
                               Here you can update the student info. 
                               1. Update student first name.
                               2. Update student last name.
                               3. Update student age.
                               4. Update student address.
                               5. Update student courses grades
                               6. Go to the main menu.
                               """);
                String choice = s.nextLine();
                switch(choice){
                    case "1" -> {
                        while(true){
                            System.out.print("Which student you want to update his first name: ");
                            while(true){    
                                try{
                                    selectedStudent = s.nextInt();
                                    s.nextLine();
                                    break;
                                }
                                catch(InputMismatchException e){
                                    System.out.print("Only numbers are allowed here! Enter a valid student: ");
                                    s.next();
                                }
                            }
                            if(selectedStudent > 0 && selectedStudent <= numberOfStudents){
                                System.out.println("The name before updating is: " + 
                                        student.get(selectedStudent-1).getFirstName()+" "+
                                        student.get(selectedStudent-1).getLastName()+
                                        "\nEnter the new first name: ");
                                student.get(selectedStudent-1).setFirstName(s.nextLine());
                                
                                System.out.println("The name after updating is: " + 
                                        student.get(selectedStudent-1).getFirstName()+" "+
                                        student.get(selectedStudent-1).getLastName()+"\n"+
                                        "------------------------------------------");
                                break;
                            }
                            
                            else{
                                System.out.println("Invalid student!");
                            }
                        }
                    }
                    case "2" -> {
                        while(true){
                            System.out.print("Which student you want to update his last name: ");
                            while(true){    
                                try{
                                    selectedStudent = s.nextInt();
                                    s.nextLine();
                                    break;
                                }
                                catch(InputMismatchException e){
                                    System.out.print("Only numbers are allowed here! Enter a valid student: ");
                                    s.next();
                                }
                            }
                            if(selectedStudent > 0 && selectedStudent <= numberOfStudents){
                                System.out.println("The name before updating is: " + 
                                        student.get(selectedStudent-1).getFirstName()+" "+
                                        student.get(selectedStudent-1).getLastName()+
                                        "\nEnter the new last name: ");
                                student.get(selectedStudent-1).setLastName(s.nextLine());
                                
                                System.out.println("The name after updating is: " + 
                                        student.get(selectedStudent-1).getFirstName()+" "+
                                        student.get(selectedStudent-1).getLastName()+"\n"+
                                        "------------------------------------------");
                                break;
                            }
                            else{
                                System.out.println("Invalid student!");
                            }
                        }
                    }
                    case "3" -> {
                        while(true){
                            int age;
                            System.out.print("Which student you want to update his age: ");
                            
                            while(true){    
                                try{
                                    selectedStudent = s.nextInt();
                                    s.nextLine();
                                    break;
                                }
                                catch(InputMismatchException e){
                                    System.out.print("Only numbers are allowed here! Enter a valid student: ");
                                    s.next();
                                }
                            }
                            
                            if(selectedStudent > 0 && selectedStudent <= numberOfStudents){
                                System.out.println("The age before updating is: " + 
                                        student.get(selectedStudent-1).getAge()+"\n"+ 
                                        "Enter the new age: ");
                                
                                while(true){    
                                    try{
                                        age = s.nextInt();
                                        s.nextLine();
                                        break;
                                    }
                                    catch(InputMismatchException e){
                                        System.out.print("Only numbers are allowe here! Enter a valid age: ");
                                        s.next();
                                    }
                                }
                                
                                while (!(age > 0 && age < 30)){
                                    System.out.println("Invalid age! Enter again");
                                    while(true){    
                                        try{
                                            age = s.nextInt();
                                            s.nextLine();
                                            break;
                                        }
                                        catch(InputMismatchException e){
                                            System.out.print("Only numbers are allowe here! Enter a valid age: ");
                                            s.next();
                                        }
                                    }
                                }
                                student.get(selectedStudent-1).setAge(age);
                                
                                System.out.println("The age after updating is: " + 
                                        student.get(selectedStudent-1).getAge()+"\n"+
                                        "------------------------------------------");
                                break;
                            }
                            
                            else{
                                System.out.println("Invalid student!");
                            }
                        }
                    }
                    case "4" -> {
                        while(true){
                            System.out.print("Which student you want to update his address: ");
                            
                            while(true){    
                                try{
                                    selectedStudent = s.nextInt();
                                    s.nextLine();
                                    break;
                                }
                                catch(InputMismatchException e){
                                    System.out.print("Only numbers are allowed here! Enter a valid student: ");
                                    s.next();
                                }
                            }
                            
                            if(selectedStudent > 0 && selectedStudent <= numberOfStudents){
                                System.out.println("The age before updating is: " + 
                                        student.get(selectedStudent-1).getAddress()+
                                        "\nEnter the new address: ");
                                student.get(selectedStudent-1).setAddress(s.nextLine());
                                
                                System.out.println("The age after updating is: " + 
                                        student.get(selectedStudent-1).getAddress()+"\n"+
                                        "------------------------------------------");
                                break;
                            }
                            else{
                                System.out.println("Invalid student!");
                            }
                        }
                    }
                    case "5" -> {
                        if(student.get(0).course.isEmpty()){
                            System.out.println("The courses has not been added yet! Please add new courses from the main menu.\n");
                        }
                        else{
                            boolean flag = true;
                            boolean flag1 = true;
                            while(flag){
                                System.out.print("Which student you want to update his courses grades: ");
                                
                                while(true){    
                                    try{
                                        selectedStudent = s.nextInt();
                                        s.nextLine();
                                        break;
                                    }
                                    catch(InputMismatchException e){
                                        System.out.print("Only numbers are allowed here! Enter a valid student: ");
                                        s.next();
                                    }
                                }
                                
                                if(selectedStudent > 0 && selectedStudent <= numberOfStudents){
                                    while(true){
                                        if(student.get(selectedStudent-1).course.isEmpty()){
                                            System.out.print("There are no courses for this student, "
                                                    + "Enter another student: ");
                                            
                                            while(true){    
                                                try{
                                                    selectedStudent = s.nextInt();
                                                    s.nextLine();
                                                    break;
                                                }
                                                catch(InputMismatchException e){
                                                    System.out.print("Only numbers are allowed here! Enter a valid student: ");
                                                    s.next();
                                                }
                                            }
                                            
                                        }
                                        else{
                                            break;
                                        }
                                    }
                                    while(flag1){
                                        System.out.println("\nnumber of courses: "+student.get(0).course.size());
                                        System.out.println("""
                                                           Select the course you want to update its grade
                                                           1. Computer Science
                                                           2. Information System
                                                           3. Online Educational Strategies
                                                           4. Go to the previous menu
                                                           """);
                                        
                                        String selectedCourse = s.nextLine();
                                        switch(selectedCourse){
                                            case "1" ->{
                                                updateCourseGrades(selectedStudent,0);
                                                break;
                                            }
                                            case "2" ->{
                                                updateCourseGrades(selectedStudent,1);
                                                break;
                                            }
                                            case "3" ->{
                                                updateCourseGrades(selectedStudent,2);
                                                break;
                                            }
                                            case "4" -> {
                                                flag1 = false;
                                            }
                                            default -> {
                                                System.out.println("Invalid course!");
                                            }
                                        }
                                    }
                                    flag = false;
                                }
                                else{
                                    System.out.println("Invalid student!");
                                }
                            }
                        }
                    }
                    case "6" -> {
                        return;
                    }
                }
            }
        }
    }
    public void updateCourseGrades(int selectedStudent, int courseNumber){
        double newStudentCourseGrade = 0;
        System.out.println("The old "+student.get(selectedStudent-1).course.get(courseNumber).getCourseName()+" course grade is: "+
                student.get(selectedStudent-1).course.get(courseNumber).getStudentCourseGrade()+"\n"+
                "Enter the new grade: ");
        while(true){
            try{
                newStudentCourseGrade = s.nextDouble();
                s.nextLine();
                break;
            }
            catch(InputMismatchException e){
                System.out.print("Only numbers are allowed here! Please Enter the new grade: ");
                s.next();
            }
        }
                                                
        while(!(newStudentCourseGrade >= 0 || newStudentCourseGrade <= 100)){
            System.out.println("Invalid grade, Enter the grade again");
            while(true){
                try{
                    newStudentCourseGrade = s.nextDouble();
                    s.nextLine();
                    break;
                }
                catch(InputMismatchException e){
                    System.out.print("Only numbers are allowed here! Please Enter the new grade: ");
                    s.next();
                }
            }
        }
        //assigning the entered grade to the setStudentCourse grade as an argument
        student.get(selectedStudent-1).course.get(2).
                setStudentCourseGrade(newStudentCourseGrade);
        System.out.println("The new \""+student.get(selectedStudent-1).course.get(courseNumber).getCourseName()+"\" course grade is: "+
                student.get(selectedStudent-1).course.get(2).getStudentCourseGrade());
    }
    
    // #5
    public void searchStudent(){
        numberOfStudents = student.size();
        ArrayList <String> search;
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
            while(true){
                System.out.println("""
                                   \n
                                   Search by: 
                                   1. First name.
                                   2. Last name.
                                   3. University ID.
                                   4. Go to the main menu.
                                   """);
                String choice = s.nextLine();
                switch(choice){
                    case "1" -> {
                        int studentCount = 0;
                        search = new ArrayList<>();
                        System.out.print("Enter the first name of a student you want to search for: ");
                        String searchedFirstName = s.nextLine();
                        
                        for (int i = 0; i < numberOfStudents; i++) {
                            if(student.get(i).getFirstName().equalsIgnoreCase(searchedFirstName)){
                                search.add(student.get(i).getFirstName()+" "+student.get(i).getLastName());
                                studentCount++;
                            }
                        }
                        if(studentCount > 0){
                            System.out.println(studentCount+" Student(s) found: \n"+search);
                        }
                        else{
                            System.out.println("No student(s) found with this name!");
                        }
                        search.clear();
                    }
                    case "2" -> {
                        int studentCount = 0;
                        search = new ArrayList<>();
                        System.out.print("Enter the last name of a student you want to search for: ");
                        String searchedLastName = s.nextLine();
                        
                        for (int i = 0; i < numberOfStudents; i++) {
                            if(student.get(i).getLastName().equalsIgnoreCase(searchedLastName)){
                                search.add(student.get(i).getFirstName()+" "+student.get(i).getLastName());
                                studentCount++;
                            }
                        }
                        if(studentCount > 0){
                            System.out.println(studentCount+" Student(s) found: \n"+search);
                        }
                        else{
                            System.out.println("No student(s) found with this name!");
                        }
                        search.clear();
                    }
                    case "3" -> {
                        int studentCount = 0;
                        search = new ArrayList<>();
                        System.out.print("Enter the university ID of a student you want to search for: ");
                        String universityID = s.nextLine();
                        
                        for (int i = 0; i < numberOfStudents; i++) {
                            if(student.get(i).getUniversityID().equals(universityID)){
                                search.add(student.get(i).getFirstName()+" "+
                                        student.get(i).getLastName()+
                                        ", university ID: "+student.get(i).getUniversityID());
                                studentCount++;
                            }
                        }
                        if(studentCount > 0){
                            System.out.println(studentCount+" Student(s) found: \n"+search);
                        }
                        else{
                            System.out.println("No student(s) found with this ID!");
                        }
                        search.clear();
                    }
                    case "4" -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid option!");
                    }
                }
            }
        }
    }
    
    // #6
    public void numberOfStudents(){
        System.out.println("Number of Students in Database: "+student.size()+"\n");
    }
    
    // #7
    @Override
    public void remove() {
        numberOfStudents = student.size();
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
            while(true){
                System.out.println("Number of students added is "+ student.size()+
                    "\nWhich one you want to remove: ");
                int removedStudent = s.nextInt();
                if(removedStudent > 0 && removedStudent <= numberOfStudents){
                    student.remove(student.get(removedStudent-1));
                    System.out.println("The selected student has been removed!\n");
                    break;
                }
                else{
                    System.out.println("Invalid student!");
                }
            }
        }
    }
    
    // #8
    void passedOrFailed() {
        numberOfStudents = student.size();
        
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{ 
            for(int i = 0; i < numberOfStudents; i++){
                System.out.println(student.get(i).getFirstName()+" "+student.get(i).getLastName()+": ");
                
                if(student.get(i).course.isEmpty()){
                    System.out.println("has no courses yet.\n---------------------------");
                }
                
                else{
                    for(int j = 0; j < student.get(i).course.size(); j++){
                        if(student.get(i).course.get(j).getStudentCourseGrade() > Course.MinimalSuccessGrade){
                            System.out.println(student.get(i).course.get(j).getCourseName()+
                                    ": "+student.get(i).course.get(j).getStudentCourseGrade()+" (Passed)");
                        }
                        else{
                            System.out.println(student.get(i).course.get(j).getCourseName()+
                                    ": "+student.get(i).course.get(j).getStudentCourseGrade()+" (Failed)");
                        }
                    }
                    System.out.println("----------------------------------");
                }
            }
            System.out.println();
        }
    }
    
    // #9
    public void highLowTotalGrades(){
        numberOfStudents = student.size();
        ArrayList <Double> totalGradesList = new ArrayList<>();
        
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
            if(student.get(0).course.isEmpty()){
                System.out.println("The courses has not been added yet! Please add new courses from the main menu.\n");
            }
            else{
                for(int i = 0; i < numberOfStudents; i++){
                    highAndLowTotalGrade(i, totalGradesList);
                }
                System.out.printf("The highest Total Grades is: %.2f%nThe lowest Total Grades is: %.2f%n%n",
                Collections.max(totalGradesList), 
                Collections.min(totalGradesList));
            }
        }
        totalGradesList.clear();
    }
    public void highAndLowTotalGrade(int i, ArrayList<Double>list){
        if(!student.get(i).course.isEmpty())
            list.add(student.get(i).getTotalGrades());
    }
    
    // #10
    public void highLowSpecificCourseGrade(){
        numberOfStudents = student.size();
        ArrayList <Double> list = new ArrayList<>();
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
            if(student.get(0).course.isEmpty()){
                System.out.println("The courses has not been added yet! Please add new courses from the main menu.\n");
            }
            else{
                boolean flag = true;
                int couresSeries = 0;
                while(flag){
                    System.out.println("""
                                       High and low courses grades: 
                                       1. Computer Science
                                       2. Information System
                                       3. Online Educational Strategies
                                       4. Go to main menu
                                       """);
                    String course = s.nextLine();
                    switch(course){
                        case "1" ->{
                            couresSeries = 0;
                            for (int i = 0; i < numberOfStudents; i++) {
                                highAndLowSpecificCourseGrade(i, couresSeries, list);
                            }
                            
                        }
                        case "2" ->{
                            couresSeries = 1;
                            for (int i = 0; i < numberOfStudents; i++) {
                                highAndLowSpecificCourseGrade(i, couresSeries, list);
                            }
                            
                        }
                        case "3" ->{
                            couresSeries = 2;
                            for (int i = 0; i < numberOfStudents; i++) {
                                highAndLowSpecificCourseGrade(i, couresSeries, list);
                            }
                            
                        }
                        case "4" ->{
                            return;
                        }
                        default ->{
                            System.out.println("Invalid Course!");
                        }
                    }
                    System.out.printf("The highest grade in "+student.get(0).course.get(couresSeries).getCourseName()+" course is: %.2f%n"
                        + "The lowest grade in "+student.get(0).course.get(couresSeries).getCourseName()+" course is: %.2f%n%n",
                    Collections.max(list), 
                    Collections.min(list));
                    list.clear();
                }
            }
        }
//        list.clear();
    }
    public void highAndLowSpecificCourseGrade(int i, int j, ArrayList<Double>list){
        if(!student.get(i).course.isEmpty())
            list.add(student.get(i).course.get(j).getStudentCourseGrade());
    }
    
    
    // #11
    public void highLowGPA(){
        numberOfStudents = student.size();
        ArrayList <Double> gpaList = new ArrayList<>();
        
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
            if(student.get(0).course.isEmpty()){
                System.out.println("The courses has not been added yet! Please add new courses from the main menu.\n");
            }
            else{
                for(int i = 0; i < numberOfStudents; i++){
                    if(!student.get(i).course.isEmpty())
                        gpaList.add(student.get(i).calculateGPA());
                }
                System.out.printf("%s%.2f%n%s%.2f%n%n","The highest cumulative GPA is: ",
                Collections.max(gpaList), "The lowest cumulative GPA is: ", Collections.min(gpaList));
            }
        }
        gpaList.clear();
    }
    
    // #12
    public void topTenStudents(){
        numberOfStudents = student.size();
        HashMap <String, Double> topTenStudents = new HashMap<>();
        if(student.isEmpty()){
            System.out.println("The student database is empty now, please add new students\n");
        }
        else{
            if(student.get(0).course.isEmpty()){
                System.out.println("The courses has not been added yet! Please add new courses from the main menu.\n");
            }
            else{
                for(int i = 0; i < numberOfStudents; i++){
                    if(!student.get(i).course.isEmpty()){
                        topTenStudents.put(student.get(i).getFirstName()+" "+student.get(i).getLastName()
                                , student.get(i).calculateGPA());
                    }
                }
//                topTenStudents.entrySet().stream()
//                .sorted(HashMap.Entry.<String, List<Double>>comparingByValue());

                //convert map to list
                List <Entry<String, Double>> list = new ArrayList<>(topTenStudents.entrySet());
                //sorting the new list
                list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
                //store the top 10 students into new list
                List <Entry<String, Double>> topList = list.subList(0, Math.min(10, list.size()));
                //loop through the sublist to print out the top 10
                for (Entry<String, Double> entry : topList) {
                    System.out.printf("%s, CGPA: %.2f%n",entry.getKey(),entry.getValue());
                }
                System.out.println();
            }
        }
        topTenStudents.clear();
    }

    
}
                