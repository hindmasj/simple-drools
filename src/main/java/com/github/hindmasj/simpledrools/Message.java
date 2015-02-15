package com.github.hindmasj.simpledrools;

public class Message {
	public static final int UNHANDLED=0;
	public static final int HANDLED=1;
	
	String message;
	int status;
	
	public Message(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
