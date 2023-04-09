/*Although the put( ) and get( ) methods on Q are synchronized, nothing stops
the producer from overrunning the consumer, nor will anything stop the
consumer from consuming the same queue value twice. Thus, you get the
erroneous output.
The proper way to write this program in Java is to use wait( ) and notify( )
to signal in both directions.*/

package com.aoop.threading.interthreadcommunication;

public class QAsynchronous {
	int n;
	
	synchronized int get() {
		System.out.println("Got :"+n);
		return n;
	}
	
	synchronized void put(int n){

		this.n = n;
		System.out.println("Put :"+n);
	}
}
