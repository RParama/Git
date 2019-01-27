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
public class Department {
    
    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;

    /**
     * Method Department merupakan constructor method dari class Department
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Memiliki access modifier public
     */
    public Department() {
    }

    /**
     * Method Department yang berfungsi untuk memberikan nilai pada variabel global dari class Department yaitu
     * departmentId, managerId dan locationId yang bertipe data integer, departmentName yang bertipe data string
     * dari parameter method Department
     * Method Department memiliki access modifier public
     */
    public Department(int departmentId, String departmentName, int managerId, int locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    /**
     * Method getDepartmentId digunakan untuk mengambil nilai dari departmentId
     * Method getDepartmentId memiliki access modifier public
     */
    public int getDepartmentId() {
        return departmentId;
    }

     /**
     * Method setDepartmentId digunakan untuk memberikakn nilai pada variabel global departmentId  
     * berdasarkan variabel departmentId pada parameter method setDepartmentId
     * Method setDepartmentId memiliki access modifier public
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

     /**
     * Method getDepartmentName digunakan untuk mengambil nilai dari departmentName
     * Method getDepartmentName memiliki access modifier public
     */
    public String getDepartmentName() {
        return departmentName;
    }

     /**
     * Method setDepartmentName digunakan untuk memberikakn nilai pada variabel global departmentName  
     * berdasarkan variabel departmentName pada parameter method setDepartmentName
     * Method setDepartmentName memiliki access modifier public
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

     /**
     * Method getManagerId digunakan untuk mengambil nilai dari managerId
     * Method getManagerId memiliki access modifier public
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * Method setManagerId digunakan untuk memberikakn nilai pada variabel global managerId  
     * berdasarkan variabel managerId pada parameter method setManagerId
     * Method setManagerId memiliki access modifier public
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
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
     * berdasarkan variabel managerId pada parameter method setLocationId
     * Method setLocationId memiliki access modifier public
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
    
    
    
}
