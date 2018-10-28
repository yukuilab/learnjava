/**
 * 
 */
package com.multiple.demo;

/**
 * @author Administrator
 *
 */
public class InterruptDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final Thread sleepThread = new Thread(){
			@Override
			public void run(){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				super.run();
			}
		};
		
		Thread busyThread = new Thread(){
			@Override
			public void run() {
				super.run();
				while(true);
			}
		};
		
		sleepThread.start();
		busyThread.start();
		
		sleepThread.interrupt();
		busyThread.interrupt();
		
		while(sleepThread.isInterrupted());
		System.out.println("sleepThread is Interrupted: " + sleepThread.isInterrupted());
		System.out.println("busyThread is Interrupted: " + busyThread.isInterrupted());
	}

}
