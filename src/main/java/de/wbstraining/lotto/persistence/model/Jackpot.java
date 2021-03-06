/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbstraining.lotto.persistence.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import de.wbstraining.lotto.persistence.util.LocalDateTimeAttributeConverter;

/**
 *
 * @author Günter
 */
@Entity
@Table(name = "jackpot")
@NamedQueries({
	@NamedQuery(name = "Jackpot.findAll", query = "SELECT j FROM Jackpot j"),
	@NamedQuery(name = "Jackpot.findByJackpotid", query = "SELECT j FROM Jackpot j WHERE j.jackpotid = :jackpotid"),
	@NamedQuery(name = "Jackpot.findByAnzahlziehungen", query = "SELECT j FROM Jackpot j WHERE j.anzahlziehungen = :anzahlziehungen"),
	@NamedQuery(name = "Jackpot.findByBetrag", query = "SELECT j FROM Jackpot j WHERE j.betrag = :betrag"),
	@NamedQuery(name = "Jackpot.findByBetragkumuliert", query = "SELECT j FROM Jackpot j WHERE j.betragkumuliert = :betragkumuliert"),
	@NamedQuery(name = "Jackpot.findByCreated", query = "SELECT j FROM Jackpot j WHERE j.created = :created"),
	@NamedQuery(name = "Jackpot.findByLastmodified", query = "SELECT j FROM Jackpot j WHERE j.lastmodified = :lastmodified"),
	@NamedQuery(name = "Jackpot.findByVersion", query = "SELECT j FROM Jackpot j WHERE j.version = :version") })
public class Jackpot implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "jackpotid")
	private Long jackpotid;
	@Basic(optional = false)
	@NotNull
	@Column(name = "anzahlziehungen")
	private int anzahlziehungen;
	@Basic(optional = false)
	@NotNull
	@Column(name = "betrag")
	private long betrag;
	@Basic(optional = false)
	@NotNull
	@Column(name = "betragkumuliert")
	private long betragkumuliert;
	@Basic(optional = false)
	@NotNull
	@Column(name = "created")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime created;
	@Basic(optional = false)
	@NotNull
	@Column(name = "lastmodified")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime lastmodified;
	@Column(name = "version")
	private Integer version;
	@JoinColumn(name = "gewinnklasseid", referencedColumnName = "gewinnklasseid")
	@ManyToOne(optional = false)
	private Gewinnklasse gewinnklasse;
	@JoinColumn(name = "ziehungid", referencedColumnName = "ziehungid")
	@ManyToOne(optional = false)
	private Ziehung ziehung;

	public Jackpot() {
	}

	public Jackpot(Long jackpotid) {
		this.jackpotid = jackpotid;
	}

	public Jackpot(Long jackpotid, int anzahlziehungen, long betrag,
		long betragkumuliert, LocalDateTime created, LocalDateTime lastmodified) {
		this.jackpotid = jackpotid;
		this.anzahlziehungen = anzahlziehungen;
		this.betrag = betrag;
		this.betragkumuliert = betragkumuliert;
		this.created = created;
		this.lastmodified = lastmodified;
	}

	public Long getJackpotid() {
		return jackpotid;
	}

	public void setJackpotid(Long jackpotid) {
		this.jackpotid = jackpotid;
	}

	public int getAnzahlziehungen() {
		return anzahlziehungen;
	}

	public void setAnzahlziehungen(int anzahlziehungen) {
		this.anzahlziehungen = anzahlziehungen;
	}

	public long getBetrag() {
		return betrag;
	}

	public void setBetrag(long betrag) {
		this.betrag = betrag;
	}

	public long getBetragkumuliert() {
		return betragkumuliert;
	}

	public void setBetragkumuliert(long betragkumuliert) {
		this.betragkumuliert = betragkumuliert;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(LocalDateTime lastmodified) {
		this.lastmodified = lastmodified;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Gewinnklasse getGewinnklasse() {
		return gewinnklasse;
	}

	public void setGewinnklasse(Gewinnklasse gewinnklasseid) {
		this.gewinnklasse = gewinnklasseid;
	}

	public Ziehung getZiehung() {
		return ziehung;
	}

	public void setZiehung(Ziehung ziehungid) {
		this.ziehung = ziehungid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (jackpotid != null ? jackpotid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not
		// set
		if (!(object instanceof Jackpot)) {
			return false;
		}
		Jackpot other = (Jackpot) object;
		if ((this.jackpotid == null && other.jackpotid != null)
			|| (this.jackpotid != null && !this.jackpotid.equals(other.jackpotid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "wbs.corejpa.persistence.Jackpot[ jackpotid=" + jackpotid + " ]";
	}

}
