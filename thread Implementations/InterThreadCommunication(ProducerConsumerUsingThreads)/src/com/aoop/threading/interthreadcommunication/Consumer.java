package com.aoop.threading.interthreadcommunication;

public class Consumer implements Runnable{
	
	Q q;		// reference of Q
	Thread t;
	Consumer (Q q){
		this.q = q;
		t = new Thread(this, "Consumer");		//to call run()
	}
	@Override
	public void run() {
		while(true) {
			q.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
