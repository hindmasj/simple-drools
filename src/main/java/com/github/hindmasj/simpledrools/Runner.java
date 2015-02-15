package com.github.hindmasj.simpledrools;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class Runner {
	public static final String SESSION="SimpleKS";
	public static final String BASE="SimpleKB";

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession(SESSION);
        
        Runner runner=new Runner();
		runner.run(ksession);
	}
	
	public void run(KieSession ksession){
		ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        Message one=new Message("Hello World One",Message.UNHANDLED);
        
        ksession.insert(one);
        ksession.fireAllRules();
	}

}
