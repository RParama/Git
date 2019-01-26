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
import models.Countries;
import models.Region;

/**
 *
 * @author User
 */
public class CountriesDAO {

    private Connection connection;

    public CountriesDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Countries> getAll() {
        List<Countries> cs = new ArrayList<>();
        String query = "SELECT * FROM hr.countries";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);   //menyiapkan query.dari prepareStatement.menggunakan koneksi
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Countries r = new Countries();
                r.setCountryId(resultSet.getString(1));
                r.setCountryName(resultSet.getString(2));
                r.setRegionId(resultSet.getInt(3));
                cs.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return cs;
    }

    public List<Countries> getData(Object keyword, boolean z) {
        String query;
        List<Countries> cs = new ArrayList<Countries>();
        if (!z) {
            query = "SELECT country_id, country_name, region_id FROM hr.countries"
                    + "WHERE country_id LIKE '%" + keyword + "%'"
                    + "OR country_name LIKE '%" + keyword + "%'"
                    + "OR region_id LIKE '%" + keyword + "%'";
        } else {
            query = "SELECT * FROM hr.countries WHERE country_id=" + keyword;

        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cs.add(new Countries(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cs;
    }

    public boolean save(Countries r, boolean z) {
        boolean result = false;
        String query;
        if (!z) {
            query = "UPDATE hr.countries SET country_name=? WHERE country_id=? AND region_id=?";
        } else {
            query = "INSERT INTO hr.countries (country_name,country_id,region_id) VALUES(?,?,?)";
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getCountryName());
            preparedStatement.setString(2, r.getCountryId());
            preparedStatement.setInt(3, r.getRegionId());
            preparedStatement.executeQuery();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void hapus(Countries r) {
        String query = "DELETE FROM hr.countries WHERE country_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getCountryId());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
