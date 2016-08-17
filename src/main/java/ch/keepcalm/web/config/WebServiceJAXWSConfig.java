package ch.keepcalm.web.config;

import ch.helsana.services.spezialfunktionen.tarif.v2.TarifPortType;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import java.io.IOException;


/**
 * Created by panter on 16/12/15.
 */
// tag::WebServiceJAXWSConfig[]
@Configuration
public class WebServiceJAXWSConfig {

    @Value("${soap.portname}")
    public String PORTNAME;

    @Value("${soap.servicename}")
    public String SERVICENAME;

    @Value("${soap.namespace}")
    public String NAMESPACEURI;

    @Value("${soap.wsdl}")
    public String WSDL;

    @Value("${soap.endpoint.service}")
    public String ENDPOINT_SERVICE;

    @Value("${soap.endpoint.url}")
    public String ENDPOINT_URL;


    @Bean(name = "tarifPortType", autowire = Autowire.BY_NAME)
    public JaxWsPortProxyFactoryBean tarifPortType() throws IOException {
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        Resource resource = context.getResource(WSDL);
        proxy.setWsdlDocumentResource(resource);
        proxy.setServiceInterface(TarifPortType.class);

        proxy.setServiceName(SERVICENAME);
        proxy.setPortName(PORTNAME);
        proxy.setNamespaceUri(NAMESPACEURI);
        proxy.setEndpointAddress(ENDPOINT_SERVICE);

        return proxy;
    }

}
// end::WebServiceJAXWSConfig[]
