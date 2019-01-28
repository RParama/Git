/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Department;

/**
 *
 * @author Rayhan
 */
public class DepartmentDAO {
     private Connection connection;

     /**
     * Fungsi untuk melakukan koneksi ke database
     * @param objek connection dari class Connection
     */
    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

     /**
     * Fungsi digunakan untuk melakukan pencarian data berdasarkan keyword yang di inputkan
     * Jika isGetById bernilai false, maka sistem akan menampilkan 
     * semua data yang berkaitan dengan keyword
     * Jika isGetById bernilai true, maka sistem akan menampilkan data berdasarkan department_id nya
     * @param keyword bertipe Object
     * @param isGetById bertipe data boolean
     * @return menampilkan hasil pencarian
     */
    public List<Department> getData(Object keyword, boolean isGetById) {
        String query;
        List<Department> departments = new ArrayList<Department>();
        if (!isGetById) {
            query = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS "
                    + "WHERE DEPARTMENT_ID LIKE '%" + keyword + "%' "
                    + "OR DEPARTMENT_NAME LIKE '%" + keyword + "%' "
                    + "OR MANAGER_ID LIKE '%" + keyword + "%' "
                    + "OR LOCATION_ID LIKE '%" + keyword + "%' ";

        } else {
            query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = " + keyword;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departments.add(new Department(resultSet.getInt(1), resultSet.getString(2), 
                        resultSet.getInt(3), resultSet.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

     /**
     * Fungsi digunakan untuk melakukan insert dan update pada database
     * Jika nilai isInsert bernilai false, maka sistem akan melakukan update data 
     * Jika nilai isInsert bernilai true, maka sistem akan melakukan insert data 
     * @param objek d pada class Department
     * @param isInsert bertipe data boolean
     * @return berhasil melakukan update atau insert
     */
    public boolean save(Department d, boolean isInsert) {
        String query;
        boolean result = true;
        if (!isInsert) {
            query = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, "
                    + "MANAGER_ID = ? , LOCATION_ID = ? "
                    + " WHERE DEPARTMENT_ID = ?";
        } else {
            query = "INSERT INTO DEPARTMENTS (DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID, "
                    + "DEPARTMENT_ID) "
                    + "VALUES(? , ? , ? , ?)";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d.getDepartmentName());
            preparedStatement.setInt(2, d.getManagerId());
            preparedStatement.setInt(3, d.getLocationId());
            preparedStatement.setInt(4, d.getDepartmentId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method delete digunakan untuk menghapus data berdasrkan department_id nya
     * @param id bertipe data integer
     * @return berhasil melakukan delete berdasarkan department_id
     */
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = " + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
        /**
     * Method MaxEmpId berfungsi untuk mengembalikan nilai id employee yang
     * paling besar dalam table employee
     * @return mengambil nilai terbesar
     */
    public int MaxDepId() {
        String query = "SELECT DEPARTMENT_ID"
                + " FROM DEPARTMENTS INNER JOIN (SELECT MAX(DEPARTMENT_ID) AS MAX_DEP"
                + " FROM DEPARTMENTS) dep_id ON DEPARTMENTS.DEPARTMENT_ID = dep_id.MAX_DEP";
        int maxId = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                maxId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }
}
