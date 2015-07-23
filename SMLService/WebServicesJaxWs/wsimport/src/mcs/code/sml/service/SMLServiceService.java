
package mcs.code.sml.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.1-hudson-749-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "SMLServiceService", targetNamespace = "http://service.sml.code.mcs", wsdlLocation = "file:/E:/SML/SMLService/WebServicesJaxWs/wsdl/SMLServiceService.wsdl")
public class SMLServiceService
    extends Service
{

    private final static URL SMLSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(mcs.code.sml.service.SMLServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = mcs.code.sml.service.SMLServiceService.class.getResource(".");
            url = new URL(baseUrl, "file:/E:/SML/SMLService/WebServicesJaxWs/wsdl/SMLServiceService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/E:/SML/SMLService/WebServicesJaxWs/wsdl/SMLServiceService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SMLSERVICESERVICE_WSDL_LOCATION = url;
    }

    public SMLServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SMLServiceService() {
        super(SMLSERVICESERVICE_WSDL_LOCATION, new QName("http://service.sml.code.mcs", "SMLServiceService"));
    }

    /**
     * 
     * @return
     *     returns SMLService
     */
    @WebEndpoint(name = "SMLServicePort")
    public SMLService getSMLServicePort() {
        return super.getPort(new QName("http://service.sml.code.mcs", "SMLServicePort"), SMLService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SMLService
     */
    @WebEndpoint(name = "SMLServicePort")
    public SMLService getSMLServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.sml.code.mcs", "SMLServicePort"), SMLService.class, features);
    }

}
