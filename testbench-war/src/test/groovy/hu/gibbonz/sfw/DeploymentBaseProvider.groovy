package hu.gibbonz.sfw

import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive
import org.jboss.shrinkwrap.api.spec.JavaArchive
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.jboss.shrinkwrap.resolver.api.maven.Maven

class DeploymentBaseProvider {
    static def EJB = ShrinkWrap.create(JavaArchive.class, 'ejb.jar')
            .addAsManifestResource('persistence.xml')
    static def WAR = ShrinkWrap.create(WebArchive.class, 'web.war')
            .addAsWebInfResource('web.xml')

    static def ear(final JavaArchive ejb, final WebArchive web, final Class test) {
        return ShrinkWrap.create(EnterpriseArchive.class)
                .addAsLibraries(Maven.configureResolver().loadPomFromFile('../testbench-bom/pom.xml').resolve(
                        'org.codehaus.groovy:groovy-all:pom:?',
                        'com.h2database:h2:'
                ).withTransitivity().asFile())
                .addAsModule(ejb)
                .addAsModule(web.addClass(test))
    }
}
