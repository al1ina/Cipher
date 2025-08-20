package windowbuilder.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.*;
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private WindowTwo two; 
	private WindowThree three; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Prompts user to select a cipher
		JLabel lblSelectCipher = new JLabel("Select which cipher you would like to encode your message with:");
		lblSelectCipher.setBounds(10, 43, 416, 14);
		contentPane.add(lblSelectCipher);
		
		JButton btnCaesar = new JButton("Caesar Cipher");
		btnCaesar.addMouseListener(new MouseAdapter() { //listener that runs when mouse clicks on Withdraw button
		      public void mouseClicked(MouseEvent e) {
		        openNewWindow(2);
		      }
		    });
		btnCaesar.setBounds(48, 84, 130, 39);
		contentPane.add(btnCaesar);
		
		JButton btnOnetime = new JButton("One-time Pad");
		btnOnetime.addMouseListener(new MouseAdapter() { //listener that runs when mouse clicks on Withdraw button
		      public void mouseClicked(MouseEvent e) {
		        openNewWindow(3);
		      }
		    });
		btnOnetime.setBounds(227, 84, 144, 39);
		contentPane.add(btnOnetime);
		
		
	}
	//Method to open a new window based on the cipher selection
	public void openNewWindow(int x){
	    if (x == 2) {
	      two = new WindowTwo(); // Instantiate WindowTwo frame
	      two.setVisible(true); // Make WindowTwo visible
	    }
	    if (x == 3) {
	      three = new WindowThree(); // Instantiate WindowThree frame
	      three.setVisible(true); // Make WindowThree visible
	    }
	  }
	 
}
