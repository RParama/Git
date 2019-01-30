/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import models.Employee;

/**
 *
 * @author kresna92
 */
public class EmployeeDAO {

    private Connection connection;

    /**
     * Fungsi untuk melakukan koneksi ke database
     *
     * @param objek connection dari class Connection
     */
    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method MaxEmpId berfungsi untuk mengembalikan nilai id employee yang
     * paling besar dalam table employee
     *
     * @return menampilkan nilai max
     */
    public int MaxEmpId() {
        String query = "SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES";
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

//    public List<Employee> getManager(){
//        List<Employee> employees = new ArrayList<Employee>();
//        String query = "SELECT DISTINCT b.manager_id , a.first_name FROM employees a JOIN employees b ON a.employee_id = b.manager_id";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                employees.add()
//            }
//        } catch (Exception e) {
//        }
//    }
    /**
     * Fungsi digunakan untuk melakukan pencarian data berdasarkan keyword yang
     * di inputkan Jika isGetById bernilai false, maka sistem akan menampilkan
     * semua data yang berkaitan dengan keyword Jika isGetById bernilai true,
     * maka sistem akan menampilkan data berdasarkan employee_id nya
     *
     * @param keyword bertipe Object
     * @param isGetById bertipe data boolean
     * @return menampilkan hasil pencarian
     */
    public List<Employee> getData(Object keyword, boolean isGetById) {
        String query;
        List<Employee> employees = new ArrayList<Employee>();
        if (isGetById) {
            query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " + keyword + "ORDER BY EMPLOYEE_ID";
        } else {
            query = "SELECT * FROM EMPLOYEES "
                    + "WHERE EMPLOYEE_ID LIKE '%" + keyword + "%' "
                    + "OR FIRST_NAME LIKE '%" + keyword + "%' ORDER BY EMPLOYEE_ID";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Timestamp t = resultSet.getTimestamp(6);
                employees.add(new Employee(
                        resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), t, resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    /**
     * Fungsi digunakan untuk melakukan insert dan update pada database Jika
     * nilai isInsert bernilai false, maka sistem akan melakukan update data
     * Jika nilai isInsert bernilai true, maka sistem akan melakukan insert data
     *
     * @param objek e pada class Employee
     * @param isInsert bertipe data boolean
     * @return berhasil melakukan update atau insert
     */
    public boolean save(Employee e, boolean isInsert) {
        String query;
        boolean result = false;
        if (isInsert) {
            query = "INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER,"
                    + "HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID, EMPLOYEE_ID) "
                    + "VALUES(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        } else {
            query = "UPDATE EMPLOYEES SET FIRST_NAME = ? , LAST_NAME = ? , EMAIL = ? , "
                    + "PHONE_NUMBER = ? , HIRE_DATE = ? , JOB_ID = ? , SALARY = ? , COMMISSION_PCT = ? , MANAGER_ID = ? , DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?";
        }
        try {
            Date d = e.getHire();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String s = sdf.format(d);
            Timestamp t = Timestamp.valueOf(s);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, e.getFirst_name());
            preparedStatement.setString(2, e.getLast_name());
            preparedStatement.setString(3, e.getEmail());
            preparedStatement.setString(4, e.getPhone());
            preparedStatement.setTimestamp(5, t);
            preparedStatement.setString(6, e.getJob());
            preparedStatement.setInt(7, e.getSalary());
            preparedStatement.setInt(8, e.getCommission());
            preparedStatement.setInt(9, e.getManager());
            preparedStatement.setInt(10, e.getDepartment());
            preparedStatement.setInt(11, e.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

    /**
     * Fungsii untuk menghapus employee berdasarkan id nya
     *
     * @param id bertipe data integer
     * @return berhasil melakukan delete
     */
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE EMPLOYEES WHERE EMPLOYEE_ID = " + id;
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
