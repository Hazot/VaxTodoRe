import Controllers.SystemAccountController;
import Entities.*;
import Models.SystemAccountModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The system account tests class calls assertion tests on the system accounts of the application
 *
 * @author Kevin Lessard
 */
public class SystemAccountTests {
    /**
     * Tests the login method by creating accounts and trying to log in to them
     *
     * @author Kevin Lessard
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     * @throws IOException Failed to read a file if it throws this error
     */
    @Test
    void loginTest() throws ParseException, IOException {

        // Creates 4 accounts to test with different identification code and passwords
        String id = "123456789101";
        String idenCode1 = "123123123";
        String pass1 = "Barbpass1!";
        String idenCode2 = "124124124";
        String pass2 = "Barbpass2!";
        String idenCode3 = "125125125";
        String pass3 = "Barbpass3!";
        String idenCode4 = "126126126";
        String pass4 = "Barbpass4!";
        PersonalInfo info = new PersonalInfo("Barbara", "Streisand", "1234567890", "barbarastreisand@gmail.com");
        Address address = new Address("2900 Edouard-Montpetit Blvd", "H3T1J4", "Montreal");
        String birthDateStr = "1942-04-24";
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);

        EmployeeAccount employee1 = new EmployeeAccount(id, idenCode1, pass1, info, address, birthDate);
        EmployeeAccount employee2 = new EmployeeAccount(id, idenCode2, pass2, info, address, birthDate);

        VolunteerAccount volunteer1 = new VolunteerAccount(id, idenCode3, pass3, info, address, birthDate);
        VolunteerAccount volunteer2 = new VolunteerAccount(id, idenCode4, pass4, info, address, birthDate);

        // Adds the account created to the model lists
        SystemAccountModel model = new SystemAccountModel();
        model.addEmployeeAccount(employee1);
        model.addEmployeeAccount(employee2);
        model.addVolunteerAccount(volunteer1);
        model.addVolunteerAccount(volunteer2);

        SystemAccountController controller = new SystemAccountController(model.getEmployeeAccounts(),
                model.getVolunteerAccounts());

        // Tries to login to the created accounts
        ArrayList<Integer> loginsOrder = new ArrayList<>();
        loginsOrder.add(controller.login("123123123", "Barbpass1!"));
        loginsOrder.add(controller.login("124124124", "Barbpass2!"));
        loginsOrder.add(controller.login("125125125", "Barbpass3!"));
        loginsOrder.add(controller.login("126126126", "Barbpass4!"));
        loginsOrder.add(controller.login("111111111", "Barbpass(0)"));

        // Creates the homemade logins (1: employees, 2: volunteers, 0: not an account)
        ArrayList<Integer> loginsOrderHomemade = new ArrayList<>();
        loginsOrderHomemade.add(1);
        loginsOrderHomemade.add(1);
        loginsOrderHomemade.add(2);
        loginsOrderHomemade.add(2);
        loginsOrderHomemade.add(0);

        // Test to compare both login list
        Assertions.assertEquals(loginsOrderHomemade, loginsOrder);
    }
}
