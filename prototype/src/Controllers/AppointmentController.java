package Controllers;

import Csv.CsvWriter;
import Entities.Appointment;
import Models.AppointmentModel;
import Views.AppointmentView;
import constraintChecker.ConstraintChecker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.*;

import static java.util.stream.Collectors.toCollection;

/**
 * The Appointment controller for running the different tasks on the appointments
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class AppointmentController extends Controller {
    /**
     * Appointment model for the lists and the methods
     */
    private AppointmentModel model = new AppointmentModel();
    /**
     * Appointment view for the prints
     */
    private AppointmentView view = new AppointmentView();

    /**
     * Constructor for a general appointment controller
     *
     * @throws IOException    Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public AppointmentController() throws IOException, ParseException {
    }

    /**
     * Shows the appointment menu and runs the choices and the feedback
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void runMenuGestionRDV() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printAppointmentMenu();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showCalendar();
                case 2 -> addAppointment();
                case 3 -> showAppointmentOptions();
                case 4 -> notificationReminder();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Sends the notification reminder
     */
    private void notificationReminder() {
        view.printNotificationReminder();
    }

    /**
     * Shows all the appointments in the file
     */
    private void showAllAppointments() {
        //object, then arraylist
        for (Appointment appointment : model.getAppointments()) {
            view.printAppointment(appointment);
        }
    }

    /**
     * Show a specific appointment for a specific date and time
     */
    private void showSpecificAppointments() {
        //object, then arraylist
        Scanner sc = new Scanner(System.in);
        view.printAskDateSelection();
        String dateSelected = sc.nextLine();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ArrayList<Appointment> filteredAppointments = model.getAppointments().stream()
                .filter(appointment -> dateFormatter.format(appointment.getDate()).equals(dateSelected))
                .collect(toCollection(ArrayList::new));

        for (Appointment appointment : filteredAppointments) {
            view.printAppointment(appointment);
        }
    }

    /**
     * Formats a counter changing from 1 to 2 digits. Used for looping
     * (eg. hours in a day: 08, 09, 10, .... and not 010
     *
     * @param number number representing time
     * @return time in String
     */
    public String formatTime(Integer number) {
        if (number < 10) {
            return "0" + number.toString();
        } else {
            return number.toString();
        }
    }

    /**
     * Finds the time available of a day to show and returns it
     *
     * @param uniqueYearDate unique selected date of the year to show
     * @return hours of availabilities
     */
    public ArrayList<String> showDayAvailabilities(String uniqueYearDate) {
        // Format: 2021-03-12 15:00
        ArrayList<String> dayAvailabilities = new ArrayList<>();
        for (int i = 8; i < 18; i++) {
            String hourMinute;
            hourMinute = " " + formatTime(i) + ":00";
            String uniqueYearDateHour = uniqueYearDate + hourMinute;
            // Can't count if not 100% sure its not null
            if (model.getTimeSlots().get(uniqueYearDateHour) == null) {
                dayAvailabilities.add(uniqueYearDateHour);
            }
            if (model.getTimeSlots().get(uniqueYearDateHour) != null &&
                    model.getTimeSlots().get(uniqueYearDateHour) < 15) {
                dayAvailabilities.add(uniqueYearDateHour);
            }
        }
        return dayAvailabilities;
    }

    /**
     * Checks if a day is full of appointments by looking if there`s 15 appointments
     * in every timeslots
     *
     * @param uniqueYearDate a specific date without hours to check
     * @return boolean about if the day is full or not
     */
    public boolean isDayFullAppointments(String uniqueYearDate) {
        int sum = 0;
        for (int i = 0; i < 18; i++) {
            String hourMinute;
            hourMinute = " " + formatTime(i) + ":00";
            String uniqueYearDateHour = uniqueYearDate + hourMinute;
            // We need to check both conditions separately
            if (model.getTimeSlots().get(uniqueYearDateHour) != null &&
                    model.getTimeSlots().get(uniqueYearDateHour) >= 15) {
                sum += 15;
            }
        }
        if (sum >= 150) {
            return true;
        }
        return false;
    }

    /**
     * Shows 5 available days for vaccination with at least one place open
     *
     * @param date actual date
     */
    public void newShowNext5Availabilities(Date date) {
        ArrayList<Date> next5Availabilities = new ArrayList<>();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String uniqueYearDateHour;
        while (next5Availabilities.size() < 5) {
            uniqueYearDateHour = dateFormatter.format(date);
            if (!isDayFullAppointments(uniqueYearDateHour)) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                // skip weekends
                while (true) {
                    if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        cal.add(Calendar.DATE, 1);
                    } else {
                        break;
                    }
                }
                date = cal.getTime();
                next5Availabilities.add(date);
                cal.add(Calendar.DATE, 1);
                date = cal.getTime();
            }
        }

        view.printNext5AvailableDays();
        view.printDates(next5Availabilities);

        boolean exit = false;
        while (!exit) {
            view.printShowNext5Availabilities();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> {
                    newShowNext5Availabilities(date);
                    exit = true;
                }
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Shows the available period for a certain date
     */
    private void showDateAvailabilities() {
        Scanner sc = new Scanner(System.in);

        String dateSelected;
        while (true) {
            view.printAskDateNoHourSelection();
            dateSelected = sc.nextLine();

            if (ConstraintChecker.isDateFormatValid(dateSelected)) {
                break;
            }
            else {
                view.printInvalidDateFormat();
            }
        }
        view.printShowDateAvailabilities();
        ArrayList<String> filteredAvailableAppointments = showDayAvailabilities(dateSelected);

        for (String appointment : filteredAvailableAppointments) {
            view.printAvailableAppointment(appointment);
        }
    }

    /**
     * Runs the menu for the calendar and the options
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void showCalendar() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printCalendarOptions();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> newShowNext5Availabilities(new Date());
                case 2 -> showDateAvailabilities();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Runs the steps to add an appointment
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void addAppointment() throws ParseException {
        Scanner sc = new Scanner(System.in);

        String fName;
        while (true) {
            view.printAskEnterFName();
            fName = sc.nextLine();
            if (ConstraintChecker.isCharLimitValid(fName, 50)) {
                break;
            }
        }

        String lName;
        while (true) {
            view.printAskEnterLName();
            lName = sc.nextLine();
            if (ConstraintChecker.isCharLimitValid(lName, 50)) {
                break;
            }
        }

        String dateStr = askForDate(sc);
        String timeStr = askForTime(sc);

        if (model.getTimeSlots().get(dateStr + " " + timeStr) != null) {
            while (model.getTimeSlots().get(dateStr + " " + timeStr) >= 15) {
                view.printTooManyAppointmentsMsg();
                view.printAskEnterInfoAgain();
                dateStr = askForDate(sc);
                timeStr = askForTime(sc);
            }
        }

        String doseType;
        while (true) {
            view.printAskEnterDoseType();
            doseType = sc.nextLine();

            if (ConstraintChecker.isDoseTypeValid(doseType)) {
                break;
            }
        }

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateStr + " " + timeStr);

        model.addAppointment(new Appointment(generateRandomDigitId(6), fName, lName, date, Integer.parseInt(doseType)));
    }

    /**
     * Asks the user to enter a date
     *
     * @param sc an input scanner
     * @return a date in String
     */
    private String askForDate(Scanner sc) {
        String dateStr;
        while (true) {
            view.printAskEnterDate();
            dateStr = sc.nextLine();

            if (ConstraintChecker.isDateFormatValid(dateStr)) {
                break;
            }
        }

        return dateStr;
    }

    /**
     * Asks the user to enter a time
     *
     * @param sc an input scanner
     * @return a time in String
     */
    private String askForTime(Scanner sc) {
        String timeStr;
        while (true) {
            view.printAskEnterTime();
            timeStr = sc.nextLine();

            if (ConstraintChecker.isTimeFormatValid(timeStr)) {
                break;
            }
        }

        return timeStr;
    }

    /**
     * Runs the menu for the user to show the appointments with prompt and feedback
     */
    public void showAppointmentOptions() {
        boolean exit = false;
        while (!exit) {
            view.printAppointmentOptions();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showAllAppointments();
                case 2 -> showSpecificAppointments();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }

    /**
     * Saves the appointments created or modified
     */
    public void saveAppointments() {
        CsvWriter.saveAppointments(model.getAppointments());
    }

    /**
     * Runs the volunteer menu for the appointments and the calendar
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public void runMenuVolunteerGestionRDV() throws ParseException {
        boolean exit = false;
        while (!exit) {
            view.printAppointmentMenuVolunteer();
            int choice = getSelectionInput();
            switch (choice) {
                case 0 -> exit = true;
                case 1 -> showCalendar();
                case 2 -> addAppointment();
                case 3 -> showAppointmentOptions();
                default -> utilView.printInvalidChoiceMsg();
            }
        }
    }
}
