/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import models.Region;

/**
 *
 * @author vivian
 */
public class JobDAO {

    private Connection connection;

     /**
     * Fungsi untuk melakukan koneksi ke database
     * @param objek connection dari class Connection
     */
    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Fungsi digunakan untuk melakukan pencarian data berdasarkan keyword yang di inputkan
     * Jika isGetById bernilai false, maka sistem akan menampilkan 
     * semua data yang berkaitan dengan keyword
     * Jika isGetById bernilai true, maka sistem akan menampilkan data berdasarkan job_id nya
     * @param keyword bertipe Object
     * @param isGetById bertipe data boolean
     * @return menampilkan hasil pencarian
     */
    public List<Job> getData(Object keyword, boolean isGetById) {
        String query;
        List<Job> job = new ArrayList<Job>();
        if (!isGetById) {
            query = "SELECT JOB_ID, JOB_TITLE, MIN_SALARY,MAX_SALARY FROM JOBS "
                    + "WHERE JOB_ID LIKE '%" + keyword + "%' "
                    + "OR JOB_TITLE LIKE '%" + keyword + "%' ";
        } else {
            query = "SELECT * FROM JOBS WHERE JOB_ID = '" + keyword+"'";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                job.add(new Job(resultSet.getString(1), resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return job;
    }

     /**
     * Fungsi digunakan untuk melakukan insert dan update pada database
     * Jika nilai isInsert bernilai false, maka sistem akan melakukan update data pada database
     * Jika nilai isInsert bernilai true, maka sistem akan melakukan insert data baru ke database
     * @param objek J pada class Job
     * @param isInsert bertipe data boolean
     * @return berhasil melakukan update atau insert
     */
    public boolean save(Job j, boolean isInsert) {
        String query;
        boolean result = false;
        if (!isInsert) {
            query = "UPDATE JOBS SET JOB_TITLE = ? , MIN_SALARY= ?, MAX_SALARY= ? WHERE JOB_ID = ?";
        } else {
            query = "INSERT INTO JOBS (JOB_TITLE,MIN_SALARY,MAX_SALARY,JOB_ID) VALUES(?,?,?,?)";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, j.getJobTitle());
            preparedStatement.setInt(2, j.getMinSalary());
            preparedStatement.setInt(3, j.getMaxSalary());
            preparedStatement.setString(4, j.getJobId());

            preparedStatement.executeQuery();
             preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method delete digunakan untuk menghapus data berdasrkan job_id nya
     * @param id 
     * @return berhasil melakukan delete berdasarkan Job id
     */
    public boolean delete(Job id) {
        boolean result = false;
        String query = "DELETE JOBS WHERE JOB_ID ='" +id.getJobId()+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
