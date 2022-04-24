package com.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class DanhSachMonHocUi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String IdGiaoVu;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DanhSachMonHocUi(final Controller controller,final String IdGiaoVu) {
		
		// lay mot giao vu cung voi nhieu mon hoc
		List<GiaoVu> giaoVu= GiaoVu.layDanhSachMonHoc(IdGiaoVu);
		for (final GiaoVu gv : giaoVu)
		{
			System.out.println("Danh sach ma mon"+ gv);
		}
		
		 final DefaultTableModel model1 = new DefaultTableModel(); 
		 model1.addColumn("Id mon hoc");
	      model1.addColumn("Ten mon hoc");
	        
    		
	        for (final GiaoVu gv: giaoVu)
	        {
	    		
	        	MonHoc monHoc = MonHoc.LayThongTinMonHoc(gv.getIdMonHoc());
	        	
	        	if(monHoc!=null)
	        	{
	        		System.out.println("mon hoc"+monHoc);
	        		model1.addRow(new String[] {monHoc.getIdMonHoc(),monHoc.getTenMonHoc()});
	        	}

	        }
	      
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 502, 324);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Danh s\u00E1ch m\u00F4n h\u1ECDc");
			
			lblNewLabel.setForeground(Color.GREEN);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
			 
			lblNewLabel.setBounds(150, 7, 152, 34);
			contentPane.add(lblNewLabel);
			
		        // Column Names
		     
	        // Append a row 
	   
	 
	        // Initializing the JTable
	        JTable jTable = new JTable(model1);
	        jTable.revalidate();
	        // adding it to JScrollPane
	        JScrollPane sp = new JScrollPane(jTable);
	        sp.setLocation(99, 52);
	        sp.setSize(244, 222);
	        jTable.setLocation(22, 81);
	        contentPane.add(sp);
	        
	        JButton btnNewButton = new JButton("T\u1EA1o M\u00F4n H\u1ECDc");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		controller.ThemMonHoc(IdGiaoVu);
	        	}
	        });
	        btnNewButton.setBounds(368, 49, 108, 23);
	        contentPane.add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("Quay L\u1EA1i");
	        btnNewButton_1.setBackground(Color.ORANGE);
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		controller.closeDanhSachMonHoc();
	        	}
	        });
	        btnNewButton_1.setBounds(0, 15, 97, 23);
	        contentPane.add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton("ReLoad ");
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		model1.setRowCount(0);
	        		List<GiaoVu> giaoVu1= GiaoVu.layDanhSachMonHoc(IdGiaoVu);
	        		for (final GiaoVu gv: giaoVu1)
	    	        {
	    	    		
	    	        	MonHoc monHoc = MonHoc.LayThongTinMonHoc(gv.getIdMonHoc());
	    	        	
	    	        	if(monHoc!=null)
	    	        	{
	    	        		System.out.println("mon hoc"+monHoc);
	    	        		model1.addRow(new String[] {monHoc.getIdMonHoc(),monHoc.getTenMonHoc()});
	    	        	}

	    	        }
	        		
	        	}
	        });
	        btnNewButton_2.setBounds(368, 92, 108, 23);
	        contentPane.add(btnNewButton_2);
	       

	
		
	}
}
