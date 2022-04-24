package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.function.Function;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

//    public static <T> T query(Function<Session, T> queryFunction) {
//        T value = null;
//        Transaction transaction = null;
//        try (Session session = getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//
//            value = queryFunction.apply(session);
//
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        shutdown();
//        return value;
//    }

//    public static String validString(String str) {
//        return str.isBlank() ? "<invalid>" : str;
//    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}