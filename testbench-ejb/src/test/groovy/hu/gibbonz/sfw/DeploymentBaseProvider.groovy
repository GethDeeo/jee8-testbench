package hu.gibbonz.sfw

import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.jboss.shrinkwrap.resolver.api.maven.Maven

class DeploymentBaseProvider {
    static def WAR = ShrinkWrap.create(WebArchive.class)
            .addAsLibraries(Maven.configureResolver().loadPomFromFile('../testbench-bom/pom.xml').resolve(
                    'org.codehaus.groovy:groovy-all:pom:?',
                    'com.h2database:h2:'
            ).withTransitivity().asFile())
            .addAsWebInfResource('web.xml')
            .addAsManifestResource('persistence.xml')
}
