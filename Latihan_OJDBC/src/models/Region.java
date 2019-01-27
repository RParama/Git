/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kresna92
 */
public class Region {

    private int regionId;
    private String regionName;
    
    public Region(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    /**
     * Method Region merupakan constructor method dari class Region
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Memiliki access modifier public
     */
    public Region() {
    }

    /**
     * Method Region yang berfungsi untuk memberikan nilai pada variabel global dari class Region yaitu
     * regionId yang bertipe data integer, regionName yang bertipe data string
     * dari parameter method Region
     * Method Region memiliki access modifier public
     */
    public Region(int regionId, String regionName) {
        this.regionId = regionId;
    }

    /**
     * Method getRegionId digunakan untuk mengambil nilai dari regionId
     * Method getRegionId memiliki access modifier public
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * Method getRegionName digunakan untuk mengambil nilai dari regionName
     * Method getRegionName memiliki access modifier public
     */
    public String getRegionName() {
        return regionName;
    }

     /**
     * Method setRegionId digunakan untuk memberikakn nilai pada variabel global regionId  
     * berdasarkan variabel regionId pada parameter method setRegionId
     * Method setRegionId memiliki access modifier public
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * Method setRegionName digunakan untuk memberikakn nilai pada variabel global regionName  
     * berdasarkan variabel regionName pada parameter method setRegionName
     * Method setRegionName memiliki access modifier public
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
}
