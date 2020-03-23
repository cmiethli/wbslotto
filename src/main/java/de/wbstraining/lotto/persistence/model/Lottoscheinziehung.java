/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbstraining.lotto.persistence.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Günter
 */
@Entity
@Table(name = "lottoscheinziehung")
@NamedQueries({
    @NamedQuery(name = "Lottoscheinziehung.findAll", query = "SELECT l FROM Lottoscheinziehung l"),
    @NamedQuery(name = "Lottoscheinziehung.findByLottoscheinziehungid", query = "SELECT l FROM Lottoscheinziehung l WHERE l.lottoscheinziehungid = :lottoscheinziehungid"),
    @NamedQuery(name = "Lottoscheinziehung.findByZiehungnr", query = "SELECT l FROM Lottoscheinziehung l WHERE l.ziehungnr = :ziehungnr"),
    @NamedQuery(name = "Lottoscheinziehung.findByIsabgeschlossen", query = "SELECT l FROM Lottoscheinziehung l WHERE l.isabgeschlossen = :isabgeschlossen"),
    @NamedQuery(name = "Lottoscheinziehung.findByIsletzteziehung", query = "SELECT l FROM Lottoscheinziehung l WHERE l.isletzteziehung = :isletzteziehung"),
    @NamedQuery(name = "Lottoscheinziehung.findByCreated", query = "SELECT l FROM Lottoscheinziehung l WHERE l.created = :created"),
    @NamedQuery(name = "Lottoscheinziehung.findByLastmodified", query = "SELECT l FROM Lottoscheinziehung l WHERE l.lastmodified = :lastmodified"),
    @NamedQuery(name = "Lottoscheinziehung.findByVersion", query = "SELECT l FROM Lottoscheinziehung l WHERE l.version = :version"),
    @NamedQuery(name = "Lottoscheinziehung.findByGewinnspiel77", query = "SELECT l FROM Lottoscheinziehung l WHERE l.gewinnspiel77 = :gewinnspiel77"),
    @NamedQuery(name = "Lottoscheinziehung.findByGewinnsuper6", query = "SELECT l FROM Lottoscheinziehung l WHERE l.gewinnsuper6 = :gewinnsuper6")})
public class Lottoscheinziehung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lottoscheinziehungid")
    private Long lottoscheinziehungid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ziehungnr")
    private int ziehungnr;
    @Column(name = "isabgeschlossen")
    private Boolean isabgeschlossen;
    @Column(name = "isletzteziehung")
    private Boolean isletzteziehung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastmodified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodified;
    @Column(name = "version")
    private Integer version;
    @Column(name = "gewinnspiel77")
    private BigInteger gewinnspiel77;
    @Column(name = "gewinnsuper6")
    private BigInteger gewinnsuper6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lottoscheinziehungid")
    private List<Lottoscheinziehung6aus49> lottoscheinziehung6aus49List;
    @JoinColumn(name = "gewinnklasseidspiel77", referencedColumnName = "gewinnklasseid")
    @ManyToOne
    private Gewinnklasse gewinnklasseidspiel77;
    @JoinColumn(name = "gewinnklasseidsuper6", referencedColumnName = "gewinnklasseid")
    @ManyToOne
    private Gewinnklasse gewinnklasseidsuper6;
    @JoinColumn(name = "lottoscheinid", referencedColumnName = "lottoscheinid")
    @ManyToOne(optional = false)
    private Lottoschein lottoscheinid;
    @JoinColumn(name = "ziehungid", referencedColumnName = "ziehungid")
    @ManyToOne(optional = false)
    private Ziehung ziehungid;

    public Lottoscheinziehung() {
    }

    public Lottoscheinziehung(Long lottoscheinziehungid) {
        this.lottoscheinziehungid = lottoscheinziehungid;
    }

    public Lottoscheinziehung(Long lottoscheinziehungid, int ziehungnr, Date created, Date lastmodified) {
        this.lottoscheinziehungid = lottoscheinziehungid;
        this.ziehungnr = ziehungnr;
        this.created = created;
        this.lastmodified = lastmodified;
    }

    public Long getLottoscheinziehungid() {
        return lottoscheinziehungid;
    }

    public void setLottoscheinziehungid(Long lottoscheinziehungid) {
        this.lottoscheinziehungid = lottoscheinziehungid;
    }

    public int getZiehungnr() {
        return ziehungnr;
    }

    public void setZiehungnr(int ziehungnr) {
        this.ziehungnr = ziehungnr;
    }

    public Boolean getIsabgeschlossen() {
        return isabgeschlossen;
    }

    public void setIsabgeschlossen(Boolean isabgeschlossen) {
        this.isabgeschlossen = isabgeschlossen;
    }

    public Boolean getIsletzteziehung() {
        return isletzteziehung;
    }

    public void setIsletzteziehung(Boolean isletzteziehung) {
        this.isletzteziehung = isletzteziehung;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigInteger getGewinnspiel77() {
        return gewinnspiel77;
    }

    public void setGewinnspiel77(BigInteger gewinnspiel77) {
        this.gewinnspiel77 = gewinnspiel77;
    }

    public BigInteger getGewinnsuper6() {
        return gewinnsuper6;
    }

    public void setGewinnsuper6(BigInteger gewinnsuper6) {
        this.gewinnsuper6 = gewinnsuper6;
    }

    public List<Lottoscheinziehung6aus49> getLottoscheinziehung6aus49List() {
        return lottoscheinziehung6aus49List;
    }

    public void setLottoscheinziehung6aus49List(List<Lottoscheinziehung6aus49> lottoscheinziehung6aus49List) {
        this.lottoscheinziehung6aus49List = lottoscheinziehung6aus49List;
    }

    public Gewinnklasse getGewinnklasseidspiel77() {
        return gewinnklasseidspiel77;
    }

    public void setGewinnklasseidspiel77(Gewinnklasse gewinnklasseidspiel77) {
        this.gewinnklasseidspiel77 = gewinnklasseidspiel77;
    }

    public Gewinnklasse getGewinnklasseidsuper6() {
        return gewinnklasseidsuper6;
    }

    public void setGewinnklasseidsuper6(Gewinnklasse gewinnklasseidsuper6) {
        this.gewinnklasseidsuper6 = gewinnklasseidsuper6;
    }

    public Lottoschein getLottoscheinid() {
        return lottoscheinid;
    }

    public void setLottoscheinid(Lottoschein lottoscheinid) {
        this.lottoscheinid = lottoscheinid;
    }

    public Ziehung getZiehungid() {
        return ziehungid;
    }

    public void setZiehungid(Ziehung ziehungid) {
        this.ziehungid = ziehungid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lottoscheinziehungid != null ? lottoscheinziehungid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lottoscheinziehung)) {
            return false;
        }
        Lottoscheinziehung other = (Lottoscheinziehung) object;
        if ((this.lottoscheinziehungid == null && other.lottoscheinziehungid != null) || (this.lottoscheinziehungid != null && !this.lottoscheinziehungid.equals(other.lottoscheinziehungid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wbs.corejpa.persistence.Lottoscheinziehung[ lottoscheinziehungid=" + lottoscheinziehungid + " ]";
    }
    
}
