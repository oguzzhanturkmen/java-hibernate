package com.hibernate.hb11.caching;

import com.hibernate.hb09.fetchtypes.Book09;
import com.hibernate.hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {
        Student11 student = new Student11();
        student.setName("John");
        student.setCity("New York");

        Student11 student2 = new Student11();
        student2.setName("Jane");
        student2.setCity("New York");



        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student11.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(student2);


        transaction.commit();

        session.close();

        sessionFactory.close();
    }

}
