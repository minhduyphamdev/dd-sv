package com.example;

import java.awt.EventQueue;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
	
	
//		public static void main()
//         EventQueue.invokeLater(new Runnable() {
// 			public void run() {
// 				try {
// 					
// 					frame.setVisible(true);
// 				} catch (Exception e) {
// 					e.printStackTrace();
// 				}
// 			}
// 		});
//		}
	
	
	public static void printNguoiDung(Session session)
	{
		 List<NguoiDung> list = session.createQuery("From NguoiDung",NguoiDung.class).list();
         for(final NguoiDung a :list)
         {
      	   System.out.println(a.toString());
         }
	}
//	public static void khachha() {
//		khachha frame = new khachha();
//		frame.setVisible(true);
//	}
	
	public static void main(String []args) {
		Controller controller = new Controller();
		controller.start();
//       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//           transaction = session.beginTransaction();
//           printNguoiDung(session);
//       		
//         
//    	
//
//           transaction.commit();
//       } catch (Exception e) {
//           e.printStackTrace();
//           if (transaction != null) {
//               transaction.rollback();
//           }
//       }
//       HibernateUtil.shutdown();
	}
}
