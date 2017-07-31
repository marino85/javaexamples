/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.test.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin
 */
@Entity
@Table(name = "pbfn_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PbfnAudit.findAll", query = "SELECT p FROM PbfnAudit p"),
    @NamedQuery(name = "PbfnAudit.findById", query = "SELECT p FROM PbfnAudit p WHERE p.id = :id"),
    @NamedQuery(name = "PbfnAudit.findByActivityDescription", query = "SELECT p FROM PbfnAudit p WHERE p.activityDescription = :activityDescription"),
    @NamedQuery(name = "PbfnAudit.findByData", query = "SELECT p FROM PbfnAudit p WHERE p.data = :data"),
    @NamedQuery(name = "PbfnAudit.findByDate", query = "SELECT p FROM PbfnAudit p WHERE p.date = :date"),
    @NamedQuery(name = "PbfnAudit.findByDeviceDescription", query = "SELECT p FROM PbfnAudit p WHERE p.deviceDescription = :deviceDescription"),
    @NamedQuery(name = "PbfnAudit.findByIpAddress", query = "SELECT p FROM PbfnAudit p WHERE p.ipAddress = :ipAddress"),
    @NamedQuery(name = "PbfnAudit.findByMessage", query = "SELECT p FROM PbfnAudit p WHERE p.message = :message"),
    @NamedQuery(name = "PbfnAudit.findByUsername", query = "SELECT p FROM PbfnAudit p WHERE p.username = :username")})
public class PbfnAudit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1028)
    @Column(name = "activity_description")
    private String activityDescription;
    @Size(max = 2048)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 512)
    @Column(name = "device_description")
    private String deviceDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ip_address")
    private String ipAddress;
    @Size(max = 1024)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "username")
    private String username;

    public PbfnAudit() {
    }

    public PbfnAudit(Integer id) {
        this.id = id;
    }

    public PbfnAudit(Integer id, Date date, String ipAddress, String username) {
        this.id = id;
        this.date = date;
        this.ipAddress = ipAddress;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PbfnAudit)) {
            return false;
        }
        PbfnAudit other = (PbfnAudit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.test.model.PbfnAudit[ id=" + id + " ]";
    }
    
}
