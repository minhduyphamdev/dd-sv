package com.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NhapFileCsvUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhapFileCsv frame = new NhapFileCsv();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

//	public static void downloadFile(URL url, String fileName) throws Exception {
////		url = System.getClass().getResource("SinhVien.csv");
//        try (InputStream in = url.openStream()) {
//            Files.copy(in, Paths.get(fileName));
//        }
//    }
	/**
	 * Create the frame.
	 */
	public NhapFileCsvUi(final Controller controller) {
		
//		
//		ClassLoader cl = getClass().getClassLoader();
//		File file1 = new File(cl.getResource("./SinhVien.csv").getFile());

//		URL url;
//		try {
//			url = new URL(path);
//			try {
//				downloadFile(url,"SinhVien.xml");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		String []sinhVien = null;
		List <String[]>listSinhVien = new ArrayList() ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String line;
		String splitBy=",";
		final JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("D:\\"));
		int returnVal = fc.showOpenDialog(contentPane);
		  if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            //This is where a real application would open the file.
	            try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					int i=0;
					while((line=br.readLine())!=null)
					{		
						if(i!=0)
						{
							sinhVien=line.split(splitBy);
							System.out.println("Employee [First Name=" + sinhVien[0] + ", Last Name=" + sinhVien[1] + ", Designation=" + sinhVien[2]);  
							listSinhVien.add(sinhVien);
						}
						i++;
					}
					SinhVien.themDanhSachSinhVien(listSinhVien);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            

	        } else {
	            System.out.println("Open command cancelled by user." );
	        }
		  controller.closeNhapFileCsvUi();
	
	}

}
