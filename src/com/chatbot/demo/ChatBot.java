package com.chatbot.demo;

/*
 * Chatbot project 
 * created using java 17 and eclipse IDE
 * honorable mention to stackoverflow for some pieces of code
 */

// importing required the awt packages

import java.awt.Color; //color package
import java.awt.Desktop; //used for the action type
import java.awt.event.ActionEvent; //A semantic event which indicates that a component-defined action occurred.
import java.awt.event.ActionListener; //a listener event to record the actions taking place
import java.io.File; //file for the file based works
import java.io.IOException;
import java.net.URI; //for searching a given valid url
import java.net.URISyntaxException; //exception class for the uri
import java.time.LocalDateTime; //date and time based class 
import java.time.format.DateTimeFormatter;

/*
 * swing attributes are contained in the given jars to be used in this project 
 */
import javax.swing.JButton; //the functioning "send" button
import javax.swing.JFrame; //the frame of the chatbot
import javax.swing.JLabel; //for creating the label of the bot with it's name
import javax.swing.JTextArea; //for the text area
import javax.swing.JTextField;

import com.chatbot.config.JFrameChatBotConfiguration;

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

					/*
					 * a simple if else ladder for the replies future scope: 1.creating a self
					 * evaluating AI 2.can do anything
					 */

					/*
					 * some basic questions are here
					 */
					/**
					 * 
					 */
					if (text.contains("hi")) {
						replyMeth("Hi there");// calling the replymeth(...) method for the answers
					} else if (text.contains("how are you")) {
						replyMeth("I'm Good :).Thankyou for asking");
					} else if (text.contains("what is your name")) {
						replyMeth("I'm Mya");
					} else if (text.contains("who created you")) {
						replyMeth("I was created by a group of students from CSE 1C");
					} else if (text.contains("tell me a joke")) {
						replyMeth("why did google go the dentist?" + "\n" + "to get its bluetooth checked");
					} else if (text.contains("what can you do?") | text.contains("help")) {
						replyMeth("\nRight now I can do These but I\'m still evolving:\n"
								+ "1.opening google chrome\n2.opening notepad\n3.printing the date and time\n4.opening youtube using its url\n5.deleting a given file\n6.turning off the pc\n7.restarting the pc\n8.opening a game ");
					}

					/*
					 * advanced features of Mya are listed below 1.opening google chrome 2.opening
					 * notepad 3.printing the date and time 4.opening youtube using it's url
					 * 5.deleting a given file 6.turning off the pc 7.restarting the pc 8.opening a
					 * game
					 */

					else if (text.contains("open google chrome")) {
						replyMeth("opening google chrome");
						File file = new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"); // storing
																											// the
																											// target
																											// application.exe
																											// in a file
																											// object
						try {
							Desktop.getDesktop().open(file);
							/*
							 * This class provides methods corresponding to these operations. The methods
							 * look for the associated application registered on the current platform, and
							 * launch it to handle a URI or file. If there is no associated application or
							 * the associated application fails to be launched, an exception is thrown.
							 */
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else if (text.contains("open notepad")) {
						replyMeth("opening notepad ");
						Runtime runtime = Runtime.getRuntime(); // creating an object for the runtime class
						try {
							runtime.exec("notepad");// accessing the runtime class for launching notepad
						} catch (IOException e2) {
							System.out.println(e2);
						}
					} else if (text.contains("what is the date and time now")) {
						/*
						 * using the simple date time class for printing the date and time
						 */
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						LocalDateTime now = LocalDateTime.now(); // creating an object for the LocalDateTime class
						replyMeth(dtf.format(now));
					} else if (text.contains("open youtube")) {
						/*
						 * A URI is a uniform resource identifier while a URL is a uniform resource
						 * locator. Hence every URL is a URI, abstractly speaking, but not every URI is
						 * a URL. This is because there is another sub category of URIs, uniform
						 * resource names (URNs), which name resources but do not specify how to locate
						 * them.
						 */
						URI uri = null;
						try {
							uri = new URI("http://www.youtube.com"); // the target uniform resource identifier
						} catch (URISyntaxException e3) {
							e3.printStackTrace();
						}
						try {
							java.awt.Desktop.getDesktop().browse(uri); // using the desktop class to open the given url
																		// in the default browser
						} catch (IOException e4) {
							e4.printStackTrace();
						}
						replyMeth("Youtube opened in browser");
					} else if (text.contains("delete abc.txt")) {
						File file = new File("C:\\Users\\Soumyajit\\Desktop\\abc.txt"); // location of the given file
						if (file.delete()) // using the delete method to delete the file
						{
							replyMeth("File deleted successfully");
						} else {
							replyMeth("Failed to delete the file");
						}
					} else if (text.contains("shutdown my laptop")) {
						Runtime runtime = Runtime.getRuntime();

						/*
						 * getRuntime() : Terminates the currently running Java virtual machine by
						 * initiating its shutdown sequence. This method never returns normally. The
						 * argument serves as a status code; by convention, a nonzero status code
						 * indicates abnormal termination.
						 */

						try {
							replyMeth("Shutting down the PC after 5 seconds.");
							runtime.exec("shutdown -s -t 5");// shutdown sequence
						} catch (IOException e5) {
							System.out.println("Exception: " + e5);
						}
					} else if (text.contains("restart my laptop")) {
						Runtime runtime = Runtime.getRuntime();
						try {
							runtime.exec("shutdown -r -t 5");// restart sequence
							System.out.println("Restarting the Computer after 5 seconds.");
						} catch (IOException e6) {
							System.out.println("Exception: " + e6);
						}
					}
					/*
					 * the target application.exe file path has been added to a mew file object that
					 * searches for the file and opens it
					 */
					else if (text.contains("open minecraft")) {
						replyMeth("opening minecraft java edition");
						File file = new File("C:\\Users\\Soumyajit\\AppData\\Roaming\\.minecraft\\TLauncher.exe");
						try {
							/*
							 * This class provides methods corresponding to these operations. The methods
							 * look for the associated application registered on the current platform, and
							 * launch it to handle a URI or file. If there is no associated application or
							 * the associated application fails to be launched, an exception is thrown.
							 */
							Desktop.getDesktop().open(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else if (text.contains("search for abc.txt")) {
						File directory = new File("C:\\Users\\Soumyajit\\Desktop"); // predefined directory
						String[] flist = directory.list();

						/*
						 * Returns an array of strings naming the files and directories in the directory
						 * denoted by this abstract pathname. The strings are ensured to represent
						 * normalized paths.
						 */

						int flag = 0; // flag variable
						if (flist == null) {
							replyMeth("Empty directory.");
						} else {
							for (int i = 0; i < flist.length; i++) {
								String filename = flist[i];
								if (filename.equalsIgnoreCase("abc.txt")) // checking if the searched file is identical
																			// to an existing file
								{
									replyMeth(filename + " found at" + "\n" + " C:\\Users\\Soumyajit\\Desktop");
									flag = 1;
								}
							}
						}

						if (flag == 0) {
							replyMeth("File Not Found");
						}
					} else if (text.contains("bye")) // final answer to the last question
					{
						replyMeth("STAY HOME STAY SAFE ");
					} else // the default answer for the unknown questions
						replyMeth("I Can't Understand");
				}
			}
		});
	}

	/*
	 * the replymeth method for the replies of Mya
	 */

	public void replyMeth(String reply) {
		area.setForeground(Color.green);
		area.append("Mya-->" + reply + "\n"); // this appends and prints the answers in the text area
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