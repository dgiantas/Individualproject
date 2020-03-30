/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mypackage.Course;
import mypackage.Trainer;

/**
 *
 * @author user
 */
public class TrainerHandler {

    private static List<Trainer> trainers = new ArrayList<>();
    Trainer trainer = new Trainer();

    public static void addTrainer(Scanner input) {
        System.out.println("Please enter the first name of the trainer");
        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the first name again, using words only: ");
            input.next();

        }

        String firstName = input.next();

        System.out.println("Please enter the last name of the trainer.");
        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the last name again, using words only: ");
            input.next();

        }
        String lastName = input.next();

        System.out.println("Please enter the subject taught by the trainer.");

        while (input.hasNextInt()) {
            System.out.println("Invalid input!");
            System.out.print("Enter the subject again, using words only: ");
            input.next();
            continue;
        }

        String subject = input.next();

        System.out.println("Thank you");

        Trainer trainer = new Trainer(firstName, lastName, subject);
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setSubject(subject);
        trainers.add(trainer);

    }

    public static List<Trainer> getTrainers() {
        return trainers;
    }

    public static void setTrainers(List<Trainer> trainers) {
        TrainerHandler.trainers = trainers;
    }

    public static void initializeSyntheticTrainers() {
        trainers.add(new Trainer("Jonathan ", " Donaldson", "Introduction to Java"));
        trainers.add(new Trainer("Betty", "Hook", "HTML and CSS Fundamentals"));
        trainers.add(new Trainer("Helen-Josephine", "Scott", "Web programming with Javascript and Python"));
        trainers.add(new Trainer("Dorothy", "Chesnut", "PHP and MySQL for Designers"));
    }

    public static Trainer getTrainerById(int id) {
        for (Trainer tr : trainers) {
            if (tr.getId() == id) {
                return tr;
            }
        }
        return null;

    }

    public static void printTrainers() {
        for (Trainer tr : trainers) {
            System.out.println(tr);
        }
    }

    public static void printTrainers(List<Trainer> trainers) {
        for (Trainer tr : trainers) {
            System.out.println(tr);
        }
    }
}
