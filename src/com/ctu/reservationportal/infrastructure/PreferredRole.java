package com.ctu.reservationportal.infrastructure;
import com.ctu.reservationportal.model.AdminInfo;

import java.util.Scanner;

/**
 * Class for selection of your preferred role in the portal
 */
public class PreferredRole {

    /**
     *A Method to select preferred role
     * and register user or admin
     */
    public static void selectPreferRole(String roleAtSchool, AdminInfo adminInfo) {
        Scanner scanner = new Scanner(System.in);
        int preferredRole;

        do {
            System.out.println("Enter Preferred Role (1 = User, 2 = Admin):");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter only 1 for User and 2 for Admin.");

                // Consumes the invalid input
                scanner.next();
            }
            preferredRole = scanner.nextInt();

            // Consumes the newline character
            scanner.nextLine();
        } while (preferredRole != 1 && preferredRole != 2);
        // Loop until valid email is entered

        {
            if (preferredRole == 1) {
                // Generate user ID number
                String idNumber = IDGenerator.generateRegistrationID();
                System.out.println("User ID number: " + idNumber);

                // Set user info
                adminInfo.setIDNumber(idNumber);

                // Admin registration
            } else if (preferredRole == 2) {

                // Generate admin ID number
                String idNumber = IDGenerator.generateRegistrationID();
                System.out.println("Admin ID number: " + idNumber);

                // Set admin info
                adminInfo.setIDNumber(idNumber);

            } else {
                System.out.println("Invalid role selected.");
            }

            // Executes the program
            System.out.println("End of execution. ");
            System.exit(0);
        }
    }
}
