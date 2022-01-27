package Csv;

import Entities.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * The CsvParser is a utility class used to parse data into csv format
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class CsvWriter {

    /**
     * Parses the data from the arraylist for visitors and stores it into csv format
     *
     * @param visitors ArrayList of the visitor accounts stored in the program
     */
    public static void saveVisitors(ArrayList<VisitorAccount> visitors) {
        try (PrintWriter writer = new PrintWriter("src/CsvData/Visitors.csv")){
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            StringBuilder sb = new StringBuilder();

            for (VisitorAccount visitor : visitors) {
                sb.append(visitor.getId());
                sb.append(",");
                sb.append(dateFormatter.format(visitor.getDateOfBirth()));
                sb.append(",");
                sb.append(visitor.getInfo().getFirstName());
                sb.append(",");
                sb.append(visitor.getInfo().getLastName());
                sb.append(",");
                sb.append(visitor.getInfo().getTelephoneNum());
                sb.append(",");
                sb.append(visitor.getInfo().getEmail());
                sb.append(",");
                sb.append(visitor.getAddress().getStreetInfo());
                sb.append(",");
                sb.append(visitor.getAddress().getPostalCode());
                sb.append(",");
                sb.append(visitor.getAddress().getCity());
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the data from the arraylist for employees and stores it into csv format
     *
     * @param employeeAccounts ArrayList of the employee accounts stored in the program
     */
    public static void saveEmployees(ArrayList<EmployeeAccount> employeeAccounts) {
        try (PrintWriter writer = new PrintWriter("src/CsvData/Employees.csv")){
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            for (EmployeeAccount employee : employeeAccounts) {
                sb.append(employee.getId());
                sb.append(",");
                sb.append(employee.getUsername());
                sb.append(",");
                sb.append(employee.getPassword());
                sb.append(",");
                sb.append(employee.getPersonalInfo().getFirstName());
                sb.append(",");
                sb.append(employee.getPersonalInfo().getLastName());
                sb.append(",");
                sb.append(employee.getPersonalInfo().getTelephoneNum());
                sb.append(",");
                sb.append(employee.getPersonalInfo().getEmail());
                sb.append(",");
                sb.append(employee.getAddress().getStreetInfo());
                sb.append(",");
                sb.append(employee.getAddress().getPostalCode());
                sb.append(",");
                sb.append(employee.getAddress().getCity());
                sb.append(",");
                sb.append(dateFormatter.format(employee.getDateOfBirth()));
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the data from the arraylist for volunteers and stores it into csv format
     *
     * @param volunteerAccounts ArrayList of the volunteer accounts stored in the program
     */
    public static void saveVolunteer(ArrayList<VolunteerAccount> volunteerAccounts) {
        try (PrintWriter writer = new PrintWriter("src/CsvData/Volunteers.csv")){
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            for (VolunteerAccount volunteer : volunteerAccounts) {
                sb.append(volunteer.getId());
                sb.append(",");
                sb.append(volunteer.getUsername());
                sb.append(",");
                sb.append(volunteer.getPassword());
                sb.append(",");
                sb.append(volunteer.getPersonalInfo().getFirstName());
                sb.append(",");
                sb.append(volunteer.getPersonalInfo().getLastName());
                sb.append(",");
                sb.append(volunteer.getPersonalInfo().getTelephoneNum());
                sb.append(",");
                sb.append(volunteer.getPersonalInfo().getEmail());
                sb.append(",");
                sb.append(volunteer.getAddress().getStreetInfo());
                sb.append(",");
                sb.append(volunteer.getAddress().getPostalCode());
                sb.append(",");
                sb.append(volunteer.getAddress().getCity());
                sb.append(",");
                sb.append(dateFormatter.format(volunteer.getDateOfBirth()));
                for (String dayName:volunteer.getSchedule()) {
                    sb.append(",");
                    sb.append(dayName);
                }
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the data from the arraylist for vaccination profiles and stores it into csv format
     *
     * @param vaccinationProfiles ArrayList of the vaccination profiles stored in the program
     */
    public static void saveVaccinationProfiles(ArrayList<VaccinationProfile> vaccinationProfiles) {
        try (PrintWriter writer = new PrintWriter("src/CsvData/VaccinationProfiles.csv")){
            StringBuilder sb = new StringBuilder();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            for (VaccinationProfile vaccinationProfile : vaccinationProfiles) {
                sb.append(vaccinationProfile.getVisitorId());
                sb.append(",");
                sb.append(dateFormatter.format(vaccinationProfile.getVaccinationDate()));
                sb.append(",");
                sb.append(vaccinationProfile.getDoseType());
                sb.append(",");
                sb.append(vaccinationProfile.getVaccineName());
                sb.append(",");
                sb.append(vaccinationProfile.getVaccineCode());
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the data from the arraylist for form information and stores it into csv format
     *
     * @param formInfos ArrayList of the forms stored in the program
     */
    public static void saveFormInfos(ArrayList<FormInfo> formInfos) {
        try (PrintWriter writer = new PrintWriter("src/CsvData/FormInfos.csv")){
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            for (FormInfo formInfo : formInfos) {
                sb.append(formInfo.getVisitorId());
                sb.append(",");
                sb.append(formInfo.getFirstName());
                sb.append(",");
                sb.append(formInfo.getLastName());
                sb.append(",");
                sb.append(dateFormatter.format(formInfo.getDateOfBirth()));
                sb.append(",");
                sb.append(formInfo.getHealthInsuranceNum());
                sb.append(",");
                sb.append(dateFormatter.format(formInfo.getVisitDate()));
                sb.append(",");
                sb.append(formInfo.getHasReceivedFirstDose());
                sb.append(",");
                sb.append(formInfo.getHasContractedCovid());
                sb.append(",");
                sb.append(formInfo.getHasCovidSymptoms());
                sb.append(",");
                sb.append(formInfo.getHasAllergies());
                sb.append(",");
                sb.append(formInfo.getVaccineChoice());
                sb.append(",");
                sb.append(formInfo.getWasVaccineAdministered());
                sb.append(",");
                sb.append(formInfo.getVaccineName());
                sb.append(",");
                sb.append(formInfo.getVaccineCode());
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the data from the arraylist for appointments and stores it into csv format
     *
     * @param appointments ArrayList of the appointments stored in the program
     */
    public static void saveAppointments(ArrayList<Appointment> appointments) {
        try (PrintWriter writer = new PrintWriter("src/CsvData/Appointments.csv")){
            StringBuilder sb = new StringBuilder();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            for (Appointment appointment : appointments) {
                sb.append(appointment.getId());
                sb.append(",");
                sb.append(appointment.getFirstName());
                sb.append(",");
                sb.append(appointment.getLastName());
                sb.append(",");
                sb.append(dateFormatter.format(appointment.getDate()));
                sb.append(",");
                sb.append(new SimpleDateFormat("HH:mm").format(appointment.getDate()));
                sb.append(",");
                sb.append(appointment.getDoseType());
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
