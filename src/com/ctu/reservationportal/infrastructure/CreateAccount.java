package com.ctu.reservationportal.infrastructure;
import java.util.Scanner;

public class CreateAccount {
    public static void createAccount () {
        /**
         * Allows users to create an account by providing a username and password.
         * Prompts the user to enter a username, password, and confirm the password.
         * Checks if the passwords match and displays a success message upon successful registration.
         * @param args The command-line arguments.
         */
        Scanner scanner = new Scanner(System.in);
        String username, password, confirmPassword;

        do {
            System.out.println("Create an Account");
            System.out.print("Username: ");
            username = scanner.nextLine();

            do {
                System.out.print("Password: ");
                password = scanner.nextLine();

                System.out.print("Confirm Password: ");
                confirmPassword = scanner.nextLine();

                if (!password.equals(confirmPassword)) {
                    System.out.println("Passwords do not match. Please try again.");
                }
            } while (!password.equals(confirmPassword)); // Loop for password confirmation

            System.out.println("Congrats! You can now freely reserve preferred room.");
            break; // Exit the loop after successful registration

        } while (true); // Loop continues until passwords match

        scanner.close(); // Close the Scanner
    }

}
