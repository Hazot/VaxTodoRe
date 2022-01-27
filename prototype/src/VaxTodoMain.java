import Controllers.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * The Main class used to run the program and generate the controllers
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class VaxTodoMain {

    /**
     * The main method of the program.
     *
     * @param args The command line arguments
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static void main(String[] args) throws IOException, ParseException {
        Controller controller = new Controller();
        AppointmentController appointController = new AppointmentController();
        VisitorAccountController visController = new VisitorAccountController();
        SystemAccountController sysController = new SystemAccountController();
        FormInfoController formInfoController = new FormInfoController();

        Scanner sc = new Scanner(System.in);
        // userType: 0 == not connected, 1 == Employee account, 2 == Volunteer account
        int userType;

        // While not connected, try again
        do {
            sysController.showEnterUsernameMsg();
            String userName = sc.nextLine();
            sysController.showEnterPasswordMsg();
            String password = sc.nextLine();
            userType = sysController.login(userName, password);
        } while (userType == 0);

        
        if (userType == 1) {
            runEmployeeMainMenu(controller, sysController, appointController, visController, formInfoController);
        } else {
            runVolunteerMainMenu(controller, sysController, appointController, visController);
        }

        saveAll(appointController, sysController, visController, formInfoController);
    }

    /**
     * Shows the employees main menu and runs the choices and the feedback
     *
     * @param controller The main controller that is a parent of the other controllers, used for utils
     * @param sysController The system controller where we manage every request about the system accounts
     * @param appointController The appointment controller where we manage every request about appointments
     * @param visController The visitor controller where we manage every request about visitors
     * @param formInfoController The form information controller where we manage every request about the form
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static void runEmployeeMainMenu(Controller controller, SystemAccountController sysController,
                                           AppointmentController appointController,
                                           VisitorAccountController visController,
                                           FormInfoController formInfoController) throws IOException, ParseException {
        boolean exit = false;
        sysController.showHeader();
        while (!exit) {
            sysController.showView(1);
            int choice = sysController.getSelectionInput();
            switch (choice) {
                case 0 -> {
                    exit = true;
                    controller.utilView.printExitMsg();
                }
                case 1 -> appointController.runMenuGestionRDV();
                case 2 -> formInfoController.runMenuFormInfo();
                case 3 -> visController.runShowMenuVisiteurs();
                case 4 -> sysController.runGestionVolunteer();
                default -> controller.utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Shows the volunteers main menu and runs the choices and the feedback
     *
     * @param controller The main controller that is a parent of the other controllers, used for utils
     * @param sysController The system controller where we manage every request about the system accounts
     * @param appointController The appointment controller where we manage every request about appointments
     * @param visController The visitor controller where we manage every request about visitors
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static void runVolunteerMainMenu(Controller controller, SystemAccountController sysController,
                                            AppointmentController appointController,
                                            VisitorAccountController visController) throws IOException, ParseException {
        boolean exit = false;
        sysController.showHeader();
        while (!exit) {
            sysController.showView(2);
            int choice = controller.getSelectionInput();
            System.out.println(choice);
            switch (choice) {
                case 0 -> {
                    exit = true;
                    controller.utilView.printExitMsg();
                }
                case 1 -> appointController.runMenuVolunteerGestionRDV();
                case 2 -> visController.runShowMenuVolunteerVisiteurs();
                default -> controller.utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Saves the changes made to any database file
     *
     * @param appointController The appointment controller where we manage every request about appointments
     * @param systemAccountController The system controller where we manage every request about the system accounts
     * @param visitorAccountController The visitor controller where we manage every request about visitors
     * @param formInfoController The form information controller where we manage every request about the form
     */
    public static void saveAll(AppointmentController appointController, SystemAccountController systemAccountController,
                               VisitorAccountController visitorAccountController, FormInfoController formInfoController) {
        appointController.saveAppointments();
        systemAccountController.saveSysAccounts();
        visitorAccountController.saveVisitors();
        formInfoController.saveForms();
        visitorAccountController.saveVaccinationProfiles();
    }
}