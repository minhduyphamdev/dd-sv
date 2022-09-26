package com.example;
import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DanhSachSinhVienUi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	

	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DanhSachSinhVienUi frame = new DanhSachSinhVienUi(final Controller controller);
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
	
	public DanhSachSinhVienUi(final Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh s\u00E1ch sinh vi\u00EAn");
		lblNewLabel.setBounds(25, 52, 144, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp m\u00E3 h\u1ECDc ph\u1EA7n: ");
		lblNewLabel_1.setBounds(25, 32, 144, 22);
		contentPane.add(lblNewLabel_1);
		
		

		
		final DefaultTableModel model1 = new DefaultTableModel(); 
	  	model1.addColumn("Id sinh vien");
        model1.addColumn("Ten sinh vien");
        
        final JTextField textField = new JTextField();
		textField.setBounds(160, 33, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		         
         JTable jTable = new JTable(model1);
         jTable.revalidate();
		 JScrollPane sp = new JScrollPane(jTable);
	     sp.setLocation(25, 85);
	     sp.setSize(267, 165);
	     jTable.setLocation(22, 81);
	     
	     
	     
	     JButton btnNewButton = new JButton("Nh\u1EADp Sinh Vi\u00EAn M\u1EDBi");
	     btnNewButton.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		controller.openNhapSinhVienUi();
	     	}
	     });
	     btnNewButton.setBounds(302, 82, 159, 23);
	     contentPane.add(btnNewButton);
	     
	     
	     JButton btnNewButton_1 = new JButton("Nh\u1EADp T\u1EEB File CSV");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		controller.openNhapFileCsvUi();
	     	}
	     });
	     btnNewButton_1.setBounds(302, 116, 159, 23);
	     contentPane.add(btnNewButton_1);
	     
	     JButton btnTmKim = new JButton("T\u00ECm Ki\u1EBFm");
	     btnTmKim.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		String IdMonHoc=textField.getText();
				List <SinhVien> sinhVien= SinhVien.laySinhVienCungMaMon(IdMonHoc);
				model1.setRowCount(0);
				
				if(sinhVien!=null)
				{
					
					
					for(final SinhVien sv : sinhVien)
					{
						model1.addRow(new Object[] {sv.getIdSinhVien(),sv.getTenHocSinh()});
					}
						
	     		}
				
					
				
	     	
	     	}
	     	
	     	
	     });
	     contentPane.add(sp);
	     btnTmKim.setBounds(302, 32, 101, 23);
	     contentPane.add(btnTmKim);
	     
	     JButton btnNewButton_1_1 = new JButton("Open Template CSV");
	     btnNewButton_1_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		String downloadDir = System.getProperty("user.dir") + "\\src\\main\\resources\\SinhVien.csv";
	     		try  
	     		{  
		     		//constructor of file class having file as argument  
		     		File file = new File(downloadDir);   
		     		if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
		     		{  
		     		System.out.println("not supported");  
		     		return;  
		     		}  
		     		Desktop desktop = Desktop.getDesktop();  
		     		if(file.exists())         //checks file exists or not  
		     		desktop.open(file);              //opens the specified file  
		     		}  
		     	catch(Exception e1)  
		     	{  
		     		e1.printStackTrace();  
	     		}  
//	     		String link="https://drive.google.com/file/d/1Jhi0bTncowxUe9zxgJbN9BLyRhjzvsD0/view?usp=sharing";
//	     		try {
//	     		
//	     				
//	     		}
////					URL url = new URL(link);
////					File out = new File("D:\\");
////					HttpURLConnection http = (HttpURLConnection)url.openConnection();
////					double fileSize=(double)http.getContentLengthLong();
////					BufferedInputStream in = new BufferedInputStream(http.getInputStream());
////					FileOutputStream fos =new FileOutputStream(out);
////					BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
////					byte[] buffer= new byte[1024];
////					double downloaded =0.00;
////					int read=0;
////					double percentDownloaded = 0.00;
////					while((read= in.read(buffer,0,1024))>=0)
////					{
////						bout.write(buffer,0,read);
////						downloaded +=read;
////						percentDownloaded = (downloaded*100)/fileSize;
////						String percent= String.format("%.4f", percentDownloaded);
////						System.out.println("Downloaded "+ percent);
////					}
////					bout.close();
////					in.close();
////					
////					
////					
////				} catch (IOException e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//	     		
	     	}
	     });
	     btnNewButton_1_1.setBounds(302, 227, 159, 23);
	     contentPane.add(btnNewButton_1_1);
	     
	     JButton btnNewButton_2 = new JButton("Quay L\u1EA1i");
	     btnNewButton_2.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		controller.closeDanhSachSinhVien();
	     	}
	     });
	     btnNewButton_2.setBackground(Color.ORANGE);
	     btnNewButton_2.setBounds(10, 11, 89, 23);
	     contentPane.add(btnNewButton_2);
	     
	     
	     
		

	     
	}
}
