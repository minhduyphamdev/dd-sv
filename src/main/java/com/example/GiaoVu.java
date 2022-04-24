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
@Table(name="giaovu")
public class GiaoVu {
	@Id
	private String Id;
	@Id
	private String IdMonHoc;
	
	private String TenGiaoVu;
	
	
	public GiaoVu() {
		super();
	}


	public GiaoVu(String id, String idMonHoc, String tenGiaoVu) {
		super();
		Id = id;
		IdMonHoc = idMonHoc;
		TenGiaoVu = tenGiaoVu;
	}


	@Override
	public String toString() {
		return "GiaoVu [Id=" + Id + ", IdMonHoc=" + IdMonHoc + ", TenGiaoVu=" + TenGiaoVu + "]";
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getIdMonHoc() {
		return IdMonHoc;
	}


	public void setIdMonHoc(String idMonHoc) {
		IdMonHoc = idMonHoc;
	}


	public String getTenGiaoVu() {
		return TenGiaoVu;
	}


	public void setTenGiaoVu(String tenGiaoVu) {
		TenGiaoVu = tenGiaoVu;
	}
	public static void themMonHocChoGiaoVu(String Id,String tenGiaoVu,String IdMonHoc)
	{
	
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			 if(!trans.isActive())
			 {				 
				 trans.begin();
			 }
			 //tao moi mot giao vu 
			 GiaoVu gv = new GiaoVu(Id,IdMonHoc,tenGiaoVu);
			 ss.save(gv);
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
			trans.rollback();
			System.out.println(ex.getMessage());
		}
	
	
	}

	public static String layTenGiaoVuTuId(String Id)
	{
		List<GiaoVu> giaoVu=null;
		String ten="";
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			 trans.begin();
			 giaoVu = ss.createQuery("From GiaoVu where Id = :Id",GiaoVu.class).setParameter("Id",Id).list();
			 //
			 ten=giaoVu.get(0).getTenGiaoVu();
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
	
		return ten;
		
	}
	public static List<GiaoVu> layDanhSachMonHoc(String Id)
	{
		List<GiaoVu> giaoVu=null;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			 trans.begin();
			 giaoVu = ss.createQuery("From GiaoVu where Id = :Id",GiaoVu.class).setParameter("Id",Id).list();
			 //
			 for(final GiaoVu gv : giaoVu)
			 {		 
				 System.out.println("Giao Vu"+gv);
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
	
		return giaoVu;
	}

	
	
	
	
	
	
	
	
	
}
