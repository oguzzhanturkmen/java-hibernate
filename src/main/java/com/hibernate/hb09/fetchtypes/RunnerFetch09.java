package com.hibernate.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Student09 student = session.get(Student09.class, 1);


        transaction.commit();

        session.close();
        sessionFactory.close();
    }

}
