import Entities.Address;
import Entities.PersonalInfo;
import Entities.VaccinationProfile;
import Models.VisitorAccountModel;
import Entities.VisitorAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The visitor tests class calls assertion tests on the visitor side of the application
 *
 * @author Antoine Ho
 */
public class VisitorTests {

    /**
     * Checks if the list of visitors created by the model are valid visitors from a valid ArrayList
     *
     * @author Antoine Ho
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     * @throws IOException Failed to read a file if it throws this error
     */
    @Test
    void AddVisitorListTest() throws ParseException, IOException {
        // First we create 2 visitor accounts from scratch
        PersonalInfo info = new PersonalInfo("Hannah", "Brown", "1234567890", "hannahbrown@gmail.com");
        String birthDateStr = "2000-01-01";
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        Address address = new Address("2900 Edouard-Montpetit Blvd", "H3T1J4", "Montreal");
        VisitorAccount visitorAcc1 = new VisitorAccount("123456789112", birthDate, info, address);
        VisitorAccount visitorAcc2 = new VisitorAccount("123456789113", birthDate, info, address);

        // Puts the visitors in an array list
        ArrayList<VisitorAccount> visitorList = new ArrayList<>();
        visitorList.add(visitorAcc1);
        visitorList.add(visitorAcc2);

        // Creates a visitor account from the model and put it in the model list
        VisitorAccountModel model = new VisitorAccountModel();
        model.addVisitorAccount(new VisitorAccount("123456789112", birthDate, info, address));
        model.addVisitorAccount(new VisitorAccount("123456789113", birthDate, info, address));

        // Gets the list created by the model
        int idx1 = model.getVisitors().size() - 2;
        int idx2 = model.getVisitors().size();
        ArrayList<VisitorAccount> modelArray= new ArrayList<>(model.getVisitors().subList(idx1, idx2));

        // Test to see if the 2 lists are the same (Comparing values by string)
        Assertions.assertEquals(visitorList.toString(), modelArray.toString());
    }

    /**
     * Checks if the vaccination profiles are properly stored with the visitor
     *
     * @author Antoine Ho
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    @Test
    void VaccinationProfileTest() throws ParseException{
        // First we create 1 visitor account from scratch
        PersonalInfo info = new PersonalInfo("Mahmoud", "Farahi", "1234567890", "mahmoudfarahi@gmail.com");
        String birthDateStr = "2000-01-01";
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        Address address = new Address("2900 Edouard-Montpetit Blvd", "H3T1J4", "Montreal");
        VisitorAccount visitorAcc1 = new VisitorAccount("200020012002", birthDate, info, address);

        String vaxDateStr1 = "2022-01-01";
        Date vaxDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(vaxDateStr1);
        String vaxDateStr2 = "2022-03-01";
        Date vaxDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(vaxDateStr2);
        visitorAcc1.addVaccinationProfile(new VaccinationProfile("200020012002", vaxDate1, 1, "Moderna", 111));
        visitorAcc1.addVaccinationProfile(new VaccinationProfile("200020012002", vaxDate2, 2, "AstraZeneca", 222));

        // Create vaccination profile entities
        VaccinationProfile vax1 = new VaccinationProfile("200020012002", vaxDate1, 1, "Moderna", 111);
        VaccinationProfile vax2 = new VaccinationProfile("200020012002", vaxDate2, 2, "AstraZeneca", 222);

        // Puts the vaccination profiles into a list
        ArrayList<VaccinationProfile> vaxList = new ArrayList<>();
        vaxList.add(vax1);
        vaxList.add(vax2);

        // Gets the list of the vaccination profiles of the visitor
        ArrayList<VaccinationProfile> vaxProfilesFromVisitor = visitorAcc1.getVaccinationProfiles();

        // Test to see if the 2 lists are the same (Comparing values by string)
        Assertions.assertEquals(vaxProfilesFromVisitor.toString(), vaxList.toString());
    }
}
