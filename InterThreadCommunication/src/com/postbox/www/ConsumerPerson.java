package com.postbox.www;

public class ConsumerPerson extends Thread{
	PostBox pb;
	
	public ConsumerPerson(PostBox pb) {
		this.pb = pb;
	}

	public void run() {
		try {
			pb.receiveMail();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
