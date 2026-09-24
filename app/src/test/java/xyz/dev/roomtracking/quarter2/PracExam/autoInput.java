package xyz.dev.roomtracking.quarter2.PracExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class autoInput {
    @Test
    public void autoInput() {
        StringBuilder automatedInput = new StringBuilder();
        int interactionCount = 1;
        while (interactionCount <= 3) {
            System.out.println("Generating inputs for interaction #" + interactionCount);
            // ADD REQUIRED INPUTS!! Back Input is for going back to Main Menu.
            if (interactionCount == 1) { //Login Inputs
                automatedInput.append("0\n"); // Back Input
            } else if (interactionCount == 2) { // Records Inputs
                automatedInput.append("0\n"); // Back Input
            } else if (interactionCount == 3){ // Alerts Inputs
                automatedInput.append("0\n"); // Back Input
            }else { // Program Close
                automatedInput.append("0\n");
            }
            interactionCount++;
        }
        ByteArrayInputStream simInput = new ByteArrayInputStream(automatedInput.toString().getBytes());

        Scanner autoin = new Scanner(simInput);

        MainMenu mainSystem = new MainMenu();

        mainSystem.start(autoin);
    }
}