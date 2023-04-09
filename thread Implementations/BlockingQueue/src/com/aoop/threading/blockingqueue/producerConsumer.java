package com.aoop.threading.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class producerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5) ;
		
		new Producer(bq);
		
		new Consumer(bq);
	}

}
