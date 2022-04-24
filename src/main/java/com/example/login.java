package com.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import org.hibernate.query.results.ResultBuilderEntityValued;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	

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
	public login(final Controller controller) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(166, 27, 169, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel_1.setBounds(10, 93, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_2.setBounds(10, 124, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(109, 90, 300, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);

		textField_1.setBounds(109, 121, 300, 20);
		contentPane.add(textField_1);
		
		final JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=textField.getText();
				String passWord=textField_1.getText();
				String newPass="";
				// hash password 
				newPass=encryptThisString(passWord);
				//reset pass 
//				NguoiDung.UpdateNguoiDung(userName, newPass);
				
				System.out.println("us + pW"+userName+" "+passWord);
			
				NguoiDung result=NguoiDung.layThongTinNguoiDung(userName, newPass);
				if(result!=null)
				{
					System.out.println("Thong tin Nguoi Dung"+result.toString());
					String Id=result.getId();
					
					int IsTeacher=result.getIsTeacher();
					
					if(IsTeacher==1)
					{
					
						controller.changelogintogiaovu(Id,result);
//						frame.setVisible(false)
////						if(btnNewButton.getParent() instanceof JFrame) {
////						       System.out.println(btnNewButton.getParent().getParent());
////						       	
////						}
//						
					}
					else {
						if(userName.equals(passWord))
						{
							controller.openDoiMatKhauUi(result);
						}
						else {
							controller.changeLoginToQuanLyMonHocUi(result);
						}
					}
				}
				else {


						controller.showErrorLogin();
				}
			}
		});
		btnNewButton.setBounds(135, 168, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(283, 168, 89, 23);
		contentPane.add(btnCancel);
	}
}
