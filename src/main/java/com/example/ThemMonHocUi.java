package com.example;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;

public class ThemMonHocUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThemMonHocUi frame = new ThemMonHocUi();
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
	public void Clear()
	{
		try {
			Container con=getContentPane();
			  for (Component c : con.getComponents())
		        {
		            if (c instanceof JTextField)
		            {
		                JTextField j = (JTextField)c;
		                j.setText("");
		            }
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ThemMonHocUi(final Controller controller, final String IdGiaoVu) {
		DateFormat format = new SimpleDateFormat("HH:mm");
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IbINewLabel1 = new JLabel("Th\u00EAm m\u00F4n h\u1ECDc");
		IbINewLabel1.setForeground(Color.GREEN);
		IbINewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IbINewLabel1.setBounds(238, 8, 179, 28);
		contentPane.add(IbINewLabel1);
		
		JLabel LblNewLabel = new JLabel("M\u00E3 m\u00F4n h\u1ECDc");
		LblNewLabel.setBounds(20, 47, 76, 20);
		contentPane.add(LblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn m\u00F4n h\u1ECDc");
		lblNewLabel_1_1.setBounds(20, 78, 91, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ng\u00E0y B\u1EAFt \u0110\u1EA7u");
		lblNewLabel_1_2.setBounds(20, 117, 91, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ng\u00E0y K\u1EBFt Th\u00FAc");
		lblNewLabel_1_3.setBounds(20, 156, 91, 28);
		contentPane.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(121, 47, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 82, 133, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JFormattedTextField(format1);
		textField_2.setColumns(10);
		textField_2.setBounds(121, 121, 133, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JFormattedTextField(format1);
		textField_3.setColumns(10);
		textField_3.setBounds(121, 160, 133, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u");
		lblNewLabel_1_4.setBounds(278, 47, 94, 20);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Gi\u1EDD k\u1EBFt th\u00FAc");
		lblNewLabel_1_4_1.setBounds(278, 85, 94, 20);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("S\u1ED1 tu\u1EA7n");
		lblNewLabel_1_4_2.setBounds(278, 124, 76, 20);
		contentPane.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("L\u1EDBp h\u1ECDc");
		lblNewLabel_1_4_2_1.setBounds(278, 163, 76, 20);
		contentPane.add(lblNewLabel_1_4_2_1);
		
		textField_4 = new JFormattedTextField(format);
		textField_4.setColumns(10);
		textField_4.setBounds(382, 47, 138, 20);
		contentPane.add(textField_4);
		

		textField_5 = new JFormattedTextField(format);
		textField_5.setColumns(10);
		textField_5.setBounds(382, 82, 138, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText(Integer.toString(15));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(382, 121, 138, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(382, 160, 138, 20);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Th\u1EE9 trong tu\u1EA7n");
		lblNewLabel_1_3_1.setBounds(20, 201, 91, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("ThuHai");
		comboBox.addItem("ThuBa");
		comboBox.addItem("ThuTu");
		comboBox.addItem("ThuNam");
		comboBox.addItem("ThuSau");
		comboBox.addItem("ThuBay");
		comboBox.addItem("ChuNhat");
		comboBox.setBounds(124, 204, 352, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Th\u00EAm M\u00F4n H\u1ECDc");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isBlank()||textField_1.getText().isBlank()||textField_2.getText().isBlank()||textField_3.getText().isBlank()
				||textField_4.getText().isBlank()||textField_5.getText().isBlank()||textField_6.getText().isBlank()||
				textField_7.getText().isBlank())
				{
					controller.showBlankExist();
				}
				else 
				{
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					Date d1;
					Date d2;
					Date d3;
					Date d4;
				
					long second = 0;
						try {
							d1 = sdf.parse(textField_2.getText());
							d2 = sdf.parse(textField_3.getText());
						
							
							 second = d2.getTime()- d1.getTime();
						
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
				
					int days2=(int)(second/(1000*60*60*24));
					if(second>=0&& days2 >=105)
					{
						
						String MaMonHoc=textField.getText();
						String TenMonHoc= textField_1.getText();
						String NgayBatDau=textField_2.getText();
						String NgayKetThuc=textField_3.getText();
						String GioBatDau=textField_4.getText();
						String GioKetThuc=textField_5.getText();
						int Tuan=15;
						String phongHoc=textField_7.getText();
						String ThuTrongTuan=(String) comboBox.getSelectedItem();
						
						MonHoc monHoc = new MonHoc(MaMonHoc,TenMonHoc,NgayBatDau,NgayKetThuc,Tuan,GioBatDau,GioKetThuc,ThuTrongTuan,phongHoc);
						System.out.println("Mon hoc sau khi them"+monHoc.toString());
						MonHoc.LuuThongTinMonHoc(monHoc);
						String tenGiaoVu=GiaoVu.layTenGiaoVuTuId(IdGiaoVu);
						GiaoVu.themMonHocChoGiaoVu(IdGiaoVu, tenGiaoVu, MaMonHoc);
						
						Clear();
						controller.closeThemMonHoc();
					}
					else {
						controller.showNotEnoughTime();
					}
				}
					
			}
		});
		btnNewButton.setBounds(121, 255, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHyThm = new JButton("H\u1EE7y Th\u00EAm");
		btnHyThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear();
				controller.closeThemMonHoc();
			}
		});
		btnHyThm.setBounds(367, 255, 110, 23);
		contentPane.add(btnHyThm);
		
		JTextArea txtrGiBtu = new JTextArea();
		txtrGiBtu.setBackground(Color.GRAY);
		txtrGiBtu.setForeground(Color.WHITE);
		txtrGiBtu.setFont(new Font("Monospaced", Font.PLAIN, 10));
		txtrGiBtu.setText("Ch\u00FA \u00FD :\r\n-Gi\u1EDD b\u1EAFt \u0111\u1EA7u v\u00E0 gi\u1EDD k\u1EBFt th\u00FAc ph\u1EA3i \u1EDF d\u1EA1ng hh:mm( trong \u0111\u00F3 hh l\u00E0 gi\u1EDD, mm l\u00E0 ph\u00FAt)\r\n-Ng\u00E0y b\u1EAFt \u0111\u1EA7u v\u00E0 ng\u00E0y k\u1EBFt th\u00FAc ph\u1EA3i \u1EDF d\u1EA1ng yyyy-mm-dd( trong \u0111\u00F3 yyyy l\u00E0 n\u0103m, mm l\u00E0 \r\nth\u00E1ng v\u00E0 dd l\u00E0 ng\u00E0y )\r\n");
		txtrGiBtu.setBounds(20, 290, 508, 60);
		contentPane.add(txtrGiBtu);
	}
}
