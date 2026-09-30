package xyz.dev.roomtracking.quarter2.MiniPeta3;

import java.util.Scanner;

public class Login {
    public static void run(Scanner autoin) {

        System.out.print("Enter Username: ");
        String username = autoin.next();

        System.out.print("Enter Password: ");
        String password = autoin.next();

        if (username.equals("admin") && password.equals("1234")) {

            System.out.println("Login Successful!");
            System.out.println("Welcome, Admin!");

        } else if (username.equals("Student") && password.equals("1234")) {

            System.out.println("Login Successful!");
            System.out.println("Welcome, Student!");

        } else {

            System.out.println("Login Failed!");
            System.out.println("Invalid Username or Password");

            MainMenu.start(autoin);
        }
    }
}
