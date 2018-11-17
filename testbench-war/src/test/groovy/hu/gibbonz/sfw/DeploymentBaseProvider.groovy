package hu.gibbonz.sfw

import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.jboss.shrinkwrap.resolver.api.maven.Maven

class DeploymentBaseProvider {
    // FIXME: not released, this way it's known during IT
    private static def pom = Maven.configureResolver().loadPomFromFile('../bom/pom.xml')

    static def DEYPLOYMENT_BASE = ShrinkWrap.create(WebArchive.class)
            .addAsLibraries(pom.resolve('org.codehaus.groovy:groovy-all:pom:?').withTransitivity().asFile())
            .addAsLibraries(pom.resolve('com.h2database:h2:').withTransitivity().asFile())
            .addAsResource('META-INF/persistence.xml')
            .addAsWebInfResource('web.xml')
}
