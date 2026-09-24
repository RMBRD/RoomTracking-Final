package xyz.dev.roomtracking.quarter2.PracExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class autoInput {
    @Test
    public void autoinput() {
        StringBuilder automatedInput = new StringBuilder(); // This creates a StringBuilder named "automatedInput"
        System.out.println("=== CREATING AUTO INPUT ===");
        automatedInput.append("Hello\n"); // 1st Keyboard input (PLACEHOLDER)
        automatedInput.append(", world\n"); // 2nd Keyboard input (PLACEHOLDER)
        System.out.println("=== AUTO INPUT CREATED===");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.toString().getBytes()); // This converts the String into automatedInput
        Scanner autoin = new Scanner(inputStream); // This creates a Scanner that contains inputStream. Its name is "autoin"
        // Use "public void start(Scanner autoin) {" to call the String.
        // the java class must be called  with "new 'java class name'().start(autoin);"
        MainMenu.start(autoin);
    }
}