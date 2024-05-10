package com.ctu.reservationportal.model;

/**
 * a class to hold and get Admin Informations/Details
 */
public class AdminInfo {

        private String firstName;
        private String middleName;
        private String lastName;
        private String birthDate;
        private String street;
        private String barangay;
        private String municipality;
        private String city;
        private int ZIPcode;
        private String Email;
        private Long PhoneNumber;
        private String nationality;

        private String gender;
        private String roleAtSchool;

    /**
     *
     * @return first name of the person
     */
    public String getFirstName() {
            return firstName;
        }

      /**
       *
       * * @param firstName
     */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

    /**
     *
     * @return middle name
     */
    public String getMiddleName() {
            return middleName;
        }

    /**
     *
     * @param middleName
     */
    public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

    /**
     *
     * @return last name
     */
    public String getLastName() {
            return lastName;
        }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
            this.lastName = lastName;
        }

    /**
     *
     * @return birthdate
     */
    public String getBirthdate() {
            return birthDate;
        }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

    /**
     *
     * @return email
     */
    public String getEmail() {
            return Email;
        }

    /**
     *
     * @param Email
     */
    public void setEmail(String Email) {
            this.Email = Email;
        }

    /**
     *
     * @return phone number
     */
    public Long getPhoneNumber() {
            return PhoneNumber;
        }

    /**
     *
     * @param PhoneNumber
     */
    public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = Long.valueOf(PhoneNumber);
        }

    /**
     *
     * @return street
     */
    public String getStreet() {
            return street;
        }

    /**
     *
     * @param Street
     */
    public void setStreet(String Street) {
            this.street = street;
        }

    /**
     *
     * @return barangay
     */
    public String getBarangay() {
            return barangay;
        }

    /**
     *
     * @param barangay
     */
    public void setBarangay(String barangay) {
            this.barangay = barangay;
        }

    /**
     *
     * @return municipality
     */
    public String getMunicipality() {
            return municipality;}

    /**
     *
     * @param municipality
     */
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return ZIP code
     */
    public int getZIPcode() {
        return ZIPcode;
    }

    /**
     *
     * @param ziPcode
     */
    public void setZIPcode(int ziPcode) {
        this.ZIPcode = ziPcode;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
     public void setGender(String gender) {
         this.gender = gender;
     }

    /**
     *
     * @return nationality
     */
    public String getNationality() {
            return nationality;
        }

    /**
     *
     * @param nationality
     */
    public void setNationality(String nationality) {
            this.nationality = nationality;
        }

    /**
     *
     * @return role at school
     */
    public String getRoleAtSchool() {
            return roleAtSchool;
        }
        public void setroleAtSchool(String roleAtSchool) { this.roleAtSchool = roleAtSchool;}

        public void setisValidId(String adminId) {
        }

        public void setAdminID(String adminId) {
        }

        public void displayUserInfo() {
        }
}
