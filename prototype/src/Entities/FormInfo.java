package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The form information entity class used to define the form information
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class FormInfo {
    //////////////////////////////////
    // INSTANCE VARIABLE
    //////////////////////////////////
    /**
     * Visitor's unique id
     */
    private final String visitorId;
    /**
     * Visitor's first name
     */
    private final String fName;
    /**
     * Visitor's last name
     */
    private final String lName;
    /**
     * Visitor's date of birth
     */
    private final Date dateOfBirth;
    /**
     * Visitor's health insurance number
     */
    private final String healthInsuranceNum;
    /**
     * Date of the visit of a visitor
     */
    private final Date visitDate;
    /**
     * Boolean about if the visitor has received or not the first dose
     */
    private final boolean hasReceivedFirstDose;
    /**
     * Boolean about if the visitor has contracted covid or not
     */
    private final boolean hasContractedCovid;
    /**
     * Boolean about if the visitor has covid symptoms or not
     */
    private final boolean hasCovidSymptoms;
    /**
     * Boolean about if the visitor has allergies or not
     */
    private final boolean hasAllergies;
    /**
     * Vaccine wanted by the visitor
     */
    private final String vaccineChoice;
    /**
     * Boolean about if the visitor got vaccinated during the visit
     */
    private final boolean wasVaccineAdministered;
    /**
     * Vaccine name string
     */
    private final String vaccineName;
    /**
     * Vaccine code string
     */
    private final String vaccineCode;

    /**
     * Constructor used to create any form in the program or from csv files
     *
     * @param visitorId Unique visitor ID
     * @param fName Visitor's first name
     * @param lName Visitor's last name
     * @param dateOfBirth Visitor's date of birth
     * @param healthInsuranceNum Visitor's health insurance number
     * @param visitDate Date of the visit of a visitor
     * @param hasReceivedFirstDose visitor has received or not
     * @param hasContractedCovid visitor has contracted covid or not
     * @param hasCovidSymptoms visitor has covid symptoms or not
     * @param hasAllergies visitor has allergies or not
     * @param vaccineChoice String vaccine choice
     * @param wasVaccineAdministered Boolean of if the visitor got vaccinated during the visit
     * @param vaccineName Vaccine name string
     * @param vaccineCode Vaccine code string
     */
    public FormInfo(String visitorId, String fName, String lName, Date dateOfBirth, String healthInsuranceNum,
                    Date visitDate, boolean hasReceivedFirstDose, boolean hasContractedCovid, boolean hasCovidSymptoms,
                    boolean hasAllergies, String vaccineChoice, boolean wasVaccineAdministered, String vaccineName,
                    String vaccineCode) {
        this.visitorId = visitorId;
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.healthInsuranceNum = healthInsuranceNum;
        this.visitDate = visitDate;
        this.hasReceivedFirstDose = hasReceivedFirstDose;
        this.hasContractedCovid = hasContractedCovid;
        this.hasCovidSymptoms = hasCovidSymptoms;
        this.hasAllergies = hasAllergies;
        this.vaccineChoice = vaccineChoice;
        this.wasVaccineAdministered = wasVaccineAdministered;
        this.vaccineName = vaccineName;
        this.vaccineCode = vaccineCode;
    }

    /**
     * Gets the visitor id of the form
     *
     * @return String unique id of the visitor
     */
    public String getVisitorId() {
        return visitorId;
    }

    /**
     * Gets the first name of a visitor on the form
     *
     * @return String first name of the visitor
     */
    public String getFirstName() {
        return fName;
    }

    /**
     * Gets the last name of a visitor on the form
     *
     * @return String last name of the visitor
     */
    public String getLastName() {
        return lName;
    }

    /**
     * Gets the date of birth of a visitor on the form
     *
     * @return Date of birth of the visitor
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets health insurance number of a visitor on the form
     *
     * @return String health insurance number of the visitor
     */
    public String getHealthInsuranceNum() {
        return healthInsuranceNum;
    }

    /**
     * Gets the date of the visit
     *
     * @return String first name of the visitor
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * Gets the boolean about the first dose
     *
     * @return true or false
     */
    public boolean getHasReceivedFirstDose() {
        return hasReceivedFirstDose;
    }

    /**
     * Gets the boolean about the contraction of covid
     *
     * @return true or false
     */
    public boolean getHasContractedCovid() {
        return hasContractedCovid;
    }

    /**
     * Gets the boolean about the contraction of covid symptoms
     *
     * @return true or false
     */
    public boolean getHasCovidSymptoms() {
        return hasCovidSymptoms;
    }

    /**
     * Gets the boolean about allergies
     *
     * @return true or false
     */
    public boolean getHasAllergies() {
        return hasAllergies;
    }

    /**
     * Gets the vaccine choice of the visitor
     *
     * @return String vaccine
     */
    public String getVaccineChoice() {
        return vaccineChoice;
    }

    /**
     * Gets the boolean about if the visitor got vaccinated
     *
     * @return True or false
     */
    public boolean getWasVaccineAdministered() {
        return wasVaccineAdministered;
    }

    /**
     * Gets vaccine name on the form
     *
     * @return String vaccine name
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * Gets vaccine code on the form
     *
     * @return String vaccine code
     */
    public String getVaccineCode() {
        return vaccineCode;
    }

    /**
     * Pretty print for a form
     *
     * @return Printable string representing a form
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Id du visteur: %s\n", visitorId) +
                String.format("Prenom: %s\n", fName) +
                String.format("Nom: %s\n", lName) +
                String.format("Date de naissance: %s\n", dateFormatter.format(dateOfBirth)) +
                String.format("Numero d'assurance maladie: %s\n", healthInsuranceNum) +
                String.format("Date de visite: %s\n", dateFormatter.format(visitDate)) +
                String.format("Première dose recu?: %b\n", hasReceivedFirstDose) +
                String.format("A contracté le covid dans le passé?: %b\n", hasContractedCovid) +
                String.format("A des symptomes de covid?: %b\n", hasContractedCovid) +
                String.format("A des allergies?: %b\n", hasAllergies) +
                String.format("Vaccin de choix: %s\n", vaccineChoice) +
                String.format("Est-ce que le vaccin a été administré?: %b\n", wasVaccineAdministered) +
                String.format("Nom du vaccin administré: %s\n", vaccineName) +
                String.format("Code du vaccin: %s\n", vaccineCode);
    }
}
