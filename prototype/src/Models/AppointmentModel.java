package Models;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import Csv.CsvParser;
import Entities.Appointment;
import Entities.VisitorAccount;
import java.time.LocalDateTime;

import java.io.IOException;
import java.text.ParseException;

/**
 * The appointment model used to store the appointment list and define methods
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class AppointmentModel {
    /**
     * Appointment list used by the program
     */
    private ArrayList<Appointment> appointments = new ArrayList<>();
    /**
     * Timeslot list used with an hashmap
     */
    private HashMap<String, Integer> timeSlots = new HashMap<>();

    /**
     * Constructor used to create the list of appointments and define the possible methods
     *
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public AppointmentModel() throws IOException, ParseException {

        setAppointments(CsvParser.parseAppointments());
        Collections.sort(appointments);

        for (Appointment appointment: appointments) {
            addToHashMap(appointment);
        }
    }

    /**
     * Gets the appointment list
     *
     * @return the appointments in an ArrayList
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Sets the appointment list
     *
     * @param appointments the appointments in an ArrayList
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Gets the possible time slots for the appointments
     *
     * @return Hashmap of the time slots
     */
    public HashMap<String, Integer> getTimeSlots() {
        return timeSlots;
    }

    /**
     * Adds an appointment to the list of appointments
     *
     * @param appointment appointment
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        addToHashMap(appointment);
    }

    /**
     * Adds an appointment to the time slot list
     *
     * @param appointment appointment
     */
    private void addToHashMap(Appointment appointment) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String uniqueYearDateHour = dateFormatter.format(appointment.getDate());
        if (timeSlots.get(uniqueYearDateHour) == null){
            timeSlots.put(uniqueYearDateHour, 1);
        } else {
            timeSlots.put(uniqueYearDateHour, timeSlots.get(uniqueYearDateHour) + 1);
        }
    }


    /**
     * Finds the dates available to show and returns it
     *
     * @param uniqueYearDate unique selected date of the year to show
     * @return hours of availabilities
     */
    public ArrayList<String> showDayAvailabilities(String uniqueYearDate){
        // Format: 2021-03-12 15:00
        ArrayList<String> dayAvailabilities = new ArrayList<>();
        for (int i=8; i < 18; i++){
            String hourMinute;
            hourMinute = " " + formatTime(i) + ":00";
            String uniqueYearDateHour = uniqueYearDate + hourMinute;
            // Can't count if not 100% sure its not null
            if (getTimeSlots().get(uniqueYearDateHour) == null) {
                dayAvailabilities.add(uniqueYearDateHour);
            }
            if (getTimeSlots().get(uniqueYearDateHour) != null &&
                    getTimeSlots().get(uniqueYearDateHour) < 15) {
                dayAvailabilities.add(uniqueYearDateHour);
            }
        }
        return dayAvailabilities;
    }

    /**
     * Formats a counter changing from 1 to 2 digits. Used for looping
     * (eg. hours in a day: 08, 09, 10, .... and not 010
     *
     * @param number number representing time
     * @return time in String
     */
    public String formatTime(Integer number){
        if(number<10){
            return "0" + number.toString();
        } else{
            return number.toString();
        }
    }
}
