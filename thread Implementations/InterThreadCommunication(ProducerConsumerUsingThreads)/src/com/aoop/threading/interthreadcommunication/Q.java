/*Inside get( ), wait( ) is called. This causes its execution to suspend until
Producer notifies you that some data is ready. When this happens, execution
inside get( ) resumes. After the data has been obtained, get( ) calls notify( ).
This tells Producer that it is okay to put more data in the queue. Inside put( ),
wait( ) suspends execution until Consumer has removed the item from the
queue. When execution resumes, the next item of data is put in the queue, and
notify( ) is called. This tells Consumer that it should now remove it.*/

package com.aoop.threading.interthreadcommunication;

public class Q {

	int n;
	boolean valueset = false;
	
	synchronized int get() {
		while(!valueset) {
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("Got :"+n);
		valueset = false;
		notify();
		return n;
	}
	
	synchronized void put(int n){
		
		while(valueset) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.n = n;
		valueset = true;
		System.out.println("Put :"+n);
		notify();
	}
}
