package com.postbox.www;

public class ProducerPostman extends Thread{
	PostBox pb;
	
	ProducerPostman(PostBox pb) {
		this.pb = pb;
	}
	
	public void run() {
		try {
			pb.dropMail();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
