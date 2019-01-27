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
    public List<String> getJobs (){
        List<String> joblist = new ArrayList<String>();
        boolean result = false;
        try {
            for (Job job : jdao.getData("", false)) {
                joblist.add(job.getJobTitle());
            }

            
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joblist;
    }
    
     /**
     * Method insert digunakan untuk melakukan insert data baru ke database
     * dengan cara memanggil method save dengan kondisi true pada class JobDAO
     * Method insert memiliki parameter id dan title bertipe data string
     * minSalary dan maxSalary bertipe data integer
     * Method insert memiliki access modifier public
     */
    public boolean insert(String id, String title, int minSalary, int maxSalary) {
        boolean result = false;
        try {

            jdao.save(new Job(id, title, minSalary, maxSalary), true);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method update digunakan untuk melakukan update data pada database
     * dengan cara memanggil method save dengan kondisi false pada class JobDAO
     * Method update memiliki parameter id dan title bertipe data string
     * minSalary dan maxSalary bertipe data integer
     * Method update memiliki access modifier public
     */
    public boolean update(String id, String title, int minSalary, int maxSalary) {
        boolean result = false;
        try {

            jdao.save(new Job(id, title, minSalary, maxSalary), false);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

     /**
     * Method delete digunakan untuk menghapus department berdasarkan job id
     * dengan cara memanggil method delete pada class JobDAO
     * Method delete memiliki parameter id bertipe data string
     * Method delete memiliki access modifier public
     */
    public boolean delete(String id) {
        boolean result = false;
        try {
            jdao.delete(new Job(id));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method getData digunakan untuk menampilkan data pada department secara keseluruhan
     * dengan cara memanggil method getData dengan kondisi false pada class DepartmentDAO
     * Method getData memiliki list bernama job yang berfungsi untuk menyimpan hasil pencarian
     * Method getData memiliki access modifier public
     */
    public List<Job> getData() {
        List<Job> job = new ArrayList<Job>();
 
        boolean result = false;
        try {

            job = jdao.getData("", false);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return job;
    }

     /**
     * Method getById digunakan untuk melakukan pencarian data berasarkan job id
     * dengan cara memanggil method getData dengan kondisi false pada class JobDAO
     * Method getById memiliki list bernama job yang berfungsi untuk menyimpan hasil pencarian
     * Method getById memiliki access modifier public
     */
    public List<Job> getById(Object id) {
        List<Job> job = new ArrayList<Job>();
        boolean result = false;
        try {

            job = jdao.getData(id, false);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return job;
    }

    /**
     * Mendeklarasikan method main yang berisi :
     * Instansiasi objek bernama connections pada class Connections
     * Instansiasi obje bernama a pada class JobController
     * Memanggil method getJobId dan getJobTitle pada class model Job
     * untuk menampilkan id dana nama
     */
    public static void main(String[] args) {
        Connections connections = new Connections();
        JobController a = new JobController(connections.getConnection());

        for (Job r : a.getById("REP")) {
            System.out.println("Id : " + r.getJobId());
            System.out.println("Nama : " + r.getJobTitle());
//        }

        }
    }
}
