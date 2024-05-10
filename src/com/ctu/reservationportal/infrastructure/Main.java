package com.ctu.reservationportal.infrastructure;
import com.ctu.reservationportal.model.AdminInfo;

import java.util.Scanner;

public class Main {
        public static String promptForInput(Scanner scanner, String promptMessage, Validator validator) {
            String input;
            boolean isValid;
            do {
                System.out.print(promptMessage);
                input = scanner.nextLine();
                isValid = validator.isValid(input);
                if (!isValid) {
                    System.out.println("Please input correctly.");
                }
            } while (!isValid);
            return input;
        }

        interface Validator {
            boolean isValid(String input);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            AdminInfo adminInfo = new AdminInfo();

            System.out.println("\n     WELCOME TO PORTAL REGISTRATION!");
            System.out.println("Please make sure that the first letter especially in names are capitalized " +
                    "unless it won't be accepted. \n");

            // Prompt for user details
            String firstName = promptForInput(scanner, "Enter First name: ", Validators::isValidName);
            adminInfo.setFirstName(firstName);

            String middleName = promptForInput(scanner, "Enter Middle name: ", Validators::isValidName);
            adminInfo.setMiddleName(middleName);

            String lastName = promptForInput(scanner, "Enter Last name: ", Validators::isValidName);
            adminInfo.setLastName(lastName);

            String birthdate = promptForInput(scanner, "Enter Birthdate (YYYY-MM-DD): ", Validators::isValidDate);
            adminInfo.setBirthDate(birthdate);

            String email = promptForInput(scanner, "Enter Email: ", Validators::isValidEmail);
            adminInfo.setEmail(email);

            // Prompt for phone number
            String phoneNumber = promptForInput(scanner, "Enter Phone Number: ", Validators::isValidPhoneNumber);
            adminInfo.setPhoneNumber(phoneNumber);

            String street = promptForInput(scanner, "Enter Street: ", Validators::isValidStreet);
            adminInfo.setStreet(street);

            String barangay = promptForInput(scanner, "Enter Barangay: ", Validators::isValidLocation);
            adminInfo.setBarangay(barangay);

            String municipality = promptForInput(scanner, "Enter Municipality: ", Validators::isValidLocation);
            adminInfo.setMunicipality(municipality);

            String city = promptForInput(scanner, "Enter City: ", Validators::isValidLocation);
           adminInfo.setCity(city);

            int zipcode = Integer.parseInt(promptForInput(scanner, "Enter ZIP Code: ", Validators::isValidZIPCode));
            adminInfo.setZIPcode(zipcode);

            String nationality = promptForInput(scanner, "Enter Nationality: ", Validators::isValidName);
            adminInfo.setNationality(nationality);

            String gender = promptForInput(scanner, "Enter Gender (Male/Female): ", Validators::isValidGender);
            adminInfo.setGender(gender);

            // Display the details provided by the user during the registration process.
            System.out.println("\nDETAILS PROVIDED");
            System.out.println("\nUSER DETAILS");
            System.out.println("First name: " + adminInfo.getFirstName());
            System.out.println("Middle name: " + adminInfo.getMiddleName());
            System.out.println("Last name: " + adminInfo.getLastName());
            System.out.println("Birthdate: " + adminInfo.getBirthdate());
            System.out.println("Email: " + adminInfo.getEmail());
            System.out.println("Phone Number: " + adminInfo.getPhoneNumber());
            System.out.println("\nHOME ADDRESS DETAILS");
            System.out.println("Street: " + adminInfo.getStreet());
            System.out.println("Barangay: " + adminInfo.getBarangay());
            System.out.println("Municipality: " + adminInfo.getMunicipality());
            System.out.println("City: " + adminInfo.getCity());
            System.out.println("ZIP Code: " + adminInfo.getZIPcode());

            System.out.println("\nUSER OTHER DETAILS");
            System.out.println("Nationality: " + adminInfo.getNationality());
            System.out.println("Gender: " + adminInfo.getGender());

            // Validation of role at school
            String RoleAtSchool;
            System.out.print("\nEnter role at school (Teacher/Student/Staff): ");
            RoleAtSchool = scanner.nextLine();
            adminInfo.setroleAtSchool(RoleAtSchool);

            // Check the role at school and validate it
            int choice = 0;
            if (RoleAtSchool.equalsIgnoreCase("Teacher")) {
                TeachingDetails teachingDetails = new TeachingDetails();
                teachingDetails.inputSubjectNames();
                // Generate registration code and verify
            } else if (RoleAtSchool.equalsIgnoreCase("Student") || RoleAtSchool.equalsIgnoreCase("Staff")) {
                System.out.println("\nSorry, only teachers are allowed in this portal.");
                // Execution of check details and skipping part
                System.out.println("\nProceeding to checking details...");
                // Direct to CheckDetails class for checking details logic...
                CheckDetails.checkDetails(adminInfo);
                // After checking, offer to edit details or proceed to registration code
                //  System.out.println("Do you want to edit your details? (1 = Yes, 2 = No): ");
                //int editChoice = Integer.parseInt(scanner.nextLine());
                // if (editChoice == 1) {
                EditAdminInfo edit = new EditAdminInfo(adminInfo);
                edit.editAdminInfo();


                // while (choice != 2) ;
                // Display registration code
                // RegistrationCode generatedCode = new RegistrationCode();
                //RegistrationCode.displayRegistrationCode();

                // Proceed to create account
                CreateAccount.createAccount();
            }
        }

    }

