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
     * Pada method ini melakukan instansiasi objek 
     * bernama ldao pada class LocationDAO untuk melakukan koneksi ke database
     * @param connection objek dari class Connection
     */
    public LocationController(Connection connection) {
        ldao = new LocationDAO(connection);
    }

    /**
     * Fungsi digunakan untuk melakukan pencarian data berasarkan id 
     * dengan cara memanggil method getData dengan kondisi true pada class LocationDAO 
     * List bernama locations berfungsi untuk menyimpan hasil pencarian
     * @param id bertipe data string
     * @return menampilkan data berdasarkan id yang dicari
     */
    public List<Location> getDataById(String id) {
        List<Location> locations = new ArrayList<Location>();
        try {
            int idINT = new Integer(id);
            locations = ldao.getData(idINT, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    /**
     * Fungsi digunakan untuk melakukan pencarian data sesuai dengan keyword
     * Memanggil method getData dengan kondisi false pada class LocationDAO
     * @param k bertipe Obejct
     * @return menampilkan data yang di cari
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
     * Fungsi digunakan untuk melakukan insert data 
     * Memanggil method save dengan kondisi true pada class LocationDAO 
     * @param locationId bertipe string
     * @param streetAddress bertipe string
     * @param postalCode bertipe string
     * @param city bertipe string
     * @param stateProvince bertipe string
     * @param countryId bertipe string
     * @return berhasil melakukan insert data
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
     * Fungsi digunakan untuk melakukan update data 
     * Memanggil method save dengan kondisi false pada class LocationDAO 
     * @param locationId bertipe string
     * @param streetAddress bertipe string
     * @param postalCode bertipe string
     * @param city bertipe string
     * @param stateProvince bertipe string
     * @param countryId bertipe string
     * @return berhasil melakukan update
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
     * Fungsi digunakan untuk menghapus data berdasarkan locationId
     * Memanggil method delete pada class LocationDAO
     * @param locationId bertipe string
     * @return berhasil menghapus data sesuai dengan locationId
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

    public int getMaxLocId() {
        int locId = ldao.MaxLocId();
        return locId;
    }
}
