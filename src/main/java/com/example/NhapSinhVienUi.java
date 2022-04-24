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
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class NhapSinhVienUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhapSinhVienUi frame = new NhapSinhVienUi();
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
	public NhapSinhVienUi(final Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp Id m\u00F4n h\u1ECDc");
		lblNewLabel.setBounds(10, 59, 121, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp Id sinh vi\u00EAn");
		lblNewLabel_1.setBounds(10, 100, 121, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(175, 56, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 97, 161, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u00EAm sinh vi\u00EAn v\u00E0o m\u00F4n h\u1ECDc");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(90, 11, 211, 34);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Th\u00EAm Sinh Vi\u00EAn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IdMonHoc=textField.getText();
				String IdSinhVien=textField_1.getText();
				String tenSinhVien=textField_2.getText();
				SinhVien sv1 = SinhVien.laySinhVienTuId(IdSinhVien,IdMonHoc);
				if(sv1==null)
				{
					SinhVien sv2= new SinhVien(IdSinhVien, IdMonHoc,tenSinhVien);
					SinhVien.themMotSinhVien(sv2);
				}
				controller.closeNhapSinhVienUi();
				
			}
		
		});
		btnNewButton.setBounds(60, 180, 142, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nh\u1EADp t\u00EAn sinh vi\u00EAn");
		lblNewLabel_1_1.setBounds(10, 141, 121, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(175, 138, 161, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("H\u1EE7y B\u1ECF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.closeNhapSinhVienUi();
			}
		});
		btnNewButton_1.setBounds(247, 180, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
