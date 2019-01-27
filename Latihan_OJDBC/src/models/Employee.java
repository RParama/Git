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
public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String hire;
    private String job;
    private int salary;
    private int commission;
    private int manager;
    private int department;

    public Employee(int id, String first_name, String last_name, String email, String phone, String hire, String job, int salary, int commision, int manager, int department) {
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

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public String getHire() {
        return hire;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public int getCommission() {
        return commission;
    }

    public int getManager() {
        return manager;
    }

    public int getDepartment() {
        return department;
    }

}
