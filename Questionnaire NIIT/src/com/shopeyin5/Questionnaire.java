package com.shopeyin5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Questionnaire implements Runnable {

	String[] questions = { "When was NIIT established?", "What year was Java created?",
			"How many classes are there at NIIT?" };

	String[][] options = { { "1960", "2000", "1997" }, { "1970", "1985", "1996" }, { "3", "5", "7", "6" } };

	char[] answers = { 'A', 'B', 'C' };
	char guess, answer;
	int index;
	int seconds = 10;
	boolean exit = false;

	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JTextArea textArea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel answerLabelC = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel secondsLeft = new JLabel();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!exit) {
			displayQuestion();
		}

	}

	public Questionnaire() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(null);
		frame.setResizable(false);

		textField.setBounds(0, 0, 650, 50);
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 30));
		textField.setBorder(BorderFactory.createBevelBorder(1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);
		textField.setText("Questionnaire");

		textArea.setBounds(0, 50, 650, 50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(25, 25, 25));
		textArea.setForeground(new Color(25, 255, 0));
		textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
		textArea.setBorder(BorderFactory.createBevelBorder(1));
		textArea.setEditable(false);

		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonA.setFocusable(false);
		buttonA.setText("A");

		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.setText("B");

		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.setText("C");

		answerLabelA.setBounds(125, 100, 500, 100);
		answerLabelA.setBackground(new Color(50, 50, 50));
		answerLabelA.setForeground(new Color(25, 255, 0));
		answerLabelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answerLabelB.setBounds(125, 200, 500, 100);
		answerLabelB.setBackground(new Color(50, 50, 50));
		answerLabelB.setForeground(new Color(25, 255, 0));
		answerLabelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answerLabelC.setBounds(125, 300, 500, 100);
		answerLabelC.setBackground(new Color(50, 50, 50));
		answerLabelC.setForeground(new Color(25, 255, 0));
		answerLabelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

		secondsLeft.setBounds(535, 510, 100, 100);
		secondsLeft.setBackground(new Color(25, 25, 25));
		secondsLeft.setForeground(new Color(255, 0, 0));
		secondsLeft.setFont(new Font("Ink Free", Font.BOLD, 60));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));

		timeLabel.setBounds(535, 475, 100, 25);
		timeLabel.setBackground(new Color(25, 25, 25));
		timeLabel.setForeground(new Color(255, 0, 0));
		timeLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setText("Timer >:D");

		frame.add(timeLabel);
		frame.add(secondsLeft);
		frame.add(answerLabelA);
		frame.add(answerLabelB);
		frame.add(answerLabelC);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(textArea);

		frame.add(textField);
		frame.setVisible(true);
		nextQuestion();
	}

	public void nextQuestion() {

		textField.setText("Question " + (index + 1));
		textArea.setText(questions[index]);
		answerLabelA.setText(options[index][0]);
		answerLabelB.setText(options[index][1]);
		answerLabelC.setText(options[index][2]);

	}

	public void displayQuestion() {

		for (int i = 10; i > 0; i--) {
			secondsLeft.setText(String.valueOf(i));

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		index++;

		if (index > questions.length - 1) {
			exit = true;
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

		nextQuestion();
//		
//		index++;
//		
//		if (index > questions.length-1) {
//			frame.setVisible(false); //you can't see me!
//			frame.dispose();
//		}
//		
//
//		nextQuestion();

	}

}
