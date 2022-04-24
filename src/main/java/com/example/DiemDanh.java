package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="diemdanh")
public class DiemDanh {
	@Id
	private String IdMonHoc;
	@Id
	private String IdSinhVien;
	
	private int Tuan1;
	
	private int Tuan2;
	
	private int Tuan3;
	
	private int Tuan4;
	
	private int Tuan5;
	
	private int Tuan6;
	
	private int Tuan7;
	
	private int Tuan8;
	
	private int Tuan9;
	
	private int Tuan10;
	
	private int Tuan11;
	
	private int Tuan12;
	
	private int Tuan13;
	
	private int Tuan14;

	private int Tuan15;

	public static void capNhatDiemDanh(DiemDanh dd)
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			if(!trans.isActive())
			{				
				trans.begin();
			}
	
			ss.update(dd);
			trans.commit();
		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
	}
	public static DiemDanh layDanhSachDiemDanhChoMonHocCuaSinhVien(String IdSinhVien, String IdMonHoc)
	{
		DiemDanh dd = null;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			 if(!trans.isActive())
			 {				 
				 trans.begin();
			 }
			 dd = ss.createQuery("From DiemDanh where IdSinhVien = :IdSinhVien and IdMonHoc = :IdMonHoc",DiemDanh.class).setParameter("IdSinhVien",IdSinhVien).setParameter("IdMonHoc", IdMonHoc).getSingleResult();
			 //
//			 for(final GiaoVu gv : giaoVu)
//			 {		 
//				 System.out.println("Giao Vu"+gv);
//			 }
//			 for(final NguoiDung si : list)
//			 {
//				 System.out.println(si.toString());
//				 if(si.UserName==Username)
//				 {
//					 System.out.println(si.toString());
//				 }
//			 }
			 
			 trans.commit();
			 

		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
		return dd;
		
	}
	public static DiemDanh layDanhSachDiemDanhMotSinhVien(SinhVien sv) 
	{
		DiemDanh dd=null;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			 if(!trans.isActive())
			 {				 
				 trans.begin();
			 }
			 dd = ss.createQuery("From DiemDanh where IdSinhVien = :IdSinhVien and IdMonHoc = :IdMonHoc",DiemDanh.class).setParameter("IdSinhVien",sv.getIdSinhVien()).setParameter("IdMonHoc", sv.getIdMonHoc()).getSingleResult();
			 //
//			 for(final GiaoVu gv : giaoVu)
//			 {		 
//				 System.out.println("Giao Vu"+gv);
//			 }
//			 for(final NguoiDung si : list)
//			 {
//				 System.out.println(si.toString());
//				 if(si.UserName==Username)
//				 {
//					 System.out.println(si.toString());
//				 }
//			 }
			 trans.commit();
			 

		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
	
		return dd;
	}
	public DiemDanh() {
		super();
	}
	
	public DiemDanh(String idMonHoc, String idSinhVien, int tuan1, int tuan2, int tuan3, int tuan4, int tuan5,
			int tuan6, int tuan7, int tuan8, int tuan9, int tuan10, int tuan11, int tuan12, int tuan13, int tuan14,
			int tuan15) {
		super();
		IdMonHoc = idMonHoc;
		IdSinhVien = idSinhVien;
		Tuan1 = tuan1;
		Tuan2 = tuan2;
		Tuan3 = tuan3;
		Tuan4 = tuan4;
		Tuan5 = tuan5;
		Tuan6 = tuan6;
		Tuan7 = tuan7;
		Tuan8 = tuan8;
		Tuan9 = tuan9;
		Tuan10 = tuan10;
		Tuan11 = tuan11;
		Tuan12 = tuan12;
		Tuan13 = tuan13;
		Tuan14 = tuan14;
		Tuan15 = tuan15;
	}

	@Override
	public String toString() {
		return "DiemDanh [IdMonHoc=" + IdMonHoc + ", IdSinhVien=" + IdSinhVien + ", Tuan1=" + Tuan1 + ", Tuan2=" + Tuan2
				+ ", Tuan3=" + Tuan3 + ", Tuan4=" + Tuan4 + ", Tuan5=" + Tuan5 + ", Tuan6=" + Tuan6 + ", Tuan7=" + Tuan7
				+ ", Tuan8=" + Tuan8 + ", Tuan9=" + Tuan9 + ", Tuan10=" + Tuan10 + ", Tuan11=" + Tuan11 + ", Tuan12="
				+ Tuan12 + ", Tuan13=" + Tuan13 + ", Tuan14=" + Tuan14 + ", Tuan15=" + Tuan15 + "]";
	}

	public String getIdMonHoc() {
		return IdMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		IdMonHoc = idMonHoc;
	}

	public String getIdSinhVien() {
		return IdSinhVien;
	}

	public void setIdSinhVien(String idSinhVien) {
		IdSinhVien = idSinhVien;
	}

	public int getTuan1() {
		return Tuan1;
	}

	public void setTuan1(int tuan1) {
		Tuan1 = tuan1;
	}

	public int getTuan2() {
		return Tuan2;
	}

	public void setTuan2(int tuan2) {
		Tuan2 = tuan2;
	}

	public int getTuan3() {
		return Tuan3;
	}

	public void setTuan3(int tuan3) {
		Tuan3 = tuan3;
	}

	public int getTuan4() {
		return Tuan4;
	}

	public void setTuan4(int tuan4) {
		Tuan4 = tuan4;
	}

	public int getTuan5() {
		return Tuan5;
	}

	public void setTuan5(int tuan5) {
		Tuan5 = tuan5;
	}

	public int getTuan6() {
		return Tuan6;
	}

	public void setTuan6(int tuan6) {
		Tuan6 = tuan6;
	}

	public int getTuan7() {
		return Tuan7;
	}

	public void setTuan7(int tuan7) {
		Tuan7 = tuan7;
	}

	public int getTuan8() {
		return Tuan8;
	}

	public void setTuan8(int tuan8) {
		Tuan8 = tuan8;
	}

	public int getTuan9() {
		return Tuan9;
	}

	public void setTuan9(int tuan9) {
		Tuan9 = tuan9;
	}

	public int getTuan10() {
		return Tuan10;
	}

	public void setTuan10(int tuan10) {
		Tuan10 = tuan10;
	}

	public int getTuan11() {
		return Tuan11;
	}

	public void setTuan11(int tuan11) {
		Tuan11 = tuan11;
	}

	public int getTuan12() {
		return Tuan12;
	}

	public void setTuan12(int tuan12) {
		Tuan12 = tuan12;
	}

	public int getTuan13() {
		return Tuan13;
	}

	public void setTuan13(int tuan13) {
		Tuan13 = tuan13;
	}

	public int getTuan14() {
		return Tuan14;
	}

	public void setTuan14(int tuan14) {
		Tuan14 = tuan14;
	}

	public int getTuan15() {
		return Tuan15;
	}

	public void setTuan15(int tuan15) {
		Tuan15 = tuan15;
	}
	
	
	
	
	
	
	
	
}
