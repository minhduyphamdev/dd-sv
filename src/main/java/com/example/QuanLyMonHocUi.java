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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Component;

public class QuanLyMonHocUi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTable table2;
	private JLabel lblNewLabel_7;
	private String IdMonHocDuocClick;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuanLyMonHocUi frame = new QuanLyMonHocUi();
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
	public String convertToTable(int tuanHienTai, int diemSo,int tuan)
	{
		String k=null;
		if(tuanHienTai>tuan)
		{
			k="chua co";
		}
		else if(diemSo==1)
		{
			k="co hoc";
		}
		else {
			k="vang mat";
		}
		return k;
	}
	public QuanLyMonHocUi(final Controller controller,final NguoiDung nd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00F4n h\u1ECDc");
		lblNewLabel.setBounds(20, 31, 72, 21);
		contentPane.add(lblNewLabel);
		
		
		final DefaultTableModel model1 = new DefaultTableModel(); 
		final DefaultTableModel model2 = new DefaultTableModel(); 

	  	model1.addColumn("Id mon hoc");
        model1.addColumn("Ten mon hoc");
        
		table = new JTable(model1);
		
		table.setBounds(21, 80, 1, 1);
		
		
		List <String> listMaMon=SinhVien.layMaMonTuMotSinhVien(nd.getUserName());
		List <MonHoc> monHoc =null;
		if(listMaMon!=null)
		{
			monHoc=MonHoc.layDanhsachMonHoc(listMaMon);
			
		}
		for (final MonHoc mh : monHoc)
		{
			model1.addRow(new String[] {mh.getIdMonHoc(),mh.getTenMonHoc()});
		}
	
		table.revalidate();
		JScrollPane sp = new JScrollPane(table);
		sp.setLocation(20, 63);
		sp.setSize(190, 165);
		table.setLocation(22, 81);
		contentPane.add(sp);
		
		lblNewLabel_1 = new JLabel("Id sinh vi\u00EAn   :");
		lblNewLabel_1.setBounds(20, 6, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(125, 6, 105, 14);
		lblNewLabel_2.setText(nd.getUserName());
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("\u0110\u1ED5i M\u1EADt Kh\u1EA9u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.openDoiMatKhauUi(nd);
				controller.closeQuanLyMonHocUi();
			}
		});
		btnNewButton.setBounds(255, 2, 129, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("K\u1EBFt qu\u1EA3 \u0111i\u1EC3m danh c\u1EE7a m\u00F4n  : ");
		lblNewLabel_3.setBounds(255, 34, 174, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(439, 34, 157, 14);
		contentPane.add(lblNewLabel_4);
	
		
		
		model2.addColumn("Idsinhvien  ");
		
        model2.addColumn("Tuan 1");
        model2.addColumn("Tuan 2");
        model2.addColumn("Tuan 3");
        model2.addColumn("Tuan 4");
        model2.addColumn("Tuan 5");
        model2.addColumn("Tuan 6");
        model2.addColumn("Tuan 7");
        model2.addColumn("Tuan 8");
        model2.addColumn("Tuan 9");
        model2.addColumn("Tuan 10");
        model2.addColumn("Tuan 11");
        model2.addColumn("Tuan 12");
        model2.addColumn("Tuan 13");
        model2.addColumn("Tuan 14");
        model2.addColumn("Tuan 15");
       
        
        
      
		table2 = new JTable(model2);
		table2.setBounds(255, 53, 1, 1);
		JScrollPane sp1 = new JScrollPane(table2);
		sp1.setLocation(255, 63);
		sp1.setSize(1020, 165);
		table.setLocation(22, 81);
		contentPane.add(sp1);
		
		JLabel lblNewLabel_5 = new JLabel("Tu\u1EA7n hi\u1EC7n t\u1EA1i ");
		lblNewLabel_5.setBounds(20, 264, 85, 14);
		contentPane.add(lblNewLabel_5);
		
		final JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(164, 264, 85, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Th\u00F4ng tin m\u00F4n h\u1ECDc");
		lblNewLabel_7.setBounds(20, 239, 141, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5_1 = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");
		lblNewLabel_5_1.setBounds(20, 289, 92, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc");
		lblNewLabel_5_1_1.setBounds(20, 314, 92, 14);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_8 = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u");
		lblNewLabel_8.setBounds(20, 342, 72, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Gi\u1EDD k\u1EBFt th\u00FAc");
		lblNewLabel_8_1.setBounds(20, 367, 72, 14);
		contentPane.add(lblNewLabel_8_1);
		
		final JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setBounds(164, 289, 85, 14);
		contentPane.add(lblNewLabel_6_1);
		
		final JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1.setBounds(164, 314, 85, 14);
		contentPane.add(lblNewLabel_6_1_1);
		
		final JLabel lblNewLabel_6_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_1.setBounds(164, 342, 85, 14);
		contentPane.add(lblNewLabel_6_1_1_1);
		
		final JLabel lblNewLabel_6_1_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_1_1.setBounds(164, 367, 85, 14);
		contentPane.add(lblNewLabel_6_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("\u0110i\u1EC3m Danh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IdMonHocDuocClick!=null)
				{
					DiemDanh dd1 = DiemDanh.layDanhSachDiemDanhChoMonHocCuaSinhVien(nd.getUserName(),IdMonHocDuocClick);
					ThoiGianMonHoc tg=ThoiGianMonHoc.layTuanHienTai(IdMonHocDuocClick);
					int tuan = tg.getTuan();
					if(dd1!=null&&tg!=null)
					{
						switch(tg.getTuan())
						{
							case 1:
								dd1.setTuan1(1);
								break;
							case 2:
								dd1.setTuan2(1);
								break;
							case 3:
								dd1.setTuan3(1);
								break;
							case 4:
								dd1.setTuan4(1);
								break;
							case 5:
								dd1.setTuan5(1);
								break;
							case 6:
								dd1.setTuan6(1);
								break;
							case 7:
								dd1.setTuan7(1);
								break;
							case 8:
								dd1.setTuan8(1);
								break;
							case 9:
								dd1.setTuan9(1);
								break;
							case 10:
								dd1.setTuan10(1);
								break;
							case 11:
								dd1.setTuan11(1);
								break;
							case 12:
								dd1.setTuan12(1);
								break;
							case 13:
								dd1.setTuan13(1);
								break;
							case 14:
								dd1.setTuan14(1);
								break;
							case 15:
								dd1.setTuan15(1);
								break;
						}
						
						 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
						 LocalDateTime now = LocalDateTime.now();  
						 System.out.println(dtf.format(now));  
						 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						 try {
							Date d1 = sdf.parse(lblNewLabel_6_1_1_1.getText());
							Date d2 = sdf.parse(lblNewLabel_6_1_1_1_1.getText());
							Date d3=sdf.parse(dtf.format(now));
							long first = d3.getTime() - d1.getTime();
							long second = d2.getTime()- d3.getTime();
							if(first>=0&&second>=0)
							{
								DiemDanh.capNhatDiemDanh(dd1);
								DiemDanh dd = DiemDanh.layDanhSachDiemDanhChoMonHocCuaSinhVien(nd.getUserName(),IdMonHocDuocClick);

								model2.setRowCount(0);
								 Object[] data = {
										 dd1.getIdSinhVien(),convertToTable(1,dd.getTuan1(),tuan),convertToTable(2,dd.getTuan2(),tuan),convertToTable(3,dd.getTuan3(),tuan),
										 convertToTable(4,dd.getTuan4(),tuan),convertToTable(5,dd.getTuan5(),tuan),convertToTable(6,dd.getTuan6(),tuan),
										 convertToTable(7,dd.getTuan7(),tuan),convertToTable(8,dd.getTuan8(),tuan),convertToTable(9,dd.getTuan9(),tuan),
										 convertToTable(10,dd.getTuan10(),tuan),convertToTable(11,dd.getTuan11(),tuan),convertToTable(12,dd.getTuan12(),tuan),
										 convertToTable(13,dd.getTuan13(),tuan),convertToTable(14,dd.getTuan14(),tuan),convertToTable(15,dd.getTuan15(),tuan),
								 };
								 model2.addRow(data);
							}
							else {
								controller.showNotRightTime();
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
//						 
//						    long elapsed = d2.getTime() - d1.getTime();


					}
				}
			}
		});
		btnNewButton_1.setBounds(430, 2, 129, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0110\u0103ng Xu\u1EA5t");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.closeQuanLyMonHocUi();
			}
		});
		btnNewButton_2.setBounds(593, 2, 141, 23);
		contentPane.add(btnNewButton_2);
		TableColumnModel columnModel = table2.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(100); 
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String IdMonHocChon = table.getModel().getValueAt(row, 0).toString();
				IdMonHocDuocClick=IdMonHocChon;
				String TenMonHocChon=table.getModel().getValueAt(row, 1).toString();
				
				//lay thong tin mon hoc
				MonHoc mhInfo = MonHoc.LayThongTinMonHoc(IdMonHocChon);
				if(mhInfo!=null)
				{
					lblNewLabel_6_1.setText(mhInfo.getNgayBatDau());
					lblNewLabel_6_1_1.setText(mhInfo.getNgayKetThuc());
					lblNewLabel_6_1_1_1.setText(mhInfo.getGioBatDau());
					lblNewLabel_6_1_1_1_1.setText(mhInfo.getGioKetThuc());
				}
				
				
				lblNewLabel_4.setText(TenMonHocChon);
				// lay duoc id mon hoc 
				String IdSinhVienChon=nd.getUserName();
				System.out.println("Clicked"+IdMonHocChon);
				
				DiemDanh dd = DiemDanh.layDanhSachDiemDanhChoMonHocCuaSinhVien(IdSinhVienChon, IdMonHocChon);
				model2.setRowCount(0);
				
				// lay tuan hien tai
				ThoiGianMonHoc ht = ThoiGianMonHoc.layTuanHienTai(IdMonHocChon);
				int tuan =ht.getTuan();
				if(ht!=null)
				{
					lblNewLabel_6.setText(Integer.toString(ht.getTuan()));
					
					
				}
				if(dd!=null)
				{
					 Object[] data = {
							 dd.getIdSinhVien(),convertToTable(1,dd.getTuan1(),tuan),convertToTable(2,dd.getTuan2(),tuan),convertToTable(3,dd.getTuan3(),tuan),
							 convertToTable(4,dd.getTuan4(),tuan),convertToTable(5,dd.getTuan5(),tuan),convertToTable(6,dd.getTuan6(),tuan),
							 convertToTable(7,dd.getTuan7(),tuan),convertToTable(8,dd.getTuan8(),tuan),convertToTable(9,dd.getTuan9(),tuan),
							 convertToTable(10,dd.getTuan10(),tuan),convertToTable(11,dd.getTuan11(),tuan),convertToTable(12,dd.getTuan12(),tuan),
							 convertToTable(13,dd.getTuan13(),tuan),convertToTable(14,dd.getTuan14(),tuan),convertToTable(15,dd.getTuan15(),tuan),
					 };
					 model2.addRow(data);
				}
				
				
			}
		});
	}
}
