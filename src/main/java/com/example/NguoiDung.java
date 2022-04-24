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
@Table(name="nguoidung")
public class NguoiDung {
	@Id
	private String Id;
	
	private String UserName;
	
	private String Password;
	
	private int IsTeacher;
	
	public NguoiDung() {
		super();
	}

	public NguoiDung(String id, String userName, String password, int isTeacher) {
		super();
		Id = id;
		UserName = userName;
		Password = password;
		IsTeacher = isTeacher;
	}
	public static void doiMatKhau(NguoiDung nd)
	{
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			if(!trans.isActive())
			{				
				trans.begin();
			}
			ss.update(nd);
		
			trans.commit();

		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

	}
	public static void UpdateNguoiDung(String UserName,String Password)
	{
		NguoiDung nguoiDung=null;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
				if(!trans.isActive())
				{				
					trans.begin();
				}
			 nguoiDung= ss.createQuery("From NguoiDung where UserName = :UserName",NguoiDung.class).setParameter("UserName",UserName).getSingleResult();
			 nguoiDung.setPassword(Password);
			 ss.update(nguoiDung);

			 //
			 // sua lai thanh nguoiDung
			
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
	}
	public static NguoiDung layThongTinNguoiDung(String UserName, String Password)
	{
		NguoiDung nguoiDung=null;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss= sf.getCurrentSession();
		Transaction trans= ss.getTransaction();
		try {
			if(!trans.isActive())
			{				
				trans.begin();
			}
			 List<NguoiDung> list = ss.createQuery("From NguoiDung where UserName = :UserName and Password = :Password",NguoiDung.class).setParameter("UserName",UserName).setParameter("Password",Password).list();
			 //
			 // sua lai thanh nguoiDung
			 for(NguoiDung a:list)
			 {
				 System.out.println(a.getUserName());
				 System.out.println(UserName);
				 System.out.println(a.getUserName().equals(UserName));
				 if(a.getUserName().equals(UserName))
				 {
					 nguoiDung=a;
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
			System.out.println(ex.getMessage());
		}
		return nguoiDung;
	}
	
	@Override
	public String toString() {
		return "NguoiDung [Id=" + Id + ", Name=" + UserName + ", Password=" + Password + ", IsTeacher=" + IsTeacher + "]";
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String name) {
		UserName = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getIsTeacher() {
		return IsTeacher;
	}

	public void setIsTeacher(int isTeacher) {
		IsTeacher = isTeacher;
	}
	
	
	
	
	
	
}
