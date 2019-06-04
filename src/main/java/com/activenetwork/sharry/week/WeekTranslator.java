package com.activenetwork.sharry.week;

import java.util.ArrayList;
import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeekTranslator {

    private int day;
    private String enName;
    private String cnName;

    public WeekTranslator(int day) {
        this.day = day;
    }

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        execute(kc);
    }

    public static void execute(KieContainer kc){
        KieSession ksession = kc.newKieSession("point-rulesKS");
        List<WeekTranslator> list =  buildWeeks();
        for (WeekTranslator w : list) {
            ksession.insert(w);
        }
        ksession.fireAllRules();
        ksession.dispose();

        for (WeekTranslator w : list) {
            showResult(w);
        }
    }

    private static List<WeekTranslator> buildWeeks() {
        List<WeekTranslator> list = new ArrayList<WeekTranslator>(7);
        for (int day = 1; day <= 7; day++) {
            list.add(new WeekTranslator(day));
        }
        return list;
    }

    private static void showResult(WeekTranslator w) {
        String msg = String.format("Day number=%s, \t Chiese name=%s, \t English name=%s",
            w.getDay(), w.getCnName(), w.getEnName());
        System.out.println(msg);
    }

}
