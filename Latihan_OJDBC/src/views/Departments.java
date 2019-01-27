/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "DEPARTMENTS", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d")
    , @NamedQuery(name = "Departments.findByDepartmentId", query = "SELECT d FROM Departments d WHERE d.departmentId = :departmentId")
    , @NamedQuery(name = "Departments.findByDepartmentName", query = "SELECT d FROM Departments d WHERE d.departmentName = :departmentName")
    , @NamedQuery(name = "Departments.findByManagerId", query = "SELECT d FROM Departments d WHERE d.managerId = :managerId")
    , @NamedQuery(name = "Departments.findByLocationId", query = "SELECT d FROM Departments d WHERE d.locationId = :locationId")})
public class Departments implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_ID")
    private Short departmentId;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Column(name = "LOCATION_ID")
    private Short locationId;

    public Departments() {
    }

    public Departments(Short departmentId) {
        this.departmentId = departmentId;
    }

    public Departments(Short departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        Short oldDepartmentId = this.departmentId;
        this.departmentId = departmentId;
        changeSupport.firePropertyChange("departmentId", oldDepartmentId, departmentId);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        String oldDepartmentName = this.departmentName;
        this.departmentName = departmentName;
        changeSupport.firePropertyChange("departmentName", oldDepartmentName, departmentName);
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        Integer oldManagerId = this.managerId;
        this.managerId = managerId;
        changeSupport.firePropertyChange("managerId", oldManagerId, managerId);
    }

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
        Short oldLocationId = this.locationId;
        this.locationId = locationId;
        changeSupport.firePropertyChange("locationId", oldLocationId, locationId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "views.Departments[ departmentId=" + departmentId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
