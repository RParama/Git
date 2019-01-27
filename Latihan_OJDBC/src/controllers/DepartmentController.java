/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Department;

/**
 *
 * @author Rayhan
 */
public class DepartmentController {

    private DepartmentDAO ddao;

    Connection connection;

    public DepartmentController(Connection connection) {
        ddao = new DepartmentDAO(connection);
    }

    public List<String> getDepList() {
        List<String> depList = new ArrayList<String>();
        boolean result = false;
        try {
            for (Department department : ddao.getData("", false)) {
                depList.add(department.getDepartmentName());
            }

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return depList;
    }

    public List<Department> getDataById(String id) {
        List<Department> departments = new ArrayList<Department>();
        try {
            int idINT = new Integer(id);
            departments = ddao.getData(idINT, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public List<Department> getDataSearch(Object k) {
        List<Department> departments = new ArrayList<Department>();
        try {
            departments = ddao.getData(k, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public boolean insert(String departmentId, String departmentName,
            String managerId, String locationId) {
        boolean result = false;
        try {
            int idDeptINT = new Integer(departmentId); //casting String id menjadi int
            int idManagINT = new Integer(managerId); //casting String id menjadi int
            int idLocINT = new Integer(locationId); //casting String id menjadi int
            ddao.save(new Department(idDeptINT, departmentName, idManagINT, idLocINT), true); //save(region,true) = insert
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(String departmentId, String departmentName,
            String managerId, String locationId) {
        boolean result = false;
        try {
            int idDeptINT = new Integer(departmentId); //casting String id menjadi int
            int idManagINT = new Integer(managerId); //casting String id menjadi int
            int idLocINT = new Integer(locationId); //casting String id menjadi int
            ddao.save(new Department(idDeptINT, departmentName, idManagINT, idLocINT), false); //save(region,false) = update
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String departmentId) {
        boolean result = false;
        try {
            int idINT = new Integer(departmentId); //casting String id menjadi int
            ddao.delete(idINT); //delete
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}