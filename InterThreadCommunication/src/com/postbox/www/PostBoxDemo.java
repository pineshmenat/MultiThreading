package com.postbox.www;

public class PostBoxDemo {
	
	public static void main(String[] args) {
		PostBox pb = new PostBox();
		
		ConsumerPerson cp = new ConsumerPerson(pb);
		
		ProducerPostman pp = new ProducerPostman(pb);
		
		cp.start();
		pp.start();
	}
}
