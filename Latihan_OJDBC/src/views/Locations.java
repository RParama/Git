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
 * @author SAMSUNG
 */
@Entity
@Table(name = "LOCATIONS", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l")
    , @NamedQuery(name = "Locations.findByLocationId", query = "SELECT l FROM Locations l WHERE l.locationId = :locationId")
    , @NamedQuery(name = "Locations.findByStreetAddress", query = "SELECT l FROM Locations l WHERE l.streetAddress = :streetAddress")
    , @NamedQuery(name = "Locations.findByPostalCode", query = "SELECT l FROM Locations l WHERE l.postalCode = :postalCode")
    , @NamedQuery(name = "Locations.findByCity", query = "SELECT l FROM Locations l WHERE l.city = :city")
    , @NamedQuery(name = "Locations.findByStateProvince", query = "SELECT l FROM Locations l WHERE l.stateProvince = :stateProvince")
    , @NamedQuery(name = "Locations.findByCountryId", query = "SELECT l FROM Locations l WHERE l.countryId = :countryId")})
public class Locations implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOCATION_ID")
    private Short locationId;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Column(name = "COUNTRY_ID")
    private String countryId;

    public Locations() {
    }

    public Locations(Short locationId) {
        this.locationId = locationId;
    }

    public Locations(Short locationId, String city) {
        this.locationId = locationId;
        this.city = city;
    }

    public Short getLocationId() {
        return locationId;
    }

    public void setLocationId(Short locationId) {
        Short oldLocationId = this.locationId;
        this.locationId = locationId;
        changeSupport.firePropertyChange("locationId", oldLocationId, locationId);
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        String oldStreetAddress = this.streetAddress;
        this.streetAddress = streetAddress;
        changeSupport.firePropertyChange("streetAddress", oldStreetAddress, streetAddress);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        String oldPostalCode = this.postalCode;
        this.postalCode = postalCode;
        changeSupport.firePropertyChange("postalCode", oldPostalCode, postalCode);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        String oldStateProvince = this.stateProvince;
        this.stateProvince = stateProvince;
        changeSupport.firePropertyChange("stateProvince", oldStateProvince, stateProvince);
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        String oldCountryId = this.countryId;
        this.countryId = countryId;
        changeSupport.firePropertyChange("countryId", oldCountryId, countryId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "views.Locations[ locationId=" + locationId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
