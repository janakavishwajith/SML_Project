
package mcs.code.sml.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mcs.code.sml.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDoctorsListResponse_QNAME = new QName("http://service.sml.code.mcs", "getDoctorsListResponse");
    private final static QName _GetDoctorsList_QNAME = new QName("http://service.sml.code.mcs", "getDoctorsList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mcs.code.sml.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDoctorsList }
     * 
     */
    public GetDoctorsList createGetDoctorsList() {
        return new GetDoctorsList();
    }

    /**
     * Create an instance of {@link GetDoctorsListResponse }
     * 
     */
    public GetDoctorsListResponse createGetDoctorsListResponse() {
        return new GetDoctorsListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDoctorsListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sml.code.mcs", name = "getDoctorsListResponse")
    public JAXBElement<GetDoctorsListResponse> createGetDoctorsListResponse(GetDoctorsListResponse value) {
        return new JAXBElement<GetDoctorsListResponse>(_GetDoctorsListResponse_QNAME, GetDoctorsListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDoctorsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sml.code.mcs", name = "getDoctorsList")
    public JAXBElement<GetDoctorsList> createGetDoctorsList(GetDoctorsList value) {
        return new JAXBElement<GetDoctorsList>(_GetDoctorsList_QNAME, GetDoctorsList.class, null, value);
    }

}
