/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Rayhan
 */
public class Location {
    
    private int locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryId;

     /**
     * Method Location merupakan constructor method dari class Location
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Memiliki access modifier public
     */
    public Location() {
    }

    /**
     * Method Location yang berfungsi untuk memberikan nilai pada variabel global dari class Location yaitu
     * locationId yang bertipe data integer
     * streetAddress, postalCode, city, stateProvince dan countryId yang bertipe data string
     * dari parameter method Location
     * Method Location memiliki access modifier public
     */
    public Location(int locationId, String streetAddress, String postalCode, 
            String city, String stateProvince, String countryId) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    }

    /**
     * Method getLocationId digunakan untuk mengambil nilai dari locationId
     * Method getLocationId memiliki access modifier public
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * Method setLocationId digunakan untuk memberikakn nilai pada variabel global locationId  
     * berdasarkan variabel locationId pada parameter method setLocationId
     * Method setLocationId memiliki access modifier public
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * Method getStreetAddress digunakan untuk mengambil nilai dari streetAddress
     * Method getStreetAddress memiliki access modifier public
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Method setStreetAddress digunakan untuk memberikakn nilai pada variabel global streetAddress  
     * berdasarkan variabel streetAddress pada parameter method setStreetAddress
     * Method setStreetAddress memiliki access modifier public
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Method getPostalCode digunakan untuk mengambil nilai dari postalCode
     * Method getPostalCode memiliki access modifier public
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Method setPostalCode digunakan untuk memberikakn nilai pada variabel global postalCode  
     * berdasarkan variabel postalCode pada parameter method setPostalCode
     * Method setPostalCode memiliki access modifier public
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Method getCity digunakan untuk mengambil nilai dari city
     * Method getCity memiliki access modifier public
     */
    public String getCity() {
        return city;
    }

    /**
     * Method setCity digunakan untuk memberikakn nilai pada variabel global city  
     * berdasarkan variabel city pada parameter method setCity
     * Method setCity memiliki access modifier public
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method getStateProvince digunakan untuk mengambil nilai dari stateProvince
     * Method getStateProvince memiliki access modifier public
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * Method setStateProvince digunakan untuk memberikakn nilai pada variabel global stateProvince  
     * berdasarkan variabel stateProvince pada parameter method setStateProvince
     * Method setStateProvince memiliki access modifier public
     */
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

     /**
     * Method getCountryId digunakan untuk mengambil nilai dari countryId
     * Method getCountryId memiliki access modifier public
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * Method setCountryId digunakan untuk memberikakn nilai pada variabel global countryId  
     * berdasarkan variabel countryId pada parameter method setCountryId
     * Method setCountryId memiliki access modifier public
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
    
    
    
    
    
}
