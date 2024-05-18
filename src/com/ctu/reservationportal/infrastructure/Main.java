package com.ctu.reservationportal.infrastructure;

import com.ctu.reservationportal.dbservices.InsertRecords;
import com.ctu.reservationportal.infrastructure.CreateAdminInfo;
import com.ctu.reservationportal.model.AdminInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Main class for main execution
 */
public class Main {

    /**
     * Main method of execution
     * @param args
     */
    public static void main(String[] args) {
        // Creating an instance of class InsertRecords
        InsertRecords insertDetails = new InsertRecords();

        // Creating an instance of CreateAdminInfo
        CreateAdminInfo registerAdminService = new CreateAdminInfo();

        // Register admin and insert record
        AdminInfo adminInfo = registerAdminService.registerAdmin();
        insertDetails.insertUserRecord( adminInfo);
    }
}
