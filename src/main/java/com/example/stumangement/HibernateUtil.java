package com.example.stumangement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
     private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure()   // loads hibernate.cfg.xml from resources
                    .buildSessionFactory();
        } catch (Exception e) {
            System.err.println("❌ SessionFactory creation failed");
            e.printStackTrace();
        }
    }

    // Provide SessionFactory to DAO layer
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Optional: close factory when app ends
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
