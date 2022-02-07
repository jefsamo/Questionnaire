package com.shopeyin5;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Questionnaire question = new Questionnaire();
		Thread thread = new Thread(question);
				
		thread.start();

	}

}
