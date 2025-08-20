package windowbuilder.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class WindowTwo extends JFrame { //Caesar Cipher

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMessage;
	private JTextField textEncryptedMsg;
	private JTextField textKey;
	private JTextField textKey1;
	private JLabel lblNewEncypt; //encrypted message label
	private JLabel lblNewDecrypt;
	private JTextArea area;
	private JTextArea area1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowTwo frame = new WindowTwo();
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
	public WindowTwo() {
		setTitle("Caesar Cipher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 // Labels for Encryption and Decryption
		JLabel lblEncyption = new JLabel("Encyption");
		lblEncyption.setBounds(69, 11, 89, 14);
		contentPane.add(lblEncyption);
		
		JLabel lblDecryption = new JLabel("Decryption");
		lblDecryption.setBounds(286, 11, 66, 14);
		contentPane.add(lblDecryption);
		 // Labels and text fields for entering messages and keys
		JLabel lblNewLabel_1 = new JLabel("Enter text to be encypted:");
		lblNewLabel_1.setBounds(27, 36, 177, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter text to be decrypted:");
		lblNewLabel_2.setBounds(242, 36, 184, 14);
		contentPane.add(lblNewLabel_2);
		
		textMessage = new JTextField(); // Input for message to be encrypted
		textMessage.setBounds(27, 61, 160, 20);
		contentPane.add(textMessage);
		textMessage.setColumns(10);
		
		textEncryptedMsg = new JTextField(); // Input for encrypted message to be decrypted
		textEncryptedMsg.setColumns(10);
		textEncryptedMsg.setBounds(242, 61, 160, 20);
		contentPane.add(textEncryptedMsg);
		
		JLabel lblSecretKey1 = new JLabel("Enter the secret key: ");
		lblSecretKey1.setBounds(27, 85, 131, 14);
		contentPane.add(lblSecretKey1);
		
		textKey = new JTextField(); // Input for encryption key
		textKey.setBounds(27, 110, 160, 20);
		contentPane.add(textKey);
		textKey.setColumns(10);
		
		JLabel lblSecretKey2 = new JLabel("Enter the secret key: ");
		lblSecretKey2.setBounds(242, 92, 131, 14);
		contentPane.add(lblSecretKey2);
		
		textKey1 = new JTextField(); // Input for decryption key
		textKey1.setColumns(10);
		textKey1.setBounds(242, 110, 160, 20);
		contentPane.add(textKey1);
		
		//mouse click listener that runs when the encypt button is pressed
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addMouseListener(new MouseAdapter() { //listener that runs when mouse clicks on ok button
		      public void mouseClicked(MouseEvent e) {
		    	  EncryptCaesarCipher();
		      }
		    });
		btnEncrypt.setBounds(27, 141, 160, 23);
		contentPane.add(btnEncrypt);
		
		JButton btnDecrpyt = new JButton("Decrypt");
		btnDecrpyt.addMouseListener(new MouseAdapter() { //listener that runs when mouse clicks on ok button
		      public void mouseClicked(MouseEvent e) {
		    	  DecryptCaesarCipher();
		      }
		    });
		btnDecrpyt.setBounds(242, 141, 160, 23);
		contentPane.add(btnDecrpyt);
		
		 // Labels for displaying encrypted and decrypted messages, "outputs"
		JLabel lblOutput1 = new JLabel("Encrypted Message:");
		lblOutput1.setBounds(27, 175, 131, 14);
		contentPane.add(lblOutput1);
		
		JLabel lblOutput2 = new JLabel("Decrypted Message:");
		lblOutput2.setBounds(242, 175, 131, 14);
		contentPane.add(lblOutput2);
		
		// Text areas for displaying encrypted and decrypted messages
		area = new JTextArea();  //Encrypted message display
	    area.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(area);
	    scrollPane.setBounds(27, 198, 160, 50); 
	    contentPane.add(scrollPane);
	    
	    area1 = new JTextArea();  //Decrypted message display
	    area1.setEditable(false);
	    JScrollPane scrollPane1 = new JScrollPane(area1);
	    scrollPane1.setBounds(242, 198, 160, 50); 
	    contentPane.add(scrollPane1);
	}
	public void EncryptCaesarCipher() { //Method to encrypt the message using Caesar Cipher
		char[] chars = ((String) textMessage.getText()).toCharArray();
		Integer key = Integer.valueOf(textKey.getText());
		String text = "";
		for (char c : chars) { //For each character 'c' in chars array this:
			if (Character.isUpperCase(c)) {
				if (c + key > 90) { //Checks if c plus key goes over "Z"
					int overflow = (c + key - 65) % 26; // Calculate the overflow within the alphabet range
				    c = (char) (65 + overflow);
				}
				else {
					c += key;
				}
			}
			else if (Character.isLowerCase(c)) {
				if (c + key > 122) { //Checks if c plus key goes over "z"
					int overflow = (c + key - 97) % 26; // Calculate the overflow within the alphabet range
				    c = (char) (97 + overflow);	
				}
				else {
					c +=key;
				}
			}
			
	        text += String.valueOf(c);
	    }
		area.setText("" + text);
	}
	
	public void DecryptCaesarCipher() {
		char[] chars = ((String) textEncryptedMsg.getText()).toCharArray();
		Integer key = Integer.valueOf(textKey1.getText());
		String text = "";
		for (char c : chars) { //for each character "c" in chars array this:

			if (Character.isUpperCase(c)) {
				if (c - key < 65) {
					int overflow = (c - 65 - key) % 26;
					c = (char) (overflow >= 0 ? (overflow + 65) : (overflow + 91));
				}
				else {
					c -= key;
				}
			}
			else if (Character.isLowerCase(c)) {
				if (c - key < 97) { 

					int overflow = (c - 97 - key) % 26;
					c = (char) (overflow >= 0 ? (overflow + 97) : (overflow + 123));
					// Checks if overflow is negative or not
					// If overflow is non-negative, adds 97 to bring it back into the range (97-122).
					// If overflow is negative, add 123 to wrap around and bring it into the range.
				}
				else {
					c -= key;
				}
			}
			//No other else because nothing other than lowercase and uppercase alphabet values will be shifted
			text += String.valueOf(c);
		}
		area1.setText("" + text);
	}
}
