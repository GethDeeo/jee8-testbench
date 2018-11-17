package hu.gibbonz.sfw

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.Archive
import org.junit.Test
import org.junit.runner.RunWith

import javax.inject.Inject

@RunWith(Arquillian.class)
class WebIT {
    @Inject
    MySimpleEjb mySimpleEjb

    @Deployment
    static Archive<?> createDeployment() {
        def a = DeploymentBaseProvider.ear(
                DeploymentBaseProvider.EJB
                        .addClass(MySimpleEjb.class),
                DeploymentBaseProvider.WAR
                        .addClass(SfwApplication.class)
                        .addClass(SfwRest.class),
                WebIT.class
        )
        println(a.toString(true))
        a
    }

    @Test
    void test() {
        mySimpleEjb.simpleMethod()
    }
}
