package com.hibernate.hb04.bi_directional_onetoone;

import com.hibernate.hb03.uni_onetoone.Diary;
import com.hibernate.hb03.uni_onetoone.Student03;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        org.hibernate.SessionFactory sessionFactory = cfg.buildSessionFactory();

        org.hibernate.Session session = sessionFactory.openSession();

        org.hibernate.Transaction transaction = session.beginTransaction();

       Diary04 diary1 = session.get(Diary04.class, 1);
        System.out.println(diary1);

        Diary04 diary2 = session.get(Diary04.class, 2);
        System.out.println(diary2);

        transaction.commit();

        session.close();

        sessionFactory.close();
    }
}
