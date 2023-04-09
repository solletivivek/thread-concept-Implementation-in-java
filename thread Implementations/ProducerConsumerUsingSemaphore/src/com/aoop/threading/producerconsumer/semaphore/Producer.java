package com.aoop.threading.producerconsumer.semaphore;

public class Producer implements Runnable{

	Q q;
	Thread t;
	public Producer(Q q) {
		this.q=q;
		t= new Thread(this,"Producer");
	}
	@Override
	public void run() {
		int i=0;
		while(true) {
			q.put(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
