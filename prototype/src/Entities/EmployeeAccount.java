package Entities;

import java.util.Date;

/**
 * The employee account entity class used to define the employee account
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class EmployeeAccount extends SystemAccount {
    /**
     * Constructor used to create an employee account from csv files into the program
     *
     * @param id Unique account number
     * @param identificationCode Username
     * @param password Password
     * @param personalInfo Information asked for every account
     * @param address Address object
     * @param dateOfBirth Birthdate
     */
    public EmployeeAccount(String id, String identificationCode, String password, PersonalInfo personalInfo, Address address, Date dateOfBirth) {
        super(id, identificationCode, password, personalInfo, address, dateOfBirth);
    }

    /**
     * Pretty print for employee
     *
     * @return Printable String representing an employee
     */
    @Override
    public String toString() {
        return "EMPLOYEE: " + getId() + " " + getPersonalInfo();
    }
}
