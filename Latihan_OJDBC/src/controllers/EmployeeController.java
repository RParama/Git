/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import models.Employee;

/**
 *
 * @author kresna92
 */
public class EmployeeController {

    private EmployeeDAO edao;
    private Connection connection;

    public EmployeeController(Connection connection) {
        edao = new EmployeeDAO(connection);
    }
    
    /**
     * Fungsi untuk mengambil id employee yang bernilai paling besar
     * @return id employee bernilai paling besar
     */
    
    public int getMaxEmpId() {
        return edao.MaxEmpId();
//        return edao.getData("", false).size()+1;
    }

    /**
     * Fungsi untuk melakukan pencarian data dengan objek
     * @param k objek yang dicari
     * @return mengembalikan variabel employee
     */
    public List<Employee> getDataSearch(Object k) {
        return edao.getData(k, false);
    }
    /**
     * Fungsi untuk melakukan pencarian data dengan String id
     * @param id data yang dicari
     * @return mengembalikan variabel employee
     */
    public List<Employee> getDataById(String id) {
        return edao.getData(new Integer(id), false);
    }
    /**
     * Fungsi untuk melakukan proses insert pada database
     * @param id employee id
     * @param first first name 
     * @param last last name
     * @param email email
     * @param phone phone number
     * @param hire hire date
     * @param job job id
     * @param salary salary
     * @param commission commission
     * @param manager manager id
     * @param dept department id
     * @return hasil dari proses insert
     */
    public boolean insert(String id, String first, String last, String email,
            String phone, Date hire, String job, String salary,
            String commission, String manager, String dept) {
        return edao.save(new Employee(new Integer(id), first, last, email, phone, hire, job,
                new Integer(salary), new Integer(commission), new Integer(manager), new Integer(dept)), true);
    }
        /**
     * Fungsi untuk melakukan proses update pada database
     * @param id employee id
     * @param first first name 
     * @param last last name
     * @param email email
     * @param phone phone number
     * @param hire hire date
     * @param job job id
     * @param salary salary
     * @param commission commission
     * @param manager manager id
     * @param dept department id
     * @return hasil dari proses update
     */
    public boolean update(String id, String first, String last, String email,
            String phone, Date hire, String job, String salary,
            String commission, String manager, String dept) {
        return edao.save(new Employee(new Integer(id), first, last, email, phone, hire, job,
                new Integer(salary), new Integer(commission), new Integer(manager), new Integer(dept)), false);
    }
    /**
     * Fungsi untuk melakukan penghapusan data berdasar id
     * @param id yang akan dihapus
     * @return hasil dari proses penghapusan
     */
    public boolean delete(String id) {
        return edao.delete(new Integer(id));
    }

}
