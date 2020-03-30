/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.handlers;

import java.time.LocalDate;
import java.time.Month;
import static java.time.Month.MARCH;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mypackage.Course;
import mypackage.Student;

/**
 *
 * @author user
 */
public class CourseHandler {

    private static List<Course> courses = new ArrayList<>();
    Course course = new Course();

    public static void addCourse(Scanner input) {
        System.out.println("Please enter the title of the course");
        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the title again, using words only: ");
            input.next();

        }
        String title = input.next();

        System.out.println("Please enter the stream of the course, e.g Java or C#");

        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the stream again, using words only: ");
            input.next();

        }
        String stream = input.next();

        System.out.println("Please enter the type of the course, full or part time.");

        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the type again, using words only: ");
            input.next();

        }
        String type = input.next();

        System.out.println("Please enter the start date (in dd/MM/yyyy)of the course.");
        String startDate2 = input.next();

        System.out.println("Please enter the end date (in dd/MM/yyyy) of the course.");
        String endDate2 = input.next();

        System.out.println("Thank you");

        Course course = new Course();

        course.setTitle(title);
        course.setStream(stream);
        course.setType(type);
        course.setStart_date(startDate2);
        course.setEnd_date(endDate2);

        courses.add(course);

    }

    public CourseHandler() {
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static void setCourses(List<Course> courses) {
        CourseHandler.courses = courses;
    }

    public static void initialiseSyntheticCourses() {
        courses.add(new Course("BN1", "Java", "full time", LocalDate.of(2020, 2, 10), LocalDate.of(2020, 1, 10)));
        courses.add(new Course("CB8", "Java", "full time", LocalDate.of(2020, 2, 20), LocalDate.of(2020, 03, 20)));
        courses.add(new Course(" CB9 ", " HTML ", "full time ", LocalDate.of(2020, 2, 2), LocalDate.of(2020, 2, 25)));
        courses.add(new Course(" CB11 ", " Javascript ", " full time ", LocalDate.of(2020, 2, 25), LocalDate.of(2020, 3, 1)));
        courses.add(new Course(" CB12 ", " Python ", " full time ", LocalDate.of(2020, 3, 4), LocalDate.of(2020, 4, 10)));
        courses.add(new Course("CB10", "SQUL", "full time", LocalDate.of(2020, 3, 15), LocalDate.of(2020, 5, 5)));
        courses.add(new Course("CB12", "CSS", " part time ", LocalDate.of(2020, 2, 3), LocalDate.of(2020, 2, 20)));
    }

    public static Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public static void printCourses() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public static void printCourses(List<Course> courrses) {
        for (Course c : courses) {
            System.out.println(c);
        }
    }

}
