package com.aoop.threading.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	private BlockingQueue<Integer> bq;
	Thread consumer;
	
	public Consumer(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
		consumer = new Thread(this,"Consumer");
		consumer.start();
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println("Consumer "+bq.take());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
