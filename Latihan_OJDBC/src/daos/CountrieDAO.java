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
import models.Countries;
import models.Region;

/**
 *
 * @author Suwandi
 */
public class CountrieDAO {

    private Connection connection;
    
    /**
     * Method CountriesDAO merupakan constructor method dari class CountriesDAO 
     * yang berfungsi untuk melakukan koneksi dengan menggunakan parameter Connection 
     */
    public CountrieDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method getAll digunakan untuk menampilkan semua data yang ada pada tabel countries (id, name dan region id)
     * Membuat sebuah list yang berfungsi untuk menampung hasil dengan nama "cs"
     * Mengambil data dengan perintah query yang disimpan pada variable query
     * Menyiapkan query yang akan dieksekusi (connection.prepareStatement(query))
     * Melakkan eksekusi query (preparedStatement.executeQuery())
     * Membuat sebuah objek yang bernama "r" dari class Countries yang akan memanggil method yang ada di class Countries
     * Output berupa list yang berisi data yang telah ditambahkan di dalam list (region id, country name dan region id)
     */
    public List<Countries> getAll() {
        List<Countries> cs = new ArrayList<>();
        String query = "SELECT * FROM hr.countries";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);   //menyiapkan query.dari prepareStatement.menggunakan koneksi
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Countries r = new Countries();
                r.setCountryId(resultSet.getString(1));
                r.setCountryName(resultSet.getString(2));
                r.setRegionId(resultSet.getInt(3));
                cs.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cs;
    }

    /**
     * Method getData digunakan untuk menampilkan data bedasarkan keyword yang di inputkan
     * Membuat list yang diberinama "cs" untuk menampung hasil pencarian
     * Jika data yang di inputkan bernilai false, maka akan menampilkan hasil semua yang mengandung karakter pada keyword yang di inputkan
     * Apabila data yang di inputkan bernilai true, maka akan menampilkan berdasarkan id yang di cari
     */
    public List<Countries> getData(Object keyword, boolean z) {
        String query;
        List<Countries> cs = new ArrayList<Countries>();
        if (!z) {
            query = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES "
                    + "WHERE COUNTRY_ID LIKE '%" + keyword + "%' "
                    + "OR COUNTRY_NAME LIKE '%" + keyword + "%' "
                    + "OR REGION_ID LIKE '%" + keyword + "%' ";
        } else {
            query = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID =" + keyword;//
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cs.add(new Countries(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cs;
    }

    /**
     * Method save digunakan untuk melakukan update dan insert data baru
     * Method ini memiliki parameter r objek dari class Countries
     * Apabila data yang di intutkan bernilai false, maka akan melakukan update ke database
     * Apabila data yang di inputkan bernilai false, maka akan melakukan insert data baru
     *
     */
    public boolean save(Countries r, boolean z) {
        boolean result = false;
        String query;
        if (!z) {
            query = "UPDATE hr.countries SET country_name=? WHERE country_id=? AND region_id=?";
        } else {
            query = "INSERT INTO hr.countries (country_name,country_id,region_id) VALUES(?,?,?)";
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getCountryName());
            preparedStatement.setString(2, r.getCountryId());
            preparedStatement.setInt(3, r.getRegionId());
            preparedStatement.executeQuery();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

   /**
     * Method hapus berfunngsi untuk menghapus data countries pada database
     * Method ini memiliki parameter objek r dari class Countries
     * Method ini akan menghapus data dari database berdasarkan country id nya
     */
    public void hapus(Countries r) {
        String query = "DELETE FROM hr.countries WHERE country_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getCountryId());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Method delete berfunngsi untuk menghapus data countries pada database
     * Method ini memiliki parameter objek r dari class Countries
     * Method ini akan menghapus data dari database berdasarkan country id nya
     */
    public boolean delete(String id) {
        boolean result = false;
        String query = "DELETE FROM hr.countries WHERE country_id='"+id+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, r.getCountryId());
//            preparedStatement.executeQuery();
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Method getAll2 digunakan untuk menampilkan semua data yang ada pada tabel countries (id, name dan region id)
     * Membuat sebuah list yang berfungsi untuk menampung hasil dengan nama "cs"
     * Mengambil data dengan perintah query yang disimpan pada variable query
     * Menyiapkan query yang akan dieksekusi (connection.prepareStatement(query))
     * Melakkan eksekusi query (preparedStatement.executeQuery())
     * Membuat sebuah objek yang bernama "r" dari class Countries yang akan memanggil method yang ada di class Countries
     * Output berupa list yang berisi data yang telah ditambahkan di dalam list (region id, country name dan region id)
     */
    public List<Countries> getAll2() {
        PreparedStatement ps = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String query = "SELECT * FROM hr.countries";
        try {
            ps = connection.prepareStatement(query);   //menyiapkan query.dari prepareStatement.menggunakan koneksi
            rs = ps.executeQuery();
            while (rs.next()) {
                Countries r = new Countries();
                r.setCountryId(rs.getString(""));
                r.setCountryName(rs.getString(""));
                r.setRegionId(rs.getInt(3));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
