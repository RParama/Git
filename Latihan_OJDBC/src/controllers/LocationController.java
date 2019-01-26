/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Location;

/**
 *
 * @author Rayhan
 */
public class LocationController {

    private LocationDAO ldao;
    private Connection connection;

    public LocationController(Connection connection) {
        ldao = new LocationDAO(connection);
    }

    public List<Location> getDataById(String id) {
        List<Location> locations = new ArrayList<Location>();
        try {
            int idINT = new Integer (id);
                locations = ldao.getData(idINT, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    public List<Location> getDataSearch(Object k) {
        List<Location> locations = new ArrayList<Location>();
        try {
            locations = ldao.getData(k, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
    
    public boolean insert(String locationId, String streetAddress, String postalCode,
            String city, String stateProvince, String countryId) {
        boolean result = false;
        try {
            int idINT = new Integer(locationId); //casting String id menjadi int
            ldao.save(new Location(idINT, streetAddress, postalCode,
                    city, stateProvince, countryId), true); //save(region,true) = insert
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(String locationId, String streetAddress, String postalCode,
            String city, String stateProvince, String countryId) {
        boolean result = false;
        try {
            int idINT = new Integer(locationId); //casting String id menjadi int
            ldao.save(new Location(idINT, streetAddress, postalCode, city,
                    stateProvince, countryId), false); //save(region,false) = update
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String locationId) {
        boolean result = false;
        try {
            int idINT = new Integer(locationId); //casting String id menjadi int
            ldao.delete(idINT); //delete
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
