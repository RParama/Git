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

    public RegionController(Connection connection) {
        rdao = new RegionDAO(connection);
    }

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
