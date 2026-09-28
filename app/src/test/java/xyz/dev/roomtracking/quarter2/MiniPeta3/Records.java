package xyz.dev.roomtracking.quarter2.MiniPeta3;

import java.util.Scanner;

public class Records {
    public static void run(Scanner autoin) {
        ;


        System.out.print("Enter Student ID: ");
        String studentID = autoin.nextLine();
        //DWADASDADdwd
        System.out.print("Enter Student Name: ");
        String studentName = autoin.nextLine();

        System.out.print("Enter Grade Level: ");
        String gradeLevel = autoin.nextLine();

        System.out.print("Is the student record active? (Yes/No): ");
        String activeInput = autoin.nextLine();

        // Safely converts "Yes" (case-insensitive) to true, anything else to false
        boolean isActive = activeInput.trim().equalsIgnoreCase("Yes");

        System.out.println("\n--- Student Records Details Captured ---");
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Active Record: " + isActive);

        MainMenu.start(autoin);

    }
}


