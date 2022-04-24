package com.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DanhSachDiemDanhUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private String IdMonHocGB;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DanhSachDiemDanhUi frame = new DanhSachDiemDanhUi(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public int convertBooleanToInt(boolean a)
	{
		return a==true?1:0;
	}

	/**
	 * Create the frame.
	 */
	public boolean convertIntToBoolean(int a)
	{
		return a==1?true:false;
	}
	
	public DanhSachDiemDanhUi(final Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(800,800);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh s\u00E1ch \u0111i\u1EC3m danh");
		lblNewLabel.setBounds(208, 11, 144, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp m\u00E3 m\u00F4n h\u1ECDc");
		lblNewLabel_1.setBounds(10, 55, 104, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(135, 52, 255, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		final DefaultTableModel model1 = new DefaultTableModel(); 

        model1.addColumn("Idsinhvien ");
        model1.addColumn("Tuan 1");
        model1.addColumn("Tuan 2");
        model1.addColumn("Tuan 3");
        model1.addColumn("Tuan 4");
        model1.addColumn("Tuan 5");
        model1.addColumn("Tuan 6");
        model1.addColumn("Tuan 7");
        model1.addColumn("Tuan 8");
        model1.addColumn("Tuan 9");
        model1.addColumn("Tuan 10");
        model1.addColumn("Tuan 11");
        model1.addColumn("Tuan 12");
        model1.addColumn("Tuan 13");
        model1.addColumn("Tuan 14");
        model1.addColumn("Tuan 15");
		JButton btnNewButton = new JButton("T\u00ECm Ki\u1EBFm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IdMonHoc=textField.getText();
				List<DiemDanh> dd = new ArrayList<DiemDanh>();
				if(!IdMonHoc.equals(""))
				{
					IdMonHocGB=IdMonHoc;
					List<SinhVien> sv =SinhVien.laySinhVienCungMaMon(IdMonHoc);
					if(sv!=null)
					{
						
						for(final SinhVien sv1: sv)
						{
							DiemDanh dd1 = DiemDanh.layDanhSachDiemDanhMotSinhVien(sv1);
							if(dd1!=null)
							{
								dd.add(dd1);
							}
						}
					}
				}
				model1.setRowCount(0);
				for(DiemDanh dd2: dd)
				{
					  Object[] data = {dd2.getIdSinhVien(), convertIntToBoolean(dd2.getTuan1()),convertIntToBoolean(dd2.getTuan2()), 
							  convertIntToBoolean(dd2.getTuan3()),convertIntToBoolean(dd2.getTuan4()),convertIntToBoolean(dd2.getTuan5()),
							  convertIntToBoolean(dd2.getTuan6()),convertIntToBoolean(dd2.getTuan7()),convertIntToBoolean(dd2.getTuan8()),
							  convertIntToBoolean(dd2.getTuan9()),convertIntToBoolean(dd2.getTuan10()),convertIntToBoolean(dd2.getTuan11()),
							  convertIntToBoolean(dd2.getTuan12()),convertIntToBoolean(dd2.getTuan13()),convertIntToBoolean(dd2.getTuan14()),
							  convertIntToBoolean(dd2.getTuan15())};
				        
				      
					  model1.addRow(data);
				}
				
				
			}
		});
		btnNewButton.setBounds(411, 51, 89, 23);
		contentPane.add(btnNewButton);
		
		
      
		
		final JTable jTable = new JTable(model1){
			   private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            @Override
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return String.class;
	                    default:
	                        return Boolean.class;
		                }
		            }
			};
		  	TableColumnModel columnModel = jTable.getColumnModel();
//		  	columnModel.getColumn(0).setPreferredWidth(300);
//		  	columnMode.getColum
//	        columnModel.getColumn(1).setPreferredWidth(300);
//	        
//	        for(int i=2;i<=15;i++)
//	        {
//	        	columnModel.getColumn(i).setPreferredWidth(150);
//	        	columnModel.getColumn(i).setMaxWidth(150);;
//	        }
		 jTable.revalidate();
		 JScrollPane sp = new JScrollPane(jTable);
	     sp.setLocation(10, 86);
	     sp.setSize(1102, 188);
	     jTable.setLocation(22, 81);
	     contentPane.add(sp);
	     
	     JButton btnNewButton_1 = new JButton("L\u01B0u Thay \u0110\u1ED5i");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		int row = jTable.getRowCount();
	     		Object []result= new Object[16];
	     		for(int i=0;i<row;i++)
	     		{
	     			
	     			for(int j=0;j<16;j++)
	     			{
	     				result[j]=jTable.getModel().getValueAt(i,j);
	     			}
	     			
	     		}
	     		System.out.println("result");
	     		DiemDanh ddAdd=new DiemDanh(IdMonHocGB,(String)result[0], convertBooleanToInt((Boolean)result[1]),convertBooleanToInt((Boolean)result[2]),
	     				convertBooleanToInt((Boolean)result[3]),convertBooleanToInt((Boolean)result[4]),convertBooleanToInt((Boolean)result[5]),
	     				convertBooleanToInt((Boolean)result[6]),convertBooleanToInt((Boolean)result[7]),
	     				convertBooleanToInt((Boolean)result[8]),convertBooleanToInt((Boolean)result[9]),
	     				convertBooleanToInt((Boolean)result[10]),convertBooleanToInt((Boolean)result[11]),
	     				convertBooleanToInt((Boolean)result[12]),convertBooleanToInt((Boolean)result[13]),
	     				convertBooleanToInt((Boolean)result[14]),convertBooleanToInt((Boolean)result[15]));
	     		DiemDanh.capNhatDiemDanh(ddAdd);
	     		
	     	}
	     });
	     btnNewButton_1.setBounds(525, 51, 134, 23);
	     contentPane.add(btnNewButton_1);
	     
	     JButton btnNewButton_2 = new JButton("Quay L\u1EA1i");
	     btnNewButton_2.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		controller.closeDanhSachDiemDanhUi();
	     	}
	     });
	     btnNewButton_2.setBackground(Color.ORANGE);
	     btnNewButton_2.setBounds(10, 11, 89, 23);
	     contentPane.add(btnNewButton_2);
	}
}
