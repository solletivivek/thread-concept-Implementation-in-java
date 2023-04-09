package com.aoop.threading.producerconsumer.semaphore;

import java.util.concurrent.Semaphore;

public class Q {

	int n;
	private Semaphore semaphoreProducer = new Semaphore(1);
	private Semaphore semaphoreConsumer = new Semaphore(0);
	
	public void put(int n){
		// Before producerer can produce an item
		//it must acquire a permit from semaphoreProducer
		try {
			semaphoreProducer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.n = n;
		System.out.println("Put :"+n);
		
		// After producerer produces an item
		//it releases semaphoreConsumer to notify consumer
		semaphoreConsumer.release();
		
	}

	public void get(){
		// Before consumer can consume an item
		//it must acquire a permit from semaphoreConsumer
		try {
			semaphoreConsumer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got :"+n);
		
		// After consumer consumes an item
		//it releases semaphoreProducer to notify producer
		
		semaphoreProducer.release();
		
		
	}

}
