package com.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.CompoundBorder;

public class GiaoVuUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GiaoVuUi(final Controller controller,final String IdGiaoVu,final NguoiDung nd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Danh S\u00E1ch M\u00F4n H\u1ECDc");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.out.println("Id Giao Vu 1"+ IdGiaoVu);
				controller.openDanhSachMonHoc(IdGiaoVu);
					
					
			}
		});
		btnNewButton.setBounds(165, 52, 167, 40);
		contentPane.add(btnNewButton);
		
		JButton btnDanhSchHc = new JButton("Danh S\u00E1ch H\u1ECDc Sinh");
		btnDanhSchHc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openDanhSachSinhVien();
				
			}
		});
		btnDanhSchHc.setBounds(165, 118, 167, 40);
		contentPane.add(btnDanhSchHc);
		
		JButton btnDanhSchim = new JButton("Danh S\u00E1ch \u0110i\u1EC3m Danh");
		btnDanhSchim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openDanhSachDiemDanhUi();
			}
		});
		btnDanhSchim.setBounds(165, 189, 167, 40);
		contentPane.add(btnDanhSchim);
		
		JButton btnNewButton_1 = new JButton("\u0110\u0103ng Xu\u1EA5t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changegiaovutologin();
			}
		});
		btnNewButton_1.setBounds(365, 11, 112, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Xin Ch\u00E0o : ");
		lblNewLabel.setBounds(10, 15, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(99, 11, 211, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("\u0110\u1ED5i M\u1EADt Kh\u1EA9u");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeGiaoVuUiToDoiMatKhauUi(nd);
			}
		});
		btnNewButton_2.setBounds(365, 45, 112, 23);
		contentPane.add(btnNewButton_2);
		
		String nameGiaoVu=GiaoVu.layTenGiaoVuTuId(IdGiaoVu);
		if(nameGiaoVu!=null)
		{
			lblNewLabel_1.setText(nameGiaoVu);
		}
	}
}
