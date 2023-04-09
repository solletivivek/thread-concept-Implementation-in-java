package com.aoop.thread.priority;


class NewThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("CHild Thread");
			
		}
	}
	
}
public class ThreadPriorityDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ThreadGroup tg = new ThreadGroup("tgw");
		
		NewThread r = new NewThread();
		Thread t1 = new Thread(tg,r);
		t1.start();
		
		Thread t2 = new Thread(tg,r);
		t2.start();
		
		Thread t3 = new Thread(r);
		t3.start();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
	}

}
