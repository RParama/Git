/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import tools.Connections;

/**
 *
 * @author vivian
 */
public class JobController {

    private JobDAO jdao;
    private Connections connection;

    /**
     * Method JobController merupakan constructor method dari class JobController
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Pada method ini melakukan instansiasi objek 
     * bernama jdao pada class JobDAO untuk melakukan koneksi ke database
     * Method JobController memiliki access modifier public
     */
    public JobController(Connection connection) {
        jdao = new JobDAO(connection);
    }
 
     /**
     * Method getJobs digunakan untuk menampilkan data pada jobs secara keseluruhan
     * dengan cara memanggil method getData dengan kondisi false pada class JobDAO
     * Method getJobs memiliki list bernama joblist yang berfungsi untuk menyimpan hasil pencarian
     * Method getJobs memiliki access modifier public
     */
    public List<Job> getJobs (){
        return jdao.getData("", false); 
           }
    
     /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class JobDAO
     * Method insert memiliki parameter id dan title bertipe data string
     * minSalary dan maxSalary bertipe data integer
     * Method insert memiliki access modifier public
     */
    public boolean insert(String id, String title, int minSalary, int maxSalary) {
        return jdao.save(new Job(id, title, minSalary, maxSalary), true);
    }

    /**
     * Method update digunakan untuk melakukan update data pada database
     * dengan cara memanggil method save dengan kondisi false pada class JobDAO
     * Method update memiliki parameter id dan title bertipe data string
     * minSalary dan maxSalary bertipe data integer
     * Method update memiliki access modifier public
     */
    public boolean update(String id, String title, int minSalary, int maxSalary) {
        return jdao.save(new Job(id, title, minSalary, maxSalary), false);
    }

     /**
     * Method delete digunakan untuk menghapus department berdasarkan job id
     * dengan cara memanggil method delete pada class JobDAO
     * Method delete memiliki parameter id bertipe data string
     * Method delete memiliki access modifier public
     */
    public boolean delete(String id) {
        return jdao.delete(new Job(id));
    }

    /**
     * Method getData digunakan untuk menampilkan data pada department secara keseluruhan
     * dengan cara memanggil method getData dengan kondisi false pada class DepartmentDAO
     * Method getData memiliki list bernama job yang berfungsi untuk menyimpan hasil pencarian
     * Method getData memiliki access modifier public
     */
    public List<Job> getData() {
        return jdao.getData("", false);
    }

     /**
     * Method getById digunakan untuk melakukan pencarian data berasarkan job id
     * dengan cara memanggil method getData dengan kondisi false pada class JobDAO
     * Method getById memiliki list bernama job yang berfungsi untuk menyimpan hasil pencarian
     * Method getById memiliki access modifier public
     */
    public List<Job> getById(Object id) {
        return jdao.getData(id, false);
    }

    /**
     * Mendeklarasikan method main yang berisi :
     * Instansiasi objek bernama connections pada class Connections
     * Instansiasi obje bernama a pada class JobController
     * Memanggil method getJobId dan getJobTitle pada class model Job
     * untuk menampilkan id dana nama
     */
//    public static void main(String[] args) {
//        Connections connections = new Connections();
//        JobController a = new JobController(connections.getConnection());
//
//        for (Job r : a.getById("REP")) {
//            System.out.println("Id : " + r.getJobId());
//            System.out.println("Nama : " + r.getJobTitle());
////        }
//
//        }
    }

