/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author vivian
 */
public class Job {
    private String jobId;
    private String jobTitle;
    private int minSalary;
    private int maxSalary;

     /**
     * Method Job yang berfungsi untuk memberikan nilai pada variabel global dari class Job yaitu
     * minSalary dan maxSalary yang bertipe data integer, jobId dan jobTitle yang bertipe data string
     * dari parameter method Job
     * Method Job memiliki access modifier public
     */
    public Job(String jobId, String jobTitle, int minSalary, int maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    /**
     * Method Job merupakan constructor method dari class Job
     * method yang pertama kali dijalankan ketika class di eksekusi
     * Memiliki access modifier public
     */
    public Job() {
    }
  
    public Job(String id) {
           this.jobId=id;
         }
    
    /**
     * Method getJobId digunakan untuk mengambil nilai dari jobId
     * Method getJobId memiliki access modifier public
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * Method setJobId digunakan untuk memberikakn nilai pada variabel global jobId  
     * berdasarkan variabel jobId pada parameter method setJobId
     * Method setJobId memiliki access modifier public
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

     /**
     * Method getJobTitle digunakan untuk mengambil nilai dari jobTitle
     * Method getJobTitle memiliki access modifier public
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Method setJobTitle digunakan untuk memberikakn nilai pada variabel global jobTitle  
     * berdasarkan variabel jobTitle pada parameter method setJobTitle
     * Method setJobTitle memiliki access modifier public
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

     /**
     * Method getMinSalary digunakan untuk mengambil nilai dari minSalary
     * Method getMinSalary memiliki access modifier public
     */
    public int getMinSalary() {
        return minSalary;
    }

    /**
     * Method setMinSalary digunakan untuk memberikakn nilai pada variabel global minSalary  
     * berdasarkan variabel minSalary pada parameter method setMinSalary
     * Method setMinSalary memiliki access modifier public
     */
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    /**
     * Method getMaxSalary digunakan untuk mengambil nilai dari maxSalary
     * Method getMaxSalary memiliki access modifier public
     */
    public int getMaxSalary() {
        return maxSalary;
    }

     /**
     * Method setMaxSalary digunakan untuk memberikakn nilai pada variabel global maxSalary  
     * berdasarkan variabel minSalary pada parameter method setMaxSalary
     * Method setMaxSalary memiliki access modifier public
     */
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
    
    
   
    
}
