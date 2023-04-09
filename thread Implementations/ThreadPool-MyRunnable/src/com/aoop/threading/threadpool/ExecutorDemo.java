package com.aoop.threading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;

	public PrintJob(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name + " Job started by Thread : "+ Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name +" Job completed by Thread : "+ Thread.currentThread().getName());
	}
	
}
public class ExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintJob[] jobs = {new PrintJob("Atal"),new PrintJob("Raman"),new PrintJob("shastri"),
						   new PrintJob("Prasad"), new PrintJob("Kohli"), new PrintJob("Nelson")};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(PrintJob job : jobs)
			service.submit(job);
		service.shutdown();

	}

}
//In this example 3 threads are responsible to execute 6 Jobs, 
//so that a single thread can be reused for multiple jobs.