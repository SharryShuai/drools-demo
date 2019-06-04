package com.activenetwork.sharry.snail;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SnailClimbingTree {

    private String name;
    private Phase phase;
    private int day;
    private int climbedDistance;
    private int treeHeight;
    private boolean debugging;

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        execute(kc);
    }

    public static void execute(KieContainer kc){
        KieSession ksession = kc.newKieSession("point-rulesKS");
        SnailClimbingTree snail = new SnailClimbingTree("Snail", Phase.DAY, 0, 0, 15, true);
        ksession.insert(snail);
        ksession.fireAllRules();
        ksession.dispose();
        System.out.println(snail.getName() + " will clmib to the top of the tree after " + snail.getDay() + " days.");
    }
}
