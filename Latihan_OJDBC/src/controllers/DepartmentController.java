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

    /**
     * Method DepartmentController merupakan constructor method dari class
     * DepartmentController method yang pertama kali dijalankan ketika class di
     * eksekusi Pada method ini melakukan instansiasi objek bernama ddao pada
     * class DepartmentDAO untuk melakukan koneksi ke database Method
     * DepartmentController memiliki access modifier public
     */
    public DepartmentController(Connection connection) {
        ddao = new DepartmentDAO(connection);
    }

    /**
     * Method getDepList digunakan untuk menampilkan data pada department secara
     * keseluruhan dengan cara memanggil method getData dengan kondisi false
     * pada class DepartmentDAO Method getDepList memiliki list bernama depList
     * yang berfungsi untuk menyimpan hasil pencarian Method getDepList memiliki
     * access modifier public
     */
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

    /**
     * Method getDataById digunakan untuk melakukan pencarian data pada
     * departments berasarkan id dengan cara memanggil method getData dengan
     * kondisi true pada class DepartmentDAO Method getDataById memiliki list
     * bernama departments yang berfungsi untuk menyimpan hasil pencarian Method
     * getDataById memiliki access modifier public
     */
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

    /**
     * Method getDataSearch digunakan untuk melakukan pencarian data pada
     * departments sesuai dengan keyword yang di inputkan dengan cara memanggil
     * method getData dengan kondisi false pada class DepartmentDAO Method
     * getDataSearch memiliki list bernama departments yang berfungsi untuk
     * menyimpan hasil pencarian Method getDataSearch memiliki access modifier
     * public
     */
    public List<Department> getDataSearch(Object k) {
        List<Department> departments = new ArrayList<Department>();
        try {
            departments = ddao.getData(k, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class
     * DepartmentDAO Method insert memiliki parameter departmentId,
     * departmentName, managerId dan locationId yang memiliki tipe data string
     * Method insert memiliki access modifier public
     */
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

    /**
     * Method update digunakan untuk melakukan update data baru ke database
     * dengan cara memanggil method save dengan kondisi false pada class
     * DepartmentDAO Method update memiliki parameter departmentId,
     * departmentName, managerId dan locationId yang memiliki tipe data string
     * Method update memiliki access modifier public
     */
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

    /**
     * Method delete digunakan untuk menghapus department berdasarkan department
     * id dengan cara memanggil method delete pada class DepartmentDAO Method
     * delete memiliki parameter departmentId bertipe data string Method delete
     * memiliki access modifier public
     */
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

    public int getMaxDepId() {
        int depId = ddao.MaxDepId();
        return depId;
    }

}
