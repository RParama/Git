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

    /**
     * Method RegionDAO merupakan constructor method dari class RegionDAO yang
     * akan dijalankan pertama kali ketika class di eksekusi
     */
    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method MaxRegId berfungsi untuk mengembalikan nilai id region yang paling
     * besar dalam table regions
     */
    public int MaxRegId() {
//        String query = "SELECT REGION_ID FROM HR.REGIONS INNER JOIN "
//                + "(SELECT MAX(REGION_ID) AS MAX_REG FROM HR.REGIONS) reg_id ON HR.REGIONS.REGION_ID = reg_id.MAX_REG";
        String query = "select max (region_id) +1 from regions";
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
     * Fungsi getAll atau search byId atau byKeyword Jika string kosong dan
     * false = getAll, jika string berisi keyword dan false = byKeyword jika int
     * dan true = byId
     *
     * @param keyword data yang dicari
     * @param isGetById jika true maka = search byId, jika false maka =
     * berdasarkan keyword
     * @return menampilkan list data regions
     */
    public List<Region> getData(Object keyword, boolean isGetById) {
        String query;
        List<Region> regions = new ArrayList<Region>();
        if (!isGetById) {
            query = "SELECT REGION_ID, REGION_NAME FROM REGIONS "
                    + "WHERE REGION_ID LIKE '%" + keyword + "%' "
                    + "OR REGION_NAME LIKE '%" + keyword + "%' ORDER BY REGION_ID";
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

    /**
     * Fungsi untuk melakukan insert atau update
     *
     * @param r merupakan object dari class Region
     * @param isInsert jika bernilai false akan melakukan update, jika bernilai
     * true akan melakukan insert
     * @return insert / update berhasil
     */
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

    /**
     * Menghapus data region berdasarkan region id
     *
     * @param id parameter id yang bertipe data integer
     * @return result dari proses delete
     */
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
