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
@Table(name="thoigianmonhoc")
public class ThoiGianMonHoc {
	@Id
	private String IdMonHoc;
	
	private int Tuan;

	
	
	public static ThoiGianMonHoc layTuanHienTai(String IdMonHoc)
	{
		ThoiGianMonHoc ht=null;
	
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			 trans.begin();
			 ht = ss.createQuery("From ThoiGianMonHoc where IdMonHoc = :IdMonHoc",ThoiGianMonHoc.class).setParameter("IdMonHoc",IdMonHoc).getSingleResult();
			 //
			
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
		return ht;
	}
	@Override
	public String toString() {
		return "ThoiGianMonHoc [IdMonHoc=" + IdMonHoc + ", Tuan=" + Tuan + "]";
	}

	public ThoiGianMonHoc() {
		super();
	}

	public ThoiGianMonHoc(String idMonHoc, int tuan) {
		super();
		IdMonHoc = idMonHoc;
		Tuan = tuan;
	}

	public String getIdMonHoc() {
		return IdMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		IdMonHoc = idMonHoc;
	}

	public int getTuan() {
		return Tuan;
	}

	public void setTuan(int tuan) {
		Tuan = tuan;
	}
	
	

}
