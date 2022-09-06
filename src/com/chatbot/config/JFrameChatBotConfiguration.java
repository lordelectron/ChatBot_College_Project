package com.chatbot.config;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JFrameChatBotConfiguration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setFrameForChatBot(JTextArea area, JTextField field, JButton button, JLabel label) {
		JFrame frame = new JFrame(); // creating the frame of the bot window
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // exit on close runs a System.exit(0) when pressed on the red
														// cross button thus terminating the code
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setSize(400, 400); // this is the size of the bot window
		frame.getContentPane().setBackground(Color.orange); // setting the background color
		frame.setTitle("Mya"); // name label of the bot
		frame.add(area); // creating the text area
		frame.add(field); // adding the field
		area.setSize(350, 320);
		area.setLocation(1, 1);
		area.setBackground(Color.BLACK); // background colour
		field.setSize(300, 20); // field size
		field.setLocation(1, 320); // field location
		frame.add(button); // creating the button
		label.setText("SEND"); // the name of the button
		button.add(label); // adding the lable
		button.setSize(400, 20);
		button.setLocation(300, 320);
		area.setForeground(Color.yellow);
	}

}
