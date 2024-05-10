package com.ctu.reservationportal.infrastructure;
// imports the Pattern class from the java.util.regex package 
import java.util.regex.Pattern;

/**
* A Class for validation methods
*/
public class Validators {
    
    /**
    * A Method for validation names
    * String type inputs
    */
    public static boolean isValidName(String name) {
        
        /*Defines a regular expression pattern stored in a string variable 'regex' 
        * The pattern specifies the format of a valid name */
        String regex = "([A-Z][a-z]*(\\s[A-Z][a-z]*)*)";
        
        // checks if the name string matches the regular expression pattern stored in the regex variable
        return Pattern.matches(regex, name);
    }

    public static boolean isValidDate(String date) {
        // Date format: YYYY-MM-DD
        return Pattern.matches("\\d{4}-\\d{2}-\\d{2}", date);
    }
    public static boolean isValidPassword(String password) {
        // Password must contain at least one uppercase, one lowercase, one digit, and one special character
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$");
    }

    public static boolean isValidEmail(String email) {
        // Simple email validation regex with lowercase requirement
        return Pattern.matches("\\b[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}\\b", email);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Phone number format: Philippine style starting with +639 and followed by 9 digits
        return phoneNumber.matches("^\\+639\\d{9}$");
    }

    public static boolean isValidStreet(String street) {
        // Street format: [Alphanumeric with spaces and special characters]
        return Character.isUpperCase(street.charAt(0)) && Pattern.matches("[\\w\\d\\s.,'()-]+", street);
    }

    public static boolean isValidInt(String number) {
        return number.matches("\\d+");
    }

    public static boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("n") || gender.equalsIgnoreCase("Male")
                || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase ("Not to say") ;
    }

    public static boolean isValidLocation(String location) {
        // Location format: [Alphanumeric with spaces and special characters]
        return Character.isUpperCase(location.charAt(0)) && Pattern.matches("[\\w\\d\\s.,'()-]+", location);
    }

    public static boolean isValidZIPCode(String zipCode) {
        // ZIP code format: Four digits
        return zipCode.matches("^\\d{4}$");
    }

    public static boolean isValidId(String input) {
        // Validation logic for the admin user ID number
        // Return true if the input is valid, false otherwise
        return input.matches("[A-Za-z0-9]+");
    }

    public static boolean isValidAdminID(String adminID) {
        // Admin ID format: Six digits
        return adminID.matches("^\\d{6}$");
    }
    public boolean isValidInput(String fieldName, String userInput) {
        switch (fieldName) {
            case "First Name":
            case "Middle Name":
            case "Last Name":
            case "Nationality":
            case "Street":
            case "Barangay":
            case "City":
            case "Municipality":
                return Validators.isValidName(userInput);
            case "Birthdate":
                return Validators.isValidDate(userInput);
            case "Email":
                return Validators.isValidEmail(userInput);
            case "Phone Number":
                return Validators.isValidPhoneNumber(userInput);
            case "ZIP code":
                return Validators.isValidZIPCode(userInput);
            case "Gender":
                return Validators.isValidGender(userInput);
            default:
                return true;
        }
    }

    public boolean isValid(String input) {
        return true;
        }
