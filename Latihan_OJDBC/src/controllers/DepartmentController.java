/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import java.sql.Connection;
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
     * Berfungsi memanggil fungsi dari DepartmentDAO untuk mendapatkan ID
     * terbesar Digunakan untuk auto increment ID
     *
     * @return mengembalikan nilai ID yang telah diincrement
     */
    public int getMaxDepId() {
        return ddao.MaxDepId();
    }

    /**
     * Fungsi getAll
     *
     * @return menampilkan data
     */
    public List<Department> getDepartmentList() {
        return ddao.getData("", false);
    }

    /**
     * Fungsi untuk get data by id
     *
     * @param id tipe data integer
     * @return menampilkan hasil pencarian
     */
    public Department getById(String id) {
        return ddao.getData(new Integer(id), true).get(0);
    }

    /**
     * Method getDataSearch digunakan untuk melakukan pencarian data pada
     * departments sesuai dengan keyword yang di inputkan dengan cara memanggil
     * method getData dengan kondisi false pada class DepartmentDAO Method
     * getDataSearch memiliki list bernama departments yang berfungsi untuk
     * menyimpan hasil pencarian Method getDataSearch memiliki access modifier
     * public
     */
    public List<Department> search(Object k) {
        return ddao.getData(k, false);
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
        return ddao.save(new Department(new Integer(departmentId),
                departmentName, new Integer(managerId), new Integer(locationId)), true); //save(region,true) = insert
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
        return ddao.save(new Department(new Integer(departmentId),
                departmentName, new Integer(managerId), new Integer(locationId)), false); //save(region,false) = update
    }

    /**
     * Method delete digunakan untuk menghapus department berdasarkan department
     * id dengan cara memanggil method delete pada class DepartmentDAO Method
     * delete memiliki parameter departmentId bertipe data string Method delete
     * memiliki access modifier public
     */
    public boolean delete(String departmentId) {
        return ddao.delete(new Integer(departmentId));
    }
}
