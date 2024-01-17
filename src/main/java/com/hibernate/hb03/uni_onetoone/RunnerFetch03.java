package com.hibernate.hb03.uni_onetoone;

import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        org.hibernate.SessionFactory sessionFactory = cfg.buildSessionFactory();

        org.hibernate.Session session = sessionFactory.openSession();

        org.hibernate.Transaction transaction = session.beginTransaction();


        Student03 student1 = session.get(Student03.class, 1);
        System.out.println(student1);

        Student03 student2 = session.get(Student03.class, 2);
        System.out.println(student2);

        Diary diary1 = session.get(Diary.class, 1);
        System.out.println(diary1);

        Diary diary2 = session.get(Diary.class, 2);
        System.out.println(diary2);


        transaction.commit();

        session.close();

        sessionFactory.close();
    }
}
