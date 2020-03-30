/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.handlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mypackage.Course;
import mypackage.Student;
import mypackage.Trainer;

/**
 *
 * @author user
 */
public class StudentHandler {

    private static List<Student> students = new ArrayList<>();

    public static List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students) {
        StudentHandler.students = students;
    }

    public static void addStudent(Scanner input) {

        System.out.println("Please enter the first name of the student");

        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter your first name again, using words only: ");
            input.next();
            continue;
        }
        String firstName = input.next();

        System.out.println("Please enter the last name of the student.");

        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter your last name again, using words only: ");
            input.next();
            continue;
        }
        String lastName = input.next();

        System.out.println("Please enter the Date of birth of the  student (in dd/MM/yyyy).");
        
        String birthDate = input.next();
        

        System.out.println("Please enter the tuition fees of the student.");
        while (input.hasNext()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the tuition fees again, using numbers only: ");
            input.next(); 
            continue;
           }
        int tuitionFees = input.nextInt();

        System.out.println("Thank you");

        Student student = new Student(firstName, lastName, DateOfBirth, tuitionFees);
        student.setFirstName(lastName);
        student.setFirstName(firstName);
        student.setTuitionFees(tuitionFees);
        student.setDateOfBirth(birthDate);
        students.add(student);

    }

    public static void initialiseSyntheticStudents() {
        students.add(new Student("Jacob", "Harries", LocalDate.of(1996, 2, 28), 1200));
        students.add(new Student("Katherine", "Morris", LocalDate.of(1991, 1, 1), 2500));
        students.add(new Student("Annie", "Cuthbert", LocalDate.of(1995, 5, 21), 1200));
        students.add(new Student("Filip", "Watson", LocalDate.of(1992, 4, 18), 2000));
        students.add(new Student("Finnegard", "Blackburn", LocalDate.of(1997, 12, 30), 2000));

    }

    public static Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;

    }

    public static List<Student> studentsWithMoreThanOneCourse() {
        List<Student> studentsWithMoreThanOneCourse = new ArrayList();
        for (Student st : students) {
            if (st.getCourseIds().size() > 1) {
                studentsWithMoreThanOneCourse.add(st);
            }
        }
        return studentsWithMoreThanOneCourse;

    }

    public static void printStudents() {
        for (Student st : students) {
            System.out.println(st);
        }
    }

    public static void printStudents(List<Student> students) {
        for (Student st : students) {
            System.out.println(st);
        }
    }

}
