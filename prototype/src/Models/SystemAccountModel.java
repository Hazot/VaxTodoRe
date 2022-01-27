package Models;

import Csv.CsvParser;
import Entities.EmployeeAccount;
import Entities.VolunteerAccount;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * The system account model used to store the list of system accounts and define methods around it
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class SystemAccountModel {

    /**
     * Arraylist that stores the volunteer accounts
     */
    private ArrayList<VolunteerAccount> volunteerAccounts = new ArrayList<>();
    /**
     * Arraylist that stores the employee accounts
     */
    private ArrayList<EmployeeAccount> employeeAccounts = new ArrayList<>();

    /**
     * Constructor used to create the lists of volunteers and employees and use them
     *
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public SystemAccountModel() throws IOException, ParseException {
        setEmployeeAccounts(CsvParser.parseEmployees());
        setVolunteerAccounts(CsvParser.parseVolunteers());
    }

    /**
     * Gets the list of volunteer accounts
     *
     * @return list of volunteer accounts
     */
    public ArrayList<VolunteerAccount> getVolunteerAccounts() {
        return volunteerAccounts;
    }

    /**
     * Gets the list of employee accounts
     *
     * @return list of employee accounts
     */
    public ArrayList<EmployeeAccount> getEmployeeAccounts() {
        return employeeAccounts;
    }

    /**
     * Sets the list of volunteer accounts
     *
     * @param volunteerAccounts list of volunteer accounts
     */
    public void setVolunteerAccounts(ArrayList<VolunteerAccount> volunteerAccounts) {
        this.volunteerAccounts = volunteerAccounts;
    }

    /**
     * Sets the list of employee accounts
     *
     * @param employeeAccounts list of employee accounts
     */
    public void setEmployeeAccounts(ArrayList<EmployeeAccount> employeeAccounts) {
        this.employeeAccounts = employeeAccounts;
    }

    /**
     * Adds a volunteer account to the volunteer account list
     *
     * @param volunteer volunteer account to put in list
     */
    public void addVolunteerAccount(VolunteerAccount volunteer) {
        volunteerAccounts.add(volunteer);
    }

    /**
     * Adds an employee account to the volunteer account list
     *
     * @param employee empployee account put in list
     */
    public void addEmployeeAccount(EmployeeAccount employee) {
        employeeAccounts.add(employee);
    }
}
