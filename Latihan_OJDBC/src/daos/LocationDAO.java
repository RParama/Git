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
import models.Location;

/**
 *
 * @author Rayhan
 */
public class LocationDAO {

    private Connection connection;

    public LocationDAO(Connection connection) {
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
    public List<Location> getData(Object keyword, boolean isGetById) {
        String query;
        List<Location> locations = new ArrayList<Location>();
        if (!isGetById) {
            query = "SELECT LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID FROM LOCATIONS "
                    + "WHERE LOCATION_ID LIKE '%" + keyword + "%' "
                    + "OR STREET_ADDRESS LIKE '%" + keyword + "%' "
                    + "OR POSTAL_CODE LIKE '%" + keyword + "%' "
                    + "OR CITY LIKE '%" + keyword + "%' "
                    + "OR STATE_PROVINCE LIKE '%" + keyword + "%' "
                    + "OR COUNTRY_ID LIKE '%" + keyword + "%' ";

        } else {
            query = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = " + keyword;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                locations.add(new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    /**
     * >save merupakan gabungan dari insert dan update >Jika (n,true) maka akan
     * berfungsi sebagai insert >Jika (n,false) maka akan berfungsi sebagai
     * update
     */
    public boolean save(Location l, boolean isInsert) {
        String query;
        boolean result = true;
        if (!isInsert) {
            query = "UPDATE LOCATIONS SET STREET_ADDRESS = ?, "
                    + "POSTAL_CODE = ? , CITY = ? , STATE_PROVINCE = ?, "
                    + "COUNTRY_ID = ? WHERE LOCATION_ID = ?";
        } else {
            query = "INSERT INTO LOCATIONS (STREET_ADDRESS, POSTAL_CODE, CITY, "
                    + "STATE_PROVINCE, COUNTRY_ID, LOCATION_ID) "
                    + "VALUES(? , ? , ? , ? , ? , ?)";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, l.getStreetAddress());
            preparedStatement.setString(2, l.getPostalCode());
            preparedStatement.setString(3, l.getCity());
            preparedStatement.setString(4, l.getStateProvince());
            preparedStatement.setString(5, l.getCountryId());
            preparedStatement.setInt(6, l.getLocationId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE LOCATIONS WHERE LOCATION_ID = " + id;
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
