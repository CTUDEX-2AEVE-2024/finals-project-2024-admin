package com.ctu.reservationportal.infrastructure;
import com.ctu.reservationportal.dbservices.InsertRecords;
import com.ctu.reservationportal.model.AdminInfo;
import java.util.Random;

/**
 * A Class for generating user or admin ID number
 */
public class IDGenerator {

    /**
     * Method for generating user ID number
     * @return userID
     */
    public static String generateUserID() {
        Random random = new Random();
        //  Builds a string by appending/adding characters to it
        StringBuilder userID = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            userID.append(random.nextInt(10)); // Generate a random digit (0-9)
        }
        return userID.toString();
    }

    /**
     * Method for generating admin ID number
     * @return adminID
     */
    public static String generateAdminID() {
        Random random = new Random();
        StringBuilder adminID = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            adminID.append(random.nextInt(10)); // Generate a random digit (0-9)
        }
        return adminID.toString();
    }

    /**
     * Method responsible for displaying the generated ID number
     * @param idType
     * @param idNumber
     */
    public static void displayID(String idType, String idNumber) {
        AdminInfo adminInfo = new AdminInfo();
        System.out.println("Your " + idType + " ID Number: " + idNumber);
        adminInfo.setIdNumber(idNumber);

    }
}
