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
import models.Employee;

/**
 *
 * @author kresna92
 */
public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> getData(Object keyword, boolean isGetById) {
        String query;
        List<Employee> employees = new ArrayList<Employee>();
        if (isGetById) {
            query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " + keyword;
        } else {
            query = "SELECT * FROM EMPLOYEES "
                    + "WHERE EMPLOYEE_ID LIKE '%" + keyword + "%' "
                    + "OR FIRST_NAME LIKE '%" + keyword + "%' "
                    + "OR MANAGER_ID LIKE '%" + keyword + "%' "
                    + "OR DEPARTMENT_ID LIKE '%" + keyword + "%' ";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Timestamp t = resultSet.getTimestamp(6);
                String s = new SimpleDateFormat("MM/dd/yyyy").format(t);
                employees.add(new Employee(
                        resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), s, resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    public boolean save(Employee e, boolean isInsert) {
        String query;
        boolean result = false;
        if (isInsert) {
            query = "INSERT INTO EMPLOYEES (FIRST_NAME, EMPLOYEE_ID, LAST_NAME, EMAIL, PHONE_NUMBER,"
                    + "HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) "
                    + "VALUES(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        } else {
            query = "UPDATE EMPLOYEES SET FIRST_NAME = ? WHERE EMPLOYEE_ID = ?";
        }
        try {
            String s = e.getHire();
            Timestamp t = Timestamp.valueOf(s);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (isInsert) {
                preparedStatement.setString(1, e.getFirst_name());
                preparedStatement.setInt(2, e.getId());
                preparedStatement.setString(3, e.getLast_name());
                preparedStatement.setString(4, e.getEmail());
                preparedStatement.setString(5, e.getPhone());
                preparedStatement.setTimestamp(6, t);
                preparedStatement.setString(7, e.getJob());
                preparedStatement.setInt(8, e.getSalary());
                preparedStatement.setInt(9, e.getCommission());
                preparedStatement.setInt(10, e.getManager());
                preparedStatement.setInt(11, e.getDepartment());
            } else {
                preparedStatement.setString(1, e.getFirst_name());
                preparedStatement.setInt(2, e.getId());
            }
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

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
