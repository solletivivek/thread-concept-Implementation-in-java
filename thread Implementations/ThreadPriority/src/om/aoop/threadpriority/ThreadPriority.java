package om.aoop.threadpriority;

class MyThread implements Runnable{
	
	@Override
	public void run() {
		
		//System.out.println("Priority of Child Thread is : " + Thread.currentThread().getPriority());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Child Thread");
	}
	
}
public class ThreadPriority {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getPriority());
		//System.out.println("Main Thread Name is:"+Thread.currentThread().getName());
		MyThread r = new MyThread();
		Thread t = new Thread(r);
		//t.setPriority(Thread.MIN_PRIORITY);
		//System.out.println("Default Thread Name is:"+t.getName());
		t.start();
		System.out.println(t);
		t.join();
		System.out.println("Main Thread");
		
	}

}
