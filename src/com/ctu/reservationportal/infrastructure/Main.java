package com.ctu.reservationportal.infrastructure;
import com.ctu.reservationportal.model.AdminInfo;
import java.util.Scanner;

/**
* Main class for account registration
*/
public class Main {
    /**
     * Prompts the user for input and validates it using a provided validator.
     *
     * @param scanner       Scanner object for input
     * @param promptMessage Message to display when prompting for input
     * @param validator     Validator for input validation
     * @return Validated user input
     */
    public static String promptForInput(Scanner scanner, String promptMessage, Validator validator) {
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

    /**
     * Interface for input validation
     */
    interface Validator {
        boolean isValid(String input);
    }

    /**
     * Main method for user registration
     */
    public static void main(String[] args) {

        /**
         * Initialization of Scanner object to read user input
         */
        Scanner scanner = new Scanner(System.in);

        /**
         * Create a new UserInfo object to store user information
         */
        AdminInfo adminInfo = new AdminInfo();

        /**
         * Prints a welcome message and instructions for user registration
         */
        System.out.println("\n              WELCOME TO PORTAL REGISTRATION!");
        System.out.println("Reminder to capitalize the first letter in every names you are going to enter. " +
                "Adhere to the given format for the numbers.");

/**
 * Prompt for and validate user details
 * Each detail is prompted for using the promptForInput method with appropriate validators
 * In the promptForInput method, Validators::isValidName is passed as an argument to indicate that the input provided by the user should be validated using the isValidName method defined in the Validators class.
 */
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

        String gender = promptForInput(scanner, "Enter Gender (M-Male|F-Female|N-Not to say): ", Validators::isValidGender);
        adminInfo.setGender(gender);

        /**
         *Display the details provided by the user/admin during the registration process.
         */
        System.out.println("\nDETAILS PROVIDED");

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
        System.out.println("Nationality: " + adminInfo.getNationality());
        System.out.println("Gender: " + adminInfo.getGender());

        /**
         * Validation of role at school
         * Checks the role at school and performs validation
         */
        String roleAtSchool;
        do {
            System.out.print("\nEnter role at school (Teacher/Student/Staff): ");
            roleAtSchool = scanner.nextLine();
            adminInfo.setRoleAtSchool(roleAtSchool);

            if (!roleAtSchool.equalsIgnoreCase("Teacher") &&
                    !roleAtSchool.equalsIgnoreCase("Student") &&
                    !roleAtSchool.equalsIgnoreCase("Staff")) {
                System.out.println("Invalid role. Please choose only between Teacher, Student or Staff.");
            }
        } while (!roleAtSchool.equalsIgnoreCase("Teacher") &&
                !roleAtSchool.equalsIgnoreCase("Student") &&
                !roleAtSchool.equalsIgnoreCase("Staff"));

        /**
         * Checks if the user is a teacher
         */
        if (roleAtSchool.equalsIgnoreCase("Teacher")) {
            System.out.println("\nProvide your Teaching Details. ");
            TeachingDetails.collectTeachingDetails();
        } else {
            /**
             * Calls CheckDetails class if roleAtSchool! = Teacher
             */
            CheckDetails.checkDetails(adminInfo);

            /**
             * Calls EditAdminInfo class
             */
            EditAdminInfo editAdminInfo = new EditAdminInfo (adminInfo);
            editAdminInfo.editAdminInfo();

            /**
             * Calls CreateAccount class
             */
            CreateAccount.createAccount(scanner);

            /**
             * Calls PreferredRole class after the successful creation of account
             */
            PreferredRole.selectPreferRole(roleAtSchool, adminInfo);

            /**
             * Execution of the program after all actions are completed
             */
            System.out.println("End of Registration Account program.");
            System.exit(0);
        }
    }
                           }
