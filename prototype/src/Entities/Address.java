package Entities;

/**
 * The address entity class used to define the address
 *
 * @author Antoine Ho
 * @author Mendel Sun
 * @author Kevin Lessard
 */
public class Address {
    /**
     * Street part of an address (Street number, name and apt)
     */
    private String streetInfo;
    /**
     * Postal code part of an address
     */
    private String postalCode;
    /**
     * City part of an address
     */
    private String city;

    /**
     * Constructor of any general address
     *
     * @param street street number, street name combined in a string
     * @param postalCode postal code string
     * @param city city string
     */
    public Address(String street, String postalCode, String city) {
        this.streetInfo = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    /**
     * Gets the street number and name
     * @return street number and name
     */
    public String getStreetInfo() {
        return streetInfo;
    }

    /**
     * Sets the street number and name
     *
     * @param streetInfo street number and name
     */
    public void setStreetInfo(String streetInfo) {
        this.streetInfo = streetInfo;
    }

    /**
     * Gets the postal code of an address
     *
     * @return string postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of an address
     *
     * @param postalCode string postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the city name of an address
     *
     * @return string city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city name of an address
     *
     * @param city string city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Pretty print for an address
     *
     * @return printable address
     */
    @Override
    public String toString() {
        return streetInfo + " " + postalCode + " " + city;
    }
}
