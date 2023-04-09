package com.aoop.threading.producerconsumer.semaphore;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q = new Q();
		
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		p.t.start();
		c.t.start();
		
		System.out.println("Press control-c to stop");
		

	}

}
