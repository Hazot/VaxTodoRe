package Csv;

import Entities.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The CsvParser is a utility class used to parse data from csv format
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class CsvParser {

    /**
     * Turns the csv file information into visitor entities and fills an arraylist with visitors
     *
     * @return Arraylist of visitor entities
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static ArrayList<VisitorAccount> parseVisitors() throws IOException, ParseException {
        ArrayList<VisitorAccount> visitors = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/CsvData/Visitors.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[1]);
            visitors.add(new VisitorAccount(tokens[0], date,
                                            new PersonalInfo(tokens[2], tokens[3], tokens[4], tokens[5]),
                                            new Address(tokens[6], tokens[7], tokens[8])
            ));
        }

        reader.close();
        return visitors;
    }

    /**
     * Turns the csv file information into employee entities and fills an arraylist with employees
     *
     * @return Arraylist of employee entities
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static ArrayList<EmployeeAccount> parseEmployees() throws IOException, ParseException {
        ArrayList<EmployeeAccount> employees = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/CsvData/Employees.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            PersonalInfo personalInfo = new PersonalInfo(tokens[3], tokens[4], tokens[5], tokens[6]);
            Address address = new Address(tokens[7], tokens[8], tokens[9]);
            Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[10]);
            employees.add(new EmployeeAccount(tokens[0], tokens[1], tokens[2], personalInfo, address, dateOfBirth));
        }

        reader.close();
        return employees;
    }

    /**
     * Turns the csv file information into volunteer entities and fills an arraylist with volunteers
     *
     * @return Arraylist of volunteer entities
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static ArrayList<VolunteerAccount> parseVolunteers() throws IOException, ParseException {
        ArrayList<VolunteerAccount> volunteers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/CsvData/Volunteers.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            PersonalInfo personalInfo = new PersonalInfo(tokens[3], tokens[4], tokens[5], tokens[6]);
            Address address = new Address(tokens[7], tokens[8], tokens[9]);
            Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[10]);
            // any tokens that come after tokens[10] are the availabilities
            if (tokens.length > 11) {
                ArrayList<String> schedule = new ArrayList<>();
                for (int i = 11; i < tokens.length; i++) {
                    schedule.add(tokens[i]);
                }
                volunteers.add(new VolunteerAccount(tokens[0], tokens[1], tokens[2], personalInfo, address, dateOfBirth, schedule));
            }
            else {

                volunteers.add(new VolunteerAccount(tokens[0], tokens[1], tokens[2], personalInfo, address, dateOfBirth));
            }
        }


        reader.close();
        return volunteers;
    }

    /**
     * Turns the csv file information into vaccination profiles and fills an arraylist with profiles
     *
     * @return Arraylist of vaccination profiles
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static ArrayList<VaccinationProfile> parseVaccinationProfiles() throws IOException, ParseException {
        ArrayList<VaccinationProfile> vaccinationProfiles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/CsvData/VaccinationProfiles.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[1]);
            vaccinationProfiles.add(new VaccinationProfile(tokens[0], date, Integer.parseInt(tokens[2]), tokens[3], Long.parseLong(tokens[4])));
        }

        reader.close();
        return vaccinationProfiles;
    }

    /**
     * Turns the csv file information into forms and fills an arraylist with forms
     *
     * @return Arraylist of forms
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static ArrayList<FormInfo> parseFormInfos() throws IOException, ParseException {
        ArrayList<FormInfo> formInfos = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/CsvData/FormInfos.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[3]);
            Date dateOfVisit = new SimpleDateFormat("yyyy-MM-dd").parse(tokens[5]);
            boolean hasReceivedFirstDose = Boolean.parseBoolean(tokens[6]);
            boolean hasContractedCovid = Boolean.parseBoolean(tokens[7]);
            boolean hasCovidSymptoms = Boolean.parseBoolean(tokens[8]);
            boolean hasAllergies = Boolean.parseBoolean(tokens[9]);
            boolean wasVaccineAdministered = Boolean.parseBoolean(tokens[11]);

            formInfos.add(new FormInfo(tokens[0], tokens[1], tokens[2], dateOfBirth, tokens[4], dateOfVisit,
                    hasReceivedFirstDose, hasContractedCovid, hasCovidSymptoms, hasAllergies, tokens[10],
                    wasVaccineAdministered, tokens[12], tokens[13]));
        }

        reader.close();
        return formInfos;
    }

    /**
     * Turns the csv file information into appointments and fills an arraylist with appointments
     *
     * @return Arraylist of appointments
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public static ArrayList<Appointment> parseAppointments() throws IOException, ParseException {
        ArrayList<Appointment> appointments = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/CsvData/Appointments.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(tokens[3] + " " + tokens[4]);
            appointments.add(new Appointment(tokens[0], tokens[1], tokens[2], date, Integer.parseInt(tokens[5])));
        }

        reader.close();
        return appointments;
    }
}
