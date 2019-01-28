/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import java.sql.Connection;
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
     * Method LocationController merupakan constructor method dari class
     * LocationController method yang pertama kali dijalankan ketika class di
     * eksekusi Pada method ini melakukan instansiasi objek bernama ldao pada
     * class LocationDAO untuk melakukan koneksi ke database Method
     * LocationController memiliki access modifier public
     */
    public LocationController(Connection connection) {
        ldao = new LocationDAO(connection);
    }

    /**
     * Berfungsi memanggil fungsi dari LocationDAO untuk mendapatkan ID terbesar
     * Digunakan untuk auto increment ID
     *
     * @return mengembalikan nilai ID yang telah diincrement
     */
    public int getMaxLocId() {
        return ldao.MaxLocId();
    }

    /**
     * Fungsi getAll
     *
     * @return menampilkan data
     */
    public List<Location> getLocationList() {
        return ldao.getData("", false);
    }

    /**
     * Fungsi untuk get data by id
     *
     * @param id tipe data integer
     * @return menampilkan hasil pencarian
     */
    public Location getById(String id) {
        return ldao.getData(new Integer(id), true).get(0);
    }

    /**
     * Method getDataSearch digunakan untuk melakukan pencarian data pada
     * Locations sesuai dengan keyword yang di inputkan dengan cara memanggil
     * method getData dengan kondisi false pada class LocationDAO Method
     * getDataSearch memiliki list bernama Locations yang berfungsi untuk
     * menyimpan hasil pencarian Method getDataSearch memiliki access modifier
     * public
     */
    public List<Location> search(Object k) {
        return ldao.getData(k, false);
    }

    /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class
     * LocationDAO Method insert memiliki parameter locationId, streetAddress,
     * postalCode, city dan countryId yang memiliki tipe data string Method
     * insert memiliki access modifier public
     */
    public boolean insert(String locationId, String streetAddress, String postalCode,
            String city, String stateProvince, String countryId) {

        return ldao.save(new Location(new Integer(locationId), streetAddress, postalCode,
                city, stateProvince, countryId), true); //save(region,true) = insert
    }

    /**
     * Method update digunakan untuk melakukan update data baru ke database
     * dengan cara memanggil method save dengan kondisi false pada class
     * LocationDAO Method update memiliki parameter locationId, streetAddress,
     * postalCode, city dan countryId yang memiliki tipe data string Method
     * update memiliki access modifier public
     */
    public boolean update(String locationId, String streetAddress, String postalCode,
            String city, String stateProvince, String countryId) {

        return ldao.save(new Location(new Integer(locationId), streetAddress, postalCode,
                city, stateProvince, countryId), false); //save(region,false) = update
    }

    /**
     * Method delete digunakan untuk menghapus department berdasarkan locationId
     * dengan cara memanggil method delete pada class LocationDAO Method delete
     * memiliki parameter locationId bertipe data string Method delete memiliki
     * access modifier public
     */
    public boolean delete(String locationId) {
        return ldao.delete(new Integer(locationId));
    }
}
