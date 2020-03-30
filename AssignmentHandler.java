/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.handlers;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mypackage.Assignment;
import mypackage.Trainer;

/**
 *
 * @author user
 */
public class AssignmentHandler {

    private static List<Assignment> assignments = new ArrayList<>();

    public static List<Assignment> getAssignments() {
        return assignments;
    }

    public static void addAssignment(Scanner input) {
        System.out.println("Please enter the title of the assignment");

        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the title again, using words only: ");
            input.next();
            continue;
        }
        String title = input.next();

        System.out.println("Please enter the description of the assignment.");

        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the desrption again, using words only: ");
            input.next();
            continue;
        }

        String description = input.next();

        System.out.println("Please enter the Date and time of the assignment submission.(for date in dd-MM-yyyy");
        String inputDateTime = input.next();

        System.out.println("Please enter the total mark of the assignment.");

        while (input.hasNext()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the total mark again, using numbers only: ");
            input.next();
            continue;
        }

        int totalMark = input.nextInt();
        System.out.println("Thank you");

        Assignment assignment = new Assignment(title, description, LocalDate.MIN, totalMark);
        assignment.setTitle(title);
        assignment.setDescription(description);
        assignment.setSubDateTime(inputDateTime);
        assignment.setTotalMark(totalMark);
        assignments.add(assignment);

    }

    public static void initialiseSyntheticAssignments() {
        assignments.add(new Assignment("Project 1", "My first Java application", LocalDate.of(2020, 3, 3), 100));
        assignments.add(new Assignment("Project 2", "HTML Project: Individual", LocalDate.of(2020, 2, 20), 100));
        assignments.add(new Assignment("Project 3", "Group project ", LocalDate.of(2020, 5, 31), 50));
        assignments.add(new Assignment("Project 4", "Final Project for Portfolio", LocalDate.of(2020, 5, 31), 100));
    }

    public static Assignment getAssignmentById(int id) {
        for (Assignment as : assignments) {
            if (as.getId() == id) {
                return as;
            }
        }
        return null;

    }

    public static void printAssignments() {
        for (Assignment as : assignments) {
            System.out.println(as);
        }
    }

    public static void printAssignments(List<Assignment> assignments) {
        for (Assignment as : assignments) {
            System.out.println(as);
        }
    }
}
