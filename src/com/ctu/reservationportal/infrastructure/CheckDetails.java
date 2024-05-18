package com.ctu.reservationportal.infrastructure;
import com.ctu.reservationportal.model.AdminInfo;

import java.util.Scanner;

/**
 * Class for checking the provided details of an admin
 */
public class CheckDetails {

    /**
     * Method responsible for checking provided details
     * @param adminInfo which is the AdminInfo object containing the admin details.
     */
    public static void checkDetails(AdminInfo adminInfo) {
        Scanner scanner = new Scanner(System.in);
        boolean detailsConfirmed = false;

        /**
         * Displays the admin details for confirmation
         * Uses the object created from AdminInfo class
         * to access the details provided by using the getter methods
         */
        do {
            // System.out.println("* Sorry you are not allowed in this portal*");
            System.out.println("/nCheck the details you have provided.");
            System.out.println("Name: " + adminInfo.getFirstName() + " " + adminInfo.getMiddleName() + " " + adminInfo.getLastName());
            System.out.println("Birthdate: " + adminInfo.getBirthdate());
            System.out.println("Email: " + adminInfo.getEmail());
            System.out.println("Home Address: " + adminInfo.getStreet() + ", " + adminInfo.getBarangay() + ", "
                    + adminInfo.getMunicipality() + ", " + adminInfo.getCity());
            System.out.println("ZIP code: " + adminInfo.getZIPcode());
            System.out.println("");
            System.out.println("Nationality: " + adminInfo.getNationality());
            System.out.println("Gender: " + adminInfo.getGender());

            /**
             * Prompts to choose if you are going to edit your details
             * or you will proceed to registration code
             * after the details are confirmed
             */
            System.out.println("Are the details correct?");
            System.out.println("1: Edit Details");
            System.out.println("2: Proceed to Registration Code");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();

            // Consume newline character
            scanner.nextLine();

            if (choice == 2) {  // Proceed to generating registration code
                System.out.println("Details confirmed. Proceeding to Registration Code.");
                RegistrationCode generatedCode = new RegistrationCode();
                generatedCode.displayRegistrationCode();
                detailsConfirmed = true;

                /*If the Registration code is correct
                Proceed to create an account */
                CreateAccount.createAccount(scanner);

                /* After creating an account
                Redirect to the PreferredRole class */
                PreferredRole.selectPreferRole(adminInfo);

                // Break out of the loop after displaying the registration code
                break;

                // Edit admin information if choice is 1
            } else if (choice == 1) {

                // Calls the EditAdminInfo to edit details/information
                EditAdminInfo edit = new EditAdminInfo (adminInfo);
                edit.editAdminInfo();
            } else {
                System.out.println("Invalid choice.");
            }

            // Repeats the process until all the details are confirmed
        } while (!detailsConfirmed);
    }
}