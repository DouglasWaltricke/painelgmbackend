/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author goga
 */
@ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(config.CrossOriginFilter.class);
        resources.add(org.jboss.resteasy.plugins.providers.jaxb.CollectionProvider.class);
        resources.add(org.jboss.resteasy.plugins.providers.jaxb.JAXBElementProvider.class);
        resources.add(org.jboss.resteasy.plugins.providers.jaxb.JAXBXmlRootElementProvider.class);
        resources.add(org.jboss.resteasy.plugins.providers.jaxb.JAXBXmlSeeAlsoProvider.class);
        resources.add(org.jboss.resteasy.plugins.providers.jaxb.JAXBXmlTypeProvider.class);
        resources.add(org.jboss.resteasy.plugins.providers.jaxb.MapProvider.class);
        resources.add(org.jboss.resteasy.plugins.providers.jaxb.XmlJAXBContextFinder.class);
        resources.add(org.jboss.resteasy.plugins.stats.RegistryStatsResource.class);
        resources.add(painelgm.rest.DivulgacaoRestService.class);
        resources.add(painelgm.rest.EventoRestService.class);
        resources.add(painelgm.rest.ListaEventoRestService.class);
        resources.add(painelgm.rest.UsuarioRestService.class);
        resources.add(painelgm.util.Login.class);
        resources.add(painelgm.util.SecurityFilter.class);
    }
}
