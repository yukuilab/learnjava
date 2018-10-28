package com.multiple.demo;

public class JionThread {

	public static void main(String[] args) {
		
		Thread previousThread = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			Thread curThread = new JoinThread(previousThread);
			curThread.start();
			previousThread = curThread;
			
		}
	}
	
	static class JoinThread extends Thread{
		
		private Thread thread;
		
		public JoinThread(Thread t){
			this.thread = t;
		}
		
		@Override
		public void run() {
			try {
				thread.join();
				System.err.println(thread.getName() + " terminated.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
