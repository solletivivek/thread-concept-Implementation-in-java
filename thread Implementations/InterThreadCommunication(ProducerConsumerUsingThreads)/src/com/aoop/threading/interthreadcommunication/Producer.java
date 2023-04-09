package com.aoop.threading.interthreadcommunication;

public class Producer implements Runnable {

	Q q;			//reference of Q
	Thread t;
	public Producer(Q q) {
		this.q = q;
		t = new Thread(this, "Producer");  		// to call run()
		
	}
	@Override
	public void run() {
		int i=0;
		while(true) {
			q.put(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
			
		}
	}
}
