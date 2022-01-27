package Models;

import Csv.CsvParser;
import Entities.VaccinationProfile;
import Entities.VisitorAccount;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * The visitor account model used to store the list of visitors and use them
 *
 * @author Antoine Ho
 * @author Antoine Ho
 * @author Antoine Ho
 */
public class VisitorAccountModel {

    /**
     * Arraylist of the visitor accounts
     */
    private ArrayList<VisitorAccount> visitorAccounts = new ArrayList<>();

    /**
     * Constructor used to create the list of the visitors and use them
     *
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public VisitorAccountModel() throws IOException, ParseException {
        setVisitorAccounts(CsvParser.parseVisitors());
        setVisitorsVaccinationProfiles(CsvParser.parseVaccinationProfiles());
    }

    /**
     * Gets the list of visitor accounts
     *
     * @return list of visitor accounts
     */
    public ArrayList<VisitorAccount> getVisitors() {
        return visitorAccounts;
    }

    /**
     * Adds a visitor account to the visitor account list
     *
     * @param visitor visitor account list
     */
    public void addVisitorAccount(VisitorAccount visitor) {
        visitorAccounts.add(visitor);
    }

    /**
     * Sets the list of visitor accounts
     *
     * @param visitorAccounts list of visitor accounts
     */
    public void setVisitorAccounts(ArrayList<VisitorAccount> visitorAccounts) {
        this.visitorAccounts = visitorAccounts;
    }

    /**
     * Sets the vaccination profiles to the visitor accounts
     *
     * @param vaccinationProfiles list of vaccination profiles
     */
    private void setVisitorsVaccinationProfiles(ArrayList<VaccinationProfile> vaccinationProfiles) {
        for (VaccinationProfile vaccinationProfile : vaccinationProfiles) {
            for (VisitorAccount visitorAccount : visitorAccounts) {
                if (vaccinationProfile.getVisitorId().equals(visitorAccount.getId())) {
                    visitorAccount.addVaccinationProfile(vaccinationProfile);
                }
            }
        }
    }

    /**
     * Gets the visitor account from id
     *
     * @param id unique visitor id
     * @return a visitor account entity
     */
    public VisitorAccount getVisitor(String id) {
        for (VisitorAccount visitorAccount : visitorAccounts) {
            if (visitorAccount.getId().equals(id)) {
                return visitorAccount;
            }
        }
        return null;
    }
}
