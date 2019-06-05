package sharry;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeekTranslatorTestCase {

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
    public void translate() {
        List<WeekTranslator> list =  buildWeeks();
        for (WeekTranslator w : list) {
            this.ksession.insert(w);
        }
        this.ksession.fireAllRules();

        for (WeekTranslator w : list) {
            log.debug(w.toString());
        }
    }

    private List<WeekTranslator> buildWeeks() {
        List<WeekTranslator> list = new ArrayList<WeekTranslator>(7);
        for (int day = 1; day <= 7; day++) {
            list.add(new WeekTranslator(day));
        }
        return list;
    }

}
