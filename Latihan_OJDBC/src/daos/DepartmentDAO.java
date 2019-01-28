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

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * Method MaxLocId berfungsi untuk mengembalikan nilai id Departments yang
     * paling besar dalam table Departments
     */
    public int MaxDepId() {
        String query = "select max (department_id) +10 from departments";
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

    /**
     * Fungsi getAll atau search byId atau byKeyword. Jika string kosong dan
     * false = getAll. Jika string berisi keyword dan false = byKeyword. Jika
     * int dan true = byId
     *
     * @param keyword data yang dicari
     * @param isGetById jika true maka = search byId, jika false maka =
     * berdasarkan keyword
     * @return menampilkan list data Departments
     */
    public List<Department> getData(Object keyword, boolean isGetById) {
        String query;
        List<Department> departments = new ArrayList<Department>();
        if (!isGetById) {
            query = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS "
                    + "WHERE DEPARTMENT_ID LIKE '%" + keyword + "%' "
                    + "OR DEPARTMENT_NAME LIKE '%" + keyword + "%' "
                    + "OR MANAGER_ID LIKE '%" + keyword + "%' "
                    + "OR LOCATION_ID LIKE '%" + keyword + "%' ORDER BY DEPARTMENT_ID ";

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
     * Fungsi untuk melakukan insert atau update
     *
     * @param r merupakan object dari class Department
     * @param isInsert jika bernilai false akan melakukan update, jika bernilai
     * true akan melakukan insert
     * @return insert / update berhasil
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
     * Menghapus data Departments berdasarkan department_id
     *
     * @param id parameter id yang bertipe data integer
     * @return result dari proses delete
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
    
}
