package Entities;

import java.util.ArrayList;
import java.util.Date;

/**
 * The visitor account entity class used to define the visitor account
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class VisitorAccount {
    /**
     * Unique id of the visitor
     */
    private String id;
    /**
     * Date of birth of the visitor
     */
    private Date dateOfBirth;
    /**
     * Personal information of the visitor
     */
    private PersonalInfo info;
    /**
     * Vaccination profiles of the visitor
     */
    private ArrayList<VaccinationProfile> vaccinationProfiles;
    /**
     * Address of the visitor
     */
    private Address address;

    /**
     * Constructor used to add a new visitor account in the program
     *
     * @param id Unique id
     * @param birthDate date of birth
     * @param info personal information
     * @param address personal address of the visitor
     */
    public VisitorAccount(String id, Date birthDate, PersonalInfo info, Address address) {
        this.id = id;
        dateOfBirth = birthDate;
        this.info = info;
        this.address = address;
        vaccinationProfiles = new ArrayList<>();
    }

    /**
     * Constructor used to create a visitor account from csv file
     *
     * @param id Unique id
     * @param date date of birth
     * @param info personal information
     * @param address personal address of the visitor
     * @param vaccinationProfiles vaccination profile of the visitor
     */
    public VisitorAccount(String id, Date date, PersonalInfo info, Address address,
                          ArrayList<VaccinationProfile> vaccinationProfiles){
        this.id = id;
        dateOfBirth = date;
        this.info = info;
        this.address = address;
        this.vaccinationProfiles = vaccinationProfiles;
    }

    /**
     * Gets the unique id of a visitor
     *
     * @return unique String id of a visitor
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique id of a visitor
     *
     * @param id unique String id of a visitor
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the date of birth of a visitor account
     *
     * @return Date of birth of a visitor
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of a visitor account
     *
     * @param dateOfBirth Date of birth of a visitor
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the personal information of a visitor account
     *
     * @return Personal information of a visitor account
     */
    public PersonalInfo getInfo() {
        return info;
    }

    /**
     * Sets the personal information of a visitor account
     *
     * @param info personal information of a visitor account
     */
    public void setInfo(PersonalInfo info) {
        this.info = info;
    }

    /**
     * Gets the address of a visitor account
     *
     * @return Address object of a visitor account
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of a visitor account
     *
     * @param address Address of the visitor account
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets vaccination profile list
     *
     * @return ArrayList of vaccination profiles
     */
    public ArrayList<VaccinationProfile> getVaccinationProfiles() {
        return vaccinationProfiles;
    }

    /**
     * Sets the vaccination profile to the visitor account
     *
     * @param vaccinationProfiles vaccination profile to associate to the visitor account
     */
    public void setVaccinationProfiles(ArrayList<VaccinationProfile> vaccinationProfiles) {
        this.vaccinationProfiles = vaccinationProfiles;
    }

    /**
     * Adds a vaccination profile to the visitor account
     *
     * @param vaccinationProfile vaccination profile to associate to the visitor account
     */
    public void addVaccinationProfile(VaccinationProfile vaccinationProfile) {
        vaccinationProfiles.add(vaccinationProfile);
    }

    /**
     * Pretty print for a visitor account
     *
     * @return Printable string representing a visitor account's information
     */
    @Override
    public String toString() {
        return id + " " + info + " " + address;
    }
}
