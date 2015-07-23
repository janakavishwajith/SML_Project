
package mcs.code.sml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import mcs.code.sml.utils.Savable;


/**
 * <p>Java class for EntDoctors complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntDoctors">
 *   &lt;complexContent>
 *     &lt;extension base="{http://utils.sml.code.mcs}Savable">
 *       &lt;sequence>
 *         &lt;element name="adress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="doctorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hospital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specializationId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntDoctors", propOrder = {
    "adress",
    "doctorId",
    "email",
    "hospital",
    "specializationId",
    "fName",
    "lName"
})
public class EntDoctors
    extends Savable
{

    protected String adress;
    protected int doctorId;
    protected String email;
    protected String hospital;
    protected int specializationId;
    protected String fName;
    protected String lName;

    /**
     * Gets the value of the adress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Sets the value of the adress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdress(String value) {
        this.adress = value;
    }

    /**
     * Gets the value of the doctorId property.
     * 
     */
    public int getDoctorId() {
        return doctorId;
    }

    /**
     * Sets the value of the doctorId property.
     * 
     */
    public void setDoctorId(int value) {
        this.doctorId = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the hospital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * Sets the value of the hospital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospital(String value) {
        this.hospital = value;
    }

    /**
     * Gets the value of the specializationId property.
     * 
     */
    public int getSpecializationId() {
        return specializationId;
    }

    /**
     * Sets the value of the specializationId property.
     * 
     */
    public void setSpecializationId(int value) {
        this.specializationId = value;
    }

    /**
     * Gets the value of the fName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFName() {
        return fName;
    }

    /**
     * Sets the value of the fName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFName(String value) {
        this.fName = value;
    }

    /**
     * Gets the value of the lName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLName() {
        return lName;
    }

    /**
     * Sets the value of the lName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLName(String value) {
        this.lName = value;
    }

}
