package Controllers;

import Csv.CsvParser;
import Csv.CsvWriter;
import Entities.*;
import Models.SystemAccountModel;
import Views.SystemAccountView;
import constraintChecker.ConstraintChecker;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static java.util.stream.Collectors.toCollection;

/**
 * The system account controller for running the different tasks by/on the system accounts
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class SystemAccountController extends Controller {
    /**
     * The system account model for the lists and the methods
     */
    private SystemAccountModel model = new SystemAccountModel();
    /**
     * The system account view for prints
     */
    private SystemAccountView view = new SystemAccountView();

    /**
     * General constructor for the system account controller
     *
     * @throws IOException    Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public SystemAccountController() throws IOException, ParseException {
        model.setEmployeeAccounts(CsvParser.parseEmployees());
        model.setVolunteerAccounts(CsvParser.parseVolunteers());
    }

    /**
     * Construtor used to create a constructor with updated lists before without saving if csv files
     *
     * @param employeeList  Model's employee list
     * @param volunteerList Model's volunteer list
     * @throws IOException    Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public SystemAccountController(ArrayList<EmployeeAccount> employeeList, ArrayList<VolunteerAccount> volunteerList) throws IOException, ParseException {
        model.setEmployeeAccounts(employeeList);
        model.setVolunteerAccounts(volunteerList);
    }

    /**
     * Returns an int that verify if the account with the input parameters exists or not.
     * It returns 0 if it doesn't find an account that matches the inputs and returns 1 if it finds an employee account
     * or 2 if it finds a volunteer account.
     *
     * @param username identification code of a system account
     * @param password password of any system account
     * @return int that represent the type of account (userType: 0 == not connected, 1 == Employee account,
     * 2 == Volunteer account)
     */
    public int login(String username, String password) {
        for (EmployeeAccount employeeAccount : model.getEmployeeAccounts()) {
            if (username.equals(employeeAccount.getUsername()) && password.equals(employeeAccount.getPassword())) {
                return 1;
            }
        }
        for (VolunteerAccount volunteerAccount : model.getVolunteerAccounts()) {
            if (username.equals(volunteerAccount.getUsername()) && password.equals(volunteerAccount.getPassword())) {
                return 2;
            }
        }
        view.printLoginTryAgain();
        return 0;
    }

    /**
     * Shows the volunteer menu and runs the choices and the feedback
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void runGestionVolunteer() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printVolunteerGestionMainMenu();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showAllVolunteers();
                case 2 -> manageVolunteersAccount();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Shows the volunteer management menu and runs the choices and the feedback
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void manageVolunteersAccount() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printMenuDelMod();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> deleteVolunteerAccount();
                case 2 -> modifyVolunteerAccount();
                case 3 -> addVolunteerAccount();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Runs the steps to add a volunteer account
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void addVolunteerAccount() throws ParseException {
        Scanner sc = new Scanner(System.in);

        boolean exceedLimit = false;
        int username = 0;
        while (!exceedLimit) {
            view.printAskEnterUsername();
            if (sc.hasNextInt()) {
                username = sc.nextInt();
            } else {
                sc.next();
            }
            exceedLimit = ConstraintChecker.isUsernameLimitValid(username, 9);
        }

        String password;

        sc = new Scanner(System.in);
        while (true) {
            view.printAskEnterPassword();
            password = sc.nextLine();

            if (ConstraintChecker.isPasswordValid(password)) {
                break;
            } else {
                view.printPasswordInvalid();
            }
        }

        exceedLimit = false;
        String fName = "";
        while (!exceedLimit) {
            view.printAskEnterFName();
            fName = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(fName, 50);
        }

        exceedLimit = false;
        String lName = "";
        while (!exceedLimit) {
            view.printAskEnterLName();
            lName = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(lName, 50);
        }

        exceedLimit = false;
        String birthDateStr = "";
        while (!exceedLimit) {
            view.printAskBirthDate();
            birthDateStr = sc.nextLine();
            exceedLimit = ConstraintChecker.isDateFormatValid(birthDateStr);
        }
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);


        view.printAskEmail();
        String email = sc.nextLine();

        exceedLimit = false;
        String phoneNumber = "";
        while (!exceedLimit) {
            view.printAskPhoneNumber();
            phoneNumber = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(phoneNumber, 10);
        }

        PersonalInfo info = new PersonalInfo(fName, lName, phoneNumber, email);

        exceedLimit = false;
        String streetInfo = "";
        while (!exceedLimit) {
            view.printAskStreetInfo();
            streetInfo = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(streetInfo, 100);
        }

        exceedLimit = false;
        String postalCode = "";
        while (!exceedLimit) {
            view.printAskPostalCode();
            postalCode = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(postalCode, 6);
        }

        exceedLimit = false;
        String city = "";
        while (!exceedLimit) {
            view.printAskCity();
            city = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(city, 50);
        }

        Address address = new Address(streetInfo, postalCode, city);

        model.addVolunteerAccount(new VolunteerAccount(generateRandomDigitId(12), Integer.toString(username), password, info, address, birthDate));
        view.printAccountCreated();
    }

    /**
     * Runs the steps to modify a volunteer account
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void modifyVolunteerAccount() throws ParseException {
        Scanner sc = new Scanner(System.in);
        view.printAskAccountIdToModify();
        String id = sc.nextLine();
        ArrayList<VolunteerAccount> volunteerAccounts = model.getVolunteerAccounts();

        for (Integer i = 0; i < volunteerAccounts.size(); i++) {
            if (volunteerAccounts.get(i).getId().equals(id)) {

                boolean exit = false;
                while (!exit) {
                    view.printMenuSelectModification();
                    int choice = getSelectionInput();
                    VolunteerAccount volunteerAccount = volunteerAccounts.get(i);
                    switch (choice) {
                        case 0 -> exit = true;
                        case 1 -> modifyVolunteerAccountFirstName(volunteerAccount);
                        case 2 -> modifyVolunteerAccountLastName(volunteerAccount);
                        case 3 -> modifyVolunteerAccountBirthDate(volunteerAccount);
                        case 4 -> modifyVolunteerAccountPhoneNumber(volunteerAccount);
                        case 5 -> modifyVolunteerAccountEmail(volunteerAccount);
                        case 6 -> modifyVolunteerAccountAddress(volunteerAccount);
                        case 7 -> modifyVolunteerAccountPostalCode(volunteerAccount);
                        case 8 -> modifyVolunteerAccountCity(volunteerAccount);
                        case 9 -> modifyVolunteerAccountUsername(volunteerAccount);
                        case 10 -> modifyVolunteerAccountPassword(volunteerAccount);
                        default -> utilView.printInvalidChoiceMsg();
                    }
                }
                break;
            }
        }
    }

    /**
     * Asks the user to modify a volunteer account's password, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountPassword(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskEnterPassword();
        boolean exceedLimit = false;
        String password = "";
        while (!exceedLimit) {
            password = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(password, 50);
        }

        volunteerAccount.setPassword(password);
    }

    /**
     * Asks the user to modify a volunteer account's username, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountUsername(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskEnterUsername();
        boolean exceedLimit = false;
        String username = "";
        while (!exceedLimit) {
            username = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(username, 9);
        }

        volunteerAccount.setUsername(username);
    }

    /**
     * Asks the user to modify a volunteer account's city, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountCity(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskCity();
        boolean exceedLimit = false;
        String city = "";
        while (!exceedLimit) {
            city = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(city, 50);
        }

        volunteerAccount.getAddress().setCity(city);
    }

    /**
     * Asks the user to modify a volunteer account's postal code, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountPostalCode(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskPostalCode();
        boolean exceedLimit = false;
        String postalCode = "";
        while (!exceedLimit) {
            postalCode = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(postalCode, 6);
        }

        volunteerAccount.getAddress().setPostalCode(postalCode);
    }

    /**
     * Asks the user to modify a volunteer account's address, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountAddress(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskStreetInfo();
        boolean exceedLimit = false;
        String address = "";
        while (!exceedLimit) {
            address = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(address, 100);
        }
        volunteerAccount.getAddress().setStreetInfo(address);
    }

    /**
     * Asks the user to modify a volunteer account's email, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountEmail(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskEmail();
        String email = sc.nextLine();
        volunteerAccount.getInfo().setEmail(email);
    }

    /**
     * Asks the user to modify a volunteer account's phone number, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountPhoneNumber(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskPhoneNumber();
        boolean exceedLimit = false;
        String phoneNumber = "";

        while (!exceedLimit) {
            phoneNumber = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(phoneNumber, 10);
        }
        volunteerAccount.getInfo().setTelephoneNum(phoneNumber);
    }

    /**
     * Asks the user to modify a volunteer account's birthdate, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void modifyVolunteerAccountBirthDate(VolunteerAccount volunteerAccount) throws ParseException {
        Scanner sc = new Scanner(System.in);
        view.printAskBirthDate();
        boolean exceedLimit = false;
        String birthDateStr = "";

        while (!exceedLimit) {
            birthDateStr = sc.nextLine();
            exceedLimit = ConstraintChecker.isDateFormatValid(birthDateStr);
        }
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        volunteerAccount.setDateOfBirth(birthDate);
    }

    /**
     * Asks the user to modify a volunteer account's last name, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountLastName(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskEnterLName();
        boolean exceedLimit = false;
        String lastName = "";

        while (!exceedLimit) {

            lastName = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(lastName, 50);
        }
        volunteerAccount.getInfo().setLastName(lastName);
    }

    /**
     * Asks the user to modify a volunteer account's first name, validates it and changes it
     *
     * @param volunteerAccount The volunteer account to modify
     */
    private void modifyVolunteerAccountFirstName(VolunteerAccount volunteerAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskEnterFName();
        boolean exceedLimit = false;
        String firstName = "";
        while (!exceedLimit) {
            firstName = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(firstName, 10);
        }
        volunteerAccount.getInfo().setFirstName(firstName);
    }

    /**
     * Asks the user for a volunteer account to delete and shows confirmation
     */
    private void deleteVolunteerAccount() {
        Scanner sc = new Scanner(System.in);
        view.printAskAccountIdToDelete();
        String id = sc.nextLine();

        boolean foundVolunteer = false;
        for (VolunteerAccount volunteer : model.getVolunteerAccounts()) {
            if (volunteer.getId().equals(id)) {
                model.getVolunteerAccounts().remove(volunteer);
                foundVolunteer = true;
                break;
            }
        }

        if (foundVolunteer) {
            view.printAccountHasBeenDeleted();
        }
        else {
            view.printVolunteerAccountNotFound();
        }
    }

    /**
     * Prints all the volunteers
     */
    private void showAllVolunteers() {
        for (VolunteerAccount volunteer : model.getVolunteerAccounts()) {
            view.printVolunteers(volunteer);
        }
    }

    /**
     * Shows the right main menu for the type of account (Volunteer or Employee)
     *
     * @param userType System account type
     */
    public void showView(int userType) {
        if (userType == 1) {
            view.printEmployeeMainMenu();
        } else {
            view.printVolunteerMainMenu();
        }
    }

    /**
     * Saves the system accounts created or modified
     */
    public void saveSysAccounts() {
        CsvWriter.saveEmployees(model.getEmployeeAccounts());
        CsvWriter.saveVolunteer(model.getVolunteerAccounts());
    }

    /**
     * Prints the message for the user to enter his username
     */
    public void showEnterUsernameMsg() {
        view.printEnterLoginUsernameMsg();
    }

    /**
     * Prints the message for the user to enter his password
     */
    public void showEnterPasswordMsg() {
        view.printEnterLoginPasswordMsg();
    }

    /**
     * Prints the header of the application (cool font)
     */
    public void showHeader() {
        view.printHeader();
    }
}
