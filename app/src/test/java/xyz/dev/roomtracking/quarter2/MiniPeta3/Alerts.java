package xyz.dev.roomtracking.quarter2.MiniPeta3;

import java.util.Scanner;

public class Alerts {
    public static void run(Scanner autoin){
      
        String studentID = "";
        // this is to set the limited amount of days late or absent
        int maxAbsentDays = 3;
        int maxLateDays = 7;

        int daysAbsent = 4;
        int daysLate = 8;

        // for exceeding days of absence
        if (daysAbsent > maxAbsentDays) {
            System.out.println(studentID + ": To Be Reported to the SBMO for Absences.");
        } else if (daysAbsent == maxAbsentDays) {
            System.out.println(studentID + ": To Be Given Reminders.");
        } else {
            System.out.println();
        }


        // for exceeding days of tardiness
        if (daysLate > maxLateDays) {
            System.out.println(studentID + ": To Be Reported to the SBMO for Tardiness.");
        } else if (daysLate == maxLateDays) {
            System.out.println(studentID + ": To Be Given Reminders.");
        } else {
            System.out.println();
        }
    }
}





