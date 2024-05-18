package com.ctu.reservationportal.infrastructure;

import com.ctu.reservationportal.model.AdminInfo;

import java.util.Scanner;

/**
 * Class for handling username and password
 * for creation of accounnt
 */
public class CreateAccount {
    /**
     * Method for creating an account
     * 'AdminInfo' This is the return type of the method.
     * It suggests that this method will create an instance of the AdminInfo class and return it.
     * @param scanner
     * @return
     */
    public static AdminInfo createAccount(Scanner scanner) {
        String username, password, confirmPassword;
        AdminInfo adminInfo = new AdminInfo();

        // Prompt the user to enter a username
        username = promptForUsername(scanner);
        adminInfo.setUsername(username);

        // Do-while loop ensures the password and its confirmation are validated
        do {
            System.out.println("Password must be 8-20 characters long, contain uppercase, lowercase, digits, and special characters.");
            System.out.print("Password: ");
            password = scanner.nextLine();

            System.out.print("Confirm Password: ");
            confirmPassword = scanner.nextLine();

            // Check if passwords match
            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match. Please try again.");
            } else if (!Validators.isValidPassword(password)) { // Check if password meets complexity requirements
                System.out.println("Password does not meet complexity requirements. Please try again.");
            }
        } while (!password.equals(confirmPassword) || !Validators.isValidPassword(password));

        System.out.println("Congrats! You can now freely reserve preferred room.");

        // Call PreferRole.selectPreferRole() with the userInfo object
        PreferredRole.selectPreferRole(adminInfo);

        return adminInfo; // Return the populated AdminInfo object
    }


    /**
     * Prompts the user to enter a username.
     *
     * @param scanner The Scanner object to read user input.
     * @return The username entered by the user.
     */
    private static String promptForUsername(Scanner scanner) {
        System.out.print("Enter a Username: ");
        return scanner.nextLine();
    }
}
