package com.aoop.threading.blockingqueue;


import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Integer> bq = null;
	Thread producer;
	
	public Producer(BlockingQueue<Integer> bq) {
		this.bq = bq;
		producer = new Thread(this,"Producer");
		producer.start();
	}


	@Override
	public void run() {
		int i=0;
		while(true) {
			System.out.println("Producer "+ i);
			try {
				Thread.sleep(1000);
				bq.put(i++);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
