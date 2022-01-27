import Controllers.AppointmentController;
import Entities.Appointment;
import Models.AppointmentModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * The appointment tests class calls assertion tests for the appointment management
 * side of the application
 *
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class AppointmentTests {

    /**
     * Tests the addition of an appointment into the list of the model
     *
     * @author Mendel Sun
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     * @throws IOException Failed to read a file if it throws this error
     */
    @Test
    void TestAddAppointment() throws ParseException, IOException {
        String vaxDateStr1 = "2021-12-25";
        Date vaxDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(vaxDateStr1);
        String vaxDateStr2 = "2022-02-28";
        Date vaxDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(vaxDateStr2);
        Appointment appointment1 = new Appointment("123456", "anna", "brown", vaxDate1, 1);
        Appointment appointment2 = new Appointment("789101", "anna", "brown", vaxDate2, 2);

        // Puts the visitors in an array list
        ArrayList<Appointment> appointList = new ArrayList<>();
        appointList.add(appointment1);
        appointList.add(appointment2);

        // Use the appointment list from the model
        AppointmentModel model = new AppointmentModel();
        model.addAppointment(new Appointment("123456", "anna", "brown", vaxDate1, 1));
        model.addAppointment(new Appointment("789101", "anna", "brown", vaxDate2, 2));

        // Gets the list created by the model
        int idx1 = model.getAppointments().size() - 2;
        int idx2 = model.getAppointments().size();
        ArrayList<Appointment> modelArray= new ArrayList<>(model.getAppointments().subList(idx1, idx2));

        Assertions.assertEquals(appointList.toString(), modelArray.toString());
    }

    /**
     * Checks if the hours the constraint on the availability hours works
     *
     * @author Kevin Lessard
     *
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     * @throws IOException Failed to read a file if it throws this error
     */
    @Test
    void showDayAvailabilitiesTest() throws ParseException, IOException {

        AppointmentModel model = new AppointmentModel();

        // Creates an appointment for 13:00
        String vaxDateHourStr = "2069-04-20 13:00";
        Date vaxDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(vaxDateHourStr);
        Appointment appointment = new Appointment("121314", "hannah", "brown", vaxDate, 2);

        // Adds 15 appointments to the model list to fill the 13:00 mark
        for (int i = 0; i < 15; i++) {
            model.addAppointment(appointment);
        }

        // Finds the available hours for a specific date with the method
        String vaxDateStr = "2069-04-20";
        ArrayList<String> dayAvailabilities = new ArrayList<>(model.showDayAvailabilities(vaxDateStr));

        // Creates a list of available hours from scratch without 13:00 for comparison
        ArrayList<String> homemadeDayAvailabilities = new ArrayList<>();
        homemadeDayAvailabilities.add("2069-04-20 08:00");
        homemadeDayAvailabilities.add("2069-04-20 09:00");
        homemadeDayAvailabilities.add("2069-04-20 10:00");
        homemadeDayAvailabilities.add("2069-04-20 11:00");
        homemadeDayAvailabilities.add("2069-04-20 12:00");
        homemadeDayAvailabilities.add("2069-04-20 14:00");
        homemadeDayAvailabilities.add("2069-04-20 15:00");
        homemadeDayAvailabilities.add("2069-04-20 16:00");
        homemadeDayAvailabilities.add("2069-04-20 17:00");

        // Tests if the lists are equals
        Assertions.assertEquals(homemadeDayAvailabilities, dayAvailabilities);
    }

    /**
     * Tests the time formatting method to be able to use loops to check available hours in a day
     *
     * @author Mendel Sun
     *
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    @Test
    void timeFormatTest() throws IOException, ParseException {

        // Creates a homemade list of problematic times
        ArrayList<String> timesHomemade = new ArrayList<>();
        timesHomemade.add("08:00");
        timesHomemade.add("09:00");
        timesHomemade.add("10:00");
        timesHomemade.add("11:00");
        timesHomemade.add("12:00");

        // Creates a list of problematic times from the method
        AppointmentModel model = new AppointmentModel();
        ArrayList<String> times = new ArrayList<>();

        // Adds the same times
        for (int i = 8; i < 13; i++) {
            times.add(model.formatTime(i) + ":00");
        }

        // Tests if the lists are the same
        Assertions.assertEquals(timesHomemade, times);
    }

}
