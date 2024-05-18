package com.ctu.reservationportal.dbservices;

import com.ctu.reservationportal.model.AdminInfo;

import java.sql.*;
import static java.sql.Date.valueOf;

public class InsertRecords {

    private static final String INSERT_USERS_SQL = "INSERT INTO admininfo (" +
            "firstName, middleName, lastName, birthDate, email, phoneNumber, street, barangay, municipality, city, ZIPcode, nationality, gender, roleAtSchool, idNumber,username) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;

    public InsertRecords() {
        this.jdbcURL = "jdbc:mysql://localhost:3306/roomportaldb?useSSL=false&allowPublicKeyRetrieval=true";
        this.jdbcUsername = "root";
        this.jdbcPassword = "admin123$";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading JDBC MySQL Driver", e);
        }
    }

    public void insertUserRecord(AdminInfo adminInfo) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setString(1, adminInfo.getFirstName());
            preparedStatement.setString(2, adminInfo.getMiddleName());
            preparedStatement.setString(3, adminInfo.getLastName());
            preparedStatement.setString(4, adminInfo.getBirthdate());
            preparedStatement.setString(5, adminInfo.getEmail());
            preparedStatement.setLong(6, adminInfo.getPhoneNumber());
            preparedStatement.setString(7, adminInfo.getStreet());
            preparedStatement.setString(8, adminInfo.getBarangay());
            preparedStatement.setString(9, adminInfo.getMunicipality());
            preparedStatement.setString(10, adminInfo.getCity());
            preparedStatement.setInt(11, adminInfo.getZIPcode());
            preparedStatement.setString(12, adminInfo.getNationality());
            preparedStatement.setString(13, adminInfo.getGender());
            preparedStatement.setString(14, adminInfo.getRoleAtSchool());
            preparedStatement.setString(15, adminInfo.getIdNumber());
            preparedStatement.setString(16, adminInfo.getUsername());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            } else {
                System.out.println("Failed to insert user data.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting user data to DB: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // Create a new instance of UserInfo with sample data
        AdminInfo adminInfo = new AdminInfo();

        adminInfo.setFirstName(adminInfo.getFirstName());
        adminInfo.setMiddleName(adminInfo.getMiddleName());
        adminInfo.setLastName(adminInfo.getLastName());
        adminInfo.setBirthDate(String.valueOf(Date.valueOf(adminInfo.getBirthdate())));
        adminInfo.setEmail(adminInfo.getEmail());
        adminInfo.setPhoneNumber(String.valueOf(adminInfo.getPhoneNumber()));
        adminInfo.setStreet(adminInfo.getStreet());
        adminInfo.setBarangay(adminInfo.getBarangay());
        adminInfo.setMunicipality(adminInfo.getMunicipality());
        adminInfo.setCity(adminInfo.getCity());
        adminInfo.setZIPcode(adminInfo.getZIPcode());
        adminInfo.setNationality(adminInfo.getNationality());
        adminInfo.setGender(adminInfo.getGender());
        adminInfo.setRoleAtSchool(adminInfo.getRoleAtSchool());
        adminInfo.setIdNumber(adminInfo.getIdNumber());
        adminInfo.setUsername(adminInfo.getUsername());

        // Create an instance of InsertRecords
        InsertRecords insertRecords = new InsertRecords();

        // Call insertUserRecord method to insert the user info into the database
        insertRecords.insertUserRecord(adminInfo);
    }

    // You can add more methods here for other operations
}
