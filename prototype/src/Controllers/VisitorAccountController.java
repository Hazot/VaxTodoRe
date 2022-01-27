package Controllers;

import Csv.CsvWriter;
import Entities.Address;
import Entities.PersonalInfo;
import Entities.VaccinationProfile;
import Entities.VisitorAccount;
import Models.VisitorAccountModel;
import Views.VisitorAccountView;
import constraintChecker.ConstraintChecker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static java.util.stream.Collectors.toCollection;

/**
 * The visitor account controller for running the different tasks on the visitor accounts
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class VisitorAccountController extends Controller {

    /**
     * The visitor account model for the lists and the methods
     */
    VisitorAccountModel model = new VisitorAccountModel();
    /**
     * The visitor account view for the prints
     */
    VisitorAccountView view = new VisitorAccountView();

    /**
     * General constructor for the visitor account controller
     *
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public VisitorAccountController() throws IOException, ParseException {
    }

    /**
     * Shows the visitor menu and runs the choices and the feedback
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void runShowMenuVisiteurs() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printVisitorMainMenu();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> addVisitorAccount();
                case 2 -> showAllVisitors();
                case 3 -> manageVisitorsAccount();
                case 4 -> manageVaccinationProfile();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Shows the visitor management menu and runs the choices and the feedback
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void manageVisitorsAccount() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printMenuDelMod();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> deleteVisitorAccount();
                case 2 -> modifyVisitorAccount();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Runs the Vaccination profile menu
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void manageVaccinationProfile() throws ParseException {
        Scanner sc = new Scanner(System.in);
        view.printAskAccountIdProfile();
        String id = sc.nextLine();
        VisitorAccount visitorAccount = model.getVisitor(id);
        boolean exit = false;
        if (visitorAccount != null) {
            while (!exit) {
                view.printMenuVaccinationProfile();
                int choice = getSelectionInput();
                switch (choice) {
                    case 0 -> exit = true;
                    case 1 -> showVaccinationProfiles(visitorAccount);
                    case 2 -> modifyVaccinationProfile(visitorAccount);
                    case 3 -> sendVaccinationReport(visitorAccount);
                    default -> utilView.printInvalidChoiceMsg();
                }
            }
        } else {
            view.printInvalidVisitorId();
        }
    }

    /**
     * Prints the vaccination report and sends it to the visitor
     * 
     * @param visitorAccount visitor account instance to take the profile
     */
    private void sendVaccinationReport(VisitorAccount visitorAccount) {
        view.printVaccinationReport(visitorAccount);
    }

    /**
     * Runs the procedure to modify a vaccination profile of a visitor
     *
     * @param visitorAccount Visitor account instance to take the profile
     */
    private void modifyVaccinationProfile(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        int vaccineNum;

        view.printAskEnterVaccinNum();
        vaccineNum = Integer.parseInt(sc.nextLine());

        try {
            visitorAccount.getVaccinationProfiles().get(vaccineNum); // to test if entered index is valid
            boolean exit = false;
            while (!exit) {
                view.printMenuSelectModifyVaccin();
                int choice = getSelectionInput();
                switch (choice) {
                    case 0 -> exit = true;
                    case 1 -> modifyVaccineDate(vaccineNum, visitorAccount);
                    case 2 -> modifyVaccineDoseType(vaccineNum, visitorAccount);
                    case 3 -> modifyVaccineName(vaccineNum, visitorAccount);
                    case 4 -> modifyVaccineCode(vaccineNum, visitorAccount);
                    default -> utilView.printInvalidChoiceMsg();
                }
            }
        } catch (Exception e) {
            view.printInvalidVaccinNum();
        }

    }

    /**
     * Runs the modification of the date of a vaccination RDV
     *
     * @param vaccineIndex vaccine index chosen
     * @param visitorAccount visitor account that needs a change
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void modifyVaccineDate(int vaccineIndex, VisitorAccount visitorAccount) throws ParseException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            view.printAskNewVaccineDate();
            String newDateStr = sc.nextLine();
            if (ConstraintChecker.isDateFormatValid(newDateStr)) {
                Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(newDateStr);
                ArrayList<VaccinationProfile> vaccinationProfilesUpdated = visitorAccount.getVaccinationProfiles();
                vaccinationProfilesUpdated.get(vaccineIndex).setVaccinationDate(newDate);   // modify vax date
                visitorAccount.setVaccinationProfiles(vaccinationProfilesUpdated);
                break;
            } else {
                view.printInvalidDateFormat();
            }
        }
    }

    /**
     * Runs the procedure to modify a vaccine dose type for a vaccination profile
     *
     * @param vaccineIndex vaccine index chosen
     * @param visitorAccount visitor account that needs a change
     */
    private void modifyVaccineDoseType(int vaccineIndex, VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            view.printAskNewDoseType();
            String newDoseType = sc.nextLine();
            if (ConstraintChecker.isDoseTypeValid(newDoseType)) {
                ArrayList<VaccinationProfile> vaccinationProfilesUpdated = visitorAccount.getVaccinationProfiles();
                vaccinationProfilesUpdated.get(vaccineIndex).setDoseType(Integer.parseInt(newDoseType));    // modify vax dose type
                visitorAccount.setVaccinationProfiles(vaccinationProfilesUpdated);
                break;
            } else {
                view.printInvalidDoseType();
            }
        }
    }

    /**
     * Runs the procedure to modify a vaccine name for a vaccination profile
     *
     * @param vaccineIndex vaccine index chosen
     * @param visitorAccount visitor account that needs a change
     */
    private void modifyVaccineName(int vaccineIndex, VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            view.printAskNewVaccineName();
            String numChoice = sc.nextLine();
            if (ConstraintChecker.isVaccineChoiceValid(numChoice)) {
                ArrayList<VaccinationProfile> vaccinationProfilesUpdated = visitorAccount.getVaccinationProfiles();
                String vaccineChoice = null;
                switch (Integer.parseInt(numChoice)) {
                    case 1 -> vaccineChoice = "Moderna";
                    case 2 -> vaccineChoice = "Pfizer";
                    case 3 -> vaccineChoice = "AstraZeneca";
                    case 4 -> vaccineChoice = "Janssen";
                }
                vaccinationProfilesUpdated.get(vaccineIndex).setVaccineName(vaccineChoice);    // modify vax name
                visitorAccount.setVaccinationProfiles(vaccinationProfilesUpdated);
                break;
            } else {
                utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Runs the modification for a vaccine code
     *
     * @param vaccineIndex vaccine index chosen
     * @param visitorAccount visitor account that needs a change
     */
    private void modifyVaccineCode(int vaccineIndex, VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            view.printAskNewVaccineCode();
            String newVaccineCode = sc.nextLine();
            if (ConstraintChecker.isCharLimitValid(newVaccineCode, 24)) {
                ArrayList<VaccinationProfile> vaccinationProfilesUpdated = visitorAccount.getVaccinationProfiles();
                vaccinationProfilesUpdated.get(vaccineIndex).setVaccineCode(Long.parseLong(newVaccineCode));    // modify vax code
                visitorAccount.setVaccinationProfiles(vaccinationProfilesUpdated);
                break;
            } else {
                view.printInvalidVaccineCode();
            }
        }
    }

    /**
     * Prints the vaccination profile of a visitor account
     *
     * @param visitorAccount visitor account to find the vaccination profile
     */
    private void showVaccinationProfiles(VisitorAccount visitorAccount) {
        ArrayList<VaccinationProfile> vaccinationProfiles = visitorAccount.getVaccinationProfiles();
        view.printVaccinationProfiles(vaccinationProfiles);
    }

    /**
     * Runs the steps to modify a visitor account
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void modifyVisitorAccount() throws ParseException {
        // System.out.println("modify visitor account");
        // ask for id first
        // then show options to change
        // then change it with setters
        Scanner sc = new Scanner(System.in);
        view.printAskAccountIdToModify();
        String id = sc.nextLine();
        ArrayList<VisitorAccount> visitorAccounts = model.getVisitors();
        // [visitorAccount1, visitorAccount1, visitorAccount1, visitorAccount1]
        for (int i = 0; i < visitorAccounts.size(); i++) {
            if (visitorAccounts.get(i).getId().equals(id)) {

                boolean exit = false;
                while (!exit) {
                    view.printMenuSelectModifyVisitor();
                    int choice = getSelectionInput();
                    VisitorAccount visitorAccount = visitorAccounts.get(i);
                    switch (choice) {
                        case 0 -> exit = true;
                        case 1 -> modifyVisitorAccountFirstName(visitorAccount);
                        case 2 -> modifyVisitorAccountLastName(visitorAccount);
                        case 3 -> modifyVisitorAccountBirthDate(visitorAccount);
                        case 4 -> modifyVisitorAccountPhoneNumber(visitorAccount);
                        case 5 -> modifyVisitorAccountEmail(visitorAccount);
                        case 6 -> modifyVisitorAccountAddress(visitorAccount);
                        case 7 -> modifyVisitorAccountPostalCode(visitorAccount);
                        case 8 -> modifyVisitorAccountCity(visitorAccount);
                        default -> utilView.printInvalidChoiceMsg();
                    }
                }
                break;
            }
        }
    }

    /**
     * Asks the user to modify a visitor account's city, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     */
    private void modifyVisitorAccountCity(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        boolean exceedLimit = false;
        String city = "";
        while (!exceedLimit) {
            view.printAskCity();
            city = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(city, 50);
        }

        visitorAccount.getAddress().setCity(city);
    }

    /**
     * Asks the user to modify a visitor's postal code, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     */
    private void modifyVisitorAccountPostalCode(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        boolean exceedLimit = false;
        String postalCode = "";
        while (!exceedLimit) {
            view.printAskPostalCode();
            postalCode = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(postalCode, 6);
        }

        visitorAccount.getAddress().setPostalCode(postalCode);
    }

    /**
     * Asks the user to modify a visitor account's address, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     */
    private void modifyVisitorAccountAddress(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        boolean exceedLimit = false;
        String address = "";
        while (!exceedLimit) {
            view.printAskStreetInfo();
            address = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(address, 100);
        }
        visitorAccount.getAddress().setStreetInfo(address);
    }

    /**
     * Asks the user to modify a visitor account's email, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     */
    private void modifyVisitorAccountEmail(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        view.printAskEmail();
        String email = sc.nextLine();
        visitorAccount.getInfo().setEmail(email);
    }

    /**
     * Asks the user to modify a visitor account's phone number, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     */
    private void modifyVisitorAccountPhoneNumber(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = "";

        boolean exceedLimit = false;
        while (!exceedLimit) {
            view.printAskPhoneNumber();
            phoneNumber = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(phoneNumber, 10);
        }
        visitorAccount.getInfo().setTelephoneNum(phoneNumber);
    }

    /**
     * Asks the user to modify a visitor's birthdate, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void modifyVisitorAccountBirthDate(VisitorAccount visitorAccount) throws ParseException {
        Scanner sc = new Scanner(System.in);
        boolean exceedLimit = false;
        String birthDateStr = "";

        while (!exceedLimit) {
            view.printAskBirthDate();
            birthDateStr = sc.nextLine();
            exceedLimit = ConstraintChecker.isDateFormatValid(birthDateStr);
        }
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        visitorAccount.setDateOfBirth(birthDate);
    }

    /**
     * Asks the user to modify a visitor's last name, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     */
    private void modifyVisitorAccountLastName(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        boolean exceedLimit = false;
        String lastName = "";

        while (!exceedLimit) {
            view.printAskEnterLName();
            lastName = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(lastName, 50);
        }
        visitorAccount.getInfo().setLastName(lastName);
    }

    /**
     * Asks the user to modify a visitor's first name, validates it and changes it
     *
     * @param visitorAccount The visitor account to modify
     */
    private void modifyVisitorAccountFirstName(VisitorAccount visitorAccount) {
        Scanner sc = new Scanner(System.in);
        boolean exceedLimit = false;
        String firstName = "";

        while (!exceedLimit) {
            view.printAskEnterFName();
            firstName = sc.nextLine();
            exceedLimit = ConstraintChecker.isCharLimitValid(firstName, 10);
        }
        visitorAccount.getInfo().setFirstName(firstName);
    }

    /**
     * Asks the user for a visitor account to delete and shows confirmation
     */
    private void deleteVisitorAccount() {
        Scanner sc = new Scanner(System.in);
        //System.out.println("delete visitor account");
        view.printAskAccountIdToDelete();
        String id = sc.nextLine();

        ArrayList<VisitorAccount> filteredAccounts = model.getVisitors().stream()
                .filter(visitor -> !visitor.getId().equals(id)).collect(toCollection(ArrayList::new));

        model.setVisitorAccounts(filteredAccounts);
        view.printAccountHasBeenDeleted();
    }

    /**
     * Prints all the visitors
     */
    private void showAllVisitors() {
        for (VisitorAccount visitor : model.getVisitors()) {
            view.printVisitors(visitor);
        }
    }

    /**
     * Runs the steps to add a visiitor account
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void addVisitorAccount() throws ParseException {
        Scanner sc = new Scanner(System.in);

        boolean exceedLimit = false;
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

        model.addVisitorAccount(new VisitorAccount(generateRandomDigitId(12), birthDate, info, address));
        view.printAccountCreated();
    }

    /**
     * Saves the visitor accounts created or modified
     */
    public void saveVisitors() {
        CsvWriter.saveVisitors(model.getVisitors());
    }

    /**
     * Saves the vaccination profiles created or modified
     */
    public void saveVaccinationProfiles() {
        ArrayList<VaccinationProfile> allVaccinationProfiles = new ArrayList<>();
        for (VisitorAccount visitorAccount : model.getVisitors()) {
            for (VaccinationProfile vaccine : visitorAccount.getVaccinationProfiles()) {
                allVaccinationProfiles.add(vaccine);
            }
        }
        CsvWriter.saveVaccinationProfiles(allVaccinationProfiles);
    }

    /**
     * Runs the menu to show visitors account for volunteer accounts
     */
    public void runShowMenuVolunteerVisiteurs() {
        boolean exit = false;
        while (!exit) {
            view.printVisitorMenuVolunteer();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showAllVisitors();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }
}
