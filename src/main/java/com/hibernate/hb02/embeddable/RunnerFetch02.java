package com.hibernate.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student02.class).addAnnotatedClass(Address.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Student02 student02 = session.get(Student02.class, 1);
        System.out.println(student02);

        Student02 student03 = session.get(Student02.class, 2);
        System.out.println(student03);

        transaction.commit();

        session.close();

        sessionFactory.close();



    }

}
