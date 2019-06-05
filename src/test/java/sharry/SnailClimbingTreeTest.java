package sharry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SnailClimbingTreeTest {

    private KieSession ksession;

    @Before
    public void setup() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        this.ksession = kc.newKieSession("point-rulesKS");
    }

    @After
    public void tearDown() {
        this.ksession.dispose();
    }

    @Test
    public void climb() {
        SnailClimbingTree snail = new SnailClimbingTree("Snail", Phase.DAY, 0, 0, 15, true);
        ksession.insert(snail);
        ksession.fireAllRules();
        String msg = String.format("%s will clmib to the top of the tree after %d days", snail.getName(), snail.getDay());
        log.debug(msg);
    }

}
