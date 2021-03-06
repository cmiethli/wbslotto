//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.03 at 09:46:17 AM CEST 
//


package de.wbstraining.lotto.testdatengenerierung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cZiehung complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cZiehung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://testdatengenerierung.lotto.wbs/lotto}anzahl6Aus49ProGkl"/>
 *         &lt;element ref="{http://testdatengenerierung.lotto.wbs/lotto}anzahlSpiel77ProGkl"/>
 *         &lt;element ref="{http://testdatengenerierung.lotto.wbs/lotto}anzahlSuper6ProGkl"/>
 *       &lt;/sequence>
 *       &lt;attribute name="zahlenAlsBits" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="superzahl" use="required" type="{http://testdatengenerierung.lotto.wbs/lotto}superzahl" />
 *       &lt;attribute name="spiel77" use="required" type="{http://testdatengenerierung.lotto.wbs/lotto}spiel77" />
 *       &lt;attribute name="super6" use="required" type="{http://testdatengenerierung.lotto.wbs/lotto}super6" />
 *       &lt;attribute name="anzahlTippsProSchein" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cZiehung", propOrder = {
    "anzahl6Aus49ProGkl",
    "anzahlSpiel77ProGkl",
    "anzahlSuper6ProGkl"
})
public class CZiehung {

    @XmlElement(required = true)
    protected Anzahl6Aus49ProGkl anzahl6Aus49ProGkl;
    @XmlElement(required = true)
    protected AnzahlSpiel77ProGkl anzahlSpiel77ProGkl;
    @XmlElement(required = true)
    protected AnzahlSuper6ProGkl anzahlSuper6ProGkl;
    @XmlAttribute(name = "zahlenAlsBits", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long zahlenAlsBits;
    @XmlAttribute(name = "superzahl", required = true)
    protected int superzahl;
    @XmlAttribute(name = "spiel77", required = true)
    protected int spiel77;
    @XmlAttribute(name = "super6", required = true)
    protected int super6;
    @XmlAttribute(name = "anzahlTippsProSchein", required = true)
    protected int anzahlTippsProSchein;

    /**
     * Gets the value of the anzahl6Aus49ProGkl property.
     * 
     * @return
     *     possible object is
     *     {@link Anzahl6Aus49ProGkl }
     *     
     */
    public Anzahl6Aus49ProGkl getAnzahl6Aus49ProGkl() {
        return anzahl6Aus49ProGkl;
    }

    /**
     * Sets the value of the anzahl6Aus49ProGkl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Anzahl6Aus49ProGkl }
     *     
     */
    public void setAnzahl6Aus49ProGkl(Anzahl6Aus49ProGkl value) {
        this.anzahl6Aus49ProGkl = value;
    }

    /**
     * Gets the value of the anzahlSpiel77ProGkl property.
     * 
     * @return
     *     possible object is
     *     {@link AnzahlSpiel77ProGkl }
     *     
     */
    public AnzahlSpiel77ProGkl getAnzahlSpiel77ProGkl() {
        return anzahlSpiel77ProGkl;
    }

    /**
     * Sets the value of the anzahlSpiel77ProGkl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnzahlSpiel77ProGkl }
     *     
     */
    public void setAnzahlSpiel77ProGkl(AnzahlSpiel77ProGkl value) {
        this.anzahlSpiel77ProGkl = value;
    }

    /**
     * Gets the value of the anzahlSuper6ProGkl property.
     * 
     * @return
     *     possible object is
     *     {@link AnzahlSuper6ProGkl }
     *     
     */
    public AnzahlSuper6ProGkl getAnzahlSuper6ProGkl() {
        return anzahlSuper6ProGkl;
    }

    /**
     * Sets the value of the anzahlSuper6ProGkl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnzahlSuper6ProGkl }
     *     
     */
    public void setAnzahlSuper6ProGkl(AnzahlSuper6ProGkl value) {
        this.anzahlSuper6ProGkl = value;
    }

    /**
     * Gets the value of the zahlenAlsBits property.
     * 
     */
    public long getZahlenAlsBits() {
        return zahlenAlsBits;
    }

    /**
     * Sets the value of the zahlenAlsBits property.
     * 
     */
    public void setZahlenAlsBits(long value) {
        this.zahlenAlsBits = value;
    }

    /**
     * Gets the value of the superzahl property.
     * 
     */
    public int getSuperzahl() {
        return superzahl;
    }

    /**
     * Sets the value of the superzahl property.
     * 
     */
    public void setSuperzahl(int value) {
        this.superzahl = value;
    }

    /**
     * Gets the value of the spiel77 property.
     * 
     */
    public int getSpiel77() {
        return spiel77;
    }

    /**
     * Sets the value of the spiel77 property.
     * 
     */
    public void setSpiel77(int value) {
        this.spiel77 = value;
    }

    /**
     * Gets the value of the super6 property.
     * 
     */
    public int getSuper6() {
        return super6;
    }

    /**
     * Sets the value of the super6 property.
     * 
     */
    public void setSuper6(int value) {
        this.super6 = value;
    }

    /**
     * Gets the value of the anzahlTippsProSchein property.
     * 
     */
    public int getAnzahlTippsProSchein() {
        return anzahlTippsProSchein;
    }

    /**
     * Sets the value of the anzahlTippsProSchein property.
     * 
     */
    public void setAnzahlTippsProSchein(int value) {
        this.anzahlTippsProSchein = value;
    }

}
