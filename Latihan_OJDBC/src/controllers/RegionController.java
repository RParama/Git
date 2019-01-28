/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
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
     * Method getRegionList digunakan untuk menampilkan data pada department secara keseluruhan
     * dengan cara memanggil method getData dengan kondisi false pada class RegionDAO
     * Method getRegionList memiliki list bernama regionList yang berfungsi untuk menyimpan hasil pencarian
     * Method getRegionList memiliki access modifier public
     */
    public List<String> getRegionList() {
        List<String> regionList = new ArrayList<String>();
        boolean result = false;
        try {
            for (Region region : rdao.getData("", false)) {
                regionList.add(region.getRegionName());
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regionList;
    }

     /**
     * Method getDataById digunakan untuk melakukan pencarian data pada departments berasarkan region id
     * dengan cara memanggil method getData dengan kondisi true pada class RegionDAO
     * Method getDataById memiliki list bernama regions yang berfungsi untuk menyimpan hasil pencarian
     * Method getDataById memiliki access modifier public
     */
    public List<Region> getDataById(String id) {
        List<Region> regions = new ArrayList<Region>();
        try {
            int idINT = new Integer(id);
            regions = rdao.getData(idINT, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    /**
     * Method getDataSearch digunakan untuk melakukan pencarian data 
     * pada regions sesuai dengan keyword yang di inputkan
     * dengan cara memanggil method getData dengan kondisi false pada class RegionDAO
     * Method getDataSearch memiliki list bernama regions yang berfungsi untuk menyimpan hasil pencarian
     * Method getDataSearch memiliki access modifier public
     */
    public List<Region> getDataSearch(Object k) {
        List<Region> regions = new ArrayList<Region>();
        try {
            regions = rdao.getData(k, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
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
            int idRegionINT = new Integer(id);
            rdao.save(new Region(idRegionINT, name), true);
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
            int idRegionINT = new Integer(id);
            rdao.save(new Region(idRegionINT, name), false);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method delete digunakan untuk menghapus regions berdasarkan regions id
     * dengan cara memanggil method delete pada class RegionDAO
     * Method delete memiliki parameter id bertipe data string
     * Method delete memiliki access modifier public
     */
    public boolean delete(String id) {
        boolean result = false;
        try {
            int idRegionINT = new Integer(id);
            rdao.delete(idRegionINT);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
