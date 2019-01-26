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
     * >Select all: jika string kosong "" dan boolean false, ex: ("",false)
     *
     * >Select id: jika int dan boolean true ataupun false, ex: (1,true) atau
     * (1,false) >Select id: jika String dan boolean true ataupun false, ex:
     * ("1",true/false)
     *
     * >Select keyword: jika string dimasukan keyword dan boolean false, ex:
     * ("a",false)
     *
     * > kesimpulan: (n, true) hanya digunakan untuk mencari id
     *
     * >Parameter Object keyword dapat menyesuaikan type data (int/String)
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
     * >save merupakan gabungan dari insert dan update >Jika (n,true) maka akan
     * berfungsi sebagai insert >Jika (n,false) maka akan berfungsi sebagai
     * update
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
