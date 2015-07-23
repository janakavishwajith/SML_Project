
package mcs.code.sml.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.1-hudson-749-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SMLService", targetNamespace = "http://service.sml.code.mcs")
@XmlSeeAlso({
    mcs.code.sml.entity.ObjectFactory.class,
    mcs.code.sml.service.ObjectFactory.class,
    mcs.code.sml.utils.ObjectFactory.class
})
public interface SMLService {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDoctorsList", targetNamespace = "http://service.sml.code.mcs", className = "mcs.code.sml.service.GetDoctorsList")
    @ResponseWrapper(localName = "getDoctorsListResponse", targetNamespace = "http://service.sml.code.mcs", className = "mcs.code.sml.service.GetDoctorsListResponse")
    public List<String> getDoctorsList();

}
