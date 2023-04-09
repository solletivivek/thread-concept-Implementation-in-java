package com.oop.threading.synch;

class TicketBooking{
	boolean booked = false;
	public void ticketBooking(String name) {
		if(booked == false) {
			System.out.println(name + " selected the seat");
			System.out.println(name + "completed the payment");
			System.out.println(name +"downloaded the ticket");
			booked = true;
		}else {
			System.out.println("Already Booked");
		}
		
	}
}
class NewThread extends Thread{
	
	String name;
	TicketBooking tkt;
	public NewThread(TicketBooking tkt,String name) {
		this.tkt = tkt;
		this.name = name;
	}
	public void run() {
		synchronized (tkt) {
			tkt.ticketBooking(name);
		}
		
	}
}

public class Synchr {

	public static void main(String[] args) {
		TicketBooking seat = new TicketBooking();
		
		NewThread t1 = new NewThread(seat,"Sivaji");
		NewThread t2 = new NewThread(seat,"Jhansi");
		
		t1.start();
		t2.start();
		
		System.out.println("Main Thread");
	}

}
