/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class Countries {

    private String countryId;
    private String countryName;
    private int regionId;

    /**
     * Method Countries merupakan constructor method dari class Countries
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Memiliki access modifier public
     */
    public Countries() {
    }

    /**
     * Method Countries yang berfungsi untuk memberikan nilai pada variabel global dari class Countries yaitu
     * countryId dan countryName yang bertipe data string, regionId yang bertipe data int
     * dari parameter method Countries
     * Method Countries memiliki access modifier public
     */
    public Countries(String countryId, String countryName, int regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
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

    /**
     * Method getCountryName digunakan untuk mengambil nilai dari countryName
     * Method getCountryName memiliki access modifier public
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Method getCountryName digunakan untuk memberikakn nilai pada variabel global countryName  
     * berdasarkan variabel countryName pada parameter method getCountryName
     * Method getCountryName memiliki access modifier public
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
    /**
     * Method getRegionId digunakan untuk mengambil nilai dari regionId
     * Method getRegionId memiliki access modifier public
     */
    public int getRegionId() {
        return regionId;
    }

     /**
     * Method setRegionId digunakan untuk memberikakn nilai pada variabel global regionId  
     * berdasarkan variabel regionId pada parameter method setRegionId
     * Method setRegionId memiliki access modifier public
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

}
