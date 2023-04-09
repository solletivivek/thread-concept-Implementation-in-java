package com.aoop.threadpool.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Object>{
	
	int number;
	public MyCallable(int number) {
		this.number = number;
	}
	@Override
	public Object call() throws Exception {
		int sum =0;
		for (int i = 0; i <= number; i++) {
			sum = sum+i;
		}
		return sum;
	}
}
	
public class MyThreadDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		MyCallable[] j = {new MyCallable(10),
							new MyCallable(20),
							new MyCallable(30),
							new MyCallable(40),
							new MyCallable(5),
							new MyCallable(4)};
		ExecutorService s = Executors.newFixedThreadPool(3);
		for(MyCallable a : j) {
			Future<?> f = s.submit(a);
			System.out.println(f.get());
			
		}
		s.shutdown();

	}

}
