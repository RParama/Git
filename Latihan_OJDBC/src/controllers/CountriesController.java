/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountrieDAO;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import models.Countries;
import tools.Connections;

/**
 *
 * @author User
 */
public class CountriesController {

    private CountrieDAO cdao;
    private Connection connection;

    public CountriesController(Connection connection) {
        cdao = new CountrieDAO(connection);
    }

    /**
     * get data digunakan untuk mengambil data di database berbentuk list
     * @return list data base country
     */
    public List<Countries> getData() {
        return cdao.getData("", false);
    }
    
    /**
     * digunakan untuk melakukan pencarian data pada regions sesuai dengan keyword yang di inputkan
     */
    public List<Countries> getDataSearch(Object k) {
        return cdao.getData(k, false);
    }
    
    /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class
     * CountryDAO Method insert memiliki parameter id, name dan region id
     */
    public boolean insert(String Country_Id, String Country_Name, String Region_Id) {
        int idINT = new Integer(Region_Id); //casting String id menjadi int
        return cdao.save(new Countries(Country_Id, Country_Name, idINT), true); //save(region,true) = insert;
    }
    
    /**
     * Method update digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi false pada class
     * CountryDAO Method update memiliki parameter id, name dan region id
     */
    public boolean update(String Country_Id, String Country_Name, String Region_Id) {
        int idINT = new Integer(Region_Id); //casting String id menjadi int
        return cdao.save(new Countries(Country_Id, Country_Name, idINT), false); //save(region,false) = update;
    }
    
    /**
     * Method delete digunakan untuk menghapus country berdasarkan country id
     * dengan cara memanggil method delete pada class CountryDAO Method delete
     * memiliki parameter id bertipe data string
     */
    public boolean delete(String id) {
        return cdao.delete(id);
    }

}
