package hu.gibbonz.sfw

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.Archive
import org.junit.Test
import org.junit.runner.RunWith

import javax.inject.Inject

@RunWith(Arquillian.class)
class JsonDemoIT {
    @Inject
    private MySimpleEjb mySimpleEjb
    @Deployment
    static Archive<?> createDeployment() {
        println(DeploymentBaseProvider.DEYPLOYMENT_BASE.toString(true))
        DeploymentBaseProvider.DEYPLOYMENT_BASE
                .addClass(MySimpleEntity.class)
                .addClass(MySimpleEjb.class)
    }

    @Test
    void test() {
        mySimpleEjb.simpleMethod()
    }

    @Test
    void test2() {
        mySimpleEjb.simpleMethod()
    }
}
