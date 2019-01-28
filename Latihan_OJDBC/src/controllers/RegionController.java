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
 * @author RParama
 */
public class RegionController {

    private RegionDAO rdao;
    private Connection connection;

    /**
     * Method RegionController merupakan constructor method dari class
     * RegionController method yang pertama kali dijalankan ketika class di
     * eksekusi Pada method ini melakukan instansiasi objek bernama rdao pada
     * class RegionDAO untuk melakukan koneksi ke database Method
     * RegionController memiliki access modifier public
     */
    public RegionController(Connection connection) {
        rdao = new RegionDAO(connection);
    }

    public int getMaxRegId() {
//        int regId = rdao.MaxRegId();
//        int regId = getRegionList().size()+1;
        return rdao.MaxRegId();
    }

    /**
     * Fungsi getAll
     *
     * @return menampilkan data
     */
    public List<Region> getRegionList() {
//        List<Region> regionList = new ArrayList<Region>();
//        try {
//            regionList = rdao.getData("", false);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return regionList;
        return rdao.getData("", false);
    }

    /**
     * Fungsi untuk get data by id
     *
     * @param id tipe data integer
     * @return menampilkan hasil pencarian
     */
    public Region getById(String id) {
        return rdao.getData(new Integer(id), true).get(0);
    }

    /**
     * Method getDataSearch digunakan untuk melakukan pencarian data pada
     * regions sesuai dengan keyword yang di inputkan dengan cara memanggil
     * method getData dengan kondisi false pada class RegionDAO Method
     * getDataSearch memiliki list bernama regions yang berfungsi untuk
     * menyimpan hasil pencarian Method getDataSearch memiliki access modifier
     * public
     */
    public List<Region> search(Object k) {
        return rdao.getData(k, false);
    }

    /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class
     * RegionDAO Method insert memiliki parameter id dan name yang memiliki tipe
     * data string Method insert memiliki access modifier public
     */
    public boolean insert(String id, String name) {
        return rdao.save(new Region(new Integer(id), name), true);
    }

    /**
     * Method update digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi false pada class
     * RegionDAO Method update memiliki parameter id dan name yang memiliki tipe
     * data string Method update memiliki access modifier public
     */
    public boolean update(String id, String name) {
        return rdao.save(new Region(new Integer(id), name), false);
    }

    /**
     * Method delete digunakan untuk menghapus regions berdasarkan regions id
     * dengan cara memanggil method delete pada class RegionDAO Method delete
     * memiliki parameter id bertipe data string Method delete memiliki access
     * modifier public
     */
    public boolean delete(String id) {
        return rdao.delete(new Integer(id));
    }
}
