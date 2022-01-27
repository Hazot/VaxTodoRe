package Entities;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * The appointment entity class used to define the appointment
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class Appointment implements Comparable<Appointment>{
    /**
     * Unique id of an appointment
     */
    private String id;
    /**
     * First name of a visitor on an appointment
     */
    private String firstName;
    /**
     * Last name of a visitor on an appointment
     */
    private String lastName;
    /**
     * Date of an appointment
     */
    private Date date;
    /**
     * Dose type for an appointment
     */
    private int doseType;

    /**
     * Constructor used to create any appointments in the program or from csv files
     *
     * @param id Unique id of the appointment
     * @param fName First name of a visitor
     * @param lName Last name of a visitor
     * @param date Date of the appointment
     * @param doseType Dose type for the appointment
     */
    public Appointment(String id, String fName, String lName, Date date, int doseType) {
        this.id = id;
        firstName = fName;
        lastName = lName;
        this.date = date;
        this.doseType = doseType;
    }

    /**
     * Gets the unique id of the appointment
     *
     * @return String unique id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the first name of a visitor on the appointment
     *
     * @return String first name of the visitor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of a visitor on the appointment
     *
     * @return String last name of the visitor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the date of the appointment
     *
     * @return Date of the appointment
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the appointment
     *
     * @param date date of the appointment
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the dose type for the appointment
     *
     * @return Dose type for the appointment
     */
    public int getDoseType() {
        return doseType;
    }

    /**
     * Pretty print for an appointment
     *
     * @return Printable string representing an appointment
     */
    @Override
    public String toString(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return "Date: " + dateFormatter.format(date) + ", Full Name: " + firstName + " " + lastName  + ", ID: " + id + ", Dose Type: " + doseType;
    }

    /**
     * Compares the date of the appointment with another appointment
     *
     * @param appointment Appointment object to compare
     * @return int comparison
     */
    @Override
    public int compareTo(Appointment appointment) {
        return date.compareTo(appointment.getDate());
    }
}
