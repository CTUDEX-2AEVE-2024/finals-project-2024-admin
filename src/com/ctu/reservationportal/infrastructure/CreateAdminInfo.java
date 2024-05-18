package com.ctu.reservationportal.infrastructure;

import com.ctu.reservationportal.dbservices.InsertRecords;
import com.ctu.reservationportal.model.AdminInfo;

import java.sql.Connection;
import java.util.Scanner;

/**
 * Class that contains processes for creating and inserting admin info unto the database
 */
public class CreateAdminInfo {

    /**
     * Prompts the user for input and validates it using a provided validator.
     *
     * @param scanner       Scanner object for input
     * @param promptMessage Message to display when prompting for input
     * @param validator     Validator for input validation
     * @return Validated user input
     */
    public static String promptForInput(Scanner scanner, String promptMessage, CreateAdminInfo.Validator validator) {
        String input;
        boolean isValid;
        do {
            System.out.print(promptMessage);
            input = scanner.nextLine();
            isValid = validator.isValid(input);
            if (!isValid) {
                System.out.println("Oops! Looks like there's a typo in there! " +
                        "Please input details correctly.");
            }
        } while (!isValid);
        return input;
    }

    //Interface for input validation
    interface Validator {

        // Classes implementing this interface must provide their own implementation of the isValid method
        boolean isValid(String input);
    }

    private Scanner scanner;
    private AdminInfo adminRegistration;

    // Constructor  to initialize the newly created object
    public CreateAdminInfo() {
        this.scanner = new Scanner(System.in);
        //  adminRegistration now refers as a new instance of AdminInfo
        adminRegistration = new AdminInfo();
    }

    /**
     *  This registerAdmin method returns AdminInfo
     */
    public AdminInfo registerAdmin() {

        /**
         * Prompts the user for input and validates it using a provided validator.
         *
         * @param scanner       Scanner object for input
         * @param promptMessage Message to display when prompting for input
         * @param validator     Validator for input validation
         * @return Validated user input
         */
        // Print welcome message and instructions for user registration
        System.out.println("\n              WELCOME TO PORTAL REGISTRATION!");
        System.out.println("Please CAPITALIZE every first letter of name inputs, " +
                "otherwise it won't be accepted.\n" +
                "Follow given formats for numbers."
        );
        System.out.println(" ");

        // Prompt for inputs and validates
        // Each detail is prompted for using the promptForInput method with appropriate validators
        //In the promptForInput method, Validators::isValidName is passed as an argument to indicate that the input provided by the user should be validated using the isValidName method defined in the Validators class.
        String firstName = promptForInput(scanner, "Enter First name: ", Validators::isValidName);
        adminRegistration.setFirstName(firstName);

        String middleName = promptForInput(scanner, "Enter Middle name: ", Validators::isValidName);
        adminRegistration.setMiddleName(middleName);

        String lastName = promptForInput(scanner, "Enter Last name: ", Validators::isValidName);
        adminRegistration.setLastName(lastName);

        String birthdate = promptForInput(scanner, "Enter Birthdate (YYYY-MM-DD): ", Validators::isValidDate);
        adminRegistration.setBirthDate(birthdate);

        String email = promptForInput(scanner, "Enter Email: ", Validators::isValidEmail);
        adminRegistration.setEmail(email);

        String phoneNumber = promptForInput(scanner, "Enter Phone Number (+63): ", Validators::isValidPhoneNumber);
        adminRegistration.setPhoneNumber(phoneNumber);

        String street = promptForInput(scanner, "Enter Street: ", Validators::isValidStreet);
        adminRegistration.setStreet(street);

        String barangay = promptForInput(scanner, "Enter Barangay: ", Validators::isValidLocation);
        adminRegistration.setBarangay(barangay);

        String municipality = promptForInput(scanner, "Enter Municipality: ", Validators::isValidLocation);
        adminRegistration.setMunicipality(municipality);

        String city = promptForInput(scanner, "Enter City: ", Validators::isValidLocation);
        adminRegistration.setCity(city);

        int zipcode = Integer.parseInt(promptForInput(scanner, "Enter ZIP Code: ", Validators::isValidZIPCode));
        adminRegistration.setZIPcode(zipcode);

        String nationality = promptForInput(scanner, "Enter Nationality: ", Validators::isValidName);
        adminRegistration.setNationality(nationality);

        String gender = promptForInput(scanner, "Enter Gender (M-Male|F-Female|N-Not to say): ", Validators::isValidGender);
        adminRegistration.setGender(gender);

        // Instantiation of AdminInfo class to access its variables and methods
        AdminInfo adminInfo = new AdminInfo ();

        adminInfo.setFirstName(firstName);
        adminInfo.setMiddleName(middleName);
        adminInfo.setLastName(lastName);
        adminInfo.setBirthDate(birthdate);
        adminInfo.setEmail(email);
        adminInfo.setPhoneNumber(phoneNumber);
        adminInfo.setStreet(street);
        adminInfo.setBarangay(barangay);
        adminInfo.setMunicipality(municipality);
        adminInfo.setCity(city);
        adminInfo.setZIPcode(zipcode);
        adminInfo.setNationality(nationality);
        adminInfo.setGender(gender);


        // Display the details provided during the registration process.
        System.out.println("\nDETAILS PROVIDED");

        System.out.println("First name: " + adminRegistration.getFirstName());
        System.out.println("Middle name: " + adminRegistration.getMiddleName());
        System.out.println("Last name: " + adminRegistration.getLastName());
        System.out.println("Birthdate: " + adminRegistration.getBirthdate());
        System.out.println("Email: " + adminRegistration.getEmail());
        System.out.println("Phone Number: " + adminRegistration.getPhoneNumber());
        System.out.println("\nHOME ADDRESS DETAILS");
        System.out.println("Street: " + adminRegistration.getStreet());
        System.out.println("Barangay: " + adminRegistration.getBarangay());
        System.out.println("Municipality: " + adminRegistration.getMunicipality());
        System.out.println("City: " + adminRegistration.getCity());
        System.out.println("ZIP Code: " + adminRegistration.getZIPcode());
        System.out.println("Nationality: " + adminRegistration.getNationality());
        System.out.println("Gender: " + adminRegistration.getGender());


        String roleAtSchool;
        do {
            System.out.print("\nEnter role at school (Teacher/Student/Staff): ");
            roleAtSchool = scanner.nextLine();
            adminRegistration.setRoleAtSchool(roleAtSchool);

            if (!roleAtSchool.equalsIgnoreCase("Teacher") &&
                    !roleAtSchool.equalsIgnoreCase("Student") &&
                    !roleAtSchool.equalsIgnoreCase("Staff")) {
                System.out.println("Invalid role. Please enter Teacher, Student, or Staff.");
            }
        } while (!roleAtSchool.equalsIgnoreCase("Teacher") &&
                !roleAtSchool.equalsIgnoreCase("Student") &&
                !roleAtSchool.equalsIgnoreCase("Staff"));
        adminInfo.setRoleAtSchool(roleAtSchool);

        // Instantiate the InsertRecords class
        InsertRecords insertRecords = new InsertRecords();
        //Call the insertUserRecord method of InsertRecords and pass the UserInfo object
        insertRecords.insertUserRecord(adminInfo);

        // Check if the user is a teacher
        if (roleAtSchool.equalsIgnoreCase("Teacher")) {
            System.out.println("\nWelcome to Teaching Details.");
            TeachingDetails teachingDetails = new TeachingDetails();
            teachingDetails.collectTeachingDetails(scanner);
        } else {
            // Call Check user detail
            CheckDetails.checkDetails(adminRegistration);
            // Call Edit user info
            EditAdminInfo edit = new EditAdminInfo(adminRegistration);
            edit.editAdminInfo();

            CreateAdminInfo createAdminInfo = new CreateAdminInfo();

            //Call create account
            CreateAccount.createAccount(scanner);

            //Call PreferredRole class
            PreferredRole.selectPreferRole(adminRegistration);

            // End the program after all actions are completed
            System.out.println("You have succesfully registered.");
            System.exit(0);
        }
        return this.adminRegistration;
    }
}




