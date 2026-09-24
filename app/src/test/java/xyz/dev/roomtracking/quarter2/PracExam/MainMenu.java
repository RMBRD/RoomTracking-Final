package xyz.dev.roomtracking.quarter2.PracExam;

import java.util.Scanner;

public class MainMenu {
    public static void start(Scanner autoin) {
        System.out.println("=== ROOM TRACKING ===");
        System.out.println("1. Login");
        System.out.println("0. Exit");

        int choice = autoin.nextInt();
        System.out.println(choice);

        if (choice == 1) {
            Login.run(autoin);
        }else if (choice == 2) {
            Records.run(autoin);
        }else if (choice == 3) {
            Alerts.run(autoin);
        } else if (choice == 0){
            System.out.println("Program closed.");
        }
    }
}
