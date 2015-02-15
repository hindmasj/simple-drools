package com.github.hindmasj.simpledrools;

public class Message {
	public static final int UNHANDLED=0;
	public static final int HANDLED=1;
	
	String message;
	int status;
	int type;
	
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
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
