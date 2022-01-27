package Controllers;

import Csv.CsvWriter;
import Entities.FormInfo;
import Models.FormInfoModel;
import Views.FormInfoView;
import constraintChecker.ConstraintChecker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The form information controller for running the different tasks on the form
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class FormInfoController extends Controller {
    /**
     * Form information model for the lists and the methods
     */
    private FormInfoModel model = new FormInfoModel();

    /**
     * Form information view for the prints
     */
    private FormInfoView view = new FormInfoView();

    /**
     * Constructor for a general form information controller
     *
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public FormInfoController() throws IOException, ParseException {
    }

    /**
     * Shows the form information menu and runs the choices and the feedback
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void runMenuFormInfo() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printFormOptions();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showForms();
                case 2 -> printForms();
                case 3 -> addForm();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Asks for visitor ID and shows the form information associated
     */
    private void showForms() {
        Scanner sc = new Scanner(System.in);
        ArrayList<FormInfo> visitorForms = new ArrayList<>();
        String visitorId;

        do {
            while (true) {
                view.askVisitorId();
                visitorId = sc.nextLine();
                if (visitorId.length() == 12) {
                    break;
                }
            }

            for (FormInfo formInfo : model.getFormInfos()) {
                if (formInfo.getVisitorId().equals(visitorId)) {
                    visitorForms.add(formInfo);
                }
            }
        }
        while (visitorForms.size() == 0);

        for (int i = 0; i < visitorForms.size(); i++) {
            view.printFormSeperator();
            view.printFormNumber(i + 1);
            view.printForm(visitorForms.get(i));
            view.printFormSeperator();
        }
    }

    /**
     * Prints the information of the forms
     */
    private void printForms() {
        view.printPrintingConfirmation();
    }

    /**
     * Asks the information to fill a new form
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    private void addForm() throws ParseException {
        Scanner sc = new Scanner(System.in);

        // On connait deja le numero de compte, prenom, nom, date de naissance et num d'assurance maladie

        String visitorId;
        while (true) {
            view.askVisitorId();
            visitorId = sc.nextLine();
            if (visitorId.length() == 12) {
                break;
            }
        }

        String fName;
        while (true) {
            view.askVisitorFName();
            fName = sc.nextLine();
            if (ConstraintChecker.isCharLimitValid(fName, 50)) {
                break;
            }
        }

        String lName;
        while (true) {
            view.askVisitorLName();
            lName = sc.nextLine();
            if (ConstraintChecker.isCharLimitValid(fName, 50)) {
                break;
            }
        }

        String birthDateStr;
        while (true) {
            view.askVisitorBirthDate();
            birthDateStr = sc.nextLine();
            if (ConstraintChecker.isDateFormatValid(birthDateStr)) {
                break;
            }
        }

        String healthInsuranceNum;
        view.askVisitorHealthInsuranceNum();
        // ca enleve les espaces vides du str
        healthInsuranceNum = sc.nextLine().replaceAll("\\s+", "");

        String visitDateStr;
        while (true) {
            view.printAskVisitDate();
            visitDateStr = sc.nextLine();
            if (ConstraintChecker.isDateFormatValid(visitDateStr)) {
                break;
            }
        }

        boolean hasReceivedFirstDose;
        while (true) {
            view.printAskHasReceivedFirstDose();
            String answer = sc.nextLine();
            if (ConstraintChecker.isOuiNonAnswerValid(answer)) {
                hasReceivedFirstDose = ouiNonAnswerToBoolean(answer);
                break;
            }
        }

        boolean hasContractedCovid;
        while (true) {
            view.printAskHasContractedCovid();
            String answer = sc.nextLine();
            if (ConstraintChecker.isOuiNonAnswerValid(answer)) {
                hasContractedCovid = ouiNonAnswerToBoolean(answer);
                break;
            }
        }

        boolean hasCovidSymptoms;
        while (true) {
            view.printAskHasCovidSymptoms();
            String answer = sc.nextLine();
            if (ConstraintChecker.isOuiNonAnswerValid(answer)) {
                hasCovidSymptoms = ouiNonAnswerToBoolean(answer);
                break;
            }
        }

        boolean hasAllergies;
        while (true) {
            view.printAskHasAllergies();
            String answer = sc.nextLine();
            if (ConstraintChecker.isOuiNonAnswerValid(answer)) {
                hasAllergies = ouiNonAnswerToBoolean(answer);
                break;
            }
        }

        String vaccineChoice = null;
        while (true) {
            view.printAskVaccineChoice();
            String numChoice = sc.nextLine();
            if (ConstraintChecker.isVaccineChoiceValid(numChoice)) {
                switch (Integer.parseInt(numChoice)) {
                    case 1 -> vaccineChoice = "Moderna";
                    case 2 -> vaccineChoice = "Pfizer";
                    case 3 -> vaccineChoice = "AstraZeneca";
                    case 4 -> vaccineChoice = "Janssen";
                }
                break;
            }
        }

        boolean wasVaccineAdministered;
        while (true) {
            view.printAskWasVaccineAdministered();
            String answer = sc.nextLine();
            if (ConstraintChecker.isOuiNonAnswerValid(answer)) {
                wasVaccineAdministered = ouiNonAnswerToBoolean(answer);
                break;
            }
        }

        String administeredVaccine = null;
        while (true) {
            view.printAskAdministeredVaccineName();
            String numChoice = sc.nextLine();
            if (ConstraintChecker.isVaccineChoiceValid(numChoice)) {
                switch (Integer.parseInt(numChoice)) {
                    case 1 -> administeredVaccine = "Moderna";
                    case 2 -> administeredVaccine = "Pfizer";
                    case 3 -> administeredVaccine = "AstraZeneca";
                    case 4 -> administeredVaccine = "Janssen";
                }

                break;
            }
        }

        String vaccineCode;
        while (true) {
            view.printAskVaccineCode();
            vaccineCode = sc.nextLine();

            if (ConstraintChecker.isCharLimitValid(vaccineCode, 24)) {
                break;
            }
        }

        Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        Date visitDate = new SimpleDateFormat("yyyy-MM-dd").parse(visitDateStr);

        model.addForm(new FormInfo(visitorId, fName, lName, dateOfBirth, healthInsuranceNum, visitDate,
                hasReceivedFirstDose, hasContractedCovid, hasCovidSymptoms, hasAllergies, vaccineChoice,
                wasVaccineAdministered, administeredVaccine, vaccineCode));
        view.showFormulaireAdded();
    }

    /**
     * Associates "oui" to True and vice-versa
     *
     * @param answer String answer input
     * @return Boolean True or False associated with the right word
     */
    private boolean ouiNonAnswerToBoolean(String answer) {
        if (answer.equals("oui")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Saves the forms created
     */
    public void saveForms() {
        CsvWriter.saveFormInfos(model.getFormInfos());
    }
}
