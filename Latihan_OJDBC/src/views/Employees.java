/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "EMPLOYEES", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmployeeId", query = "SELECT e FROM Employees e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")
    , @NamedQuery(name = "Employees.findByPhoneNumber", query = "SELECT e FROM Employees e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate")
    , @NamedQuery(name = "Employees.findByJobId", query = "SELECT e FROM Employees e WHERE e.jobId = :jobId")
    , @NamedQuery(name = "Employees.findBySalary", query = "SELECT e FROM Employees e WHERE e.salary = :salary")
    , @NamedQuery(name = "Employees.findByCommissionPct", query = "SELECT e FROM Employees e WHERE e.commissionPct = :commissionPct")
    , @NamedQuery(name = "Employees.findByDepartmentId", query = "SELECT e FROM Employees e WHERE e.departmentId = :departmentId")})
public class Employees implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @Basic(optional = false)
    @Column(name = "JOB_ID")
    private String jobId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;
    @OneToMany(mappedBy = "managerId")
    private List<Employees> employeesList;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne
    private Employees managerId;

    public Employees() {
    }

    public Employees(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employees(Integer employeeId, String lastName, String email, Date hireDate, String jobId) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.jobId = jobId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        Integer oldEmployeeId = this.employeeId;
        this.employeeId = employeeId;
        changeSupport.firePropertyChange("employeeId", oldEmployeeId, employeeId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        Date oldHireDate = this.hireDate;
        this.hireDate = hireDate;
        changeSupport.firePropertyChange("hireDate", oldHireDate, hireDate);
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        String oldJobId = this.jobId;
        this.jobId = jobId;
        changeSupport.firePropertyChange("jobId", oldJobId, jobId);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        BigDecimal oldSalary = this.salary;
        this.salary = salary;
        changeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        BigDecimal oldCommissionPct = this.commissionPct;
        this.commissionPct = commissionPct;
        changeSupport.firePropertyChange("commissionPct", oldCommissionPct, commissionPct);
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        Short oldDepartmentId = this.departmentId;
        this.departmentId = departmentId;
        changeSupport.firePropertyChange("departmentId", oldDepartmentId, departmentId);
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        Employees oldManagerId = this.managerId;
        this.managerId = managerId;
        changeSupport.firePropertyChange("managerId", oldManagerId, managerId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "views.Employees[ employeeId=" + employeeId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
