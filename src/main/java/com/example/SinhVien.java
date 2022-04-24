package com.example;

import java.util.ArrayList;
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
@Table(name="sinhvien")
public class SinhVien {
	@Id
	private String IdSinhVien;
	@Id
	private String IdMonHoc;
	
	private String TenHocSinh;

	
	public static SinhVien laySinhVienTuId(String IdSinhVien,String IdMonHoc)
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		SinhVien sinhVien=null;
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			trans.begin();
			 sinhVien = ss.createQuery("From SinhVien where IdSinhVien = :IdSinhVien and IdMonHoc =:IdMonHoc",SinhVien.class).setParameter("IdSinhVien",IdSinhVien).setParameter("IdMonHoc",IdMonHoc).getSingleResult();

			trans.commit();
		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
		return sinhVien;
		
	}
	public static void themMotSinhVien(SinhVien sv)
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			if(!trans.isActive())
			{				
				trans.begin();
			}
			ss.save(sv);
//			ss.createQuery("INSERT INTO SinhVIen (IdSinhVien, IdMonHoc, TenSinhVien) VALUES(?,?,?)").setParameter(1,sv.getIdSinhVien()).setParameter(2, sv.getIdMonHoc()).setParameter(3, sv.getTenHocSinh()).executeUpdate();
			trans.commit();
		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
	}
	public static void capNhatSinhVien(SinhVien sv)
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			if(!trans.isActive())
			{				
				trans.begin();
			}
	
			ss.update(sv);
			trans.commit();
		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
	}
	public static void themDanhSachSinhVien(List<String[]> SinhVien)
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			trans.begin();
			for(String[] sv1: SinhVien)
			{
				 StringBuffer sb = new StringBuffer();
			      for(int i = 0; i < sv1.length; i++) {
			         sb.append(sv1[i]);
			      }
			      String str = sb.toString();
			      System.out.println("Sinh vien"+ str);
				SinhVien sv =new SinhVien(sv1[0],sv1[1],sv1[2]);
				ss.save(sv);
				
				
			}
			trans.commit();
		}catch(Exception ex)
		{
			
			System.out.println(ex.getMessage());
		}
	}
	public static List<String> layMaMonTuMotSinhVien(String IdSinhVien)
	{
		List<SinhVien> sinhVien = null;
		List<String> IdMaMon = new ArrayList<String>();
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			 trans.begin();
			 sinhVien = ss.createQuery("From SinhVien where IdSinhVien = :IdSinhVien",SinhVien.class).setParameter("IdSinhVien",IdSinhVien).list();
			 //
			 for(final SinhVien sv : sinhVien)
			 {		 
				 IdMaMon.add(sv.getIdMonHoc());
			 }
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
		return IdMaMon;
	}

	public static List<SinhVien> laySinhVienCungMaMon(String IdMonHoc)
	{
		List<SinhVien> sinhVien=null;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			 if(!trans.isActive())
			 {				 
				 trans.begin();
			 }
			 sinhVien = ss.createQuery("From SinhVien where IdMonHoc = :IdMonHoc",SinhVien.class).setParameter("IdMonHoc",IdMonHoc).list();
			 //
			 for(final SinhVien sv : sinhVien)
			 {		 
				 System.out.println("Sinh vien cung mon"+sv);
			 }
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
	
		return sinhVien;
	}
	
	
	public SinhVien() {
		super();
	}

	public SinhVien(String idSinhVien, String idMonHoc, String tenHocSinh) {
		super();
		IdSinhVien = idSinhVien;
		IdMonHoc = idMonHoc;
		TenHocSinh = tenHocSinh;
	}

	@Override
	public String toString() {
		return "SinhVien [IdSinhVien=" + IdSinhVien + ", IdMonHoc=" + IdMonHoc + ", TenHocSinh=" + TenHocSinh + "]";
	}

	public String getIdSinhVien() {
		return IdSinhVien;
	}

	public void setIdSinhVien(String idSinhVien) {
		IdSinhVien = idSinhVien;
	}

	public String getIdMonHoc() {
		return IdMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		IdMonHoc = idMonHoc;
	}

	public String getTenHocSinh() {
		return TenHocSinh;
	}

	public void setTenHocSinh(String tenHocSinh) {
		TenHocSinh = tenHocSinh;
	}
	
	
	
	
	
	
	
	
	
	
}
