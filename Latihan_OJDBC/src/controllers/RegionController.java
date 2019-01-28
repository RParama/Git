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
     * Pada method ini melakukan instansiasi objek 
     * bernama rdao pada class RegionDAO untuk melakukan koneksi ke database
     * @param connection objek dari class Connection
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
     * Fungsi untuk melakukan pencarian data sesuai dengan keyword yang di inputkan
     * Memanggil method getData pada class regionDAO dengan parameter k dan kondisi false
     * @param id k bertipe Object
     * @return menampilkan hasil pencarian
     */
    public List<Region> search(Object k) {
        return rdao.getData(k, false);
    }

    /**
     * Fungsi untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class RegionDAO 
     * @param id, name bertipe data string
     * @return berhasil melakukan insert ke database
     */
    public boolean insert(String id, String name) {
        return rdao.save(new Region(new Integer(id), name), true);
    }

    /**
     * Fungsi digunakan untuk melakukan update data
     * dengan cara memanggil method save dengan kondisi false pada class
     * @param id, name bertipe data string
     * @return berhasil melakukan update data
     */
    public boolean update(String id, String name) {
        return rdao.save(new Region(new Integer(id), name), false);
    }

    /**
     * Fungsi untuk menghapus regions berdasarkan regions id
     * dengan cara memanggil method delete pada class RegionDAO
     * @param id tipe data string
     * @return berhasil menghapus data berdasarkan id
     */
    public boolean delete(String id) {
        return rdao.delete(new Integer(id));
    }
}
