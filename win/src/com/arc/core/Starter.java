package com.arc.core;

public class Starter {
	public static boolean isStart=false;
	public static void main(String[] args) {
	    String mode = args[0];
	    if ("start".equals(mode)){
	    	System.out.println("start");
	       start(args);
	    }
	    System.out.println("stop");
	}

	public static void start(String[] args) {
		isStart=true;
		while(isStart) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		System.out.println("after start loop");
	}

	public static void stop(String[] args) {
		isStart=false;
	}

}
