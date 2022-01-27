package Entities;

/**
 * The personal information entity class used to define the personal information
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class PersonalInfo {
    /**
     * First name of a user
     */
    private String firstName;
    /**
     * Last name of a user
     */
    private String lastName;
    /**
     * Phone number of a user
     */
    private String telephoneNum;
    /**
     * Email of a user
     */
    private String email;

    /**
     * Constructor of the personal information of a user
     *
     * @param fName first name of a user
     * @param lName last name of a user
     * @param phone phone number of a user
     * @param email email of a user
     */
    public PersonalInfo(String fName, String lName, String phone, String email) {
        firstName = fName;
        lastName = lName;
        telephoneNum = phone;
        this.email = email;
    }

    /**
     * Gets first name of a user
     *
     * @return String first name of a user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name of a user
     *
     * @param firstName String first name of a user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name of a user
     *
     * @return String last name of a user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name of a user
     *
     * @param lastName String last name of a user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the phone number of a user
     *
     * @return String phone number of a user
     */
    public String getTelephoneNum() {
        return telephoneNum;
    }

    /**
     * Sets the phone number of a user
     *
     * @param telephoneNum String phone number of a user
     */
    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    /**
     * Gets the email of a user
     *
     * @return String email of a user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of a user
     *
     * @param email String email of a user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Pretty print for the personal information
     *
     * @return Printable string representing the personal information
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + telephoneNum + " " + email;
    }
}
