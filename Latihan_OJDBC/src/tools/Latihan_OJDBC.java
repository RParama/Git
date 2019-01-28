/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.RegionController;
import daos.RegionDAO;
import models.Region;

/**
 *
 * @author kresna92
 */
public class Latihan_OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connections connections = new Connections();

//        RegionDAO rdao = new RegionDAO(connections.getConnection());
        RegionController regionController= new RegionController(connections.getConnection());
        System.out.println(regionController.getMaxRegId());
//        for (Region r : rdao.getData(1,true)) {
//            System.out.println("Id : " + r.getRegionId());
//            System.out.println("Nama : " + r.getRegionName());
//        }
//        for (Region r : rdao.getById(1)) {
//            System.out.println("Id : " + r.getRegionId());
//            System.out.println("Nama : " + r.getRegionName());
//        }
//        for (Region r : rdao.search("a")) {
//            System.out.println("Id : " + r.getRegionId());
//            System.out.println("Nama : " + r.getRegionName());
//        }
//        for (Region r : rdao.search(1)) {
//            System.out.println("Id : " + r.getRegionId());
//            System.out.println("Nama : " + r.getRegionName());
//        }
//
//        if (rdao.delete(7)) {
//            System.out.println("Delete Berhasil");
//        } else {
//            System.out.println("Delete Gagal");
//        }
//        Region region = new Region(101, "Ada Deh3...");

//        if (regionController.insert("9", "Afrii...")) {
//            System.out.println("Update Berhasil");
//        } else {
//            System.out.println("Update Gagal");
//        }
        
//        if (rdao.insert(region)) {
//            System.out.println("Insert Berhasil");
//        } else {
//            System.out.println("Insert Gagal");
//        }
          
    }
}
