package Entities;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * The system account entity class used to define the system account
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class SystemAccount {
    /**
     * Unique id of a system account
     */
    private String id;
    /**
     * Username of an account
     */
    private String username;
    /**
     * Password of an account
     */
    private String password;
    /**
     * Personal information of a system account
     */
    private PersonalInfo personalInfo;
    /**
     * Address of a system account
     */
    private Address address;
    /**
     * Date of birth of a user of a system account
     */
    private Date dateOfBirth;

    /**
     * Constructor of any system account used to add from program or create from csv
     *
     * @param id Unique id of a system account
     * @param username username of account
     * @param password password of account
     * @param personalInfo personal information of account
     * @param address address of an account
     * @param dateOfBirth date of birth of a system account
     */
    public SystemAccount(String id, String username, String password, PersonalInfo personalInfo, Address address, Date dateOfBirth) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.personalInfo = personalInfo;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the unique id of a system account
     *
     * @return String unique id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the username of a system account
     *
     * @return String username of the account
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the username of a system account
     *
     * @param username String username of the account
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the account
     *
     * @return String password of the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the account
     *
     * @param password String password of the account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets personal information of the account
     *
     * @return Personal information of the account
     */
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    /**
     * Gets the address of the account
     *
     * @return String address of the account
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the account
     *
     * @param address String address of the account
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the date of birth of the account
     *
     * @return Date of birth of the account
     */
    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the account
     *
     * @param dateOfBirth Date of birth of the account
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
