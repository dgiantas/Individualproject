package mypackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import mypackage.handlers.AssignmentHandler;
import mypackage.handlers.CourseHandler;
import mypackage.handlers.GeneralHandler;
import static mypackage.handlers.GeneralHandler.addAssignmentToStudent;
import static mypackage.handlers.GeneralHandler.addStudentToCourse;
import static mypackage.handlers.GeneralHandler.addTrainerToCourse;
import static mypackage.handlers.GeneralHandler.studentsPerCourse;
import mypackage.handlers.StudentHandler;
import mypackage.handlers.TrainerHandler;

public class MainClass {

    public static void main(String[] args) {

        
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to load default data? \n(1) for Yes \n(2) for No");
        int choiceLoadData = input.nextInt();

        if (choiceLoadData == 1) {

            CourseHandler.initialiseSyntheticCourses();
            TrainerHandler.initializeSyntheticTrainers();
            AssignmentHandler.initialiseSyntheticAssignments();
            StudentHandler.initialiseSyntheticStudents();
            GeneralHandler.initializeSyntheticRelations();

        }

        int choice;
        int printListChoice;
        for (;;) {

            printMainMenu();

            choice = input.nextInt();

            if (choice == 1) {

                System.out.println("Good. Do you want to add another course? (1) for Yes (2) for No");
                int action = input.nextInt();
                if (action == 1) {
                    CourseHandler.addCourse(input);
                } else if (action == 2) {
                    continue;
                }

            } else if (choice == 2) {
                System.out.println("Good.Do you want to add another trainer? \n(1) for Yes \n(2) for No");
                int action = input.nextInt();
                if (action == 1) {
                    TrainerHandler.addTrainer(input);
                } else if (action == 2) {
                    continue;
                }

            } else if (choice == 3) {
                System.out.println("Good. Do you want to add another student?\n(1) for Yes \n(2) for No");
                int action = input.nextInt();
                if (action == 1) {
                    StudentHandler.addStudent(input);
                } else if (action == 2) {
                    continue;
                }

            } else if (choice == 4) {
                System.out.println("Good.Do you want to add another assignment?\n(1) for Yes \n(2) for No");
                int action = input.nextInt();

                if (action == 1) {
                    AssignmentHandler.addAssignment(input);
                } else if (action == 2) {
                    continue;
                }

            } else if (choice == 5) {

                    System.out.println("What do you want to do? \\n(1) Add student to course?\n"
                            + "                                    \\n(2) Add trainer to course?\n"
                            + "                                    \\n(3) Add assignment to course?\n"
                            + "                                    \\n(4)Add assignment to student?");

                 int addchoice = input.nextInt();

                if (addchoice == 1) {
                    System.out.println("Please enter the ID(number) of the student");
                    int studentId = input.nextInt();

                    System.out.println("Please enter the ID(number) of the course");
                    int courseId = input.nextInt();
                    addStudentToCourse(studentId, courseId);
                    

                } else if (addchoice == 2) {
                    System.out.println("Please enter the ID(number) of the trainer");
                    int trainerId = input.nextInt();

                    System.out.println("Please enter the ID(number) of the course");
                    int courseId = input.nextInt();
                    addTrainerToCourse(trainerId, courseId);

                } else if (addchoice == 3) {
                    System.out.println("Please enter the ID(number) of the student");
                    int studentId = input.nextInt();

                    System.out.println("Please enter the ID(number) of the assignment");
                    int assignmentId = input.nextInt();
                    addAssignmentToStudent(studentId, assignmentId);;

                } else if (choice == 6) {
                    do {

                        printLists();
                        printListChoice = input.nextInt();

                        if (printListChoice == 1) {
                            StudentHandler.printStudents();

                        } else if (printListChoice == 2) {
                            TrainerHandler.printTrainers();
                        } else if (printListChoice == 3) {
                            CourseHandler.printCourses();
                        } else if (printListChoice == 4) {
                            AssignmentHandler.printAssignments();
                        } else if (printListChoice == 5) {
                            System.out.println("Please enter the course Id");
                            int courseId = input.nextInt();
                            studentsPerCourse(courseId);
                            System.out.println("The list of students per course is: \n");
                            System.out.println("=======================================");
                            StudentHandler.printStudents(GeneralHandler.studentsPerCourse(courseId));
                        } else if (printListChoice == 6) {
                            System.out.println("Please enter the course Id ");
                            int courseId = input.nextInt();
                            System.out.println("The list of trainers per course:");
                            System.out.println("=======================================");
                            TrainerHandler.printTrainers(GeneralHandler.trainersPerCourse(courseId));
                        } else if (printListChoice == 7) {
                            System.out.println("Please enter the course Id");
                            int courseId = input.nextInt();
                            System.out.println("The list of assignments per course: \n");
                            System.out.println("=======================================");
                            AssignmentHandler.printAssignments(GeneralHandler.assignmentsPerCourse(courseId));
                        } else if (printListChoice == 8) {
                            System.out.println("Please enter Student Id.");
                            int studentId = input.nextInt();
                            System.out.println("The list of assignments per student: \n");
                            System.out.println("=======================================");
                            AssignmentHandler.printAssignments(GeneralHandler.assignmentsPerStudent(studentId));
                        } else if (printListChoice == 9) {
                            System.out.println("The list of assignments per student: \n");
                            System.out.println("=======================================");
                            StudentHandler.printStudents(StudentHandler.studentsWithMoreThanOneCourse());

                        } else if (printListChoice == 10) {
                            System.out.println("Please enter a date (dd/MM/yyyy");
                            String inputDate = input.next();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate givenDate = LocalDate.parse(inputDate, formatter);
                            System.out.println("The list of the students that must sumbmit one or more assignments on the same calendar week as the given date are ");
                            System.out.println("=======================================");
                            StudentHandler.printStudents(GeneralHandler.studentsWithAssignmentInGivenWeek(givenDate));
                        } else if (printListChoice == 11) {
                            System.out.println("Returning to main menu");
                            break;
                        }

                    } while (printListChoice != 11);

                } else if (choice == 6) {
                    System.out.println("Are you sure you want to exit?\n(1) for Yes \n(2) for No.");
                    int exitChoice = input.nextInt();
                    if (exitChoice == 1) {
                        System.out.println("Thank you for using the application.");
                        return;
                    }
                }

            }

        }

	
    }
    private static void printMainMenu() {
        System.out.println(
                "Welcome to the application of Athens School of Technology.\nWhat do you want to do? \nPlease choose: \n1.Insert Course \n2.Insert Trainer \n3.Insert Student \n4.Insert Assignment \n5.Print a list."
                + "\n 6.EXIT. ");

    }

    private static void printLists() {
        System.out.println(
                "Choose to print a list: \n(1)List of students \n(2)List of trainers \n(3)List of courses \n(4)List of assignments \n(5)List of students per course \n(6)List of trainers per course \n(7)List of assignments per course \n(8)List of assignments per student \n(9)List of students that belong to one or more courses \n(10)List of students who must submit one or more assignments on given date (dd/MM/yyyy)\n(11)Return to previous menu.");

    }

}
