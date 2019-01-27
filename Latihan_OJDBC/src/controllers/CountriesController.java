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

    public List<Countries> getData() {
        List<Countries> countrieses = new ArrayList<Countries>();

        boolean result = false;
        try {

            countrieses = cdao.getData("", false);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrieses;
    }

    public List<Countries> getDataById(Object id) {
        List<Countries> cs = new ArrayList<Countries>();
        try {
            //String idString = new String(id);
            cs = cdao.getData(id, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cs;
    }

    public List<Countries> getDataSearch(Object k) {
        List<Countries> cs = new ArrayList<Countries>();
        try {
            cs = cdao.getData(k, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cs;
    }

    public boolean insert(String Country_Id, String Country_Name, String Region_Id) {
        boolean result = false;
        try {
            int idINT = new Integer(Region_Id); //casting String id menjadi int
            cdao.save(new Countries(Country_Id, Country_Name, idINT), true); //save(region,true) = insert
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(String Country_Id, String Country_Name, String Region_Id) {
        boolean result = false;
        try {
            int idINT = new Integer(Region_Id); //casting String id menjadi int
            cdao.save(new Countries(Country_Id, Country_Name, idINT), false); //save(region,false) = update
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        try {
            //int idINT = new Integer(locationId); //casting String id menjadi int
//            cdao.delete(idINT); //delete
            cdao.delete(id); //delete
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
