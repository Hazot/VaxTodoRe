package Models;

import Csv.CsvParser;
import Entities.FormInfo;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * The form information model used to store the forms in a list and define methods used on the forms
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class FormInfoModel {
    /**
     * Lists of the forms
     */
    private ArrayList<FormInfo> formInfos = new ArrayList<>();

    /**
     * Constructor used to create the list of forms and define the methods
     *
     * @throws IOException Failed to read a file if it throws this error
     * @throws ParseException Failed to analyse any kind of parsing if it throws this error
     */
    public FormInfoModel() throws IOException, ParseException {
        setFormInfos(CsvParser.parseFormInfos());
    }

    /**
     * Gets the list of forms
     *
     * @return list of forms
     */
    public ArrayList<FormInfo> getFormInfos() {
        return formInfos;
    }

    /**
     * Sets the list of forms
     *
     * @param formInfos list of forms
     */
    public void setFormInfos(ArrayList<FormInfo> formInfos) {
        this.formInfos = formInfos;
    }

    /**
     * Adds a form to the list
     *
     * @param formInfo form information
     */
    public void addForm(FormInfo formInfo) {
        formInfos.add(formInfo);
    }
}
