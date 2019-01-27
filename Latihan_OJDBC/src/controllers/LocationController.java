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

    /**
     * Method LocationController merupakan constructor method dari class LocationController
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Pada method ini melakukan instansiasi objek 
     * bernama ldao pada class LocationDAO untuk melakukan koneksi ke database
     * Method LocationController memiliki access modifier public
     */
    public LocationController(Connection connection) {
        ldao = new LocationDAO(connection);
    }

    /**
     * Method getDataById digunakan untuk melakukan pencarian data berasarkan location id
     * dengan cara memanggil method getData dengan kondisi true pada class LocationDAO
     * Method getDataById memiliki list bernama locations yang berfungsi untuk menyimpan hasil pencarian
     * Method getDataById memiliki access modifier public
     */
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

     /**
     * Method getDataSearch digunakan untuk melakukan pencarian data 
     * pada departments sesuai dengan keyword yang di inputkan
     * dengan cara memanggil method getData dengan kondisi false pada class LocationDAO
     * Method getDataSearch memiliki list bernama locations yang berfungsi untuk menyimpan hasil pencarian
     * Method getDataSearch memiliki access modifier public
     */
    public List<Location> getDataSearch(Object k) {
        List<Location> locations = new ArrayList<Location>();
        try {
            locations = ldao.getData(k, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
    
    /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class LocationDAO
     * Method insert memiliki parameter locationId, streetAddress, 
     * postalCode, city dan countryId yang memiliki tipe data string
     * Method insert memiliki access modifier public
     */
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

    /**
     * Method update digunakan untuk melakukan update data baru ke database
     * dengan cara memanggil method save dengan kondisi false pada class LocationDAO
     * Method update memiliki parameter locationId, streetAddress, 
     * postalCode, city dan countryId yang memiliki tipe data string
     * Method update memiliki access modifier public
     */
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

     /**
     * Method delete digunakan untuk menghapus department berdasarkan locationId
     * dengan cara memanggil method delete pada class LocationDAO
     * Method delete memiliki parameter locationId bertipe data string
     * Method delete memiliki access modifier public
     */
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
