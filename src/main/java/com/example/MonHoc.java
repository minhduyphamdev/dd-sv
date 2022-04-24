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
@Table(name="monhoc")
public class MonHoc {
	@Id
	private String IdMonHoc;
	
	private String TenMonHoc;
	
	private String NgayBatDau;
	
	private String NgayKetThuc;
	
	private int Tuan;
	
	private String GioBatDau;
	
	private String GioKetThuc;
	
	private String ThuTrongTuan;
	
	private String PhongHoc;
 
	
	
	public static List<MonHoc> layDanhsachMonHoc(List<String> IdMonHoc)
	{
		List<MonHoc> monHoc=new ArrayList<MonHoc>();
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			if(!trans.isActive())
			{		
				
				trans.begin();
			}
			for(final String IdMonHoc1 : IdMonHoc)
			{
				
				MonHoc mh = ss.createQuery("From MonHoc where IdMonHoc = :IdMonHoc",MonHoc.class).setParameter("IdMonHoc",IdMonHoc1).getSingleResult();
				
				if(mh!=null)
				{
					monHoc.add(mh);
				}
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
			trans.rollback();
		
			System.out.println(ex.getMessage());
		}
		return monHoc;
	}
	public static MonHoc LayThongTinMonHoc(String IdMonHoc)
	{
		MonHoc monHoc=null;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			if(!trans.isActive())
			{		
				
				trans.begin();
				monHoc = ss.createQuery("From MonHoc where IdMonHoc = :IdMonHoc",MonHoc.class).setParameter("IdMonHoc",IdMonHoc).getSingleResult();
				//
				System.out.println("Mon hoc"+monHoc);
//			 for(final NguoiDung si : list)
//			 {
//				 System.out.println(si.toString());
//				 if(si.UserName==Username)
//				 {
//					 System.out.println(si.toString());
//				 }
//			 }
				trans.commit();
			}
			
		}catch(Exception ex)
		{
			trans.rollback();
		
			System.out.println(ex.getMessage());
		}
		return monHoc;
	}
	public static void LuuThongTinMonHoc(MonHoc monHoc)
	{
	
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			
			if(!trans.isActive())
			{		
				
				trans.begin();
				ss.save(monHoc);
				//
				System.out.println("Mon hoc"+monHoc);
//			 for(final NguoiDung si : list)
//			 {
//				 System.out.println(si.toString());
//				 if(si.UserName==Username)
//				 {
//					 System.out.println(si.toString());
//				 }
//			 }
				trans.commit();
			}
			
		}catch(Exception ex)
		{
			trans.rollback();
		
			System.out.println(ex.getMessage());
		}
		
	}
	
	public MonHoc(String idMonHoc, String tenMonHoc, String ngayBatDau, String ngayKetThuc, int tuan,
			String gioBatDau, String gioKetThuc, String thuTrongTuan, String phongHoc) {
		super();
		IdMonHoc = idMonHoc;
		TenMonHoc = tenMonHoc;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		Tuan = tuan;
		GioBatDau = gioBatDau;
		GioKetThuc = gioKetThuc;
		ThuTrongTuan = thuTrongTuan;
		PhongHoc = phongHoc;
	}

	public MonHoc() {
		super();
	}

	@Override
	public String toString() {
		return "MonHoc [IdMonHoc=" + IdMonHoc + ", TenMonHoc=" + TenMonHoc + ", NgayBatDau=" + NgayBatDau
				+ ", NgayKetThuc=" + NgayKetThuc + ", Tuan=" + Tuan + ", GioBatDau=" + GioBatDau + ", GioKetThuc="
				+ GioKetThuc + ", ThuTrongTuan=" + ThuTrongTuan + ", PhongHoc=" + PhongHoc + "]";
	}

	public String getIdMonHoc() {
		return IdMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		IdMonHoc = idMonHoc;
	}

	public String getTenMonHoc() {
		return TenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		TenMonHoc = tenMonHoc;
	}

	public String getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}

	public int getTuan() {
		return Tuan;
	}

	public void setTuan(int tuan) {
		Tuan = tuan;
	}

	public String getGioBatDau() {
		return GioBatDau;
	}

	public void setGioBatDau(String gioBatDau) {
		GioBatDau = gioBatDau;
	}

	public String getGioKetThuc() {
		return GioKetThuc;
	}

	public void setGioKetThuc(String gioKetThuc) {
		GioKetThuc = gioKetThuc;
	}

	public String getThuTrongTuan() {
		return ThuTrongTuan;
	}

	public void setThuTrongTuan(String thuTrongTuan) {
		ThuTrongTuan = thuTrongTuan;
	}

	public String getPhongHoc() {
		return PhongHoc;
	}

	public void setPhongHoc(String phongHoc) {
		PhongHoc = phongHoc;
	}
	
	
	
	
	
	
	
	
	
}
