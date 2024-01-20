package com.hibernate.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // With get method, we can fetch the data from the database.
        /*Student05 student1 =session.get(Student05.class, 1001);
        System.out.println(student1.getUniversity());*/

        String hql = "FROM Student05 s WHERE s.university.id = 1";
        List<Student05> list = session.createQuery(hql).getResultList();
        list.forEach(System.out::println);

        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
