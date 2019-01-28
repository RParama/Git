/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
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
 * @author SAMSUNG
 */
@Entity
@Table(name = "COUNTRIES", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")
    , @NamedQuery(name = "Countries.findByCountryId", query = "SELECT c FROM Countries c WHERE c.countryId = :countryId")
    , @NamedQuery(name = "Countries.findByCountryName", query = "SELECT c FROM Countries c WHERE c.countryName = :countryName")
    , @NamedQuery(name = "Countries.findByRegionId", query = "SELECT c FROM Countries c WHERE c.regionId = :regionId")})
public class Countries implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Column(name = "REGION_ID")
    private BigInteger regionId;

    public Countries() {
    }

    public Countries(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        String oldCountryId = this.countryId;
        this.countryId = countryId;
        changeSupport.firePropertyChange("countryId", oldCountryId, countryId);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        String oldCountryName = this.countryName;
        this.countryName = countryName;
        changeSupport.firePropertyChange("countryName", oldCountryName, countryName);
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        BigInteger oldRegionId = this.regionId;
        this.regionId = regionId;
        changeSupport.firePropertyChange("regionId", oldRegionId, regionId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "views.Countries[ countryId=" + countryId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
