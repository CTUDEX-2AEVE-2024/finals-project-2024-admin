package com.ctu.reservationportal.infrastructure;
import com.ctu.reservationportal.model.AdminInfo;

import java.util.Scanner;
public class EditAdminInfo {
    private final Scanner scanner;
    private final AdminInfo adminInfo;
    private final Validators validators;
    private boolean exitEditing;

    public EditAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
        this.scanner = new Scanner(System.in);
        this.validators = new Validators();
    }

    public void editAdminInfo() {
        boolean exitEditing = false;

        do {
            System.out.println("\nEDIT USER INFORMATION\n");

            // Print options for editing
            printEditOptions();

            System.out.print("Enter your choice (0 to exit editing): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    System.out.println("Exiting editing.");
                    RegistrationCode.displayRegistrationCode();
                    exitEditing = true; // Set flag to exit editing
                    break;
                case 1:
                    editField("First Name", this::editFirstName);
                    break;
                case 2:
                    editField("Middle Name", this::editMiddleName);
                    break;
                // Add cases for other fields
                case 3:
                    editField("Last Name", this::editLastName);
                    break;
                case 4:
                    editField("Birthdate", this::editBirthdate);
                    break;
                case 5:
                    editField("Email", this::editEmail);
                    break;
                case 6:
                    editField("Phone Number", this::editPhoneNumber);
                    break;
                case 7:
                    editField("Street", this::editStreet);
                    break;
                case 8:
                    editField("Barangay", this::editBarangay);
                    break;
                case 9:
                    editField("City", this::editCity);
                    break;
                case 10:
                    editField("Municipality", this::editMunicipality);
                    break;
                case 11:
                    editField("ZIP code", this::editZIPCode);
                    break;
                case 12:
                    editField("Gender", this::editGender);
                    break;
                case 13:
                    editField("Nationality", this::editNationality);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!exitEditing); // Continue editing until flag is set
    }

    // Method to print edit options
    private void printEditOptions() {
        System.out.println("What information do you want to edit?");
        System.out.println("1. First Name");
        System.out.println("2. Middle Name");
        System.out.println("3. Last Name");
        System.out.println("4. Birthdate");
        System.out.println("5. Email");
        System.out.println("6. Phone Number");
        System.out.println("7. Street");
        System.out.println("8. Barangay");
        System.out.println("9. City");
        System.out.println("10. Municipality");
        System.out.println("11. ZIP code");
        System.out.println("12. Gender");
        System.out.println("13. Nationality");
        System.out.println("0. Exit Editing\n");
    }

    // Method to edit a field
    private void editField(String fieldName, Runnable editMethod) {
        System.out.println("\nEditing " + fieldName);
        editMethod.run();
        System.out.println(fieldName + " updated successfully!\n");

        // Display updated details
        adminInfo.displayUserInfo();

        // Ask if user wants to continue editing
        System.out.print("Do you want to continue editing? (1 = Yes, 0 = No): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice == 0) {
            System.out.println("Exit editing.");
            RegistrationCode generatedCode = new RegistrationCode();
            RegistrationCode.displayRegistrationCode();
            exitEditing = true;
            CreateAccount.createAccount(

            );
        }
    }

    // Methods to edit individual fields
    private void editFirstName() {
        adminInfo.setFirstName(validateInput("First Name"));
    }

    private void editMiddleName() {
        adminInfo.setMiddleName(validateInput("Middle Name"));
    }

    private void editLastName() {
        adminInfo.setLastName(validateInput("Last Name"));
    }

    private void editBirthdate() {
        adminInfo.setBirthDate(validateInput("Birthdate"));
    }

    private void editEmail() {
        adminInfo.setEmail(validateInput("Email"));
    }

    private void editStreet() {
        adminInfo.setStreet(validateInput("Street"));
    }

    private void editBarangay() {
        adminInfo.setBarangay(validateInput("Barangay"));
    }

    private void editCity() {
        adminInfo.setCity(validateInput("City"));
    }

    private void editMunicipality() {
        adminInfo.setMunicipality(validateInput("Municipality"));
    }

    private void editZIPCode() {
        adminInfo.setZIPcode(Integer.parseInt(validateInput("ZIP code")));
    }

    private void editGender() {
        adminInfo.setGender(validateInput("Gender"));
    }

    private void editNationality() {
        adminInfo.setNationality(validateInput("Nationality"));
    }

    private void editPhoneNumber() {
        adminInfo.setPhoneNumber(validateInput("Phone Number"));
    }

    // Method to validate user input
    private String validateInput(String fieldName) {
        String userInput;
        boolean isValid;

        do {
            System.out.print("Enter new " + fieldName + ": ");
            userInput = scanner.nextLine();
            isValid = validators.isValidInput(fieldName, userInput);

            if (!isValid) {
                System.out.println("Invalid input. Please try again.");
            }

        } while (!isValid);

        return userInput;

    }
}
