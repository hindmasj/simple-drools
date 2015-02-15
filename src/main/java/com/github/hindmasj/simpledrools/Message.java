package com.github.hindmasj.simpledrools;

public class Message {
	public static final int UNHANDLED=0;
	public static final int HANDLED=1;
	public static final int PASSIVE=0;
	public static final int ACTIVE=1;
	
	String message;
	int status;
	int type;
	int value;
	
	public Message(String message, int status, int type, int value) {
		super();
		this.message = message;
		this.status = status;
		this.type = type;
		this.value = value;
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
