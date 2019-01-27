/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author kresna92
 */
public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private Date hire;
    private String job;
    private int salary;
    private int commission;
    private int manager;
    private int department;

    /**
     * Method Employee yang berfungsi untuk memberikan nilai pada variabel global dari class Employee yaitu
     * id, salary, commision, manager dan department yang bertipe data integer, 
     * first_name, last_name, email, phone dan yang bertipe data string
     * dari parameter method Department
     * Method Employee memiliki access modifier public
     */
    public Employee(int id, String first_name, String last_name, String email, String phone, Date hire, String job, int salary, int commision, int manager, int department) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.hire = hire;
        this.job = job;
        this.salary = salary;
        this.commission = commision;
        this.manager = manager;
        this.department = department;
    }

     /**
     * Method getId digunakan untuk mengambil nilai dari id
     * Method getId memiliki access modifier public
     */
    public int getId() {
        return id;
    }

    /**
     * Method getFirst_name digunakan untuk mengambil nilai dari first_name
     * Method getFirst_name memiliki access modifier public
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Method getLast_name digunakan untuk mengambil nilai dari last_name
     * Method getLast_name memiliki access modifier public
     */
    public String getLast_name() {
        return last_name;
    }

     /**
     * Method getEmail digunakan untuk mengambil nilai dari email
     * Method getEmail memiliki access modifier public
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method setId digunakan untuk memberikakn nilai pada variabel global id  
     * berdasarkan variabel id pada parameter method setId
     * Method setId memiliki access modifier public
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method setFirst_name digunakan untuk memberikakn nilai pada variabel global first_name  
     * berdasarkan variabel first_name pada parameter method setFirst_name
     * Method setFirst_name memiliki access modifier public
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Method setLast_name digunakan untuk memberikakn nilai pada variabel global last_name  
     * berdasarkan variabel last_name pada parameter method setLast_name
     * Method setLast_name memiliki access modifier public
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Method setEmail digunakan untuk memberikakn nilai pada variabel global email  
     * berdasarkan variabel email pada parameter method setEmail
     * Method setEmail memiliki access modifier public
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method setPhone digunakan untuk memberikakn nilai pada variabel global phone  
     * berdasarkan variabel phone pada parameter method setPhone
     * Method setPhone memiliki access modifier public
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

     /**
     * Method setHire digunakan untuk memberikakn nilai pada variabel global hire  
     * berdasarkan variabel hire pada parameter method setHire
     * Method setHire memiliki access modifier public
     */
    public void setHire(Date hire) {
        this.hire = hire;
    }

     /**
     * Method setJob digunakan untuk memberikakn nilai pada variabel global job  
     * berdasarkan variabel job pada parameter method setJob
     * Method setJob memiliki access modifier public
     */
    public void setJob(String job) {
        this.job = job;
    }

     /**
     * Method setSalary digunakan untuk memberikakn nilai pada variabel global salary  
     * berdasarkan variabel salary pada parameter method setSalary
     * Method setSalary memiliki access modifier public
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Method setCommission digunakan untuk memberikakn nilai pada variabel global commission  
     * berdasarkan variabel commission pada parameter method setCommission
     * Method setCommission memiliki access modifier public
     */
    public void setCommission(int commission) {
        this.commission = commission;
    }

    /**
     * Method setManager digunakan untuk memberikakn nilai pada variabel global manager  
     * berdasarkan variabel manager pada parameter method setManager
     * Method setManager memiliki access modifier public
     */
    public void setManager(int manager) {
        this.manager = manager;
    }

    /**
     * Method setDepartment digunakan untuk memberikakn nilai pada variabel global department  
     * berdasarkan variabel department pada parameter method setDepartment
     * Method setDepartment memiliki access modifier public
     */
    public void setDepartment(int department) {
        this.department = department;
    }

   /**
     * Method getPhone digunakan untuk mengambil nilai dari phone
     * Method getPhone memiliki access modifier public
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method getHire digunakan untuk mengambil nilai dari hire
     * Method getHire memiliki access modifier public
     */
    public Date getHire() {
        return hire;
    }

    /**
     * Method getJob digunakan untuk mengambil nilai dari job
     * Method getJob memiliki access modifier public
     */
    public String getJob() {
        return job;
    }

    /**
     * Method getSalary digunakan untuk mengambil nilai dari salary
     * Method getSalary memiliki access modifier public
     */
    public int getSalary() {
        return salary;
    }

     /**
     * Method getCommission digunakan untuk mengambil nilai dari commission
     * Method getCommission memiliki access modifier public
     */
    public int getCommission() {
        return commission;
    }

    /**
     * Method getManager digunakan untuk mengambil nilai dari manager
     * Method getManager memiliki access modifier public
     */
    public int getManager() {
        return manager;
    }

     /**
     * Method getDepartment digunakan untuk mengambil nilai dari department
     * Method getDepartment memiliki access modifier public
     */
    public int getDepartment() {
        return department;
    }

}
