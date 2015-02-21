package com.github.hindmasj.simpledrools;

import org.kie.api.runtime.KieSession;

import java.util.Scanner;
import java.io.PrintStream;

public class TextConsole implements Console {
	public static final String PROMPT_DEFAULT="[a,p,q]> ";
	public static final String PROMPT_NAME="name > ";
	public static final String PROMPT_VALUE="value > ";

	private String prompt="";
	private int promptLength=0;
	private final KieSession session;
	private final PrintStream out;
	
	public TextConsole(KieSession session){
		this.session=session;
		this.out=System.out;
	}
	
	@Override
	public void printf(String format, String... args) {
		erasePrompt();
		out.printf(format, args);
		printPrompt();
	}
	
	private void erasePrompt(){
		for(int i=0;i<promptLength;i++)System.out.print('\b');
	}
	
	private void setPrompt(String prompt){
		this.prompt=prompt;
		promptLength=prompt.length();
	}
	
	private void printPrompt(){
		out.print(prompt);
	}
	
	@Override
	public void run(){
		Scanner in=new Scanner(System.in);
		boolean more=true;
		setPrompt(PROMPT_DEFAULT);
		printPrompt();
		while(more){
			String input=in.nextLine();
			if(input.equals("q"))break;
			
			if(input.equals("p")){
				capturePassive(in);
				continue;
			}
			
			if(input.equals("a")){
				captureActive(in);
				continue;
			}
			
			out.printf("Unknown option: %s\n Expected: a, p or q\n",input);
			printPrompt();
		}
		in.close();
	}
	
	private String getName(Scanner in){
		out.print(PROMPT_NAME);
		return in.nextLine();
	}
	
	private int getValue(Scanner in){
		int value=0;
		while(value <= 0){
			out.print(PROMPT_VALUE);
			if(in.hasNextLine() && in.hasNextInt()){
				value=in.nextInt();
				if(value<=0){
					out.println("Out of range");
				}
			}else{
				out.println("Invalid number");
			}
			in.nextLine();
		}
		return value;
	}
	
	private void captureActive(Scanner in){
		String name=getName(in);
		int value=getValue(in);
		
		session.insert(new Message(name,Message.UNHANDLED,Message.ACTIVE,value));
		session.fireAllRules();
	}
	
	private void capturePassive(Scanner in){
		String name=getName(in);
		
		session.insert(new Message(name,Message.UNHANDLED,Message.PASSIVE,0));
		session.fireAllRules();
	}
}