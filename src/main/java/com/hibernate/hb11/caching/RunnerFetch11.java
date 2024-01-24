package com.hibernate.hb11.caching;

import com.hibernate.hb09.fetchtypes.Book09;
import com.hibernate.hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student11.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Student11 student = session.get(Student11.class, 1L);
        System.out.println(student.getName());

        System.out.println("Fetching again");

        // session.clear(); // This will clear the cache and will fetch from the database again

        Student11 student2 = session.get(Student11.class, 1L);
        System.out.println(student2.getName());

        transaction.commit();

        session.close();

        Session session2 = sessionFactory.openSession();

        Transaction transaction2 = session2.beginTransaction();

        Student11 student3 = session2.get(Student11.class, 1L);
        System.out.println(student.getName());


        transaction2.commit();

        session2.close();

        sessionFactory.close();
    }
}
