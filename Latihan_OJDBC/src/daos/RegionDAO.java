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
import models.Region;

/**
 *
 * @author kresna92
 */
public class RegionDAO {

    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Region> getAll() {
        List<Region> regions = new ArrayList<Region>();
        String query = "SELECT * from REGIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                regions.add(new Region(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    public List<Region> getData(Object keyword, boolean isGetById) {
        String query;
        List<Region> regions = new ArrayList<Region>();
        if (!isGetById) {
            query = "SELECT REGION_ID, REGION_NAME FROM REGIONS "
                    + "WHERE REGION_ID LIKE '%" + keyword + "%' "
                    + "OR REGION_NAME LIKE '%" + keyword + "%' ";
        } else {
            query = "SELECT * FROM REGIONS WHERE REGION_ID = " + keyword;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                regions.add(new Region(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    public List<Region> search(String keyword) {
        List<Region> regions = new ArrayList<Region>();
        String keywordlower = keyword.toLowerCase();
        String query = "SELECT REGION_ID, REGION_NAME FROM REGIONS "
                + "WHERE REGION_ID LIKE '%" + keyword + "%' "
                + "OR REGION_NAME LIKE '%" + keyword + "%' ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                regions.add(new Region(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return regions;
    }

    public boolean save(Region r, boolean isInsert) {
        String query;
        boolean result = false;
        if (!isInsert) {
            query = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        } else {
            query = "INSERT INTO REGIONS (REGION_NAME,REGION_ID) VALUES(? , ?)";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getRegionName());
            preparedStatement.setInt(2, r.getRegionId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE REGIONS WHERE REGION_ID = " + id;
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
