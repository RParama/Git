/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import java.sql.Connection;
import java.util.ArrayList;
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

    public int getMaxEmpId() {
        int empId = edao.MaxEmpId();
        return empId;
    }

    public List<String> getManagerId() {
        List<String> manager = new ArrayList<String>();
        List<Integer> id = new ArrayList<Integer>();
        boolean result = false;
        try {
            for (Employee e : edao.getData("", false)) {
                id.add(e.getManager());
            }
            for (int i = 0; i < id.size(); i++) {
                for (Employee employee : edao.getData(id.remove(i), result)) {
                    manager.add(employee.getFirst_name());
                }
            }
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return manager;
    }

    public List<Employee> getDataSearch(Object k) {
        List<Employee> employees = new ArrayList<Employee>();
        try {
            employees = edao.getData(k, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> getDataById(String id) {
        List<Employee> employees = new ArrayList<Employee>();
        try {
            int idINT = new Integer(id);
            employees = edao.getData(idINT, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public boolean insert(String id, String first, String last, String email,
            String phone, Date hire, String job, String salary,
            String commission, String manager, String dept) {
        boolean result = false;
        try {
            int idINT = new Integer(id);
            int salaryINT = new Integer(salary);
            int commissionINT = new Integer(commission);
            int managerINT = new Integer(manager);
            int deptINT = new Integer(dept);
            edao.save(new Employee(idINT, first, last, email, phone, hire, job,
                    salaryINT, commissionINT, managerINT, deptINT), true);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(String id, String first, String last, String email,
            String phone, Date hire, String job, String salary,
            String commission, String manager, String dept) {
        boolean result = false;
        try {
            int idINT = new Integer(id);
            int salaryINT = new Integer(salary);
            int commissionINT = new Integer(commission);
            int managerINT = new Integer(manager);
            int deptINT = new Integer(dept);
            edao.save(new Employee(idINT, first, last, email, phone, hire, job,
                    salaryINT, commissionINT, managerINT, deptINT), false);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        try {
            int idINT = new Integer(id);
            edao.delete(idINT);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
