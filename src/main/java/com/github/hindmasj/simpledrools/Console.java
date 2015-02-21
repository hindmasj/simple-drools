package com.github.hindmasj.simpledrools;

public interface Console extends Runnable{
	public void printf(String format,String... args);
	public void run();
}
