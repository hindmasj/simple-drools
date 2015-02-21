package com.github.hindmasj.simpledrools;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class Runner {
	public static final String SESSION="SimpleKS";
	public static final String BASE="SimpleKB";
	public static final String CONSOLE="console";

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession(SESSION);
        
		if(args.length>0 && args[0].equals("0")){
			System.out.println("No Audit Trail");
		}else{
			ksession.addEventListener( new DebugAgendaEventListener() );
			ksession.addEventListener( new DebugRuleRuntimeEventListener() );
		}

        Runner runner=new Runner();
        Console console=new TextConsole(ksession);
		ksession.setGlobal(CONSOLE, console);

		runner.run(ksession);
        console.run();
		System.out.println("\nBye");
	}
	
	public void run(KieSession ksession){
        Message m=new Message("One",Message.UNHANDLED,Message.PASSIVE,0);
        ksession.insert(m);
        m=new Message("Two",Message.UNHANDLED,Message.PASSIVE,0);
        ksession.insert(m);
        m=new Message("Three",Message.UNHANDLED,Message.PASSIVE,0);
        ksession.insert(m);
        m=new Message("A",Message.UNHANDLED,Message.ACTIVE,3);
        ksession.insert(m);
        ksession.fireAllRules();
	}

}
