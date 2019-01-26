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

    public JobController(Connection connection) {
        jdao = new JobDAO(connection);
    }

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
