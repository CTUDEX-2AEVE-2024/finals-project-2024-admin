package com.ctu.reservationportal.model;

/**
 * a class to hold and get Admin Informations/Details
 */
public class AdminInfo {
    //public AdminInfo (String firstName, String middleName, String lastName, String birthDate, String email, long phoneNumber,
                   //   String street, String barangay, String municipality, String city, int ZIPcode, String nationality, String roleAtSchool,
                   //   String idNumber, String username) {
        this.firstName = getFirstName();
        this.middleName = getMiddleName();
        this.lastName = getLastName();
        this.birthDate = getBirthdate();
        this.email = getEmail();
        this.phoneNumber = getPhoneNumber();
        this.street= getStreet();
        this.barangay= getBarangay();
        this.municipality= getMunicipality();
        this.city= getCity();
        this.ZIPcode=getZIPcode();
        this.roleAtSchool= getRoleAtSchool();
        this.idNumber= getIdNumber();
        this.username = getUsername();

    }

    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDate;
    private String email;
    private long phoneNumber;

    private String street;

    private String barangay;
    private String municipality;
    private String city;
    private int ZIPcode;

    private String nationality;
    private String gender;
    private String roleAtSchool;

    private String idNumber;

    private String username;

    /**
     * @return first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return birthdate
     */
    public String getBirthdate() {
        return birthDate;
    }

    /**
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return phone number
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Long.valueOf(phoneNumber);
    }

    public String getStreet() { return street; }

    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return barangay
     */
    public String getBarangay() {
        return barangay;
    }

    /**
     * @param barangay
     */
    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    /**
     * @return municipality
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * @param municipality
     */
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    /**
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return ZIP code
     */
    public int getZIPcode() {
        return ZIPcode;
    }

    /**
     * @param ziPcode
     */
    public void setZIPcode(int ziPcode) {
        this.ZIPcode = ziPcode;
    }

    /**
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return role at school
     */
    public String getRoleAtSchool() {
        return roleAtSchool;
    }

    public void setRoleAtSchool(String roleAtSchool) {
        this.roleAtSchool = roleAtSchool;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = this.username;
    }

    public void displayAdminInfo() {
    }

}



// public void displayAdminInfo() {
//  }



