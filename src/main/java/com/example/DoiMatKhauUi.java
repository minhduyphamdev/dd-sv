package com.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DoiMatKhauUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoiMatKhauUi frame = new DoiMatKhauUi();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	 public  String encryptThisString(String input)
	    {
	        try {
	            // getInstance() method is called with algorithm SHA-512
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	  
	            // digest() method is called
	            // to calculate message digest of the input string
	            // returned as array of byte
	            byte[] messageDigest = md.digest(input.getBytes());
	  
	            // Convert byte array into signum representation
	            BigInteger no = new BigInteger(1, messageDigest);
	  
	            // Convert message digest into hex value
	            String hashtext = no.toString(16);
	  
	            // Add preceding 0s to make it 32 bit
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	  
	            // return the HashText
	            return hashtext;
	        }
	  
	        // For specifying wrong message digest algorithms
	        catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }
	public DoiMatKhauUi(final Controller controller, final NguoiDung nd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u1ED5i m\u1EADt kh\u1EA9u ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(156, 11, 116, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp m\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_1.setBounds(10, 74, 121, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNewLabel_2.setBounds(10, 123, 121, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(141, 74, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 120, 185, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("L\u01B0u Thay \u0110\u1ED5i");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passWord=textField.getText();
				String rePassWord=textField_1.getText();
				if(passWord!="")
				{
					if(passWord.equals(rePassWord))
					{
						String newPass=encryptThisString(passWord);
						nd.setPassword(newPass);
						
						NguoiDung.doiMatKhau(nd);
					}
					else {
						controller.showNotEqual();
					}
				}
				controller.closeDoiMatKhauUi();
			}
		});
		btnNewButton.setBounds(156, 198, 116, 23);
		contentPane.add(btnNewButton);
	}
}
