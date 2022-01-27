package Entities;

import java.util.ArrayList;
import java.util.Date;

/**
 * The volunteer account entity class used to define the volunteer account
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class VolunteerAccount extends SystemAccount {
    /**
     * The vounteer account schedule
     */
    private ArrayList<String> schedule = new ArrayList<>();

    /**
     * Constructor used to add new volunteer
     *
     * @param id Unique account number
     * @param identificationCode Username
     * @param password Password
     * @param personalInfo Information asked for every account
     * @param address Address object
     * @param dateOfBirth Birthdate
     */
    public VolunteerAccount(String id, String identificationCode, String password, PersonalInfo personalInfo, Address address, Date dateOfBirth) {
        super(id, identificationCode, password, personalInfo, address, dateOfBirth);
    }

    /**
     * Constructor used to create volunteers from csv files
     *
     * @param id Unique account number
     * @param identificationCode Username
     * @param password Password
     * @param personalInfo Information asked for every account
     * @param address Address object
     * @param dateOfBirth Birthdate
     * @param schedule Volunteer week schedule
     */
    public VolunteerAccount(String id, String identificationCode, String password, PersonalInfo personalInfo,
                            Address address, Date dateOfBirth, ArrayList<String> schedule) {
        super(id, identificationCode, password, personalInfo, address, dateOfBirth);
        this.schedule = schedule;
    }

    /**
     * Gets the schedule of the volunteer
     *
     * @return the schedule in an ArrayList of weekdays in String
     */
    public ArrayList<String> getSchedule() {
        return schedule;
    }

    /**
     * Gets the personal information of the volunteer
     *
     * @return Object personal information of a volunteer
     */
    public PersonalInfo getInfo() {
        return getPersonalInfo();
    }

    /**
     * Pretty print for a volunteer account
     *
     * @return Printable String representing a volunteer
     */
    @Override
    public String toString() {
        return getId() + " " + getDateOfBirth()+ " " + getPersonalInfo() + " " + getAddress();
    }

}
