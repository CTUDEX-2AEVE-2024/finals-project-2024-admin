package com.ctu.reservationportal.infrastructure;
import com.ctu.reservationportal.model.AdminInfo;

import java.util.Scanner;

public class CheckDetails {
        /*
         * @param userInfo The UserInfo object containing the user details.
         */
        public static void checkDetails(AdminInfo adminInfo) {
            Scanner scanner = new Scanner(System.in);
            boolean detailsConfirmed = false;

            do {
                System.out.println("** Checking Details **");
                System.out.println("Name: " + adminInfo.getFirstName() + " " + adminInfo.getMiddleName() + " " + adminInfo.getLastName());
                System.out.println("Birthdate: " + adminInfo.getBirthdate());
                System.out.println("Email: " + adminInfo.getEmail());
                System.out.println("HOME ADDRESS DETAILS");
                System.out.println("Home Address: " + adminInfo.getStreet() + ", " + adminInfo.getBarangay() + ", "
                        +adminInfo.getMunicipality() + ", " + adminInfo.getCity());
                System.out.println("ZIP code: " + adminInfo.getZIPcode());
                System.out.println("");
                System.out.println("USER OTHER DETAILS");
                System.out.println("Nationality: " +adminInfo.getNationality());
                System.out.println("Gender: " +adminInfo.getGender());

                // Prompt user for confirmation after checking
                System.out.println("Are the details correct?");
                System.out.println("1: Edit Details");
                System.out.println("2: Proceed to Registration Code");
                System.out.println("Please enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (choice == 2) {
                    System.out.println("Details confirmed. Proceeding to generate code.");
                    RegistrationCode generatedCode = new RegistrationCode();
                    generatedCode.displayRegistrationCode();
                    detailsConfirmed = true;

                    // Break out of the loop after displaying the registration code
                    break;
                } else if (choice == 1) {
                    // Call UserInfoEditor to edit user information
                    EditAdminInfo edit = new EditAdminInfo(adminInfo);
                    edit.editAdminInfo();
                } else {
                    System.out.println("Invalid choice.");
                }
            } while (!detailsConfirmed);
            CreateAccount.createAccount();
        }
}
