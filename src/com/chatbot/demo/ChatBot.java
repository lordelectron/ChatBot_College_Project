package com.chatbot.demo;

import java.awt.event.ActionEvent; //A semantic event which indicates that a component-defined action occurred.
import java.awt.event.ActionListener; //a listener event to record the actions taking place

/*
 * swing attributes are contained in the given jars to be used in this project 
 */
import javax.swing.JButton; //the functioning "send" button
import javax.swing.JFrame; //the frame of the chatbot
import javax.swing.JLabel; //for creating the label of the bot with it's name
import javax.swing.JTextArea; //for the text area
import javax.swing.JTextField;

import com.chatbot.config.JFrameChatBotConfiguration;
import com.chatbot.questions.ChatBotQuestionsAndAnswers;

/*
 * the class given below is the class used in this program
 * extends jframe to inherit it's attributes
 */
class Bot extends JFrame {
	private static final long serialVersionUID = 1L;
	/*
	 * creating the object for the textarea creating the object for the textfield
	 * creating the object for the button creating the object for the label
	 */
	public JTextArea area = new JTextArea(); // area is the textarea object
	public JTextField field = new JTextField(); // field is the text field object
	public JButton button = new JButton(); // button is the button object
	public JLabel label = new JLabel(); // label is the label object
	JFrameChatBotConfiguration chatBotConfiguration = new JFrameChatBotConfiguration();

	void Mya() // default constructor for creating the functioning bot
	{

		chatBotConfiguration.setFrameForChatBot(area, field, button, label);

		/*
		 * using action listener and its attributes for the functioning of the bot
		 */
		button.addActionListener(new ActionListener() // obect of the actionlistner
		{
			public void actionPerformed(ActionEvent event) // recording the events
			{

				if (event.getSource() == button) // connected to the send button
				{
					String text = field.getText().toLowerCase(); // contains the text of the user
					// text color
					area.append("You-->" + text + "\n"); // concatinating the string
					field.setText("");
					ChatBotQuestionsAndAnswers botQuestionsAndAnswers = new ChatBotQuestionsAndAnswers();
					botQuestionsAndAnswers.QuestionAnswers(text, area);
				}
			}
		});
	}

}

/*
 * this is the driver class this contains the main method for the bot is created
 * here by using the object of the class
 */

public class ChatBot {
	public static void main(String[] args) // main method
	{
		Bot ob = new Bot(); // creating the object of the bot
		ob.Mya();// creating Mya
	}
}