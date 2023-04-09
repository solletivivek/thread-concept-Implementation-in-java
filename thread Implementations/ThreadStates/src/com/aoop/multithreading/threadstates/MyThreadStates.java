package com.aoop.multithreading.threadstates;

class MyRunnable implements Runnable{
	public void run() {
		
		try {
			Thread.sleep(200);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class MyThreadStates {
	
	public static Thread t;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyRunnable obj = new MyRunnable();
		 
		t = new Thread(obj);
		System.out.println(t.getState());//New
		t.start();
		System.out.println(t.getState());//Runnable
		t.sleep(100);
		System.out.println(t.getState()); //Timed-Waiting
		
		 t.join(); 
		 System.out.println(t.getState()); //Terminated
	}
}
