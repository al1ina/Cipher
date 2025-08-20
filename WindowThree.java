package windowbuilder.java;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.util.*;

public class WindowThree extends JFrame { //One-time pad cipher

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMsg;
	private JTextField textEncryptedMsg;
	private JTextField textKey;
	private JLabel lblGeneratedKey;
	private JLabel lblEncryptedMsg;
	private JLabel lblDecryptedMsg;
	private JTextArea areaEncypted;
	private JTextArea areaKey;
	private JTextArea areaDecrypted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowThree frame = new WindowThree();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowThree() {
		setTitle("One-time Pad Cipher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEncyption = new JLabel("Encyption");
		lblEncyption.setBounds(69, 11, 89, 14);
		contentPane.add(lblEncyption);
		
		JLabel lblDecryption = new JLabel("Decryption");
		lblDecryption.setBounds(277, 11, 66, 14);
		contentPane.add(lblDecryption);
		
		//Prompts user to input
		JLabel lblNewLabel_1 = new JLabel("Enter text to be encypted:");
		lblNewLabel_1.setBounds(27, 36, 177, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter text to be decrypted:");
		lblNewLabel_2.setBounds(242, 36, 184, 14);
		contentPane.add(lblNewLabel_2);
		
		textMsg = new JTextField();
		textMsg.setBounds(27, 57, 153, 20);
		contentPane.add(textMsg);
		textMsg.setColumns(10);
		
		textEncryptedMsg = new JTextField();
		textEncryptedMsg.setColumns(10);
		textEncryptedMsg.setBounds(242, 57, 153, 20);
		contentPane.add(textEncryptedMsg);
		
		JLabel lblSecretKey1 = new JLabel("Secret key:");
		lblSecretKey1.setBounds(27, 187, 109, 14);
		contentPane.add(lblSecretKey1);
		
		JLabel lblSecretKey2 = new JLabel("Enter the secret key: ");
		lblSecretKey2.setBounds(242, 88, 131, 14);
		contentPane.add(lblSecretKey2);
		
		JButton btnDecrpyt = new JButton("Decrypt");
		btnDecrpyt.addMouseListener(new MouseAdapter() { //listener that runs when mouse clicks on button
		      public void mouseClicked(MouseEvent e) {
		    	  Decrypt();
		      }
		    });
		btnDecrpyt.setBounds(242, 147, 153, 23);
		contentPane.add(btnDecrpyt);
		
		JLabel lblOutput1 = new JLabel("Encypted Message:");
		lblOutput1.setBounds(27, 122, 131, 14);
		contentPane.add(lblOutput1);
		
		JLabel lblOutput2 = new JLabel("Decrypted Message:");
		lblOutput2.setBounds(242, 187, 131, 14);
		contentPane.add(lblOutput2);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addMouseListener(new MouseAdapter() { //listener that runs when mouse clicks on button
		      public void mouseClicked(MouseEvent e) {
		    	  Encrypt();
		      }
		    });
		btnEncrypt.setBounds(27, 88, 153, 23);
		contentPane.add(btnEncrypt);
		
		// Text field for entering the secret key
		textKey = new JTextField();
		textKey.setBounds(242, 113, 153, 20);
		contentPane.add(textKey);
		textKey.setColumns(10);
		
		// Text area for displaying the encrypted message
		areaEncypted = new JTextArea(); 
		areaEncypted.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(areaEncypted);
	    scrollPane.setBounds(27, 147, 150, 40); 
	    contentPane.add(scrollPane);
	    
	    // Text area for displaying the generated key
	    areaKey = new JTextArea(); 
	    areaKey.setEditable(false);
	    JScrollPane scrollPane1 = new JScrollPane(areaKey);
	    scrollPane1.setBounds(27, 208, 150, 40); 
	    contentPane.add(scrollPane1);
	    
	    // Text area for displaying the decrypted message
	    areaDecrypted = new JTextArea(); 
	    areaDecrypted.setEditable(false);
	    JScrollPane scrollPane2 = new JScrollPane(areaDecrypted);
	    scrollPane2.setBounds(242, 208, 150, 40); 
	    contentPane.add(scrollPane2);
	}
	 // Method to encrypt the entered message
	public void Encrypt() {
		char[] chars = ((String) textMsg.getText()).toCharArray();
		String stringKey = "";
		String output = ""; //Will be the output
		int count = 0; //Uses a counter to count if it is the last character of the array in order to not have a comma at the end
		for (char c : chars) {
			if (count == chars.length-1) { //if it is the last character of the array
				Integer rand = (int)(Math.random() * 99); // Generates a number between 0 and 99
				stringKey += String.valueOf(rand); // Append the random number to the key
				if (Character.isLowerCase(c)) {
	                if (c + rand > 122) {
						int overflow = (c + rand - 97) % 26; // Calculate the overflow within the alphabet range
					    c = (char) (97 + overflow);
					}
					else {
						c += rand;
					}
	                
	            } else if (Character.isUpperCase(c)) {
	            	if (c + rand > 90) {
						int overflow = (c + rand - 65) % 26; // Calculate the overflow within the alphabet range
						c = (char) (65 + overflow);
					}
					else {
						c += rand;
					}
	            } 
				output += String.valueOf(c);
			}
			else {
			Integer rand = (int)(Math.random() * 99); //Generate random number between 0 and 99
			stringKey += String.valueOf(rand) + ","; // Append the random number to the key with a comma
			if (Character.isLowerCase(c)) {
				 if (c + rand > 122) {
						int overflow = (c + rand - 97) % 26; // Calculate the overflow within the alphabet range
					    c = (char) (97 + overflow);
					}
					else {
						c += rand;
					}
            } else if (Character.isUpperCase(c)) {
            	if (c + rand > 90) {
					int overflow = (c + rand - 65) % 26; // Calculate the overflow within the alphabet range
					c = (char) (65 + overflow);
				}
				else {
					c += rand;
				}
            }
			//No other else because nothing other than lowercase and uppercase alphabet values will be shifted
			output += String.valueOf(c);
			}
			count++;
		}
		areaEncypted.setText("" + output);
		areaKey.setText("" + stringKey);
		
	}
	
	public void Decrypt() {  // Method to decrypt the entered encrypted message
		char[] chars = ((String) textEncryptedMsg.getText()).toCharArray();
		String output = "";
		String stringKey = ((String) textKey.getText());
		String[] parts = stringKey.split(","); // Split the key on the commas
		for (int i = 0; i < parts.length; i++) { //For every element in parts
			int key = Integer.parseInt(parts[i % parts.length]); // Get the corresponding key value
            if (Character.isLowerCase(chars[i])) {
            	if (chars[i] - key < 97) { //check if the decryption has to go from "z" to "a"
					int overflow = (chars[i] - 97 - key) % 26;
					chars[i] = (char) (overflow >= 0 ? (overflow + 97) : (overflow + 123)); 
					// ? : checks if overflow is non negative, if overflow is non negative (overflow >= 0) it adds 97 to it, if it isnt, its negative it adds 123 to it
				}
				else {
					chars[i] -= key;
				}
            } else if (Character.isUpperCase(chars[i])) {
            	if (chars[i] - key < 65) { //check if the decryption has to go from "Z" to "A"
					int overflow = (chars[i] - 65 - key) % 26;
					chars[i] = (char) (overflow >= 0 ? (overflow + 65) : (overflow + 91));
				}
				else {
					chars[i] -= key;
				}
            }
			output += String.valueOf(chars[i]);

		}
		areaDecrypted.setText("" + output);
	}
}
