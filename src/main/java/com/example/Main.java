package com.example;

import java.awt.EventQueue;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
	public static void printNguoiDung(Session session)
	{
		 List<NguoiDung> list = session.createQuery("From NguoiDung",NguoiDung.class).list();
         for(final NguoiDung a :list)
         {
      	   System.out.println(a.toString());
         }
	}
	public static void main(String []args) {
		Controller controller = new Controller();
		controller.start();
	}
}
