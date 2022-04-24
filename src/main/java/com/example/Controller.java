package com.example;

import javax.swing.JOptionPane;

public class Controller {
	 login frame = new login(this);
	 GiaoVuUi frameGiaoVu ;
	 DanhSachMonHocUi frameDanhSachMonHoc ;
	 DanhSachSinhVienUi frameDanhSachSinhVien = new DanhSachSinhVienUi(this);
	 NhapFileCsvUi frameNhapFileCsvUi ;
	 NhapSinhVienUi frameNhapSinhVienUi = new NhapSinhVienUi(this);
	 DanhSachDiemDanhUi frameDanhSachDiemDanhUi = new DanhSachDiemDanhUi(this);
	 DoiMatKhauUi frameDoiMatKhauUiGB;
	 //SInhVien
	 QuanLyMonHocUi frameQuanLyMonHocUiGB;
	 ThemMonHocUi frameThemMonHocGB;
	
	
	 
	 public void start() {
		
		 frame.setVisible(true);
//		 frame1.setVisible(true);
		 
	 }
	 public void changelogintogiaovu(String IdGiaoVu,NguoiDung nd) {
		 frame.setVisible(false);
		 GiaoVuUi frame1= new GiaoVuUi(this, IdGiaoVu,nd);
		 frameGiaoVu=frame1;
		 frame1.setVisible(true);
	 }
	 public void changegiaovutologin()
	 {
		 frameGiaoVu.dispose();
		 frame.setVisible(true);
	 }
	 public void openDanhSachMonHoc(String IdGiaoVu)
	 {
		 DanhSachMonHocUi frame2 = new DanhSachMonHocUi(this,IdGiaoVu);
		 frameDanhSachMonHoc=frame2;
		 frame2.setVisible(true);
	 }
	 public void closeDanhSachMonHoc()
	 {
		 frameDanhSachMonHoc.setVisible(false);
		 
	 }
	 public void ThemMonHoc(String IdGiaoVu)
	 {
		 ThemMonHocUi frameThemMonHoc = new ThemMonHocUi(this,IdGiaoVu);
		 frameThemMonHocGB=frameThemMonHoc;
		 frameThemMonHocGB.setVisible(true);

	 }
	 public void closeThemMonHoc()
	 {
		 frameThemMonHocGB.dispose();
	 }
	 public void openDanhSachSinhVien()
	 {
		 frameDanhSachSinhVien.setVisible(true);
	 }
	 public void closeDanhSachSinhVien()
	 {
		 frameDanhSachSinhVien.setVisible(false);
	 }
	 public void openNhapFileCsvUi()
	 {
		 NhapFileCsvUi frameCsv = new NhapFileCsvUi(this);
		 frameCsv.setVisible(true);
		 frameNhapFileCsvUi = frameCsv;
	 }
	 public void closeNhapFileCsvUi()
	 {
		 frameNhapFileCsvUi.setVisible(false);

	 }
	 public void openNhapSinhVienUi()
	 {
		 frameNhapSinhVienUi.setVisible(true);
	 }
	 public void closeNhapSinhVienUi()
	 {
		 frameNhapSinhVienUi.setVisible(false);
	 }
	 public void openDanhSachDiemDanhUi()
	 {
		 frameDanhSachDiemDanhUi.setVisible(true);
	 }
	 public void closeDanhSachDiemDanhUi()
	 {
		 frameDanhSachDiemDanhUi.setVisible(false);
		
	 }
	 public void openDoiMatKhauUi(NguoiDung nd )
	 {
		 DoiMatKhauUi frameDoiMatKhauUi = new DoiMatKhauUi(this,nd);
		 frameDoiMatKhauUiGB=frameDoiMatKhauUi;
		 frameDoiMatKhauUi.setVisible(true);
		 
	 }
	 public void closeDoiMatKhauUi()
	 {
		 frameDoiMatKhauUiGB.setVisible(false);
		 frame.setVisible(true);
	 }
	 public void changeGiaoVuUiToDoiMatKhauUi(NguoiDung nd)
	 {
		 frameGiaoVu.dispose();
		 DoiMatKhauUi frameDoiMatKhauUi = new DoiMatKhauUi(this,nd);
		 frameDoiMatKhauUiGB=frameDoiMatKhauUi;
		 frameDoiMatKhauUi.setVisible(true);
	 }
	 public void changeLoginToQuanLyMonHocUi(NguoiDung nd)
	 {
		 frame.setVisible(false);
		 QuanLyMonHocUi frameQuanLyMonHocUi = new QuanLyMonHocUi(this,nd);
		 frameQuanLyMonHocUiGB= frameQuanLyMonHocUi;
		 frameQuanLyMonHocUiGB.setVisible(true);
	 }
	 public void closeQuanLyMonHocUi()
	 {
		 frameQuanLyMonHocUiGB.setVisible(false);
		 frame.setVisible(true);
	 }
	 public void showErrorLogin()
	 {
		 	JOptionPane.showMessageDialog(frame,
				    "Username hoac Password khong dung",
				    "Loi",
				    JOptionPane.ERROR_MESSAGE);
	 }
	 public void showNotRightTime()
	 {
		 JOptionPane.showMessageDialog(frameQuanLyMonHocUiGB,
				    "Ban khong the thuc hien chuc nang do luc nay",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
	 }
	 public void showNotEqual()
	 {
		 JOptionPane.showMessageDialog(frameDoiMatKhauUiGB,
				    "Password khong trung khop",
				    "Loi",
				    JOptionPane.ERROR_MESSAGE);
	 }
	 public void showBlankExist()
	 {
		 JOptionPane.showMessageDialog(frameThemMonHocGB,
				    "Vui long dien du tat ca cac truong",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
	 }
	 public void showNotEnoughTime()
	 {
		 JOptionPane.showMessageDialog(frameThemMonHocGB,
				    "Thoi gian ban nhap khong hop ly. Moi ban nhap lai",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
	 }
	
}
