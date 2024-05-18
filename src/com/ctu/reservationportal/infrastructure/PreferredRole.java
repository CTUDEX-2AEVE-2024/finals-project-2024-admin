package com.ctu.reservationportal.infrastructure;

import com.ctu.reservationportal.model.AdminInfo;

import java.util.Scanner;

// Import the IDGenerator class
import com.ctu.reservationportal.infrastructure.IDGenerator;

/**
 * Class that handles selection of preferred role in portal
 */
public class PreferredRole {

    /**
     * Method to select preferred role and register user or admin
     */
    public static void selectPreferRole(AdminInfo adminInfo) {
        Scanner scanner = new Scanner(System.in);
        int preferredRole;

        do {
            System.out.println("Enter Preferred Role (1 = User, 2 = Admin):");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please choose only between 1 for User and 2 for Admin.");
                scanner.next(); // Consume the invalid input
            }
            preferredRole = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } while (preferredRole != 1 && preferredRole != 2);

        if (preferredRole == 1) {
            // Calls the generateUserID from IDgenerator class
            String idNumber = IDGenerator.generateUserID();
            IDGenerator.displayID("User", idNumber);
            adminInfo.setIdNumber(String.valueOf(adminInfo.getIdNumber()));
        } else if (preferredRole == 2) {
            // Generate admin ID number
            String idNumber = IDGenerator.generateUserID();
            IDGenerator.displayID("Admin", idNumber);
            adminInfo.setIdNumber(String.valueOf(idNumber));
        } else {
            System.out.println("Invalid role selected.");
        }

        // Exit the program
        System.exit(0);
    }
}
