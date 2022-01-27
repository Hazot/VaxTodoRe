package Entities;

import java.util.Date;

/**
 * The vaccination profile entity class used to define the vaccination profile
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class VaccinationProfile {
    /**
     * Visitor id on the vaccination profile
     */
    private String visitorId;
    /**
     * Vaccination date on the vaccination profile
     */
    private Date vaccinationDate;
    /**
     * Dose type on the vaccination profile
     */
    private int doseType;
    /**
     * Vaccine name on the vaccination profile
     */
    private String vaccineName;
    /**
     * Vaccine code on the vaccination profile
     */
    private long vaccineCode;

    /**
     * Constructor used to create add a vaccination profile or get from csv files
     *
     * @param visitorId visitor id on the vaccination profile
     * @param vaccinationDate vaccination date on the vaccination profile
     * @param doseType dose type on the vaccination profile
     * @param vaccineName vaccine name on the vaccination profile
     * @param vaccineCode vaccine code on the vaccination profile
     */
    public VaccinationProfile(String visitorId, Date vaccinationDate, int doseType, String vaccineName, long vaccineCode) {
        this.visitorId = visitorId;
        this.vaccinationDate = vaccinationDate;
        this.doseType = doseType;
        this.vaccineName = vaccineName;
        this.vaccineCode = vaccineCode;
    }

    /**
     * Gets visitor id on the profile
     *
     * @return String visitor id on the profile
     */
    public String getVisitorId() {
        return visitorId;
    }

    /**
     * Gets vaccination date on the profile
     *
     * @return Date of the vaccination
     */
    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    /**
     * Gets the dose type of the profile
     *
     * @return int dose type of the profile
     */
    public int getDoseType() {
        return doseType;
    }

    /**
     * Gets vaccine name of the profile
     *
     * @return String vaccine name on the profile
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * Gets vaccine code of the profile
     *
     * @return Long vaccine code of the profile
     */
    public long getVaccineCode() {
        return vaccineCode;
    }

    /**
     * Sets vaccine code of the profile
     *
     * @param vaccineCode Long vaccine code of the profile
     */
    public void setVaccineCode(long vaccineCode) {
        this.vaccineCode = vaccineCode;
    }

    /**
     * Sets the vaccination date off the profile
     *
     * @param date Date of the profile
     */
    public void setVaccinationDate(Date date) {
        vaccinationDate = date;
    }

    /**
     * Sets the dose type of the profile
     *
     * @param doseType dose type of the profile
     */
    public void setDoseType(int doseType) {
        this.doseType = doseType;
    }

    /**
     * Sets the vaccine name of the profile
     *
     * @param name vaccine name for the profile
     */
    public void setVaccineName(String name) {
        vaccineName = name;
    }

    /**
     * Pretty print for a vaccination profile
     *
     * @return Printable string representing a visitor's vaccination profile information
     */
    @Override
    public String toString() {
        return "id: " + visitorId + "\ndate: " + vaccinationDate + "\ndoseType: " + doseType + "\nvaccine name: " + vaccineName + "\nvaccine code: " + vaccineCode;
    }
}
