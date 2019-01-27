/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.sql.Connection;
import models.Region;

/**
 *
 * @author kresna92
 */
public class RegionController {

    private RegionDAO rdao;
    private Connection connection;

     /**
     * Method RegionController merupakan constructor method dari class RegionController
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Pada method ini melakukan instansiasi objek 
     * bernama rdao pada class RegionDAO untuk melakukan koneksi ke database
     * Method RegionController memiliki access modifier public
     */
    public RegionController(Connection connection) {
        rdao = new RegionDAO(connection);
    }

    /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class RegionDAO
     * Method insert memiliki parameter id dan name yang memiliki tipe data string
     * Method insert memiliki access modifier public
     */
    public boolean insert(String id, String name) {
        boolean result = false;
        try {
            int idINT = new Integer(id);
            rdao.save(new Region(idINT, name), true);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Method update digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi false pada class RegionDAO
     * Method update memiliki parameter id dan name yang memiliki tipe data string
     * Method update memiliki access modifier public
     */
    public boolean update(String id, String name) {
        boolean result = false;
        try {
            int idINT = new Integer(id);
            rdao.save(new Region(idINT, name), false);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
